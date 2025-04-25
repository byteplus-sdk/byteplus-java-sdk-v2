package com.byteplus.endpoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DefaultEndpointProvider implements EndpointResolver {


    // 区域代码常量
    private static final String REGION_CODE_CN_BEIJING_AUTODRIVING = "cn-beijing-autodriving";
    private static final String REGION_CODE_AP_SOUTH_EAST_2 = "ap-southeast-2";
    private static final String REGION_CODE_AP_SOUTH_EAST_3 = "ap-southeast-3";
    private static final String REGION_CODE_CN_HONGKONG = "cn-hongkong";
    // 常量
    private static final String SEPARATOR = ".";
    private static final String OPEN_PREFIX = "open";
    private static final String ENDPOINT_SUFFIX = SEPARATOR + "byteplusapi.com";
    private static final String AP_SOUTHEAST_1_PREFIX = SEPARATOR + "ap-southeast-1";
    private static final String ENDPOINT = OPEN_PREFIX + ENDPOINT_SUFFIX;
    private static final String BYTEPLUS_ORIGIN_ENDPOINT_SUFFIX = SEPARATOR + "byteplusapi.com";
    private static final String BYTEPLUS_ORIGIN_ENDPOINT = OPEN_PREFIX + BYTEPLUS_ORIGIN_ENDPOINT_SUFFIX;


    private static final String DUALSTACK_ENDPOINT_SUFFIX = SEPARATOR + "byteplus-api.com";
    private static final Map<String, ServiceEndpointInfo> DEFAULT_ENDPOINT_MAP = new HashMap<>();
    private static final Set<String> BOOTSTRAP_REGION = new HashSet<>();

    // 区域端点映射类型
    private static class RegionEndpointMap extends HashMap<String, String> {
    }

    static {
        BOOTSTRAP_REGION.add(REGION_CODE_AP_SOUTH_EAST_2);
        BOOTSTRAP_REGION.add(REGION_CODE_AP_SOUTH_EAST_3);
    }


    private static class ServiceEndpointInfo {
        private String service;
        private boolean isGlobal;
        private String globalEndpoint;
        private String defaultEndpoint;
        private RegionEndpointMap regionEndpointMap;
        private String prefix;

        public ServiceEndpointInfo(String service, boolean isGlobal, String globalEndpoint,
                                   String defaultEndpoint, RegionEndpointMap regionEndpointMap, String prefix) {
            this.service = service;
            this.isGlobal = isGlobal;
            this.globalEndpoint = globalEndpoint;
            this.defaultEndpoint = defaultEndpoint;
            this.regionEndpointMap = regionEndpointMap;
            this.prefix = prefix;
        }
    }

    private static Set<String> CN_NONE_MAINLAND_REGION_SET = new HashSet<>();

    static {
        CN_NONE_MAINLAND_REGION_SET.add(REGION_CODE_CN_HONGKONG);

        // --------------------------- billing ---------------------------
        DEFAULT_ENDPOINT_MAP.put("billing", new ServiceEndpointInfo(
                "billing",
                true,
                "",
                BYTEPLUS_ORIGIN_ENDPOINT,
                createRegionEndpointMap(), ""
        ));
        // --------------------------- iam ---------------------------
        DEFAULT_ENDPOINT_MAP.put("iam", new ServiceEndpointInfo(
                "iam",
                true,
                "",
                BYTEPLUS_ORIGIN_ENDPOINT,
                createRegionEndpointMap(), ""
        ));
        // --------------------------- vpc ---------------------------
        DEFAULT_ENDPOINT_MAP.put("vpc", new ServiceEndpointInfo(
                "vpc",
                false,
                "",
                ENDPOINT,
                createRegionEndpointMap(), AP_SOUTHEAST_1_PREFIX
        ));
        CN_NONE_MAINLAND_REGION_SET.add(REGION_CODE_CN_HONGKONG);

        // --------------------------- ecs ---------------------------
        DEFAULT_ENDPOINT_MAP.put("ecs", new ServiceEndpointInfo(
                "ecs",
                false,
                "",
                ENDPOINT,
                createRegionEndpointMap(), AP_SOUTHEAST_1_PREFIX
        ));

    }

    // 创建区域端点映射的辅助方法
    private static RegionEndpointMap createRegionEndpointMap(String... keyValuePairs) {
        RegionEndpointMap map = new RegionEndpointMap();
        for (int i = 0; i < keyValuePairs.length; i += 2) {
            String regionCode = keyValuePairs[i];
            String servicePrefix = keyValuePairs[i + 1];
            map.put(regionCode, servicePrefix + SEPARATOR + regionCode + BYTEPLUS_ORIGIN_ENDPOINT_SUFFIX);
        }
        return map;
    }

    private static String standardizeDomainServiceCode(String serviceCode) {
        return serviceCode.toLowerCase().replaceAll("_", "-");
    }

    @Override
    public ResolvedEndpoint endpointFor(ResolveEndpointOption option) {
        String endpoint = DefaultEndpointProvider.getDefaultEndpointByServiceInfo(
                option.getService(), option.getRegion(), option.getCustomBootstrapRegion());
        ResolvedEndpoint result = new ResolvedEndpoint();
        result.setEndpoint(endpoint);
        return result;
    }

    private static boolean isCNRegion(String region) {
        if (!region.startsWith("cn-")) {
            return false;
        }

        return !CN_NONE_MAINLAND_REGION_SET.contains(region);
    }

    private static boolean inBootstrapRegionList(String region, Set<String> customBootstrapRegion) {
        String regionCode = region.trim();
        String bsRegionListPath = System.getenv("BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF");

        if (bsRegionListPath != null && !bsRegionListPath.isEmpty()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(bsRegionListPath));
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) {
                        continue;
                    }
                    if (line.equals(regionCode)) {
                        reader.close();
                        return true;
                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (BOOTSTRAP_REGION.contains(region)) {
            return true;
        }

        if (customBootstrapRegion != null) {
            return customBootstrapRegion.contains(region);
        }

        return false;
    }

    private static boolean hasEnabledDualstack() {
        String enableDualstack = System.getenv("BYTEPLUS_ENABLE_DUALSTACK");
        return enableDualstack != null && enableDualstack.equals("true");
    }


    public static String getDefaultEndpointByServiceInfo(String service, String regionCode,
                                                         Set<String> customBootstrapRegion) {
        String resultEndpoint = ENDPOINT;

        String endpointSuffix = hasEnabledDualstack() ? DUALSTACK_ENDPOINT_SUFFIX : ENDPOINT_SUFFIX;

        ServiceEndpointInfo endpointInfo = DEFAULT_ENDPOINT_MAP.get(service);

        if (!inBootstrapRegionList(regionCode, customBootstrapRegion)) {
            if (endpointInfo == null) {
                return resultEndpoint;
            }

            endpointSuffix = endpointInfo.prefix + endpointSuffix;
            return OPEN_PREFIX + endpointSuffix;
        }

        if (endpointInfo == null) {
            return resultEndpoint;
        }

        if (endpointInfo.isGlobal) {
            if (!endpointInfo.globalEndpoint.isEmpty()) {
                resultEndpoint = endpointInfo.globalEndpoint;
                return resultEndpoint;
            }

            resultEndpoint = standardizeDomainServiceCode(service) + endpointSuffix;
            return resultEndpoint;
        }

        if (endpointInfo.regionEndpointMap != null) {
            String regionEndpoint = endpointInfo.regionEndpointMap.get(regionCode);
            if (regionEndpoint != null) {
                resultEndpoint = regionEndpoint;
                return resultEndpoint;
            }
        }

        resultEndpoint = standardizeDomainServiceCode(service) + SEPARATOR + regionCode + endpointSuffix +
                (isCNRegion(regionCode) ? ".cn" : "");
        return resultEndpoint;
    }
}


