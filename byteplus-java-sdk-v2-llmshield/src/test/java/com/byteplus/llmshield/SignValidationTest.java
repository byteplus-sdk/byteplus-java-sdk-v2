package com.byteplus.llmshield;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Signing exits of the llmshield client. Requests go to an in-process HTTP
 * server on the loopback interface, no external network is used.
 */
public class SignValidationTest {
    private HttpServer server;
    private final AtomicInteger requests = new AtomicInteger();
    private final List<String> authorizations = Collections.synchronizedList(new ArrayList<String>());
    private final List<String> hosts = Collections.synchronizedList(new ArrayList<String>());
    private String url;

    @Before public void startServer() throws Exception {
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/", exchange -> {
            requests.incrementAndGet();
            authorizations.add(exchange.getRequestHeaders().getFirst("Authorization"));
            hosts.add(exchange.getRequestHeaders().getFirst("Host"));
            byte[] body = "{\"ResponseMetadata\":{\"RequestId\":\"unit-test\"},\"Result\":{}}".getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length);
            exchange.getResponseBody().write(body);
            exchange.close();
        });
        server.start();
        url = "http://127.0.0.1:" + server.getAddress().getPort();
    }

    @After public void stopServer() {
        server.stop(0);
    }

    private static HttpPost plainRequest() {
        HttpPost post = new HttpPost("https://llmshield.example/v2/moderate?Action=Moderate&Version=2025-08-31");
        post.setEntity(new StringEntity("{}", StandardCharsets.UTF_8));
        return post;
    }

    private static ModerateV2Request streamRequest() {
        MessageV2 message = new MessageV2();
        message.setRole("user");
        message.setContent("hello");
        ModerateV2Request request = new ModerateV2Request();
        request.setMessage(message);
        request.setUseStream(1);
        return request;
    }

    @Test public void testDoSignRequest_invalidRegionNotSigned() throws Exception {
        for (String region : ValidationCases.invalidValues()) {
            HttpPost request = plainRequest();
            ValidationCases.assertValidationError("region", region, assertThrows(EndpointValidationException.class,
                    () -> new Sign().DoSignRequest(request, request.getUri(), "Moderate", "<TEST_AK>", "<TEST_SK>", region, null)));
            assertNull(request.getFirstHeader("Authorization"));
            assertNull(request.getFirstHeader("X-Date"));
            assertNull(request.getFirstHeader("X-Top-Region"));
        }
    }

    @Test public void testDoSignRequest_validRegionSigned() throws Exception {
        for (String region : new String[]{"ap-southeast-1", "cn-beijing", "Rds_mysql-2"}) {
            HttpPost request = plainRequest();
            new Sign().DoSignRequest(request, request.getUri(), "Moderate", "<TEST_AK>", "<TEST_SK>", region);
            assertTrue(request.getFirstHeader("Authorization").getValue()
                    .contains("/" + region + "/" + Sign.getServiceCode() + "/request"));
            assertNotNull(request.getFirstHeader("X-Date"));
            assertEquals(region, request.getFirstHeader("X-Top-Region").getValue());
        }
    }

    /** Construction never fails; every request API fails before signing and sending. */
    @Test public void testClientApis_invalidRegionNoRequestSent() throws Exception {
        for (String region : ValidationCases.invalidValues()) {
            ApiClient client = ApiClient.New(url, "<TEST_AK>", "<TEST_SK>", region, 5000);
            try {
                ValidationCases.assertValidationError("region", region,
                        assertThrows(EndpointValidationException.class, () -> client.Moderate(new ModerateV2Request())));
                ValidationCases.assertValidationError("region", region, assertThrows(EndpointValidationException.class,
                        () -> client.ModerateStream(streamRequest(), new ModerateV2StreamSession())));
                ValidationCases.assertValidationError("region", region,
                        assertThrows(EndpointValidationException.class, () -> client.GenerateV2Stream(new GenerateStreamV2Request())));
            } finally {
                client.Close();
            }
            ApiClient withOptions = ApiClient.NewWithOptions(url, "<TEST_AK>", "<TEST_SK>", region, "{\"Timeout\":5000}");
            try {
                ValidationCases.assertValidationError("region", region,
                        assertThrows(EndpointValidationException.class, () -> withOptions.Moderate(new ModerateV2Request())));
            } finally {
                withOptions.Close();
            }
        }
        assertEquals(0, requests.get());
    }

    /** Valid regions keep working: the request reaches the configured URL and is signed. */
    @Test public void testClientApis_validRegionRequestSentToConfiguredHost() throws Exception {
        ApiClient client = ApiClient.New(url, "<TEST_AK>", "<TEST_SK>", "ap-southeast-1", 5000);
        try {
            assertNotNull(client.Moderate(new ModerateV2Request()));
            assertNotNull(client.ModerateStream(streamRequest(), new ModerateV2StreamSession()));
            try (GenerateStreamV2Response ignored = client.GenerateV2Stream(new GenerateStreamV2Request())) {
                assertNotNull(ignored);
            }
        } finally {
            client.Close();
        }
        assertEquals(3, requests.get());
        for (String auth : authorizations) {
            assertTrue(auth, auth.contains("/ap-southeast-1/" + Sign.getServiceCode() + "/request"));
        }
        for (String host : hosts) assertEquals("127.0.0.1:" + server.getAddress().getPort(), host);
    }
}
