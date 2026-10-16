package com.byteplus.endpoint;

import com.byteplus.ApiException;
import com.byteplus.EndpointTestSupport;
import java.lang.reflect.Constructor;
import java.util.*;
import org.junit.Test;
import static com.byteplus.EndpointTestSupport.option;
import static org.junit.Assert.*;

public class EndpointProviderSpecTest {

    /** Global and regional services, .cn and international regions, dual stack. */
    private static final String[] DEFAULT_SERVICES = {"ecs", "rds_mysql", "iam", "smc", "unknown_service"};

    private static EndpointValidationException validationCause(ApiException e) {
        assertEquals(400, e.getCode());
        assertTrue("cause: " + e.getCause(), e.getCause() instanceof EndpointValidationException);
        return (EndpointValidationException) e.getCause();
    }

    @Test public void testDefaultProvider_invalidRegionRejectedBeforeAnyBranch() {
        DefaultEndpointProvider provider = new DefaultEndpointProvider();
        for (String region : EndpointTestSupport.invalidValues()) {
            // The default resolver trims the region before using it, see testDefaultProvider_regionValidatedAfterNormalization.
            if (!region.equals(region.trim())) continue;
            for (String service : DEFAULT_SERVICES) {
                for (boolean dual : new boolean[]{false, true}) {
                    ResolveEndpointOption o = option(service, region, dual);
                    EndpointTestSupport.assertValidationError("region", region,
                            validationCause(assertThrows(ApiException.class, () -> provider.endpointFor(o))));
                    EndpointTestSupport.assertValidationError("region", region, validationCause(assertThrows(ApiException.class,
                            () -> DefaultEndpointProvider.getDefaultEndpointByServiceInfo(service, region, null, dual))));
                }
            }
        }
    }

    @Test public void testDefaultProvider_invalidServiceRejectedBeforeAnyBranch() {
        DefaultEndpointProvider provider = new DefaultEndpointProvider();
        for (String service : EndpointTestSupport.invalidValues()) {
            for (String region : new String[]{"ap-southeast-1", "cn-beijing", "cn-hongkong"}) {
                for (boolean dual : new boolean[]{false, true}) {
                    EndpointTestSupport.assertValidationError("service", service, validationCause(assertThrows(
                            ApiException.class, () -> provider.endpointFor(option(service, region, dual)))));
                }
            }
        }
    }

    @Test public void testDefaultProvider_validValuesResolveToTheSameHosts() {
        DefaultEndpointProvider provider = new DefaultEndpointProvider();
        String[][] cases = {
                // service, region, dual, expected host
                {"ecs", "ap-southeast-1", "false", "ecs.ap-southeast-1.byteplusapi.com"},
                {"ecs", "ap-southeast-1", "true", "ecs.ap-southeast-1.byteplus-api.com"},
                {"ecs", "AP-Southeast-1", "false", "ecs.ap-southeast-1.byteplusapi.com"},
                {"ecs", "cn-beijing", "false", "ecs.cn-beijing.byteplusapi.com.cn"},
                {"ecs", "cn-hongkong", "true", "ecs.cn-hongkong.byteplus-api.com"},
                {"iam", "ap-southeast-1", "false", "iam.byteplusapi.com"},
                {"iam", "cn-beijing", "true", "iam.byteplus-api.com.cn"},
                {"smc", "cn-beijing", "false", "smc.byteplusapi.com"},
                {"rds_mysql", "ap-southeast-1", "false", "rds-mysql.ap-southeast-1.byteplusapi.com"},
        };
        for (String[] c : cases) {
            assertEquals(Arrays.toString(c), c[3],
                    provider.endpointFor(option(c[0], c[1], Boolean.parseBoolean(c[2]))).getEndpoint());
        }
        // Missing values keep their previous handling.
        assertEquals("ecs..byteplusapi.com", provider.endpointFor(option("ecs", "", false)).getEndpoint());
        assertEquals("ecs..byteplusapi.com", provider.endpointFor(option("ecs", null, false)).getEndpoint());
        assertEquals("service 'unknown_service' not registered in default endpoint map",
                assertThrows(ApiException.class, () -> provider.endpointFor(option("unknown_service", "ap-southeast-1", false))).getMessage());
    }

    /**
     * The default resolver places the trimmed and lowercased region in the host:
     * that is the value validated, so inputs it accepted before resolve to the
     * same hosts, and values still invalid after normalization are rejected.
     */
    @Test public void testDefaultProvider_regionValidatedAfterNormalization() {
        DefaultEndpointProvider provider = new DefaultEndpointProvider();
        String[][] cases = {
                // service, region, expected host (same as before the change)
                {"ecs", " ap-southeast-1 ", "ecs.ap-southeast-1.byteplusapi.com"},
                {"ecs", "\tap-southeast-1", "ecs.ap-southeast-1.byteplusapi.com"},
                {"ecs", "cn-beijing\n", "ecs.cn-beijing.byteplusapi.com.cn"},
                {"ecs", "AP-Southeast-1", "ecs.ap-southeast-1.byteplusapi.com"},
                {"iam", " cn-beijing ", "iam.byteplusapi.com.cn"},
                {"iam", "   ", "iam.byteplusapi.com"},
                {"ecs", "   ", "ecs..byteplusapi.com"},
        };
        for (String[] c : cases) {
            assertEquals(Arrays.toString(c), c[2], provider.endpointFor(option(c[0], c[1], false)).getEndpoint());
            assertEquals(c[2], DefaultEndpointProvider.getDefaultEndpointByServiceInfo(c[0], c[1], null, false));
        }
        for (String region : new String[]{" cn/beijing ", "\tevil.com", " cn-beijing@127.0.0.1\n", " 1cn-beijing", "cn-beijing- "}) {
            EndpointValidationException e = validationCause(assertThrows(ApiException.class,
                    () -> provider.endpointFor(option("ecs", region, false))));
            assertEquals("InvalidRegion", e.getCode());
        }
        assertTrue(validationCause(assertThrows(ApiException.class, () -> provider.endpointFor(option("ecs", " cn/beijing ", false))))
                .getErrorMessage().startsWith("invalid region \"cn/beijing\": illegal character at index 2,"));
        // The request pipeline still validates the raw region, which is also used to sign.
        assertEquals("InvalidRegion", assertThrows(EndpointValidationException.class,
                () -> EndpointValidation.validateRegion(" ap-southeast-1 ")).getCode());
    }

    /** Blank values keep the errors reported before the change. */
    @Test public void testStandardProvider_blankValuesKeepPreviousErrors() {
        StandardEndpointProvider provider = new StandardEndpointProvider();
        for (String blank : new String[]{null, "", "   ", "\t"}) {
            assertEquals("region must not be null.", assertThrows(IllegalArgumentException.class,
                    () -> provider.endpointFor(option("ecs", blank, false))).getMessage());
            assertEquals("service must not be null.", assertThrows(IllegalArgumentException.class,
                    () -> provider.endpointFor(option(blank, "ap-southeast-1", false))).getMessage());
        }
    }

    @Test public void testStandardProvider_invalidRegionAndServiceRejected() {
        StandardEndpointProvider provider = new StandardEndpointProvider();
        for (String value : EndpointTestSupport.invalidValues()) {
            for (boolean dual : new boolean[]{false, true}) {
                EndpointTestSupport.assertValidationError("region", value, assertThrows(
                        EndpointValidationException.class, () -> provider.endpointFor(option("ecs", value, dual))));
                EndpointTestSupport.assertValidationError("region", value, assertThrows(
                        EndpointValidationException.class, () -> provider.endpointFor(option("billing", value, dual))));
                EndpointTestSupport.assertValidationError("service", value, assertThrows(
                        EndpointValidationException.class, () -> provider.endpointFor(option(value, "ap-southeast-1", dual))));
            }
        }
    }

    /** Custom services are looked up by name and the name is rendered into the host. */
    @Test public void testStandardProvider_customServiceBranchValidated() throws Exception {
        Map<String, Object> custom = new HashMap<>();
        for (String value : EndpointTestSupport.invalidValues()) custom.put(value, serviceInfo(value, false));
        custom.put("my_svc", serviceInfo("my_svc", false));
        custom.put("my_global", serviceInfo("my_global", true));
        StandardEndpointProvider provider = newStandardProvider(custom);
        for (String value : EndpointTestSupport.invalidValues()) {
            EndpointTestSupport.assertValidationError("service", value, assertThrows(
                    EndpointValidationException.class, () -> provider.endpointFor(option(value, "ap-southeast-1", false))));
        }
        assertEquals("my-svc.ap-southeast-1.byteplusapi.com", provider.endpointFor(option("my_svc", "ap-southeast-1", false)).getEndpoint());
        assertEquals("my-global.byteplus-api.com", provider.endpointFor(option("my_global", "ap-southeast-1", true)).getEndpoint());
    }

    @Test public void testStandardProvider_validValuesResolveToTheSameHosts() {
        StandardEndpointProvider provider = new StandardEndpointProvider();
        assertEquals("ecs.ap-southeast-1.byteplusapi.com", provider.endpointFor(option("ecs", "ap-southeast-1", false)).getEndpoint());
        assertEquals("ecs.cn-beijing.byteplusapi.com.cn", provider.endpointFor(option("ecs", "cn-beijing", false)).getEndpoint());
        assertEquals("rds-mysql.ap-southeast-1.byteplus-api.com", provider.endpointFor(option("rds_mysql", "ap-southeast-1", true)).getEndpoint());
        assertEquals("iam.byteplusapi.com", provider.endpointFor(option("iam", "cn-beijing", false)).getEndpoint());
        // Missing values keep their previous handling.
        assertEquals("region must not be null.", assertThrows(IllegalArgumentException.class,
                () -> provider.endpointFor(option("ecs", null, false))).getMessage());
        assertEquals("service must not be null.", assertThrows(IllegalArgumentException.class,
                () -> provider.endpointFor(option("", "ap-southeast-1", false))).getMessage());
        // Values matching the rule but unknown to the resolver keep the previous errors.
        assertTrue(assertThrows(IllegalArgumentException.class, () -> provider.endpointFor(option("ecs", "Redis", false)))
                .getMessage().startsWith("InvalidRegion: invalid region [Redis] for standard endpoint resolver"));
        assertTrue(assertThrows(IllegalArgumentException.class, () -> provider.endpointFor(option("not_a_service", "ap-southeast-1", false)))
                .getMessage().startsWith("ServiceNotFound:"));
    }

    @Test public void testStandardProvider_failedResolutionDoesNotAffectNextOne() {
        StandardEndpointProvider shared = new StandardEndpointProvider();
        assertThrows(EndpointValidationException.class, () -> shared.endpointFor(option("ecs", "cn-beijing@127.0.0.1", false)));
        assertThrows(EndpointValidationException.class, () -> shared.endpointFor(option("evil.com#", "ap-southeast-1", false)));
        assertEquals("ecs.ap-southeast-1.byteplusapi.com", shared.endpointFor(option("ecs", "ap-southeast-1", false)).getEndpoint());
    }

    static Object serviceInfo(String service, boolean global) throws Exception {
        Class<?> type = Class.forName("com.byteplus.endpoint.StandardEndpointProvider$ServiceInfo");
        Constructor<?> constructor = type.getDeclaredConstructor(String.class, boolean.class);
        constructor.setAccessible(true);
        return constructor.newInstance(service, global);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static StandardEndpointProvider newStandardProvider(Map<String, Object> custom) {
        return new StandardEndpointProvider(null, StandardEndpointProvider.SiteStackByteplusIPv4, new HashMap<>(), (Map) custom);
    }
}
