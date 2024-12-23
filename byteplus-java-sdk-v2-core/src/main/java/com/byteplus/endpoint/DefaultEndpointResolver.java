package com.byteplus.endpoint;

import java.util.HashMap;
import java.util.Map;

public class DefaultEndpointResolver {

    public static String globalDefaultEndpoint = "open.ap-southeast-1.byteplusapi.com";

    public static Map<String, ServiceEndpointInfo> defaultEndpointMap;

    static {
        defaultEndpointMap = new HashMap<String, ServiceEndpointInfo>() {
            {
                put("billing", new ServiceEndpointInfo("billing",
                        true,
                        "",
                        "open.byteplusapi.com",
                        null));
            }

        };
    }

    public static String getDefaultEndpointByServiceInfo(String service, String region) {
        if (defaultEndpointMap == null || defaultEndpointMap.isEmpty()) {
            return globalDefaultEndpoint;
        }
        if (!defaultEndpointMap.containsKey(service)) {
            return globalDefaultEndpoint;
        }
        ServiceEndpointInfo serviceEndpointInfo = defaultEndpointMap.get(service);
        if (serviceEndpointInfo.isGlobal()) {
            if (serviceEndpointInfo.getGlobalEndpoint() != null && !serviceEndpointInfo.getGlobalEndpoint().isEmpty()) {
                return serviceEndpointInfo.getGlobalEndpoint();
            }

        } else {
            if (serviceEndpointInfo.getRegionEndpointMap() != null && !serviceEndpointInfo.getRegionEndpointMap().isEmpty()) {
                if (serviceEndpointInfo.getRegionEndpointMap().containsKey(region)) {
                    return serviceEndpointInfo.getRegionEndpointMap().get(region);
                }
            }
        }
        if (serviceEndpointInfo.getDefaultEndpoint() != null && !serviceEndpointInfo.getDefaultEndpoint().isEmpty()) {
            return serviceEndpointInfo.getDefaultEndpoint();
        }
        return globalDefaultEndpoint;
    }
}

