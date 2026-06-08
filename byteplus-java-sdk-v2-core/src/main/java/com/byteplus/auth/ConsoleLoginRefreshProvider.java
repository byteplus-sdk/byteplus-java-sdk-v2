package com.byteplus.auth;

import com.byteplus.ApiException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.time.Instant;
import java.time.format.DateTimeParseException;

/**
 * console-login {@link Provider} that owns a long-lived in-memory snapshot of
 * the {@code bp login} cache and silently refreshes STS credentials via the
 * BytePlus signin OAuth endpoint.
 *
 * <p>Contract aligned with the Volcengine Java SDK console-login provider:
 * <ul>
 *   <li>The SDK reads the cache on bootstrap and on the invalid_grant fallback
 *       only; it never writes the cache file. {@code bp login} remains the
 *       only disk writer.</li>
 *   <li>When the in-memory access_token expires, the provider exchanges the
 *       cached refresh_token at the BytePlus signin OAuth endpoint and updates
 *       the in-memory cache only.</li>
 *   <li>If signin rejects the refresh_token with {@code invalid_grant}, the
 *       provider re-reads disk once. If disk contains a different
 *       refresh_token, it retries with that token; otherwise the user must run
 *       {@code bp login} again.</li>
 * </ul>
 */
class ConsoleLoginRefreshProvider implements Provider {

	private static final String PROVIDER_NAME = "ConsoleLoginCredentialProvider";
	private static final long EXPIRE_BUFFER_SECONDS = 60;

	private final String loginSession;
	private final Path cacheDir;

	private ConsoleLoginTokenCache cache;
	private CredentialValue cachedValue;
	private long expirationSeconds;

	ConsoleLoginRefreshProvider(String loginSession, Path cacheDir) {
		this.loginSession = loginSession;
		this.cacheDir = cacheDir;
	}

    @Override
    public boolean isExpired() {
        if (cachedValue == null || expirationSeconds == 0) {
            return true;
        }
        return System.currentTimeMillis() / 1000 + EXPIRE_BUFFER_SECONDS >= expirationSeconds;
    }

    @Override
    public void refresh() throws ApiException {
        if (isNullOrEmpty(loginSession)) {
            throw new ApiException(PROVIDER_NAME + ": login_session is required");
        }
        if (cache == null) {
            cache = loadCacheFromDisk();
        }
        if (tryApplyFromCache(cache)) {
            return;
        }

        try {
            refreshWithOAuth(cache);
            return;
        } catch (ConsoleOAuthClient.InvalidGrantException invalidGrant) {
            ConsoleLoginTokenCache disk = loadCacheFromDisk();
            if (isNullOrEmpty(disk.getRefreshToken())) {
                throw new ApiException(PROVIDER_NAME
                        + ": console-login refresh token rejected and disk cache lacks refresh_token;"
                        + " please run 'bp login' to re-authenticate.");
            }
            if (disk.getRefreshToken().equals(cache.getRefreshToken())) {
                throw new ApiException(PROVIDER_NAME
                        + ": console-login refresh token rejected by signin service"
                        + " (disk cache has the same RT); please run 'bp login' to re-authenticate."
                        + " underlying error: " + invalidGrant.getMessage());
            }
            cache = disk;
            if (tryApplyFromCache(cache)) {
                return;
            }
            try {
                refreshWithOAuth(cache);
            } catch (ConsoleOAuthClient.InvalidGrantException retryInvalid) {
                throw new ApiException(PROVIDER_NAME
                        + ": console-login refresh token rejected; reloaded disk cache but new RT also failed;"
                        + " please run 'bp login'. underlying error: " + retryInvalid.getMessage());
            } catch (ApiException e) {
                throw new ApiException(PROVIDER_NAME
                        + ": console-login refresh failed after disk reload;"
                        + " please run 'bp login'. underlying error: " + e.getMessage());
            } catch (RuntimeException e) {
                throw new ApiException(PROVIDER_NAME
                        + ": console-login refresh failed after disk reload;"
                        + " please run 'bp login'. underlying error: " + e.getMessage());
            }
        } catch (ApiException e) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login refresh failed; please run 'bp login'. underlying error: "
                    + e.getMessage());
        } catch (RuntimeException e) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login refresh failed; please run 'bp login'. underlying error: "
                    + e.getMessage());
        }
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

    private boolean tryApplyFromCache(ConsoleLoginTokenCache c) throws ApiException {
        long expSeconds = computeExpirationSeconds(c.getIssuedAt(), c.getExpiresIn());
        if (expSeconds == 0
                || System.currentTimeMillis() / 1000 + EXPIRE_BUFFER_SECONDS >= expSeconds) {
            return false;
        }

        STSCredentials sts;
        try {
            sts = extractStsCredentials(c.getAccessToken());
        } catch (ApiException e) {
            return false;
        }
        cachedValue = new CredentialValue(
                sts.accessKeyId, sts.secretAccessKey, sts.sessionToken, PROVIDER_NAME);
        expirationSeconds = expSeconds;
        return true;
    }

    private void refreshWithOAuth(ConsoleLoginTokenCache c)
            throws ApiException, ConsoleOAuthClient.InvalidGrantException {
        if (isNullOrEmpty(c.getRefreshToken())) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login cache lacks refresh_token; please run 'bp login' first.");
        }
        if (isNullOrEmpty(c.getClientId())) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login cache lacks client_id; please run 'bp login' to regenerate.");
        }

        ConsoleOAuthClient client = new ConsoleOAuthClient(c.getEndpointUrl());
        ConsoleOAuthClient.ConsoleTokenResponse resp =
                client.refreshToken(c.getClientId(), c.getScope(), c.getRefreshToken());

        try {
            c.setAccessToken(new JsonParser().parse(resp.accessToken));
        } catch (Exception e) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login refresh succeeded but access_token could not be parsed as JSON;"
                    + " please run 'bp login'. underlying error: " + e.getMessage());
        }
        if (!isNullOrEmpty(resp.refreshToken)) {
            c.setRefreshToken(resp.refreshToken);
        }
        if (!isNullOrEmpty(resp.idToken)) {
            c.setIdToken(resp.idToken);
        }
        if (!isNullOrEmpty(resp.scope)) {
            c.setScope(resp.scope);
        }
        if (!isNullOrEmpty(resp.tokenType)) {
            c.setTokenType(resp.tokenType);
        }
        c.setIssuedAt(Instant.now().toString());
        c.setExpiresIn(resp.expiresIn);

        if (!tryApplyFromCache(c)) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login refresh succeeded but the new access_token could not be"
                    + " parsed into STS credentials; please run 'bp login' to re-authenticate.");
        }
    }

    private ConsoleLoginTokenCache loadCacheFromDisk() throws ApiException {
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

        ConsoleLoginTokenCache parsed;
        try {
            parsed = new Gson().fromJson(content, ConsoleLoginTokenCache.class);
        } catch (Exception e) {
            throw new ApiException(PROVIDER_NAME + ": failed to parse console-login token cache: "
                    + e.getMessage());
        }
        if (parsed == null) {
            throw new ApiException(PROVIDER_NAME + ": console-login token cache is empty");
        }
        return parsed;
    }

	private Path resolveCachePath() throws ApiException {
		if (cacheDir == null) {
			throw new ApiException(PROVIDER_NAME + ": console-login cache directory is not resolved");
		}
		return cacheDir.resolve(computeCacheFileName(loginSession));
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
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new ApiException(PROVIDER_NAME + ": SHA-1 algorithm not available");
        }
    }

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
        if (isNullOrEmpty(sts.accessKeyId)
                || isNullOrEmpty(sts.secretAccessKey)
                || isNullOrEmpty(sts.sessionToken)) {
            throw new ApiException(PROVIDER_NAME
                    + ": console-login access_token did not contain valid STS credentials");
        }
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
