package com.byteplus;

import com.byteplus.EndpointTestSupport.Fixture;
import com.byteplus.EndpointTestSupport.Resolver;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** Universal client: the service name is provided by the caller. */
public class UniversalApiSpecTest {

    private static UniversalRequest request(String service) {
        return new UniversalRequest(service, "DescribeInstances", "2020-04-01");
    }

    @Test public void testRawServiceRejectedBeforePathIsBuilt() throws Exception {
        for (String service : EndpointTestSupport.invalidValues()) {
            for (Resolver resolver : new Resolver[]{Resolver.DEFAULT, Resolver.FAILING}) {
                try (Fixture f = new Fixture("ap-southeast-1", resolver)) {
                    UniversalApi api = new UniversalApi(f.client);
                    UniversalRequest request = request(service);
                    EndpointTestSupport.assertApiValidationError("service", service,
                            assertThrows(ApiException.class, () -> api.doCall(request, Collections.emptyMap())));
                    f.assertUntouched();
                    assertEquals(0, f.resolverCalls.get());
                    assertEquals(service, request.getServiceName());
                }
            }
        }
    }

    @Test public void testInvalidRegionRejected() throws Exception {
        for (String region : EndpointTestSupport.invalidValues()) {
            try (Fixture f = new Fixture(region, Resolver.FAILING)) {
                UniversalApi api = new UniversalApi(f.client);
                EndpointTestSupport.assertApiValidationError("region", region,
                        assertThrows(ApiException.class, () -> api.doCall(request("ecs"), Collections.emptyMap())));
                f.assertUntouched();
            }
        }
    }

    @Test public void testValidServicesAndRecovery() throws Exception {
        try (Fixture f = new Fixture("cn-beijing@127.0.0.1", Resolver.DEFAULT)) {
            UniversalApi api = new UniversalApi(f.client);
            assertThrows(ApiException.class, () -> api.doCall(request("ecs"), Collections.emptyMap()));
            f.assertUntouched();
            f.client.setRegion("ap-southeast-1");
            int n = 0;
            // 默认解析器只接受已注册的服务（原有行为），这里覆盖全局、地域和带下划线的服务。
            for (String service : new String[]{"ecs", "rds_mysql", "iam", "auto_scaling", "id"}) {
                Map<String, Object> result = api.doCall(request(service), Collections.emptyMap());
                n++;
                assertEquals(Boolean.TRUE, ((Map<?, ?>) result.get("Result")).get("ok"));
                assertTrue(f.http.lastRequest.header("Authorization").contains("/ap-southeast-1/" + service + "/request"));
            }
            assertEquals("rds-mysql.ap-southeast-1.byteplusapi.com", hostFor(api, f, "rds_mysql"));
            f.assertSigned(n + 1);
        }
    }

    private static String hostFor(UniversalApi api, Fixture f, String service) throws ApiException {
        api.doCall(request(service), Collections.emptyMap());
        return f.http.lastRequest.httpUrl().host();
    }

    /** With an explicit endpoint the host is used as is (same as the generated clients). */
    @Test public void testExplicitEndpoint() throws Exception {
        try (Fixture f = new Fixture("custom.region", Resolver.FAILING)) {
            f.client.setEndpoint("universal.internal.example");
            new UniversalApi(f.client).doCall(request("ecs"), Collections.emptyMap());
            assertEquals("universal.internal.example", f.http.lastRequest.httpUrl().host());
            f.assertSigned(1);
        }
    }
}
