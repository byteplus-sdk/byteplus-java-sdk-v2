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
            // The raw region is validated, values with surrounding whitespace included.
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
     * The default resolver validates the raw region, the same value the request
     * pipeline validates and signs with: surrounding whitespace is rejected
     * instead of being trimmed, letter case is still accepted and lowercased.
     */
    @Test public void testDefaultProvider_regionValidatedAsIs() {
        DefaultEndpointProvider provider = new DefaultEndpointProvider();
        // Letter case is not part of the rule, the host is still lowercased.
        assertEquals("ecs.ap-southeast-1.byteplusapi.com", provider.endpointFor(option("ecs", "AP-Southeast-1", false)).getEndpoint());
        assertEquals("ecs.ap-southeast-1.byteplusapi.com",
                DefaultEndpointProvider.getDefaultEndpointByServiceInfo("ecs", "AP-Southeast-1", null, false));
        String[][] cases = {
                // service, region, quoted region, reason
                {"ecs", " ap-southeast-1 ", "\" ap-southeast-1 \"", "illegal character at index 0"},
                {"ecs", "\tap-southeast-1", "\"\\tap-southeast-1\"", "illegal character at index 0"},
                {"ecs", "cn-beijing\n", "\"cn-beijing\\n\"", "illegal character at index 10"},
                {"iam", " cn-beijing ", "\" cn-beijing \"", "illegal character at index 0"},
                {"iam", "   ", "\"   \"", "illegal character at index 0"},
                {"ecs", "   ", "\"   \"", "illegal character at index 0"},
                {"ecs", " cn/beijing ", "\" cn/beijing \"", "illegal character at index 0"},
                {"ecs", "\tevil.com", "\"\\tevil.com\"", "illegal character at index 0"},
                {"ecs", "cn-beijing- ", "\"cn-beijing- \"", "illegal character at index 11"},
        };
        for (String[] c : cases) {
            for (boolean dual : new boolean[]{false, true}) {
                EndpointValidationException viaProvider = validationCause(assertThrows(ApiException.class,
                        () -> provider.endpointFor(option(c[0], c[1], dual))));
                assertEquals(Arrays.toString(c), "InvalidRegion", viaProvider.getCode());
                assertEquals(Arrays.toString(c), EndpointTestSupport.expectedMessage("region", c[2], c[3]),
                        viaProvider.getErrorMessage());
                EndpointValidationException direct = validationCause(assertThrows(ApiException.class,
                        () -> DefaultEndpointProvider.getDefaultEndpointByServiceInfo(c[0], c[1], null, dual)));
                assertEquals(Arrays.toString(c), "InvalidRegion", direct.getCode());
                assertEquals(Arrays.toString(c), EndpointTestSupport.expectedMessage("region", c[2], c[3]),
                        direct.getErrorMessage());
            }
        }
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
