package com.byteplus.endpoint;

import com.byteplus.EndpointTestSupport;
import com.byteplus.auth.StsAssumeRoleProvider;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.Assume;
import org.junit.Test;
import static com.byteplus.EndpointTestSupport.option;
import static org.junit.Assert.*;

/**
 * Every built-in service and region must pass the validation, and the endpoints
 * resolved for them must be the ones the resolvers produced before.
 */
public class BuiltinNamesTest {

    private static Object staticField(Class<?> type, String name) throws Exception {
        Field f = type.getDeclaredField(name);
        f.setAccessible(true);
        return f.get(null);
    }

    private static Object field(Object target, String name) throws Exception {
        Field f = target.getClass().getDeclaredField(name);
        f.setAccessible(true);
        return f.get(target);
    }

    private static Map<?, ?> defaultEndpointMap() throws Exception {
        return (Map<?, ?>) staticField(DefaultEndpointProvider.class, "DEFAULT_ENDPOINT_MAP");
    }

    private static Map<?, ?> standardServiceInfos() throws Exception {
        return (Map<?, ?>) staticField(StandardEndpointProvider.class, "SERVICE_INFOS");
    }

    private static Set<String> builtinServices() throws Exception {
        Set<String> services = new TreeSet<>();
        for (Map.Entry<?, ?> e : defaultEndpointMap().entrySet()) {
            services.add((String) e.getKey());
            services.add((String) field(e.getValue(), "service"));
        }
        for (Map.Entry<?, ?> e : standardServiceInfos().entrySet()) {
            services.add((String) e.getKey());
            services.add((String) field(e.getValue(), "service"));
        }
        for (Map.Entry<String, ServiceEndpointInfo> e : DefaultEndpointResolver.defaultEndpointMap.entrySet()) {
            services.add(e.getKey());
            services.add(e.getValue().getService());
        }
        services.add((String) staticField(com.byteplus.feature.rds.auth.ConnectUtils.class, "SERVICE_NAME"));
        services.addAll(generatedApiServices());
        return services;
    }

    @SuppressWarnings("unchecked")
    private static Set<String> builtinRegions() throws Exception {
        Set<String> regions = new TreeSet<>();
        for (Field f : DefaultEndpointProvider.class.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers()) && f.getName().startsWith("REGION_CODE_")) {
                f.setAccessible(true);
                regions.add((String) f.get(null));
            }
        }
        regions.addAll((Set<String>) staticField(DefaultEndpointProvider.class, "CN_NONE_MAINLAND_REGION_SET"));
        Object matcher = staticField(StandardEndpointProvider.class, "REGION_MATCHER");
        regions.addAll(((Map<String, ?>) field(matcher, "whiteRegions")).keySet());
        regions.addAll(((Map<String, ?>) staticField(StandardEndpointProvider.class, "CN_NON_MAINLAND_REGIONS")).keySet());
        // Default instances.
        regions.add(new StsAssumeRoleProvider("<TEST_AK>", "<TEST_SK>", "role", "account").getRegion());
        regions.add("ap-southeast-1"); // SsoPortalClient and CLI config default
        return regions;
    }

    /**
     * Service names of the generated API clients of every module: the third
     * segment of each {@code localVarPath}. Empty when the sources of the
     * other modules are not available.
     */
    static Set<String> generatedApiServices() throws IOException {
        Path root = Paths.get("..").toAbsolutePath().normalize();
        Set<String> services = new TreeSet<>();
        if (!Files.isDirectory(root.resolve("byteplus-java-sdk-v2-ecs"))) return services;
        Pattern path = Pattern.compile("localVarPath = \"/[^/\"]*/[^/\"]*/([^/\"]*)/");
        try (Stream<Path> files = Files.walk(root, 12)) {
            for (Path p : (Iterable<Path>) files::iterator) {
                String name = p.toString();
                if (!name.endsWith("Api.java") || !name.contains("/src/main/java/")) continue;
                Matcher m = path.matcher(new String(Files.readAllBytes(p), StandardCharsets.UTF_8));
                while (m.find()) services.add(m.group(1));
            }
        }
        return services;
    }

    @Test public void testAllBuiltinNamesPassValidation() throws Exception {
        Set<String> services = builtinServices();
        Set<String> regions = builtinRegions();
        assertTrue("services: " + services.size(), services.size() >= 100);
        assertTrue("regions: " + regions.size(), regions.size() >= 50);
        for (String s : services) EndpointValidation.validateService(s);
        for (String r : regions) EndpointValidation.validateRegion(r);
        Set<String> generated = generatedApiServices();
        Assume.assumeFalse("generated API sources not available", generated.isEmpty());
        assertTrue("generated services: " + generated.size(), generated.size() >= 40);
    }

    private static String std(String service) {
        return service.toLowerCase(Locale.ROOT).replaceAll("_", "-");
    }

    private static boolean isCnMainland(String region, Set<String> nonMainland) {
        return region.startsWith("cn-") && !nonMainland.contains(region);
    }

    @SuppressWarnings("unchecked")
    @Test public void testBuiltinNamesResolveToTheSameHosts() throws Exception {
        Set<String> regions = builtinRegions();
        Map<?, ?> map = defaultEndpointMap();
        Set<String> defaultNonMainland = (Set<String>) staticField(DefaultEndpointProvider.class, "CN_NONE_MAINLAND_REGION_SET");
        DefaultEndpointProvider defaults = new DefaultEndpointProvider();
        int checked = 0;
        for (Map.Entry<?, ?> e : map.entrySet()) {
            String service = (String) e.getKey();
            boolean global = (Boolean) field(e.getValue(), "isGlobal");
            boolean goChina = (Boolean) field(e.getValue(), "goChinaEnabled");
            for (String region : regions) {
                for (boolean dual : new boolean[]{false, true}) {
                    String suffix = (dual ? ".byteplus-api.com" : ".byteplusapi.com")
                            + (goChina && isCnMainland(region, defaultNonMainland) ? ".cn" : "");
                    String expected = std(service) + (global ? "" : "." + region) + suffix;
                    assertEquals(service + "/" + region, expected, defaults.endpointFor(option(service, region, dual)).getEndpoint());
                    checked++;
                }
            }
        }
        StandardEndpointProvider standard = new StandardEndpointProvider();
        Object matcher = staticField(StandardEndpointProvider.class, "REGION_MATCHER");
        Set<String> white = ((Map<String, ?>) field(matcher, "whiteRegions")).keySet();
        Set<String> standardNonMainland = ((Map<String, ?>) staticField(StandardEndpointProvider.class, "CN_NON_MAINLAND_REGIONS")).keySet();
        for (Map.Entry<?, ?> e : standardServiceInfos().entrySet()) {
            String service = (String) e.getKey();
            boolean global = (Boolean) field(e.getValue(), "isGlobal");
            for (String region : white) {
                for (boolean dual : new boolean[]{false, true}) {
                    String expected = std(service) + (global ? "" : "." + region)
                            + (dual ? ".byteplus-api.com" : ".byteplusapi.com")
                            + (!global && isCnMainland(region, standardNonMainland) ? ".cn" : "");
                    assertEquals(expected, standard.endpointFor(option(service, region, dual)).getEndpoint());
                    checked++;
                }
            }
        }
        assertTrue(checked > 10000);
    }

    /** End to end: requests of every generated service registered in the default resolver are signed and go to the same host. */
    @Test public void testGeneratedServicesRequestsUnchanged() throws Exception {
        Set<String> generated = generatedApiServices();
        Assume.assumeFalse("generated API sources not available", generated.isEmpty());
        Map<?, ?> map = defaultEndpointMap();
        try (EndpointTestSupport.Fixture f = new EndpointTestSupport.Fixture("ap-southeast-1", EndpointTestSupport.Resolver.DEFAULT)) {
            int n = 0;
            for (String service : generated) {
                Object info = map.get(service);
                if (info == null) continue; // the default resolver rejects unregistered services, unchanged
                f.client.execute(f.call(service), Map.class);
                n++;
                String expected = std(service) + ((Boolean) field(info, "isGlobal") ? "" : ".ap-southeast-1") + ".byteplusapi.com";
                assertEquals(service, expected, f.http.lastRequest.httpUrl().host());
                assertTrue(f.http.lastRequest.header("Authorization").contains("/ap-southeast-1/" + service + "/request"));
            }
            assertTrue("services exercised: " + n, n >= 30);
            f.assertSigned(n);
        }
    }
}
