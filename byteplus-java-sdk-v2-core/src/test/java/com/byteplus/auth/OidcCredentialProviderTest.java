package com.byteplus.auth;

import com.byteplus.ApiException;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.X509Certificate;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.net.ssl.*;

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

    // Keep this tracked test independent of optional local regression helpers.
    private static final class LocalHttpTestServer implements AutoCloseable {
        static final class RecordedRequest {
            final String requestLine;
            final Map<String, String> headers;
            final String body;
            RecordedRequest(String line, Map<String, String> headers, String body) {
                this.requestLine = line;
                this.headers = headers;
                this.body = body;
            }
        }
        final ServerSocket server;
        final Thread worker;
        final List<RecordedRequest> requests = new CopyOnWriteArrayList<RecordedRequest>();
        volatile boolean running = true;

        LocalHttpTestServer(ServerSocket server, int status, String response) {
            this.server = server;
            worker = new Thread(() -> {
                while (running) {
                    try (Socket socket = server.accept()) {
                        socket.setSoTimeout(3000);
                        InputStream in = socket.getInputStream();
                        String requestLine = line(in);
                        Map<String, String> headers = new LinkedHashMap<String, String>();
                        String line;
                        while (!(line = line(in)).isEmpty()) {
                            int colon = line.indexOf(':');
                            if (colon > 0) headers.put(line.substring(0, colon).toLowerCase(Locale.ROOT),
                                    line.substring(colon + 1).trim());
                        }
                        byte[] body = new byte[Integer.parseInt(headers.getOrDefault("content-length", "0"))];
                        new DataInputStream(in).readFully(body);
                        requests.add(new RecordedRequest(requestLine, headers, new String(body, StandardCharsets.UTF_8)));
                        byte[] payload = response.getBytes(StandardCharsets.UTF_8);
                        socket.getOutputStream().write(("HTTP/1.1 " + status + " Status\r\n"
                                + "Content-Type: application/json\r\nContent-Length: " + payload.length
                                + "\r\nConnection: close\r\n\r\n").getBytes(StandardCharsets.US_ASCII));
                        socket.getOutputStream().write(payload);
                        socket.getOutputStream().flush();
                    } catch (IOException ignored) {
                    }
                }
            }, "oidc-local-server");
            worker.setDaemon(true);
            worker.start();
        }
        static LocalHttpTestServer startPlain(int status, String response) throws IOException {
            return new LocalHttpTestServer(new ServerSocket(0, 20, InetAddress.getLoopbackAddress()), status, response);
        }
        static LocalHttpTestServer startTls(SSLContext context, int status, String response) throws IOException {
            return new LocalHttpTestServer(context.getServerSocketFactory()
                    .createServerSocket(0, 20, InetAddress.getLoopbackAddress()), status, response);
        }
        int getPort() { return server.getLocalPort(); }
        List<RecordedRequest> getRequests() { return new ArrayList<RecordedRequest>(requests); }
        static String line(InputStream in) throws IOException {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b;
            while ((b = in.read()) != -1) {
                if (b == '\n') break;
                if (b != '\r') out.write(b);
            }
            return out.toString("UTF-8");
        }
        public void close() throws Exception {
            running = false;
            server.close();
            worker.join(4000);
        }
    }

    private static final class TlsTestMaterials {
        final SSLContext sslContext;
        final X509Certificate certificate;
        TlsTestMaterials(SSLContext context, X509Certificate certificate) {
            this.sslContext = context;
            this.certificate = certificate;
        }
        static TlsTestMaterials tryCreate() {
            try {
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
                generator.initialize(2048);
                KeyPair pair = generator.generateKeyPair();
                Class<?> infoType = Class.forName("sun.security.x509.X509CertInfo");
                Object info = infoType.getConstructor().newInstance();
                Method set = infoType.getMethod("set", String.class, Object.class);
                Object name = Class.forName("sun.security.x509.X500Name").getConstructor(String.class).newInstance("CN=localhost");
                set.invoke(info, "subject", name);
                set.invoke(info, "issuer", name);
                set.invoke(info, "version", Class.forName("sun.security.x509.CertificateVersion")
                        .getConstructor(int.class).newInstance(2));
                set.invoke(info, "serialNumber", Class.forName("sun.security.x509.CertificateSerialNumber")
                        .getConstructor(int.class).newInstance(1));
                set.invoke(info, "validity", Class.forName("sun.security.x509.CertificateValidity")
                        .getConstructor(Date.class, Date.class).newInstance(new Date(System.currentTimeMillis() - 1000),
                                new Date(System.currentTimeMillis() + 86400000L)));
                set.invoke(info, "key", Class.forName("sun.security.x509.CertificateX509Key")
                        .getConstructor(PublicKey.class).newInstance(pair.getPublic()));
                Class<?> algorithmType = Class.forName("sun.security.x509.AlgorithmId");
                Object algorithm = algorithmType.getMethod("get", String.class).invoke(null, "SHA256withRSA");
                set.invoke(info, "algorithmID", Class.forName("sun.security.x509.CertificateAlgorithmId")
                        .getConstructor(algorithmType).newInstance(algorithm));
                Class<?> certType = Class.forName("sun.security.x509.X509CertImpl");
                Object cert = certType.getConstructor(infoType).newInstance(info);
                certType.getMethod("sign", PrivateKey.class, String.class).invoke(cert, pair.getPrivate(), "SHA256withRSA");
                X509Certificate certificate = (X509Certificate) cert;
                KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
                store.load(null, null);
                store.setKeyEntry("local", pair.getPrivate(), "local".toCharArray(),
                        new X509Certificate[]{certificate});
                KeyManagerFactory managers = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                managers.init(store, "local".toCharArray());
                SSLContext context = SSLContext.getInstance("TLS");
                context.init(managers.getKeyManagers(), null, new SecureRandom());
                return new TlsTestMaterials(context, certificate);
            } catch (ReflectiveOperationException | GeneralSecurityException | IOException unavailable) {
                return null;
            }
        }
        void writeCaPem(File file) throws Exception {
            String pem = "-----BEGIN CERTIFICATE-----\n"
                    + Base64.getMimeEncoder(64, new byte[]{'\n'}).encodeToString(certificate.getEncoded())
                    + "\n-----END CERTIFICATE-----\n";
            Files.write(file.toPath(), pem.getBytes(StandardCharsets.US_ASCII));
        }
    }
}
