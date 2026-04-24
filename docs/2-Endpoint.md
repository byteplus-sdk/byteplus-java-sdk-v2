[← Credentials](1-Credentials.md) | Endpoint | [Transport →](3-Transport.md)

---

# Endpoint Configuration

## Custom Endpoint

> - **Default**: if `endpoint` is not specified, the SDK uses [Automatic Endpoint Resolution](#automatic-endpoint-resolution).

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String region = "cn-beijing";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(region)
                .setEndpoint("<example>.<regionId>.byteplusapi.com");
    }
}
```

## Custom RegionId

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "cn-beijing";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId);
    }
}
```

## Automatic Endpoint Resolution

BytePlus provides a flexible endpoint resolution mechanism. The SDK automatically builds the endpoint based on service name and region, and supports DualStack.

### Default Endpoint Resolution

1. Whether region is in the bootstrap list.
   - Built-in list: `./byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java#BOOTSTRAP_REGION`.
   - Only predefined regions (e.g., `cn-beijing-autodriving`, `ap-southeast-2`) or user-configured regions are auto-resolved; others fall back to `open.byteplusapi.com`.
   - You can extend the list via env var `BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF` or `customBootstrapRegion`.
2. DualStack support (IPv6)
   - Enable via `setUseDualStack(true)` or env var `BYTEPLUS_ENABLE_DUALSTACK=true`.
   - When enabled, the suffix changes from `byteplusapi.com` to `byteplus-api.com`.
3. Construct endpoint:
   - Global services: `<service>.byteplusapi.com`.
   - Regional services: `<service>.<region>.byteplusapi.com`.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import java.util.HashSet;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "cn-beijing";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setUseDualStack(true)
                .setCustomBootstrapRegion(new HashSet<String>() {{
                    add("custom_example_region1");
                    add("custom_example_region2");
                }});
    }
}
```

### Standard Endpoint Resolution

| Global service | DualStack | Format |
|---|---|---|
| Yes | Yes | `{Service}.byteplus-api.com` |
| Yes | No  | `{Service}.byteplusapi.com` |
| No  | Yes | `{Service}.{region}.byteplus-api.com` |
| No  | No  | `{Service}.{region}.byteplusapi.com` |

Whether a service is global depends on the service itself and cannot be changed. See: `./byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/StandardEndpointProvider.java#SERVICE_INFOS`.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import com.byteplus.endpoint.StandardEndpointProvider;

public class SampleCode {
  public static void main(String[] args) {
    String regionId = "cn-beijing";
    ApiClient apiClient = new ApiClient()
            .setCredentials(Credentials.getEnvCredentials())
            .setEndpointResolver(new StandardEndpointProvider())
            .setRegion(regionId)
            .setUseDualStack(true);
  }
}
```

---

[← Credentials](1-Credentials.md) | Endpoint | [Transport →](3-Transport.md)
