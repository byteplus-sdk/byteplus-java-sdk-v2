package com.byteplus.auth;

import com.byteplus.ApiException;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;

/**
 * End-to-end tests for {@link OidcCredentialProvider} covering the proxy/TLS
 * parameters wired into the STS form-POST path.
 */
public class OidcCredentialProviderTest {

    private static final String STS_OK_RESPONSE = "{"
            + "\"ResponseMetadata\":{\"RequestId\":\"req-1\"},"
            + "\"Result\":{\"Credentials\":{"
            + "\"AccessKeyId\":\"AKmock\","
            + "\"SecretAccessKey\":\"SKmock\","
            + "\"SessionToken\":\"STmock\","
            + "\"Expiration\":\"2100-01-01T00:00:00Z\"}}}";

    private File writeTokenFile() throws Exception {
        File tokenFile = File.createTempFile("oidc-token", ".jwt");
        tokenFile.deleteOnExit();
        Files.write(tokenFile.toPath(), "fake-oidc-token".getBytes(StandardCharsets.UTF_8));
        return tokenFile;
    }

    private OidcCredentialProvider newProvider(String endpoint) throws Exception {
        return new OidcCredentialProvider(
                "trn:iam::123:role/r", "sess", writeTokenFile().getAbsolutePath(), null, endpoint);
    }

    @Test
    public void refreshSucceedsOverPlainHttpDirect() throws Exception {
        try (LocalHttpTestServer server = LocalHttpTestServer.startPlain(200, STS_OK_RESPONSE)) {
            OidcCredentialProvider provider = newProvider("localhost:" + server.getPort());
            provider.setSchema("http");
            provider.setMaxRetries(0);

            provider.refresh();
            CredentialValue value = provider.retrieve();

            assertEquals("AKmock", value.getAk());
            assertEquals("SKmock", value.getSk());
            assertEquals("STmock", value.getSessionToken());
            assertEquals("OidcCredentialProvider", value.getProviderName());
            assertFalse(provider.isExpired());

            List<LocalHttpTestServer.RecordedRequest> requests = server.getRequests();
            assertEquals(1, requests.size());
            // Direct (non-proxied) request uses origin-form: "POST /path HTTP/1.1".
            assertTrue(requests.get(0).requestLine.startsWith("POST /?Action=AssumeRoleWithOIDC"));
            assertTrue(requests.get(0).body.contains("OIDCToken=fake-oidc-token"));
        }
    }

    @Test
    public void refreshRoutesThroughProxy() throws Exception {
        try (LocalHttpTestServer proxy = LocalHttpTestServer.startPlain(200, STS_OK_RESPONSE)) {
            // Target host is unreachable on its own; success proves the request
            // went to the proxy, which serves the canned STS response.
            OidcCredentialProvider provider = newProvider("sts.invalid.example:80");
            provider.setSchema("http");
            provider.setMaxRetries(0);
            provider.setProxyUrl("http://127.0.0.1:" + proxy.getPort());

            provider.refresh();
            assertEquals("AKmock", provider.retrieve().getAk());

            List<LocalHttpTestServer.RecordedRequest> requests = proxy.getRequests();
            assertEquals(1, requests.size());
            // Proxied HTTP request uses absolute-form request line.
            assertTrue(requests.get(0).requestLine.startsWith("POST http://sts.invalid.example:80/?Action=AssumeRoleWithOIDC"));
        }
    }

    @Test
    public void refreshSendsProxyAuthorizationHeader() throws Exception {
        try (LocalHttpTestServer proxy = LocalHttpTestServer.startPlain(200, STS_OK_RESPONSE)) {
            OidcCredentialProvider provider = newProvider("sts.invalid.example:80");
            provider.setSchema("http");
            provider.setMaxRetries(0);
            provider.setProxyUrl("http://user:secret@127.0.0.1:" + proxy.getPort());

            provider.refresh();

            List<LocalHttpTestServer.RecordedRequest> requests = proxy.getRequests();
            assertEquals(1, requests.size());
            String auth = requests.get(0).headers.get("proxy-authorization");
            assertNotNull(auth);
            String expected = "Basic " + java.util.Base64.getEncoder()
                    .encodeToString("user:secret".getBytes(StandardCharsets.UTF_8));
            assertEquals(expected, auth);
        }
    }

    @Test
    public void refreshSucceedsOverTlsWithCaFile() throws Exception {
        TlsTestMaterials materials = TlsTestMaterials.tryCreate();
        assumeNotNull(materials);

        File caFile = File.createTempFile("sts-ca", ".pem");
        caFile.deleteOnExit();
        materials.writeCaPem(caFile);

        try (LocalHttpTestServer server = LocalHttpTestServer.startTls(materials.sslContext, 200, STS_OK_RESPONSE)) {
            OidcCredentialProvider provider = newProvider("localhost:" + server.getPort());
            provider.setSchema("https");
            provider.setMaxRetries(0);
            provider.setCaFile(caFile.getAbsolutePath());

            provider.refresh();
            assertEquals("AKmock", provider.retrieve().getAk());
        }
    }

    @Test
    public void refreshSucceedsOverTlsWithInsecureSkipVerify() throws Exception {
        TlsTestMaterials materials = TlsTestMaterials.tryCreate();
        assumeNotNull(materials);

        try (LocalHttpTestServer server = LocalHttpTestServer.startTls(materials.sslContext, 200, STS_OK_RESPONSE)) {
            OidcCredentialProvider provider = newProvider("localhost:" + server.getPort());
            provider.setSchema("https");
            provider.setMaxRetries(0);
            provider.setInsecureSkipVerify(true);

            provider.refresh();
            assertEquals("AKmock", provider.retrieve().getAk());
        }
    }

    @Test
    public void refreshFailsOverTlsWithoutTrust() throws Exception {
        TlsTestMaterials materials = TlsTestMaterials.tryCreate();
        assumeNotNull(materials);

        try (LocalHttpTestServer server = LocalHttpTestServer.startTls(materials.sslContext, 200, STS_OK_RESPONSE)) {
            OidcCredentialProvider provider = newProvider("localhost:" + server.getPort());
            provider.setSchema("https");
            provider.setMaxRetries(0);
            // No CAFile, no InsecureSkipVerify: self-signed cert must be rejected.

            try {
                provider.refresh();
                fail("expected TLS verification failure");
            } catch (ApiException expected) {
                // Network/TLS errors surface as ApiException from the STS helper.
            }
        }
    }

    @Test
    public void constructorRejectsMissingRequiredParams() {
        try {
            new OidcCredentialProvider(null, "sess", "/tmp/token", null, null);
            fail("expected IllegalArgumentException for null roleTrn");
        } catch (IllegalArgumentException expected) {
        }
        try {
            new OidcCredentialProvider("trn:role", "sess", null, null, null);
            fail("expected IllegalArgumentException for null oidcTokenFile");
        } catch (IllegalArgumentException expected) {
        }
    }
}
