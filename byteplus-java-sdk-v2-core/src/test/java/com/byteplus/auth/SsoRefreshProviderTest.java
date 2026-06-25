package com.byteplus.auth;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Manual regression test for SSO refresh behavior.
 *
 * <p>The SDK owns only an in-memory snapshot of the SSO token cache. The cache
 * file is written by {@code bp sso login}; SDK refresh must not rewrite it.
 */
public class SsoRefreshProviderTest {

    private static final AtomicBoolean URL_HANDLER_INSTALLED = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception {
        installUrlHandler();
        testSsoRefreshDoesNotRewriteTokenCache();
        System.out.println("All SsoRefreshProvider tests passed.");
    }

    static void testSsoRefreshDoesNotRewriteTokenCache() throws Exception {
        Path dir = Files.createTempDirectory("byteplus-sso-refresh-test");
        Path tokenPath = dir.resolve("sso-cache.json");
        String originalJson = "{"
                + "\"startUrl\":\"https://signin.byteplus.com/sso/start\","
                + "\"sessionName\":\"default\","
                + "\"region\":\"ap-southeast-1\","
                + "\"clientId\":\"client-id\","
                + "\"clientSecret\":\"client-secret\","
                + "\"clientSecretExpiresAt\":" + Instant.now().plusSeconds(3600).getEpochSecond() + ","
                + "\"accessToken\":\"old-access\","
                + "\"refreshToken\":\"old-refresh\","
                + "\"expiresAt\":\"" + Instant.now().minusSeconds(60).toString() + "\""
                + "}";
        Files.write(tokenPath, originalJson.getBytes(StandardCharsets.UTF_8));

        SsoTokenCache tokenCache = new SsoTokenCache();
        tokenCache.setStartUrl("https://signin.byteplus.com/sso/start");
        tokenCache.setSessionName("default");
        tokenCache.setRegion("ap-southeast-1");
        tokenCache.setClientId("client-id");
        tokenCache.setClientSecret("client-secret");
        tokenCache.setClientSecretExpiresAt(Instant.now().plusSeconds(3600).getEpochSecond());
        tokenCache.setAccessToken("old-access");
        tokenCache.setRefreshToken("old-refresh");
        tokenCache.setExpiresAt(Instant.now().minusSeconds(60).toString());

        SsoRefreshProvider provider =
                new SsoRefreshProvider(tokenCache, "2100000000", "Admin", "ap-southeast-1", tokenPath);
        provider.refresh();
        CredentialValue value = provider.retrieve();

        assertEquals("AKIA_SSO", value.getAk(), "access key");
        assertEquals("SECRET_SSO", value.getSk(), "secret key");
        assertEquals("SESSION_SSO", value.getSessionToken(), "session token");
        String after = new String(Files.readAllBytes(tokenPath), StandardCharsets.UTF_8);
        assertEquals(originalJson, after, "SSO token cache file content");
        System.out.println("PASS: testSsoRefreshDoesNotRewriteTokenCache");
    }

    private static void installUrlHandler() {
        if (!URL_HANDLER_INSTALLED.compareAndSet(false, true)) {
            return;
        }
        try {
            URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
                @Override
                public URLStreamHandler createURLStreamHandler(String protocol) {
                    if (!"https".equals(protocol)) {
                        return null;
                    }
                    return new URLStreamHandler() {
                        @Override
                        protected URLConnection openConnection(URL url) {
                            return new FakeHttpsConnection(url);
                        }
                    };
                }
            });
        } catch (Error alreadyInstalled) {
            // URLStreamHandlerFactory is JVM-global. If another test installed it,
            // leave that owner in place instead of failing this regression test.
        }
    }

    private static final class FakeHttpsConnection extends HttpURLConnection {
        private final ByteArrayOutputStream requestBody = new ByteArrayOutputStream();

        FakeHttpsConnection(URL url) {
            super(url);
        }

        @Override
        public void disconnect() {
        }

        @Override
        public boolean usingProxy() {
            return false;
        }

        @Override
        public void connect() {
        }

        @Override
        public OutputStream getOutputStream() {
            return requestBody;
        }

        @Override
        public int getResponseCode() {
            return 200;
        }

        @Override
        public InputStream getInputStream() {
            String host = url.getHost();
            String path = url.getPath();
            if (host.startsWith("cloudidentity-oauth.") && "/token".equals(path)) {
                String body = new String(requestBody.toByteArray(), StandardCharsets.UTF_8);
                if (!body.contains("\"grant_type\":\"refresh_token\"")
                        || !body.contains("\"refresh_token\":\"old-refresh\"")) {
                    throw new RuntimeException("Unexpected OAuth refresh request body: " + body);
                }
                return json("{"
                        + "\"access_token\":\"new-sso-access\","
                        + "\"refresh_token\":\"new-refresh\","
                        + "\"expires_in\":900"
                        + "}");
            }
            if (host.startsWith("cloudidentity-portal.") && "/federation/credentials".equals(path)) {
                if (!"new-sso-access".equals(getRequestProperty("x-bd-cloudidentity-bearer-token"))) {
                    throw new RuntimeException("Portal request did not use refreshed access token");
                }
                return json("{"
                        + "\"ResponseMetadata\":{\"RequestId\":\"req-sso\"},"
                        + "\"Result\":{\"RoleCredentials\":{"
                        + "\"AccessKeyId\":\"AKIA_SSO\","
                        + "\"SecretAccessKey\":\"SECRET_SSO\","
                        + "\"SessionToken\":\"SESSION_SSO\","
                        + "\"Expiration\":" + Instant.now().plusSeconds(900).getEpochSecond()
                        + "}}"
                        + "}");
            }
            throw new RuntimeException("Unexpected URL: " + url);
        }

        private static InputStream json(String value) {
            return new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
        }
    }

    private static void assertEquals(String expected, String actual, String label) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new RuntimeException("Unexpected " + label + ": got " + actual + ", want " + expected);
        }
    }
}
