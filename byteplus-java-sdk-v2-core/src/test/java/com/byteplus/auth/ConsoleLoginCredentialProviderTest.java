package com.byteplus.auth;

import com.byteplus.ApiException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Manual regression test for reading the exact console-login profile mode and
 * cache layout written by bp login.
 */
public class ConsoleLoginCredentialProviderTest {

    public static void main(String[] args) throws Exception {
        testCliConfigAcceptsHyphenatedConsoleLoginMode();
        testRefreshDoesNotRewriteCache();
        testInvalidGrantReloadsDiskCache();
        System.out.println("All ConsoleLoginRefreshProvider tests passed.");
    }

    static void testCliConfigAcceptsHyphenatedConsoleLoginMode() throws Exception {
        Path dir = Files.createTempDirectory("byteplus-console-login-test");
        Path configPath = dir.resolve("config.json");
        String loginSession = "sess-java";

        Files.write(configPath, (
                "{"
                        + "\"current\":\"default\","
                        + "\"profiles\":{"
                        + "\"default\":{"
                        + "\"mode\":\"console-login\","
                        + "\"login-session\":\"" + loginSession + "\""
                        + "}"
                        + "}"
                        + "}").getBytes(StandardCharsets.UTF_8));

        Path cacheDir = dir.resolve("login").resolve("cache");
        Files.createDirectories(cacheDir);
        Path cachePath = cacheDir.resolve(sha1Hex(loginSession) + ".json");
        Files.write(cachePath, (
                "{"
                        + "\"login_session\":\"" + loginSession + "\","
                        + "\"access_token\":{"
                        + "\"access_key_id\":\"AK\","
                        + "\"secret_access_key\":\"SK\","
                        + "\"session_token\":\"TOKEN\""
                        + "},"
                        + "\"refresh_token\":\"refresh\","
                        + "\"scope\":\"Console:All:All\","
                        + "\"client_id\":\"trn:signin:::devtools/same-device\","
                        + "\"endpoint_url\":\"https://signin.byteplus.com\","
                        + "\"issued_at\":\"" + Instant.now().toString() + "\","
                        + "\"expires_in\":3600,"
                        + "\"token_type\":\"urn:ietf:params:oauth:token-type:access_token_sts\""
                        + "}").getBytes(StandardCharsets.UTF_8));

        CLIConfigCredentialProvider provider = new CLIConfigCredentialProvider("default", configPath.toString());
        provider.refresh();
        CredentialValue value = provider.retrieve();

        assertEquals("AK", value.getAk(), "access key");
        assertEquals("SK", value.getSk(), "secret key");
        assertEquals("TOKEN", value.getSessionToken(), "session token");
        System.out.println("PASS: testCliConfigAcceptsHyphenatedConsoleLoginMode");
    }

    static void testRefreshDoesNotRewriteCache() throws Exception {
        Path dir = Files.createTempDirectory("byteplus-console-login-refresh-test");
        Path cacheDir = dir.resolve("login").resolve("cache");
        Files.createDirectories(cacheDir);
        String loginSession = "sess-java-refresh";
        Path cachePath = cacheDir.resolve(sha1Hex(loginSession) + ".json");

        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext(ConsoleOAuthClient.TOKEN_PATH, exchange -> {
            Map<String, String> form = parseForm(exchange);
            assertEquals("refresh_token", form.get("grant_type"), "grant_type");
            assertEquals("old-refresh", form.get("refresh_token"), "refresh token");
            assertEquals("trn:signin:::devtools/same-device", form.get("client_id"), "client id");
            sendJson(exchange, 200, "{"
                    + "\"access_token\":\"{\\\"access_key_id\\\":\\\"NEW\\\",\\\"secret_access_key\\\":\\\"SECRET\\\",\\\"session_token\\\":\\\"TOKEN\\\"}\","
                    + "\"refresh_token\":\"new-refresh\","
                    + "\"id_token\":\"new-id-token\","
                    + "\"token_type\":\"urn:ietf:params:oauth:token-type:access_token_sts\","
                    + "\"expires_in\":900,"
                    + "\"scope\":\"Console:All:All\""
                    + "}");
        });
        server.start();
        try {
            String endpoint = "http://127.0.0.1:" + server.getAddress().getPort();
            Files.write(cachePath, expiredCacheJson(loginSession, "OLD", "old-refresh", endpoint)
                    .getBytes(StandardCharsets.UTF_8));
            String before = new String(Files.readAllBytes(cachePath), StandardCharsets.UTF_8);

            ConsoleLoginRefreshProvider provider =
                    new ConsoleLoginRefreshProvider(loginSession, cacheDir);
            provider.refresh();
            CredentialValue value = provider.retrieve();

            assertEquals("NEW", value.getAk(), "access key");
            assertEquals("SECRET", value.getSk(), "secret key");
            assertEquals("TOKEN", value.getSessionToken(), "session token");
            String after = new String(Files.readAllBytes(cachePath), StandardCharsets.UTF_8);
            assertEquals(before, after, "cache file content");
            System.out.println("PASS: testRefreshDoesNotRewriteCache");
        } finally {
            server.stop(0);
        }
    }

    static void testInvalidGrantReloadsDiskCache() throws Exception {
        Path dir = Files.createTempDirectory("byteplus-console-login-invalid-grant-test");
        Path cacheDir = dir.resolve("login").resolve("cache");
        Files.createDirectories(cacheDir);
        String loginSession = "sess-java-invalid-grant";
        Path cachePath = cacheDir.resolve(sha1Hex(loginSession) + ".json");
        AtomicInteger requests = new AtomicInteger();

        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext(ConsoleOAuthClient.TOKEN_PATH, exchange -> {
            requests.incrementAndGet();
            Map<String, String> form = parseForm(exchange);
            String refreshToken = form.get("refresh_token");
            String endpoint = "http://127.0.0.1:" + exchange.getLocalAddress().getPort();
            if ("old-refresh".equals(refreshToken)) {
                Files.write(cachePath, expiredCacheJson(loginSession, "OLD", "new-refresh", endpoint)
                        .getBytes(StandardCharsets.UTF_8));
                sendJson(exchange, 400, "{"
                        + "\"error\":\"invalid_grant\","
                        + "\"error_description\":\"refresh token expired\""
                        + "}");
                return;
            }
            if ("new-refresh".equals(refreshToken)) {
                sendJson(exchange, 200, "{"
                        + "\"access_token\":\"{\\\"access_key_id\\\":\\\"FALLBACKAK\\\",\\\"secret_access_key\\\":\\\"FALLBACKSK\\\",\\\"session_token\\\":\\\"FALLBACKTOKEN\\\"}\","
                        + "\"refresh_token\":\"rotated-refresh\","
                        + "\"token_type\":\"urn:ietf:params:oauth:token-type:access_token_sts\","
                        + "\"expires_in\":900,"
                        + "\"scope\":\"Console:All:All\""
                        + "}");
                return;
            }
            throw new RuntimeException("Unexpected refresh token: " + refreshToken);
        });
        server.start();
        try {
            String endpoint = "http://127.0.0.1:" + server.getAddress().getPort();
            Files.write(cachePath, expiredCacheJson(loginSession, "OLD", "old-refresh", endpoint)
                    .getBytes(StandardCharsets.UTF_8));

            ConsoleLoginRefreshProvider provider =
                    new ConsoleLoginRefreshProvider(loginSession, cacheDir);
            provider.refresh();
            CredentialValue value = provider.retrieve();

            assertEquals("FALLBACKAK", value.getAk(), "access key");
            assertEquals("FALLBACKSK", value.getSk(), "secret key");
            assertEquals("FALLBACKTOKEN", value.getSessionToken(), "session token");
            if (requests.get() != 2) {
                throw new RuntimeException("Unexpected request count: got " + requests.get() + ", want 2");
            }
            String disk = new String(Files.readAllBytes(cachePath), StandardCharsets.UTF_8);
            if (!disk.contains("\"refresh_token\":\"new-refresh\"")
                    || disk.contains("FALLBACKAK")
                    || disk.contains("rotated-refresh")) {
                throw new RuntimeException("SDK rewrote console-login cache unexpectedly: " + disk);
            }
            System.out.println("PASS: testInvalidGrantReloadsDiskCache");
        } finally {
            server.stop(0);
        }
    }

    private static String expiredCacheJson(String loginSession, String akPrefix,
                                           String refreshToken, String endpoint) {
        return "{"
                + "\"login_session\":\"" + loginSession + "\","
                + "\"access_token\":{"
                + "\"access_key_id\":\"" + akPrefix + "\","
                + "\"secret_access_key\":\"" + akPrefix + "\","
                + "\"session_token\":\"" + akPrefix + "\""
                + "},"
                + "\"refresh_token\":\"" + refreshToken + "\","
                + "\"scope\":\"Console:All:All\","
                + "\"client_id\":\"trn:signin:::devtools/same-device\","
                + "\"endpoint_url\":\"" + endpoint + "\","
                + "\"issued_at\":\"" + Instant.now().minusSeconds(3600).toString() + "\","
                + "\"expires_in\":1,"
                + "\"token_type\":\"urn:ietf:params:oauth:token-type:access_token_sts\""
                + "}";
    }

    private static Map<String, String> parseForm(HttpExchange exchange) throws IOException {
        String body = new String(readAll(exchange), StandardCharsets.UTF_8);
        Map<String, String> result = new HashMap<>();
        if (body.isEmpty()) {
            return result;
        }
        for (String pair : body.split("&")) {
            String[] kv = pair.split("=", 2);
            String key = URLDecoder.decode(kv[0], "UTF-8");
            String value = kv.length > 1 ? URLDecoder.decode(kv[1], "UTF-8") : "";
            result.put(key, value);
        }
        return result;
    }

    private static byte[] readAll(HttpExchange exchange) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n;
        while ((n = exchange.getRequestBody().read(buf)) != -1) {
            out.write(buf, 0, n);
        }
        return out.toByteArray();
    }

    private static void sendJson(HttpExchange exchange, int status, String body) throws IOException {
        byte[] payload = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, payload.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(payload);
        }
    }

    private static String sha1Hex(String input) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] hash = sha1.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    private static void assertEquals(String expected, String actual, String label) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new RuntimeException("Unexpected " + label + ": got " + actual + ", want " + expected);
        }
    }
}
