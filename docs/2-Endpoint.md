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

    Whether Go China applies is decided by the service itself and cannot be overridden. Regions are lowercased before matching and before being placed in the host, so a value such as `CN-Beijing` passes local validation. However, the request is still signed with the original value, and the server is case-sensitive about the region, so such a request is rejected: always use lowercase regions (for example `cn-beijing`). A region with leading or trailing whitespace (such as `"  cn-beijing  "`) is not trimmed: it is rejected with `InvalidRegion`, both for requests sent through `ApiClient` and when `DefaultEndpointProvider` is called directly. See [Region and service validation](#region-and-service-validation).

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

##### Region and service validation

Automatic endpoint resolution places the service and region in the endpoint host (for example `{service}.{region}.byteplusapi.com`). To prevent a region or service from redirecting the request to a different host (SSRF), the SDK validates both values before any host is built. This applies to the default resolver, the standard resolver and any custom `EndpointResolver`.

**Rules**: a non-empty region or service must be a single valid host name label:

- only ASCII letters, digits, `-` and `_`;
- starts with a letter;
- does not end with `-` or `_`.

`null` and the empty string are not covered by this check and keep the existing handling of each entry point; a whitespace-only string (such as `" "`) is not empty and is rejected. Values such as `ap-southeast-1@127.0.0.1`, `ap/southeast-1`, `evil.com#` or `x:443` are rejected (`.` is not allowed either).

**When and where it applies**:

- Client requests: when no endpoint is set, `ResolveEndpointInterceptor` validates the raw region of the `ApiClient` and the service before calling `EndpointResolver#endpointFor` (including a custom resolver set with `setEndpointResolver(...)`). This interceptor runs before the request is built and signed, so a request that fails validation is neither signed nor sent.
- `UniversalApi` (`doCall` / `doCallWithHttpInfo`): when no endpoint is set, the service name of the `UniversalRequest` and the region of the `ApiClient` are validated before the service name is written into the request path.
- `DefaultEndpointProvider.getDefaultEndpointByServiceInfo` (which `DefaultEndpointProvider#endpointFor` also resolves through): the raw region is validated (no trimming), then lowercased before being placed in the host; a failure throws `ApiException` (see "Errors" below).
- Calling `StandardEndpointProvider#endpointFor` directly also validates, and throws `EndpointValidationException` directly. It runs its existing non-blank check first (blank values still fail with `region must not be null.` / `service must not be null.`), then this validation.
- RDS IAM auth token (`ConnectUtils.buildAuthToken`): when no endpoint is set, the endpoint is resolved with `StandardEndpointProvider`, and an invalid region throws `EndpointValidationException`.
- SSO credentials: the region is validated before `cloudidentity-oauth.{region}.bytepluses.com` / `cloudidentity-portal.{region}.bytepluses.com` is called. A `null`, empty or whitespace-only configured region falls back to `ap-southeast-1`; any other value is trimmed first and the trimmed value is validated. On failure, retrieving the credentials fails with an `ApiException` whose message contains `InvalidRegion`.

**When it is skipped**: when a non-blank endpoint is set on the `ApiClient` with `setEndpoint(...)`, neither `ResolveEndpointInterceptor` nor `UniversalApi` runs this validation and the endpoint is used as is; the explicitly configured endpoint itself is not restricted by these rules.

**Errors**:

- The underlying error is `com.byteplus.endpoint.EndpointValidationException`, which extends `IllegalArgumentException`. `getCode()` returns the error code `InvalidRegion` or `InvalidService` (constants `EndpointValidation.ERR_CODE_INVALID_REGION` / `EndpointValidation.ERR_CODE_INVALID_SERVICE`), `getErrorMessage()` returns the message without the code, and `getMessage()` looks like `InvalidRegion: invalid region "..."...`. When both values are invalid, the service is reported first.
- When triggered by an API call (including `UniversalApi`), or by calling `DefaultEndpointProvider.getDefaultEndpointByServiceInfo` / `DefaultEndpointProvider#endpointFor` directly, it is wrapped in `com.byteplus.ApiException`: `getCode()` is `400`, `getCause()` is the original `EndpointValidationException`, and `getResponseMetadata().getError().getCode()` is `InvalidRegion` / `InvalidService`. No request was sent, so there is no RequestId.
- Synchronous calls throw this `ApiException`; asynchronous calls (such as `describeRegionsAsync`) deliver it to `ApiCallback#onFailure` with a `statusCode` argument of `0`, so use `e.getCode()` for the status code.

```java
import com.byteplus.ApiClient;
import com.byteplus.ApiException;
import com.byteplus.ecs.EcsApi;
import com.byteplus.ecs.model.DescribeRegionsRequest;
import com.byteplus.endpoint.EndpointValidation;
import com.byteplus.model.Error;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion("ap-southeast-1@127.0.0.1"); // invalid region
        EcsApi api = new EcsApi(apiClient);
        try {
            api.describeRegions(new DescribeRegionsRequest());
        } catch (ApiException e) {
            Error error = e.getResponseMetadata() == null ? null : e.getResponseMetadata().getError();
            if (e.getCode() == 400 && error != null
                    && EndpointValidation.ERR_CODE_INVALID_REGION.equals(error.getCode())) {
                // The request was neither signed nor sent.
                System.out.println("invalid region: " + error.getMessage());
            }
        }
    }
}
```

**Behavior change**:

- On the client request path, a region with leading or trailing whitespace (such as `"ap-southeast-1 "`) is no longer accepted and fails with `InvalidRegion`. Previously the default resolver trimmed the region before placing it in the host, but the request was always signed with the untrimmed value, so the server rejected such requests anyway. Remove the surrounding whitespace from the region. Letter case is not checked locally: a value such as `CN-Beijing` still passes validation, but the server is case-sensitive about the region and rejects it, so use lowercase.
- The region configured for SSO credentials is still trimmed first, then validated.
- When `DefaultEndpointProvider.getDefaultEndpointByServiceInfo` (or `DefaultEndpointProvider#endpointFor`) is called directly, the raw region is validated as well: a value with leading or trailing whitespace, or made only of whitespace, fails with `InvalidRegion` instead of being trimmed. Letter case is still accepted and lowercased in the returned host, but this does not make an uppercase region valid for requests (see above): use lowercase.
- New public validation helpers: `EndpointValidation.validateRegion(String)`, `EndpointValidation.validateService(String)`, `EndpointValidation.validateServiceAndRegion(String, String)`, the constants `EndpointValidation.ERR_CODE_INVALID_REGION` and `EndpointValidation.ERR_CODE_INVALID_SERVICE`, and `EndpointValidationException` (`getCode()`, `getErrorMessage()`, `toApiException()`). Custom `EndpointResolver` implementations can reuse them.

#### Standard Endpoint Resolution

##### Resolution Rules

| Global service | DualStack | Format |
|---|---|---|
| Yes | Yes | `{Service}.byteplus-api.com` |
| Yes | No  | `{Service}.byteplusapi.com` |
| No  | Yes | `{Service}.{region}.byteplus-api.com` |
| No  | No  | `{Service}.{region}.byteplusapi.com` |

Standard resolution appends the Go China `.cn` suffix for regional services in mainland `cn-*` regions (for example `vpc.cn-beijing.byteplusapi.com.cn`). This is the existing behavior; the default resolver appends the same `.cn` under the same conditions (also `vpc.cn-beijing.byteplusapi.com.cn`), so if `.cn` is not desired, set the endpoint explicitly via `setEndpoint(...)`.

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
