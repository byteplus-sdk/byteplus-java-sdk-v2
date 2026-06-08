package com.byteplus.auth;

import com.byteplus.ApiException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * Provider that resolves credentials from a Byteplus CLI {@code bp login}
 * token cache.
 *
 * <p>The byteplus-cli {@code bp login} command performs the interactive
 * OAuth 2.0 Authorization Code + PKCE flow against
 * {@code https://signin.byteplus.com} and writes a token cache JSON file at
 * {@code ~/.byteplus/login/cache/<sha1(login_session)>.json}. The cached
 * {@code access_token} is itself a JSON object containing STS temporary
 * credentials. This provider:
 *
 * <ul>
 *   <li>Reads the cache by {@code login_session}.</li>
 *   <li>Parses the embedded STS credentials
 *       (access_key_id / secret_access_key / session_token).</li>
 *   <li>Considers the credentials expired when
 *       {@code now >= issued_at + expires_in - 60s}.</li>
 *   <li>Refreshes via the OAuth {@code refresh_token} grant and atomically
 *       rewrites the cache file on success.</li>
 * </ul>
 *
 * <p>Follows the {@link Provider} CQS contract and is intended to be wrapped
 * in a {@link CredentialProvider}.
 */
public class ConsoleLoginCredentialProvider implements Provider {

    private static final String PROVIDER_NAME = "ConsoleLoginCredentialProvider";
    private static final long EXPIRE_BUFFER_SECONDS = 60;

    private final String loginSession;
    private final String cacheDirectory;
    private final String endpointUrl;

    private CredentialValue cachedValue;
    private long expirationSeconds; // epoch seconds

    public ConsoleLoginCredentialProvider(String loginSession) {
        this(loginSession, null, null);
    }

    public ConsoleLoginCredentialProvider(String loginSession, String cacheDirectory, String endpointUrl) {
        this.loginSession = loginSession;
        this.cacheDirectory = cacheDirectory;
        this.endpointUrl = endpointUrl;
    }

    @Override
    public boolean isExpired() {
        if (cachedValue == null) {
            return true;
        }
        if (expirationSeconds == 0) {
            return false;
        }
        return System.currentTimeMillis() / 1000 + EXPIRE_BUFFER_SECONDS >= expirationSeconds;
    }

    @Override
    public void refresh() throws ApiException {
        if (isNullOrEmpty(loginSession)) {
            throw new ApiException(PROVIDER_NAME + ": login_session is required");
        }

        Path cachePath = resolveCachePath();
        if (!Files.exists(cachePath)) {
            throw new ApiException(PROVIDER_NAME + ": console-login token cache not found: " + cachePath
                    + "; please run `bp login` first");
        }

        String content;
        try {
            content = new String(Files.readAllBytes(cachePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApiException(PROVIDER_NAME + ": failed to read console-login token cache: "
                    + cachePath + " - " + e.getMessage());
        }

        Gson gson = new Gson();
        ConsoleLoginTokenCache cache;
        try {
            cache = gson.fromJson(content, ConsoleLoginTokenCache.class);
        } catch (Exception e) {
            throw new ApiException(PROVIDER_NAME + ": failed to parse console-login token cache: "
                    + e.getMessage());
        }
        if (cache == null) {
            throw new ApiException(PROVIDER_NAME + ": console-login token cache is empty");
        }

        long expSeconds = computeExpirationSeconds(cache.getIssuedAt(), cache.getExpiresIn());
        if (System.currentTimeMillis() / 1000 + EXPIRE_BUFFER_SECONDS >= expSeconds) {
            // Token expired or near expiry — refresh via OAuth refresh_token grant.
            refreshTokenCache(cache, cachePath, gson);
            expSeconds = computeExpirationSeconds(cache.getIssuedAt(), cache.getExpiresIn());
        }

        STSCredentials sts = extractStsCredentials(cache.getAccessToken());
        if (isNullOrEmpty(sts.accessKeyId) || isNullOrEmpty(sts.secretAccessKey)) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login access_token did not contain valid STS credentials");
        }

        this.cachedValue = new CredentialValue(
                sts.accessKeyId, sts.secretAccessKey, sts.sessionToken, PROVIDER_NAME);
        this.expirationSeconds = expSeconds;
    }

    @Override
    public CredentialValue retrieve() throws ApiException {
        CredentialValue v = cachedValue;
        if (v == null) {
            throw new ApiException(PROVIDER_NAME
                    + ": not refreshed; call refresh() first or use CredentialProvider");
        }
        return v;
    }

    // ---- Internal -----------------------------------------------------------

    private void refreshTokenCache(ConsoleLoginTokenCache cache, Path cachePath, Gson gson)
            throws ApiException {
        String refreshTokenStr = cache.getRefreshToken();
        if (isNullOrEmpty(refreshTokenStr)) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login token cache missing refresh_token; please re-login with CLI");
        }
        String clientId = cache.getClientId();
        if (isNullOrEmpty(clientId)) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login token cache missing client_id; please re-login with CLI");
        }

        String resolvedEndpoint = !isNullOrEmpty(endpointUrl)
                ? endpointUrl
                : (isNullOrEmpty(cache.getEndpointUrl())
                        ? ConsoleOAuthClient.DEFAULT_ENDPOINT_URL
                        : cache.getEndpointUrl());

        ConsoleOAuthClient client = new ConsoleOAuthClient(resolvedEndpoint);
        ConsoleOAuthClient.ConsoleTokenResponse resp = client.refreshToken(
                clientId, refreshTokenStr, cache.getScope());

        // Compose the updated cache, persist to disk first, then mutate in-memory state.
        ConsoleLoginTokenCache updated = new ConsoleLoginTokenCache();
        updated.setLoginSession(cache.getLoginSession());
        updated.setAccessToken(resp.accessToken);
        updated.setRefreshToken(
                isNullOrEmpty(resp.refreshToken) ? cache.getRefreshToken() : resp.refreshToken);
        updated.setIdToken(
                isNullOrEmpty(resp.idToken) ? cache.getIdToken() : resp.idToken);
        updated.setScope(
                isNullOrEmpty(resp.scope) ? cache.getScope() : resp.scope);
        updated.setClientId(cache.getClientId());
        updated.setEndpointUrl(cache.getEndpointUrl());
        updated.setIssuedAt(Instant.now().toString());
        updated.setExpiresIn(resp.expiresIn);
        updated.setTokenType(
                isNullOrEmpty(resp.tokenType) ? cache.getTokenType() : resp.tokenType);

        writeCacheAtomic(cachePath, gson.toJson(updated));

        // Disk write succeeded — mirror into the in-memory cache object.
        cache.setAccessToken(updated.getAccessToken());
        cache.setRefreshToken(updated.getRefreshToken());
        cache.setIdToken(updated.getIdToken());
        cache.setScope(updated.getScope());
        cache.setIssuedAt(updated.getIssuedAt());
        cache.setExpiresIn(updated.getExpiresIn());
        cache.setTokenType(updated.getTokenType());
    }

    private static void writeCacheAtomic(Path cachePath, String json) throws ApiException {
        try {
            Path parent = cachePath.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Path tempFile = Files.createTempFile(parent, ".tmp-", ".json");
            try {
                byte[] data = json.getBytes(StandardCharsets.UTF_8);
                try (OutputStream os = Files.newOutputStream(tempFile)) {
                    os.write(data);
                }
                try {
                    Files.move(tempFile, cachePath,
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.ATOMIC_MOVE);
                } catch (IOException atomicFailed) {
                    // Some filesystems do not support ATOMIC_MOVE — fall back to a non-atomic
                    // replacement, preserving the temp-file safety net.
                    Files.move(tempFile, cachePath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (Exception e) {
                try { Files.deleteIfExists(tempFile); } catch (IOException ignored) { }
                if (e instanceof ApiException) {
                    throw (ApiException) e;
                }
                throw new ApiException(PROVIDER_NAME
                        + ": failed to write console-login token cache: " + e.getMessage());
            }
        } catch (IOException e) {
            throw new ApiException(PROVIDER_NAME
                    + ": failed to write console-login token cache: " + e.getMessage());
        }
    }

    private Path resolveCachePath() throws ApiException {
        Path dir = resolveCacheDirectory();
        return dir.resolve(computeCacheFileName(loginSession));
    }

    private Path resolveCacheDirectory() {
        if (!isNullOrEmpty(cacheDirectory)) {
            return Paths.get(cacheDirectory).toAbsolutePath().normalize();
        }
        String envDir = System.getenv("BYTEPLUS_LOGIN_CACHE_DIRECTORY");
        if (!isNullOrEmpty(envDir)) {
            return Paths.get(envDir).toAbsolutePath().normalize();
        }
        String home = System.getProperty("user.home");
        return Paths.get(home, ".byteplus", "login", "cache").toAbsolutePath().normalize();
    }

    private static String computeCacheFileName(String loginSession) throws ApiException {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hash = sha1.digest(loginSession.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString() + ".json";
        } catch (NoSuchAlgorithmException e) {
            throw new ApiException(PROVIDER_NAME + ": SHA-1 algorithm not available");
        }
    }

    /**
     * Compute the absolute expiration epoch (seconds) given an RFC3339
     * {@code issued_at} timestamp and an {@code expires_in} duration.
     * Returns 0 when {@code issued_at} cannot be parsed (caller treats 0 as
     * "unknown — treat as expired").
     */
    private static long computeExpirationSeconds(String issuedAt, long expiresIn) {
        if (isNullOrEmpty(issuedAt) || expiresIn <= 0) {
            return 0;
        }
        try {
            Instant issued = Instant.parse(issuedAt.trim());
            return issued.getEpochSecond() + expiresIn;
        } catch (DateTimeParseException e) {
            return 0;
        }
    }

    /**
     * Parse the STS credentials embedded in the cached {@code access_token}.
     * The element may be a JSON object, or a JSON string holding a JSON object.
     */
    private static STSCredentials extractStsCredentials(JsonElement accessToken) throws ApiException {
        if (accessToken == null || accessToken.isJsonNull()) {
            throw new ApiException(PROVIDER_NAME + ": access_token is missing in token cache");
        }
        JsonObject obj;
        if (accessToken.isJsonObject()) {
            obj = accessToken.getAsJsonObject();
        } else if (accessToken.isJsonPrimitive() && accessToken.getAsJsonPrimitive().isString()) {
            String raw = accessToken.getAsString();
            try {
                JsonElement parsed = new JsonParser().parse(raw);
                if (!parsed.isJsonObject()) {
                    throw new ApiException(PROVIDER_NAME
                            + ": access_token string is not a JSON object");
                }
                obj = parsed.getAsJsonObject();
            } catch (Exception e) {
                throw new ApiException(PROVIDER_NAME
                        + ": failed to parse access_token JSON string - " + e.getMessage());
            }
        } else {
            throw new ApiException(PROVIDER_NAME
                    + ": access_token has unexpected JSON type");
        }

        STSCredentials sts = new STSCredentials();
        sts.accessKeyId = optString(obj, "access_key_id");
        sts.secretAccessKey = optString(obj, "secret_access_key");
        sts.sessionToken = optString(obj, "session_token");
        return sts;
    }

    private static String optString(JsonObject obj, String key) {
        JsonElement el = obj.get(key);
        if (el == null || el.isJsonNull()) {
            return null;
        }
        if (el.isJsonPrimitive() && el.getAsJsonPrimitive().isString()) {
            String s = el.getAsString();
            return s.isEmpty() ? null : s;
        }
        return null;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static final class STSCredentials {
        @SerializedName("access_key_id")
        String accessKeyId;
        @SerializedName("secret_access_key")
        String secretAccessKey;
        @SerializedName("session_token")
        String sessionToken;
    }
}
