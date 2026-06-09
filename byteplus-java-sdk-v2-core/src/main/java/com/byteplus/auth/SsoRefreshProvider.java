package com.byteplus.auth;

import com.byteplus.ApiException;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

/**
 * SSO {@link Provider} that owns a long-lived in-memory snapshot of the SSO
 * token cache and silently refreshes STS credentials via CloudIdentity OAuth
 * and Portal GetRoleCredentials.
 *
 * <p>Contract:
 * <ul>
 *   <li>The token cache is read from disk on bootstrap only, and once more for
 *       the invalid_grant fallback. This provider never writes the cache file;
 *       {@code bp sso login} remains the sole writer.</li>
 *   <li>When the SSO access token expires, the provider exchanges the cached
 *       refresh_token at CloudIdentity OAuth, updates in-memory state, then
 *       calls Portal GetRoleCredentials for fresh STS credentials.</li>
 *   <li>If OAuth rejects the refresh_token with invalid_grant-equivalent
 *       errors, the provider re-reads the SSO cache file once. A changed disk
 *       refresh_token means {@code bp sso login} rotated it, so the provider
 *       retries once with that disk state.</li>
 * </ul>
 */
class SsoRefreshProvider implements Provider {

    private static final String PROVIDER_NAME = "CLIConfigCredentialProvider";
    private static final long EXPIRE_BUFFER_SECONDS = 60;

    private final String accountId;
    private final String roleName;
    private final String region;
    private final Path tokenCachePath;

    private SsoTokenCache tokenCache;
    private CredentialValue credentials;
    private long expirationEpoch;

    SsoRefreshProvider(SsoTokenCache tokenCache, String accountId, String roleName,
                       String region, Path tokenCachePath) {
        this.tokenCache = tokenCache;
        this.accountId = accountId;
        this.roleName = roleName;
        this.region = region;
        this.tokenCachePath = tokenCachePath;
    }

    @Override
    public boolean isExpired() {
        if (credentials == null || expirationEpoch == 0) {
            return true;
        }
        return System.currentTimeMillis() / 1000 + EXPIRE_BUFFER_SECONDS >= expirationEpoch;
    }

    @Override
    public CredentialValue retrieve() throws ApiException {
        if (credentials == null) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO credentials not refreshed; call refresh() first or use CredentialProvider");
        }
        return credentials;
    }

    @Override
    public void refresh() throws ApiException {
        String accessToken = tokenCache.getAccessToken();
        if (isNullOrEmpty(accessToken)) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO token cache missing access_token, please run 'bp sso login'");
        }

        if (!isTokenExpired(tokenCache.getExpiresAt())) {
            fetchRoleCredentials(accessToken);
            return;
        }

        try {
            accessToken = doRefreshAccessToken(tokenCache);
        } catch (InvalidGrantException e) {
            SsoTokenCache disk = loadCacheFromDisk();
            if (isNullOrEmpty(disk.getRefreshToken())) {
                throw new ApiException(PROVIDER_NAME
                        + ": SSO refresh token rejected and disk cache lacks refresh_token;"
                        + " please run 'bp sso login'.");
            }
            if (disk.getRefreshToken().equals(tokenCache.getRefreshToken())) {
                throw new ApiException(PROVIDER_NAME
                        + ": SSO refresh token rejected by OAuth server"
                        + " (disk cache has the same RT); please run 'bp sso login'."
                        + " underlying error: " + e.getMessage());
            }
            tokenCache = disk;
            try {
                accessToken = doRefreshAccessToken(tokenCache);
            } catch (InvalidGrantException retryEx) {
                throw new ApiException(PROVIDER_NAME
                        + ": SSO refresh token rejected; reloaded disk cache but new RT also failed;"
                        + " please run 'bp sso login'. underlying error: " + retryEx.getMessage());
            }
        }

        fetchRoleCredentials(accessToken);
    }

    private void fetchRoleCredentials(String accessToken) throws ApiException {
        SsoPortalClient portalClient = new SsoPortalClient(region);
        SsoPortalClient.RoleCredentialsResult creds;
        try {
            creds = portalClient.getRoleCredentials(accessToken, accountId, roleName);
        } catch (ApiException e) {
            throw new ApiException(PROVIDER_NAME + ": SSO Portal GetRoleCredentials failed"
                    + " - please run 'bp sso login' if the token is expired. Cause: " + e.getMessage());
        }

        long expirationSeconds = (creds.expiration > 0)
                ? normalizeTimestamp(creds.expiration)
                : System.currentTimeMillis() / 1000 + 3600;
        credentials = new CredentialValue(creds.accessKeyId, creds.secretAccessKey,
                creds.sessionToken, PROVIDER_NAME);
        expirationEpoch = expirationSeconds;
    }

    private String doRefreshAccessToken(SsoTokenCache cache) throws ApiException, InvalidGrantException {
        String refreshToken = cache.getRefreshToken();
        if (isNullOrEmpty(refreshToken)) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO token cache missing refresh_token, please run 'bp sso login'");
        }
        long clientSecretExpiresAt = cache.getClientSecretExpiresAt();
        if (clientSecretExpiresAt > 0) {
            long expSeconds = normalizeTimestamp(clientSecretExpiresAt);
            if (System.currentTimeMillis() / 1000 >= expSeconds) {
                throw new ApiException(PROVIDER_NAME
                        + ": SSO refresh token has expired, please run 'bp sso login'");
            }
        }
        String clientId = cache.getClientId();
        String clientSecret = cache.getClientSecret();
        if (isNullOrEmpty(clientId) || isNullOrEmpty(clientSecret)) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO token cache missing client_id or client_secret, please run 'bp sso login'");
        }

        SsoPortalClient portalClient = new SsoPortalClient(region);
        SsoPortalClient.OAuthTokenResponse resp;
        try {
            resp = portalClient.refreshToken(clientId, clientSecret, refreshToken);
        } catch (ApiException e) {
            String msg = e.getMessage() != null ? e.getMessage() : "";
            if (msg.contains("invalid_grant") || msg.contains("InvalidGrant")
                    || msg.contains("status 400") || msg.contains("status 401")) {
                throw new InvalidGrantException(msg);
            }
            throw new ApiException(PROVIDER_NAME
                    + ": SSO access token refresh failed, please run 'bp sso login'. Cause: " + msg);
        }

        String newAccessToken = resp.accessToken;
        String newRefreshToken = isNullOrEmpty(resp.refreshToken)
                ? cache.getRefreshToken() : resp.refreshToken;
        String newExpiresAt = Instant.now().plusSeconds(resp.expiresIn).toString();

        cache.setAccessToken(newAccessToken);
        cache.setRefreshToken(newRefreshToken);
        cache.setExpiresAt(newExpiresAt);

        return newAccessToken;
    }

    private SsoTokenCache loadCacheFromDisk() throws ApiException {
        if (tokenCachePath == null) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO cache path not available for disk reload; please run 'bp sso login'");
        }
        if (!Files.exists(tokenCachePath)) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO token cache file not found: " + tokenCachePath
                    + ", please run 'bp sso login'");
        }
        String tokenContent;
        try {
            tokenContent = new String(Files.readAllBytes(tokenCachePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApiException(PROVIDER_NAME
                    + ": failed to read SSO token cache for disk reload: " + tokenCachePath
                    + " - please run 'bp sso login'. Cause: " + e.getMessage());
        }
        SsoTokenCache loaded;
        try {
            loaded = new Gson().fromJson(tokenContent, SsoTokenCache.class);
        } catch (Exception e) {
            throw new ApiException(PROVIDER_NAME
                    + ": failed to parse SSO token cache during disk reload"
                    + " - please run 'bp sso login'. Cause: " + e.getMessage());
        }
        if (loaded == null) {
            throw new ApiException(PROVIDER_NAME
                    + ": SSO token cache file is empty during disk reload, please run 'bp sso login'");
        }
        return loaded;
    }

    private static boolean isTokenExpired(String expiresAt) {
        if (isNullOrEmpty(expiresAt)) {
            return true;
        }
        try {
            java.time.Instant exp = java.time.Instant.parse(expiresAt.trim());
            return java.time.Instant.now().isAfter(exp);
        } catch (java.time.format.DateTimeParseException e) {
            return true;
        }
    }

    private static long normalizeTimestamp(long ts) {
        if (ts >= 1_000_000_000_000_000_000L) {
            return ts / 1_000_000_000L;
        } else if (ts >= 1_000_000_000_000_000L) {
            return ts / 1_000_000L;
        } else if (ts >= 1_000_000_000_000L) {
            return ts / 1_000L;
        }
        return ts;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private static class InvalidGrantException extends Exception {
        InvalidGrantException(String msg) {
            super(msg);
        }
    }
}
