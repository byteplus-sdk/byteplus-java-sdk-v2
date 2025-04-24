package com.byteplus.endpoint;

import java.util.HashMap;
import java.util.Map;

public class DefaultEndpointProvider implements EndpointResolver {

    private static final String SEPARATOR = ".";
    private static final String OPEN_PREFIX = "open";
    private static final String ENDPOINT_SUFFIX = SEPARATOR + "ap-southeast-1.byteplusapi.com";


    private static final String ENDPOINT = OPEN_PREFIX + ENDPOINT_SUFFIX;

    private static final String BYTEPLUS_ORIGIN_ENDPOINT_SUFFIX = SEPARATOR + "byteplusapi.com";

    private static final String BYTEPLUS_ORIGIN_ENDPOINT = OPEN_PREFIX + BYTEPLUS_ORIGIN_ENDPOINT_SUFFIX;


    // 区域代码常量
    public static final String REGION_CODE_AP_SOUTH_EAST_3 = "ap-southeast-3";


    // 区域端点映射类型
    private static class RegionEndpointMap extends HashMap<String, String> {
    }

    private static final Map<String, ServiceEndpointInfo> DEFAULT_ENDPOINT_MAP = new HashMap<>();

    private static class ServiceEndpointInfo {
        private String service;
        private boolean isGlobal;
        private String globalEndpoint;
        private String defaultEndpoint;
        private RegionEndpointMap regionEndpointMap;

        public ServiceEndpointInfo(String service, boolean isGlobal, String globalEndpoint,
                                   String defaultEndpoint, RegionEndpointMap regionEndpointMap) {
            this.service = service;
            this.isGlobal = isGlobal;
            this.globalEndpoint = globalEndpoint;
            this.defaultEndpoint = defaultEndpoint;
            this.regionEndpointMap = regionEndpointMap;
        }
    }

    static {
        // --------------------------- billing ---------------------------
        DEFAULT_ENDPOINT_MAP.put("billing", new ServiceEndpointInfo(
                "billing",
                true,
                "",
                BYTEPLUS_ORIGIN_ENDPOINT,
                createRegionEndpointMap()
        ));
        // --------------------------- iam ---------------------------
        DEFAULT_ENDPOINT_MAP.put("iam", new ServiceEndpointInfo(
                "iam",
                true,
                "",
                BYTEPLUS_ORIGIN_ENDPOINT,
                createRegionEndpointMap()
        ));
        // --------------------------- vpc ---------------------------
        DEFAULT_ENDPOINT_MAP.put("vpc", new ServiceEndpointInfo(
                "vpc",
                false,
                "",
                ENDPOINT,
                createRegionEndpointMap(REGION_CODE_AP_SOUTH_EAST_3, "vpc")
        ));
        // --------------------------- ecs ---------------------------
        DEFAULT_ENDPOINT_MAP.put("ecs", new ServiceEndpointInfo(
                "ecs",
                false,
                "",
                ENDPOINT,
                createRegionEndpointMap(REGION_CODE_AP_SOUTH_EAST_3, "ecs")
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

    @Override
    public ResolvedEndpoint endpointFor(ResolveEndpointOption option) {
        String endpoint = DefaultEndpointProvider.getDefaultEndpointByServiceInfo(option.getService(), option.getRegion());
        ResolvedEndpoint result = new ResolvedEndpoint();
        result.setEndpoint(endpoint);
        return result;
    }

    public static String getDefaultEndpointByServiceInfo(String service, String regionCode) {
        String resultEndpoint = ENDPOINT;
        ServiceEndpointInfo endpointInfo = DEFAULT_ENDPOINT_MAP.get(service);
        if (endpointInfo == null) {
            return resultEndpoint;
        }

        if (endpointInfo.isGlobal) {
            if (!endpointInfo.globalEndpoint.isEmpty()) {
                resultEndpoint = endpointInfo.globalEndpoint;
                return resultEndpoint;
            }
        } else {
            String regionEndpoint = endpointInfo.regionEndpointMap.get(regionCode);
            if (regionEndpoint != null) {
                resultEndpoint = regionEndpoint;
                return resultEndpoint;
            }
        }

        if (!endpointInfo.defaultEndpoint.isEmpty()) {
            resultEndpoint = endpointInfo.defaultEndpoint;
        }
        return resultEndpoint;
    }
}


