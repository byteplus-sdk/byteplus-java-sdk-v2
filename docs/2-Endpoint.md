[← Credentials](1-Credentials.md) | Endpoint[(中文)](2-Endpoint-zh.md) | [Transport →](3-Transport.md)

---

## Endpoint Configuration

> **Default**
>
> If `Endpoint` is not specified, the SDK uses [Automatic Endpoint Resolution](#automatic-endpoint-resolution).

### Custom Endpoint

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String region = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(region)
                .setEndpoint("<service>.<regionId>.byteplusapi.com");
    }
}
```

An explicitly configured Endpoint has the highest priority and skips every subsequent resolution step (including any custom `EndpointResolver`).

### Custom RegionId

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId);
    }
}
```

### Automatic Endpoint Resolution

BytePlus provides a flexible endpoint resolution mechanism. The SDK automatically builds the endpoint based on the service name, region and the service's Go China flag, and supports DualStack.

#### Default Endpoint Resolution

##### Resolution Logic

1. **Service registration check**

    Every service in the built-in map carries an `isGlobal` and a `goChinaEnabled` bool. The SDK builds the endpoint following the rules below.

    - Service missing from the map: `DefaultEndpointProvider.getDefaultEndpointByServiceInfo` throws `com.byteplus.ApiException` with a message like `service '<xxx>' not registered in default endpoint map`; `ResolveEndpointInterceptor` propagates it up the call chain. See [Error handling](#error-handling).

    Built-in service map: `DEFAULT_ENDPOINT_MAP` in [`../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java`](../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java).

2. **DualStack support (IPv6)**

    Enable via `setUseDualStack(true)` or env var `BYTEPLUS_ENABLE_DUALSTACK=true`. Priority: `useDualStack` > `BYTEPLUS_ENABLE_DUALSTACK`.

    When enabled, the suffix changes from `byteplusapi.com` to `byteplus-api.com`.

3. **Go China suffix**

    When a service entry has `goChinaEnabled=true` and the request region is in the Chinese mainland (a `cn-*` prefix but not one of the non-mainland regions such as `cn-hongkong`), the resolver appends the `.cn` suffix.

    Whether Go China applies is decided by the service itself and cannot be overridden. Regions are normalized with `trim + toLowerCase` before matching, so `CN-Beijing`, `  cn-beijing  ` and `cn-beijing` are treated identically.

4. **Endpoint construction**

    - **Global services (e.g., `IAM`, `Billing`)**: `<service>.byteplusapi.com` (or `byteplus-api.com` when DualStack is enabled; `.cn` is appended when Go China applies).
    - **Regional services (e.g., `ECS`, `RDS`)**: `<service>.<region>.byteplusapi.com` (DualStack / Go China rules identical to global services).

##### Decision Table

The table lists every effective combination. `RegionType` is derived from the service's `isGlobal` flag; "Region is Go China" refers to the request region.

| RegionType | goChinaEnabled | Region is Go China | Endpoint | Region embedded |
|---|---|---|---|---|
| Global | true | yes | `{service}.byteplusapi.com.cn` | no |
| Global | true | no | `{service}.byteplusapi.com` | no |
| Global | false | any | `{service}.byteplusapi.com` | no |
| Regional | true | yes | `{service}.{region}.byteplusapi.com.cn` | yes |
| Regional | true | no | `{service}.{region}.byteplusapi.com` | yes |
| Regional | false | any | `{service}.{region}.byteplusapi.com` | yes |

When DualStack is enabled, replace every occurrence of `byteplusapi.com` in the table with `byteplus-api.com`.

##### `setCustomBootstrapRegion` / `BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF` (Deprecated)

> **⚠️ Deprecated**: `ApiClient.setCustomBootstrapRegion(Set<String>)`, `ResolveEndpointOption.setCustomBootstrapRegion(Set<String>)`, and the `BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF` environment variable are **deprecated** and **no longer participate** in the default addressing pipeline. The related methods are retained only for API source/binary compatibility and are treated as no-ops at runtime. **Do not use them in new code.** Existing callers should switch to `setRegion` + `setUseDualStack` and let the SDK auto-resolve the endpoint, or override it explicitly via `setEndpoint`.

##### Code Example

> Note: the calls rendered with strikethrough (`setCustomBootstrapRegion`) are **deprecated** and kept only for backward compatibility. Do not use them in new code.

<pre><code class="language-java">import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import java.util.HashSet;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setUseDualStack(true) // enable dual stack; also honors env BYTEPLUS_ENABLE_DUALSTACK=true
<s>                .setCustomBootstrapRegion(new HashSet&lt;String&gt;() {{</s>
<s>                    add("custom_example_region1");</s>
<s>                    add("custom_example_region2");</s>
<s>                }})</s>; // Deprecated: custom auto-resolve region list; also honors env BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF
    }
}
</code></pre>

##### Error handling

If the requested service is not registered in `DEFAULT_ENDPOINT_MAP`, the SDK throws `com.byteplus.ApiException` on the first default endpoint resolution triggered by `ResolveEndpointInterceptor`, with a message like `service '<xxx>' not registered in default endpoint map`. Detect it with:

```java
import com.byteplus.ApiException;

try {
    // ... SDK call that triggers default endpoint resolution
} catch (ApiException e) {
    if (e.getMessage() != null && e.getMessage().contains("not registered in default endpoint map")) {
        // The installed SDK likely does not know this service.
        // Upgrade the dependency or set the endpoint explicitly.
    }
    throw e;
}
```

When you hit this error, first try upgrading the SDK. If the service is genuinely not carried by the SDK yet, set the endpoint explicitly via `setEndpoint(...)` or supply a custom `EndpointResolver`.

#### Standard Endpoint Resolution

##### Resolution Rules

| Global service | DualStack | Format |
|---|---|---|
| Yes | Yes | `{Service}.byteplus-api.com` |
| Yes | No  | `{Service}.byteplusapi.com` |
| No  | Yes | `{Service}.{region}.byteplus-api.com` |
| No  | No  | `{Service}.{region}.byteplusapi.com` |

Standard resolution appends the Go China `.cn` suffix for regional services in mainland `cn-*` regions (for example `vpc.cn-beijing.byteplusapi.com.cn`). This is the existing behavior; if `.cn` is not desired, use the default resolver or set the endpoint explicitly.

Whether a service is global depends on the service itself and cannot be changed. See `SERVICE_INFOS` in [`../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/StandardEndpointProvider.java`](../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/StandardEndpointProvider.java).

##### Code Example

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import com.byteplus.endpoint.StandardEndpointProvider;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setEndpointResolver(new StandardEndpointProvider())
                .setRegion(regionId)
                .setUseDualStack(true);
    }
}
```

---

[← Credentials](1-Credentials.md) | Endpoint[(中文)](2-Endpoint-zh.md) | [Transport →](3-Transport.md)
