package com.byteplus.endpoint;


import java.util.Map;

public class ServiceEndpointInfo {
    private String service;
    private boolean isGlobal;
    private String globalEndpoint;
    private String defaultEndpoint;
    private Map<String, String> regionEndpointMap;

    public ServiceEndpointInfo(String service, boolean isGlobal, String globalEndpoint, String defaultEndpoint, Map<String, String> regionEndpointMap) {
        this.service = service;
        this.isGlobal = isGlobal;
        this.globalEndpoint = globalEndpoint;
        this.defaultEndpoint = defaultEndpoint;
        this.regionEndpointMap = regionEndpointMap;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }

    public String getGlobalEndpoint() {
        return globalEndpoint;
    }

    public void setGlobalEndpoint(String globalEndpoint) {
        this.globalEndpoint = globalEndpoint;
    }

    public String getDefaultEndpoint() {
        return defaultEndpoint;
    }

    public void setDefaultEndpoint(String defaultEndpoint) {
        this.defaultEndpoint = defaultEndpoint;
    }

    public Map<String, String> getRegionEndpointMap() {
        return regionEndpointMap;
    }

    public void setRegionEndpointMap(Map<String, String> regionEndpointMap) {
        this.regionEndpointMap = regionEndpointMap;
    }
}
