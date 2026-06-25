package com.byteplus.auth;

import com.byteplus.ApiException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Map;

/**
 * Provider that resolves credentials from the Byteplus CLI {@code config.json}.
 *
 * <p>Follows the {@link Provider} CQS contract:
 * <ul>
 *   <li>{@link #isExpired()} / {@link #retrieve()} are pure reads.</li>
 *   <li>{@link #refresh()} is the only method that mutates state. It re-reads
 *       the CLI config, resolves the profile's mode to a {@link Provider}
 *       instance, and publishes it.</li>
 * </ul>
 *
 * <p>Intended to be wrapped in a {@link CredentialProvider}, which serializes
 * refresh through a {@link java.util.concurrent.locks.ReadWriteLock} and
 * guarantees the {@code isExpired → refresh → retrieve} sequence. Direct use
 * (without wrapping) is not a supported mode.
 */
public class CLIConfigCredentialProvider implements Provider {

    private static final String PROVIDER_NAME = "CLIConfigCredentialProvider";
    private static final long EXPIRE_BUFFER_SECONDS = 60;
    private static final String LOGIN_CACHE_DIRECTORY_ENV = "BYTEPLUS_LOGIN_CACHE_DIRECTORY";

    private final String profileName;
    private final String configPath;
    private Provider delegate;

    public CLIConfigCredentialProvider() {
        this(null, null);
    }

    public CLIConfigCredentialProvider(String profileName) {
        this(profileName, null);
    }

    public CLIConfigCredentialProvider(String profileName, String configPath) {
        this.profileName = profileName;
        this.configPath = configPath;
    }

    /**
     * A {@link Provider} that wraps an already-materialized credential value.
     * Used for static AK/SK modes (ak) and for SSO paths where the
     * CLI config or the SSO portal has already returned a full credential.
     *
     * <p>{@link #refresh()} is a no-op: the outer
     * {@link CLIConfigCredentialProvider#refresh()} is the thing that re-reads
     * the CLI config and publishes a new provider instance.
     */
    private static final class StaticCredentialProvider implements Provider {
        private final CredentialValue value;
        private final long expirationSeconds; // epoch seconds; 0 = never expires

        StaticCredentialProvider(CredentialValue value, long expirationSeconds) {
            this.value = value;
            this.expirationSeconds = expirationSeconds;
        }

        @Override
        public boolean isExpired() {
            if (expirationSeconds == 0) {
                return false;
            }
            return System.currentTimeMillis() / 1000 + EXPIRE_BUFFER_SECONDS >= expirationSeconds;
        }

        @Override
        public void refresh() {
            // No-op: the outer CLIConfigCredentialProvider.refresh() re-resolves
            // the profile and publishes a fresh provider instance when this one
            // is reported expired.
        }

        @Override
        public CredentialValue retrieve() {
            return value;
        }
    }

    @Override
    public boolean isExpired() {
        return delegate == null || delegate.isExpired();
    }

    @Override
    public void refresh() throws ApiException {
        this.delegate = loadFromConfig();
    }

    @Override
    public CredentialValue retrieve() throws ApiException {
        Provider d = delegate;
        if (d == null) {
            throw new ApiException(PROVIDER_NAME + ": not refreshed; call refresh() first or use CredentialProvider");
        }
        return d.retrieve();
    }

    private Provider loadFromConfig() throws ApiException {
        Path configPath = resolveConfigPath();

        if (!Files.exists(configPath)) {
            throw new ApiException(PROVIDER_NAME + ": config file not found: " + configPath);
        }

        String content;
        try {
            content = new String(Files.readAllBytes(configPath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApiException(PROVIDER_NAME + ": failed to read config file: " + configPath + " - " + e.getMessage());
        }

        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> configMap;
        try {
            configMap = gson.fromJson(content, mapType);
        } catch (Exception e) {
            throw new ApiException(PROVIDER_NAME + ": failed to parse config JSON: " + e.getMessage());
        }

        if (configMap == null) {
            throw new ApiException(PROVIDER_NAME + ": config file is empty or invalid");
        }

        String profile = resolveProfile(configMap);

        @SuppressWarnings("unchecked")
        Map<String, Object> profiles = (Map<String, Object>) configMap.get("profiles");
        if (profiles == null) {
            throw new ApiException(PROVIDER_NAME + ": 'profiles' section not found in config");
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> profileData = (Map<String, Object>) profiles.get(profile);
        if (profileData == null) {
            throw new ApiException(PROVIDER_NAME + ": profile '" + profile + "' not found in config");
        }

        String rawMode = getStringValue(profileData, "mode");
        String mode = (rawMode == null) ? "" : rawMode.toLowerCase().trim();

        switch (mode) {
            case "":
            case "ak": {
                String ak = getStringValue(profileData, "access-key");
                String sk = getStringValue(profileData, "secret-key");
                String sessionToken = getStringValue(profileData, "session-token");

                if (isNullOrEmpty(ak) || isNullOrEmpty(sk)) {
                    throw new ApiException(PROVIDER_NAME + ": access-key and secret-key not found in profile '" + profile + "'");
                }

                return new StaticCredentialProvider(
                        new CredentialValue(ak, sk, sessionToken, PROVIDER_NAME), 0);
            }
            case "ramrolearn": {
                String ak = getStringValue(profileData, "access-key");
                String sk = getStringValue(profileData, "secret-key");
                String sourceSessionToken = getStringValue(profileData, "session-token");
                String roleName = getStringValue(profileData, "role-name");
                String accountId = getStringValue(profileData, "account-id");

                if (isNullOrEmpty(ak) || isNullOrEmpty(sk)) {
                    throw new ApiException(PROVIDER_NAME + ": access-key and secret-key are required for RamRoleArn mode in profile '" + profile + "'");
                }
                if (isNullOrEmpty(roleName) || isNullOrEmpty(accountId)) {
                    throw new ApiException(PROVIDER_NAME + ": role-name and account-id are required for RamRoleArn mode in profile '" + profile + "'");
                }

                Provider d = new StsAssumeRoleProvider(ak, sk,
                        sourceSessionToken == null ? "" : sourceSessionToken,
                        roleName, accountId);
                d.refresh();
                return d;
            }
            case "oidc": {
                String oidcTokenFile = getStringValue(profileData, "oidc-token-file");
                String roleTrn = getStringValue(profileData, "role-trn");

                if (isNullOrEmpty(oidcTokenFile) || isNullOrEmpty(roleTrn)) {
                    throw new ApiException(PROVIDER_NAME + ": oidc-token-file and role-trn are required for OIDC mode in profile '" + profile + "'");
                }

                Provider d = new OidcCredentialProvider(roleTrn, null, oidcTokenFile, null, null);
                d.refresh();
                return d;
            }
            case "ecsrole": {
                String roleName = getStringValue(profileData, "role-name");

                Provider d = EcsRoleCredentialProvider.create(roleName);
                d.refresh();
                return d;
            }
            case "sso": {
                return loadSsoProvider(profileData, profile, configMap);
            }
            case "console-login": {
                return loadConsoleLoginProvider(profileData, profile);
            }
            default:
                throw new ApiException(PROVIDER_NAME + ": unsupported mode: " + mode);
        }
    }

    /**
     * Load a console-login refresh provider from the given profile.
     *
     * <p>Reads the {@code login-session} field from the profile, then delegates
     * to {@link ConsoleLoginRefreshProvider} which consumes the token cache file
     * written by the {@code bp login} CLI command.
     */
    private Provider loadConsoleLoginProvider(Map<String, Object> profileData, String profile)
            throws ApiException {
        String loginSession = getStringValue(profileData, "login-session");
        if (isNullOrEmpty(loginSession)) {
            throw new ApiException(PROVIDER_NAME
                    + ": login-session not found in console-login profile '" + profile + "'");
        }
        Path configDir = resolveConfigPath().getParent();
        String envCacheDir = System.getenv(LOGIN_CACHE_DIRECTORY_ENV);
        Path cacheDir = !isNullOrEmpty(envCacheDir)
                ? Paths.get(envCacheDir).toAbsolutePath().normalize()
                : (configDir != null ? configDir.resolve("login").resolve("cache") : null);

        Provider d = new ConsoleLoginRefreshProvider(loginSession, cacheDir);
        d.refresh();
        return d;
    }

    @SuppressWarnings("unchecked")
    private Provider loadSsoProvider(Map<String, Object> profileData, String profile,
                                     Map<String, Object> configMap) throws ApiException {
        String sessionName = getStringValue(profileData, "sso-session-name");
        if (isNullOrEmpty(sessionName)) {
            throw new ApiException(PROVIDER_NAME + ": sso-session-name not found in profile '" + profile
                    + "', please run 'bp sso login'");
        }

        Map<String, Object> ssoSessions = (Map<String, Object>) configMap.get("sso-session");
        if (ssoSessions == null) {
            throw new ApiException(PROVIDER_NAME + ": 'sso-session' section not found in config, please run 'bp sso login'");
        }
        Map<String, Object> sessionData = (Map<String, Object>) ssoSessions.get(sessionName);
        if (sessionData == null) {
            throw new ApiException(PROVIDER_NAME + ": sso-session '" + sessionName
                    + "' not found in config, please run 'bp sso login'");
        }

        String startUrl = getStringValue(sessionData, "start-url");
        if (isNullOrEmpty(startUrl)) {
            throw new ApiException(PROVIDER_NAME + ": start-url not found in sso-session '" + sessionName
                    + "', please run 'bp sso login'");
        }
        String region = getStringValue(sessionData, "region");
        if (isNullOrEmpty(region)) {
            region = "ap-southeast-1";
        }

        String cacheFileName = computeTokenCacheFileName(startUrl, sessionName);
        Path configDir = resolveConfigPath().getParent();
        Path tokenCachePath = configDir.resolve("sso").resolve("cache").resolve(cacheFileName);

        if (!Files.exists(tokenCachePath)) {
            throw new ApiException(PROVIDER_NAME + ": SSO token cache file not found: " + tokenCachePath
                    + ", please run 'bp sso login'");
        }

        String tokenContent;
        try {
            tokenContent = new String(Files.readAllBytes(tokenCachePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApiException(PROVIDER_NAME + ": failed to read SSO token cache: " + tokenCachePath
                    + " - please run 'bp sso login'. Cause: " + e.getMessage());
        }

        Gson gson = new Gson();
        SsoTokenCache tokenCache;
        try {
            tokenCache = gson.fromJson(tokenContent, SsoTokenCache.class);
        } catch (Exception e) {
            throw new ApiException(PROVIDER_NAME + ": failed to parse SSO token cache"
                    + " - please run 'bp sso login'. Cause: " + e.getMessage());
        }
        if (tokenCache == null) {
            throw new ApiException(PROVIDER_NAME + ": SSO token cache file is empty, please run 'bp sso login'");
        }

        String accessToken = tokenCache.getAccessToken();
        if (isNullOrEmpty(accessToken)) {
            throw new ApiException(PROVIDER_NAME + ": SSO token cache missing access_token, please run 'bp sso login'");
        }

        String accountId = getStringValue(profileData, "account-id");
        String roleName = getStringValue(profileData, "role-name");
        if (isNullOrEmpty(accountId)) {
            throw new ApiException(PROVIDER_NAME + ": account-id not found in SSO profile '" + profile + "'");
        }
        if (isNullOrEmpty(roleName)) {
            throw new ApiException(PROVIDER_NAME + ": role-name not found in SSO profile '" + profile + "'");
        }

        Provider d = new SsoRefreshProvider(tokenCache, accountId, roleName, region, tokenCachePath);
        d.refresh();
        return d;
    }

    private static String computeTokenCacheFileName(String startUrl, String sessionName) throws ApiException {
        try {
            // Match Go implementation: JSON {"start_url":"...","session_name":"..."}
            String json = "{\"start_url\":\"" + escapeJsonString(startUrl)
                    + "\",\"session_name\":\"" + escapeJsonString(sessionName) + "\"}";
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hash = sha1.digest(json.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString() + ".json";
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new ApiException("CLIConfigCredentialProvider: SHA-1 algorithm not available");
        }
    }

    // Escape a string to match Go encoding/json.Marshal default output
    private static String escapeJsonString(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"':  sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n");  break;
                case '\r': sb.append("\\r");  break;
                case '\t': sb.append("\\t");  break;
                case '<':  sb.append("\\u003c"); break;
                case '>':  sb.append("\\u003e"); break;
                case '&':  sb.append("\\u0026"); break;
                case '\u2028': sb.append("\\u2028"); break;
                case '\u2029': sb.append("\\u2029"); break;
                default:
                    if (c < 0x20) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }

    private Path resolveConfigPath() {
        if (!isNullOrEmpty(configPath)) {
            return Paths.get(configPath).toAbsolutePath().normalize();
        }
        String envPath = System.getenv("BYTEPLUS_CLI_CONFIG_FILE");
        if (!isNullOrEmpty(envPath)) {
            return Paths.get(envPath).toAbsolutePath().normalize();
        }
        String home = System.getProperty("user.home");
        return Paths.get(home, ".byteplus", "config.json").toAbsolutePath().normalize();
    }

    private String resolveProfile(Map<String, Object> configMap) {
        // Priority: constructor param > env var > "current" field in config
        if (!isNullOrEmpty(profileName)) {
            return profileName;
        }
        String envProfile = System.getenv("BYTEPLUS_PROFILE");
        if (!isNullOrEmpty(envProfile)) {
            return envProfile;
        }
        Object current = configMap.get("current");
        if (current instanceof String && !((String) current).isEmpty()) {
            return (String) current;
        }
        return "default";
    }

    private static String getStringValue(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof String) {
            String s = (String) value;
            return s.isEmpty() ? null : s;
        }
        return null;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
