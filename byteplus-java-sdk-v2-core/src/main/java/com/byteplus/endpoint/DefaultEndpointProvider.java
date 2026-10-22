package com.byteplus.endpoint;

import com.byteplus.ApiException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static com.byteplus.observability.debugger.SdkDebugLog.SDK_CORE_LOGGER;

public class DefaultEndpointProvider implements EndpointResolver {

    // 区域代码常量
    private static final String REGION_CODE_CN_HONGKONG = "cn-hongkong";

    // 常量
    private static final String SEPARATOR = ".";
    private static final String CN_PREFIX = "cn-";
    private static final String CN_SUFFIX = ".cn";
    private static final String ENDPOINT_SUFFIX = SEPARATOR + "byteplusapi.com";
    private static final String DUALSTACK_ENDPOINT_SUFFIX = SEPARATOR + "byteplus-api.com";

    private static final Map<String, ServiceEndpointInfo> DEFAULT_ENDPOINT_MAP = new HashMap<>();

    /**
     * Region-level whitelist of cn-* regions that should resolve to the
     * international {@code .byteplusapi.com} suffix rather than the Chinese
     * mainland {@code .byteplusapi.com.cn} suffix.
     */
    private static final Set<String> CN_NONE_MAINLAND_REGION_SET = new HashSet<>();

    static {
        CN_NONE_MAINLAND_REGION_SET.add(REGION_CODE_CN_HONGKONG);

    }

    private static final class ServiceEndpointInfo {
        private final String service;
        private final boolean isGlobal;
        private final boolean goChinaEnabled;

        ServiceEndpointInfo(String service, boolean isGlobal, boolean goChinaEnabled) {
            this.service = service;
            this.isGlobal = isGlobal;
            this.goChinaEnabled = goChinaEnabled;
        }
    }

    static {
        // goChinaEnabled controls the Go-China (.byteplusapi.com.cn) suffix when
        // dispatched to a mainland cn-* region. Set goChinaEnabled=false for
        // services that must never resolve to the .cn suffix.
        DEFAULT_ENDPOINT_MAP.put("vpc", new ServiceEndpointInfo("vpc", false, true));
        DEFAULT_ENDPOINT_MAP.put("vke", new ServiceEndpointInfo("vke", false, true));
        DEFAULT_ENDPOINT_MAP.put("auto_scaling", new ServiceEndpointInfo("auto_scaling", false, true));
        DEFAULT_ENDPOINT_MAP.put("storage_ebs", new ServiceEndpointInfo("storage_ebs", false, true));
        DEFAULT_ENDPOINT_MAP.put("vedbm", new ServiceEndpointInfo("vedbm", false, true));
        DEFAULT_ENDPOINT_MAP.put("privatelink", new ServiceEndpointInfo("privatelink", false, true));
        DEFAULT_ENDPOINT_MAP.put("clb", new ServiceEndpointInfo("clb", false, true));
        DEFAULT_ENDPOINT_MAP.put("transitrouter", new ServiceEndpointInfo("transitrouter", false, true));
        DEFAULT_ENDPOINT_MAP.put("directconnect", new ServiceEndpointInfo("directconnect", false, true));
        DEFAULT_ENDPOINT_MAP.put("vpn", new ServiceEndpointInfo("vpn", false, true));
        DEFAULT_ENDPOINT_MAP.put("natgateway", new ServiceEndpointInfo("natgateway", false, true));
        DEFAULT_ENDPOINT_MAP.put("rds_mysql", new ServiceEndpointInfo("rds_mysql", false, true));
        DEFAULT_ENDPOINT_MAP.put("smc", new ServiceEndpointInfo("smc", true, false));
        DEFAULT_ENDPOINT_MAP.put("iam", new ServiceEndpointInfo("iam", true, true));
        DEFAULT_ENDPOINT_MAP.put("vepfs", new ServiceEndpointInfo("vepfs", false, true));
        DEFAULT_ENDPOINT_MAP.put("kms", new ServiceEndpointInfo("kms", false, true));
        DEFAULT_ENDPOINT_MAP.put("ecs", new ServiceEndpointInfo("ecs", false, true));
        DEFAULT_ENDPOINT_MAP.put("mongodb", new ServiceEndpointInfo("mongodb", false, true));
        DEFAULT_ENDPOINT_MAP.put("private_zone", new ServiceEndpointInfo("private_zone", true, true));
        DEFAULT_ENDPOINT_MAP.put("rds_postgresql", new ServiceEndpointInfo("rds_postgresql", false, true));
        DEFAULT_ENDPOINT_MAP.put("resource_share", new ServiceEndpointInfo("resource_share", true, false));
        DEFAULT_ENDPOINT_MAP.put("vmp", new ServiceEndpointInfo("vmp", false, true));
        DEFAULT_ENDPOINT_MAP.put("tag", new ServiceEndpointInfo("tag", true, false));
        DEFAULT_ENDPOINT_MAP.put("cr", new ServiceEndpointInfo("cr", false, true));
        DEFAULT_ENDPOINT_MAP.put("alb", new ServiceEndpointInfo("alb", false, true));
        DEFAULT_ENDPOINT_MAP.put("sts", new ServiceEndpointInfo("sts", false, true));
        DEFAULT_ENDPOINT_MAP.put("hbase", new ServiceEndpointInfo("hbase", false, true));
        DEFAULT_ENDPOINT_MAP.put("rds_mssql", new ServiceEndpointInfo("rds_mssql", false, true));
        DEFAULT_ENDPOINT_MAP.put("ml_platform", new ServiceEndpointInfo("ml_platform", false, false));
        DEFAULT_ENDPOINT_MAP.put("apig", new ServiceEndpointInfo("apig", false, false));
        DEFAULT_ENDPOINT_MAP.put("ark", new ServiceEndpointInfo("ark", false, false));
        DEFAULT_ENDPOINT_MAP.put("waf", new ServiceEndpointInfo("waf", true, false));
        DEFAULT_ENDPOINT_MAP.put("quota", new ServiceEndpointInfo("quota", true, false));
        DEFAULT_ENDPOINT_MAP.put("dms", new ServiceEndpointInfo("dms", false, true));
        DEFAULT_ENDPOINT_MAP.put("vefaas", new ServiceEndpointInfo("vefaas", false, false));
        DEFAULT_ENDPOINT_MAP.put("cen", new ServiceEndpointInfo("cen", true, false));
        DEFAULT_ENDPOINT_MAP.put("cp", new ServiceEndpointInfo("cp", false, false));
        DEFAULT_ENDPOINT_MAP.put("cloudmonitor", new ServiceEndpointInfo("cloudmonitor", false, true));
        DEFAULT_ENDPOINT_MAP.put("eco_partner", new ServiceEndpointInfo("eco_partner", true, false));
        DEFAULT_ENDPOINT_MAP.put("milvus", new ServiceEndpointInfo("milvus", false, false));
        DEFAULT_ENDPOINT_MAP.put("llmshield", new ServiceEndpointInfo("llmshield", false, false));
        DEFAULT_ENDPOINT_MAP.put("billing", new ServiceEndpointInfo("billing", true, true));
        DEFAULT_ENDPOINT_MAP.put("id", new ServiceEndpointInfo("id", false, false));
        DEFAULT_ENDPOINT_MAP.put("clawsentry", new ServiceEndpointInfo("clawsentry", false, false));
        DEFAULT_ENDPOINT_MAP.put("resourcecenter", new ServiceEndpointInfo("resourcecenter", true, false));
        DEFAULT_ENDPOINT_MAP.put("escloud", new ServiceEndpointInfo("escloud", false, false));
        DEFAULT_ENDPOINT_MAP.put("cpaas", new ServiceEndpointInfo("cpaas", true, false));
        DEFAULT_ENDPOINT_MAP.put("filenas", new ServiceEndpointInfo("filenas", false, true));
        DEFAULT_ENDPOINT_MAP.put("kafka", new ServiceEndpointInfo("kafka", false, true));
        DEFAULT_ENDPOINT_MAP.put("kickart", new ServiceEndpointInfo("kickart", true, false));
        DEFAULT_ENDPOINT_MAP.put("rabbitmq", new ServiceEndpointInfo("rabbitmq", false, false));
        DEFAULT_ENDPOINT_MAP.put("redis", new ServiceEndpointInfo("redis", false, true));
        DEFAULT_ENDPOINT_MAP.put("vod", new ServiceEndpointInfo("vod", false, false));
        DEFAULT_ENDPOINT_MAP.put("vs", new ServiceEndpointInfo("vs", true, false));
    }

    private static String standardizeDomainServiceCode(String serviceCode) {
        return serviceCode.toLowerCase(Locale.ROOT).replaceAll("_", "-");
    }

    private static String normalizeRegion(String region) {
        return region == null ? "" : region.trim().toLowerCase(Locale.ROOT);
    }

    @Override
    public ResolvedEndpoint endpointFor(ResolveEndpointOption option) throws ApiException {
        String endpoint = DefaultEndpointProvider.getDefaultEndpointByServiceInfo(
                option.getService(), option.getRegion(),
                option.getCustomBootstrapRegion(), option.getUseDualStack());
        ResolvedEndpoint result = new ResolvedEndpoint();
        result.setEndpoint(endpoint);
        return result;
    }

    /**
     * Returns whether the given region is a mainland cn-* region resolving to
     * the {@code .byteplusapi.com.cn} suffix. Assumes the region has already
     * been normalized via {@link #normalizeRegion(String)}. Regions listed in
     * {@link #CN_NONE_MAINLAND_REGION_SET} (for example {@code cn-hongkong})
     * are treated as international.
     */
    private static boolean isCNMainlandRegion(String normalizedRegion) {
        if (!normalizedRegion.startsWith(CN_PREFIX)) {
            return false;
        }
        return !CN_NONE_MAINLAND_REGION_SET.contains(normalizedRegion);
    }

    private static boolean hasEnabledDualstack(Boolean useDualStack) {
        if (useDualStack == null) {
            String enableDualstack = System.getenv("BYTEPLUS_ENABLE_DUALSTACK");
            return "true".equals(enableDualstack);
        }
        return useDualStack;
    }

    /**
     * Resolves the default endpoint for the given service and region.
     *
     * <p>Decision table (mirrors the SDK-wide addressing spec):
     * <ol>
     *   <li>Unknown service &rarr; throws {@link ApiException}. No silent
     *       fallback; callers are expected to surface the error.</li>
     *   <li>Global service in a mainland {@code cn-*} region with
     *       {@code goChinaEnabled=true} &rarr;
     *       {@code {service}.byteplusapi.com.cn}.</li>
     *   <li>Global service otherwise &rarr; {@code {service}.byteplusapi.com}
     *       (or {@code .byteplus-api.com} when dual-stack is enabled).</li>
     *   <li>Regional service in a mainland {@code cn-*} region with
     *       {@code goChinaEnabled=true} &rarr;
     *       {@code {service}.{region}.byteplusapi.com.cn}.</li>
     *   <li>Regional service otherwise &rarr;
     *       {@code {service}.{region}.byteplusapi.com}.</li>
     * </ol>
     *
     * <p>{@code regionCode} is normalized (trim + lowercase) before being
     * placed in the returned host, so callers may pass mixed-case values.
     *
     * @param service              service code registered in the default endpoint map.
     * @param regionCode           request region.
     * @param customBootstrapRegion <b>Deprecated.</b> Retained for signature
     *                              compatibility only; no longer participates
     *                              in addressing.
     * @param useDualStack         nullable dual-stack override; when {@code null}
     *                              falls back to {@code BYTEPLUS_ENABLE_DUALSTACK}.
     * @throws ApiException when {@code service} is not registered in the default endpoint map.
     */
    public static String getDefaultEndpointByServiceInfo(String service, String regionCode,
                                                         Set<String> customBootstrapRegion, Boolean useDualStack) throws ApiException {
        // customBootstrapRegion is intentionally ignored: bootstrap-region-based
        // routing is deprecated and no longer participates in addressing.

        ServiceEndpointInfo endpointInfo = DEFAULT_ENDPOINT_MAP.get(service);
        if (endpointInfo == null) {
            throw new ApiException("service '" + service + "' not registered in default endpoint map");
        }

        String endpointSuffix = hasEnabledDualstack(useDualStack) ? DUALSTACK_ENDPOINT_SUFFIX : ENDPOINT_SUFFIX;
        String serviceCode = standardizeDomainServiceCode(service);
        String normalizedRegion = normalizeRegion(regionCode);
        String cnSuffix = (endpointInfo.goChinaEnabled && isCNMainlandRegion(normalizedRegion)) ? CN_SUFFIX : "";

        if (endpointInfo.isGlobal) {
            String resultEndpoint = serviceCode + endpointSuffix + cnSuffix;
            SDK_CORE_LOGGER.debugEndpoint("Service '{}' is global, constructing endpoint: {}", service, resultEndpoint);
            return resultEndpoint;
        }

        String resultEndpoint = serviceCode + SEPARATOR + normalizedRegion + endpointSuffix + cnSuffix;
        SDK_CORE_LOGGER.debugEndpoint("Constructing endpoint for service '{}' in region '{}': {}", service, normalizedRegion, resultEndpoint);
        return resultEndpoint;
    }
}
