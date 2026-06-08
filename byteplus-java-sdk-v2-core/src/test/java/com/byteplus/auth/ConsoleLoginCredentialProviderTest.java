package com.byteplus.auth;

import com.byteplus.ApiException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * Manual regression test for reading the exact console-login profile mode and
 * cache layout written by bp login.
 */
public class ConsoleLoginCredentialProviderTest {

    public static void main(String[] args) throws Exception {
        testCliConfigAcceptsHyphenatedConsoleLoginMode();
        System.out.println("All ConsoleLoginCredentialProvider tests passed.");
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

    private static String sha1Hex(String input) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] hash = sha1.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }

    private static void assertEquals(String expected, String actual, String label) throws ApiException {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new ApiException("Unexpected " + label + ": got " + actual + ", want " + expected);
        }
    }
}
