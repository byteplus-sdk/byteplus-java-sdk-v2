[← 访问凭据](1-Credentials-zh.md) | Endpoint 配置[(English)](2-Endpoint.md) | [Transport →](3-Transport-zh.md)

---

## EndPoint 配置

> **默认**
>
> 不指定 Endpoint 时，走 [自动化 Endpoint 寻址](#自动化-endpoint-寻址)。

### 自定义 Endpoint

用户可以通过在初始化客户端时指定 Endpoint：

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

显式设置的 Endpoint 优先级最高，会跳过后续所有寻址逻辑（包括自定义 `EndpointResolver`）。

### 自定义 RegionId

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

### 自动化 Endpoint 寻址

> **默认**
>
> 默认支持自动寻址，无需手动指定 Endpoint。

为了简化用户配置，Byteplus 提供了灵活的 Endpoint 自动寻址机制。用户无需手动指定服务地址，SDK 会根据服务名称、区域（Region）、服务是否标记为 Go China 等信息自动拼接出合理的访问地址，并支持用户自定义 DualStack（双栈）。

#### Endpoint 默认寻址

##### 寻址逻辑

1. **服务注册判定**

    每个服务在内置映射中都会登记 `isGlobal` 和 `goChinaEnabled` 两个 bool 字段，SDK 按下方“标准寻址规则”构造 Endpoint。

    - 服务未在映射中登记：`DefaultEndpointProvider.getDefaultEndpointByServiceInfo` 会抛出 `ApiException`，其消息形如 `service '<xxx>' not registered in default endpoint map`；由 `ResolveEndpointInterceptor` 沿调用链向上冒泡。参见 [错误处理](#错误处理)。

    内置服务映射：[`../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java`](../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java) 中的 `DEFAULT_ENDPOINT_MAP`。

2. **DualStack 支持（IPv6）**

    SDK 支持双栈网络（IPv4 + IPv6）访问地址，自动启用条件如下：显式传入参数 `setUseDualStack(true)`，或设置环境变量 `BYTEPLUS_ENABLE_DUALSTACK=true`。优先级：`useDualStack` > `BYTEPLUS_ENABLE_DUALSTACK`。

    启用后，域名后缀将从 `byteplusapi.com` 切换为 `byteplus-api.com`。

3. **Go China 后缀**

    当服务在内置映射中标记 `goChinaEnabled=true`，并且请求 Region 属于中国大陆（`cn-*` 前缀且不属于 `cn-hongkong` 等非大陆港澳台 Region）时，在域名后追加 `.cn` 后缀。

    是否 GoChina 由服务侧决定，不可修改。Region 匹配前会做 `trim + toLowerCase` 归一化，因此 `CN-Beijing`、`  cn-beijing  ` 与 `cn-beijing` 等价。

4. **根据服务名和区域自动构造 Endpoint 地址**

    - **Global 服务（如 `IAM`、`Billing`）**：使用 `<服务名>.byteplusapi.com`（DualStack 时使用 `byteplus-api.com`；命中 Go China 时追加 `.cn`）。
    - **Regional 服务（如 `ECS`、`RDS`）**：使用 `<服务名>.<区域名>.byteplusapi.com` 作为默认 Endpoint（DualStack / Go China 规则同上）。

##### 寻址决策表

下表列出所有生效组合。左侧列的 "RegionType" 由服务的 `isGlobal` 决定；"Region 是否 GoChina" 指请求 Region 是否属于中国大陆。

| RegionType | goChinaEnabled | 请求 Region 是否 Go China | Endpoint | 是否包含 Region |
|---|---|---|---|---|
| Global | true | 是 | `{service}.byteplusapi.com.cn` | 否 |
| Global | true | 否 | `{service}.byteplusapi.com` | 否 |
| Global | false | 任意 | `{service}.byteplusapi.com` | 否 |
| Regional | true | 是 | `{service}.{region}.byteplusapi.com.cn` | 是 |
| Regional | true | 否 | `{service}.{region}.byteplusapi.com` | 是 |
| Regional | false | 任意 | `{service}.{region}.byteplusapi.com` | 是 |

启用 DualStack 时，将上表中的 `byteplusapi.com` 整体替换为 `byteplus-api.com`。

##### `setCustomBootstrapRegion` / `BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF`（已废弃）

> **⚠️ Deprecated**：`ApiClient.setCustomBootstrapRegion(Set<String>)`、`ResolveEndpointOption.setCustomBootstrapRegion(Set<String>)` 以及 `BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF` 环境变量已被标记为**废弃**，**不再参与**默认寻址链路。相关方法仅为 API 源码/二进制兼容而保留，运行时视为 no-op。请**勿在新代码中使用**，已有代码建议改用 `setRegion` + `setUseDualStack` 让 SDK 自动寻址，或用 `setEndpoint` 显式覆盖。

##### 代码示例

> 注：示例中带删除线的调用 (`setCustomBootstrapRegion`) 为**已废弃**用法，出于兼容性目的保留，请勿在新代码中使用。

<pre><code class="language-java">import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import java.util.HashSet;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setUseDualStack(true) // 定义是否启用双栈网络（IPv4 + IPv6）访问地址，默认false；也可以使用环境变量BYTEPLUS_ENABLE_DUALSTACK=true
<s>                .setCustomBootstrapRegion(new HashSet&lt;String&gt;() {{</s>
<s>                    add("custom_example_region1");</s>
<s>                    add("custom_example_region2");</s>
<s>                }})</s>; // 已废弃：自定义自动寻址Region列表；也可以使用环境变量BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF
    }
}
</code></pre>

##### 错误处理

如果请求的服务名不在内置 `DEFAULT_ENDPOINT_MAP` 映射中，SDK 会在第一次通过 `ResolveEndpointInterceptor` 触发默认寻址时抛出 `com.byteplus.ApiException`，消息形如 `service '<xxx>' not registered in default endpoint map`。可用如下方式识别：

```java
import com.byteplus.ApiException;

try {
    // ... SDK call that triggers default endpoint resolution
} catch (ApiException e) {
    if (e.getMessage() != null && e.getMessage().contains("not registered in default endpoint map")) {
        // SDK 版本可能不识别该服务，请升级依赖或显式指定 Endpoint。
    }
    throw e;
}
```

遇到该错误时，建议先升级 SDK 版本；若确认 SDK 尚未内置该服务的寻址元数据，可通过 `setEndpoint(...)` 或自定义 `EndpointResolver` 显式指定。

#### Endpoint 标准寻址

##### 标准寻址规则

| Global 服务 | 双栈 | 格式 |
|---|---|---|
| 是 | 是 | `{Service}.byteplus-api.com` |
| 是 | 否 | `{Service}.byteplusapi.com` |
| 否 | 是 | `{Service}.{region}.byteplus-api.com` |
| 否 | 否 | `{Service}.{region}.byteplusapi.com` |

标准寻址在中国大陆 Regional 服务下会追加 Go China 的 `.cn` 后缀（例如 `vpc.cn-beijing.byteplusapi.com.cn`）。此为既有实现；默认寻址 Provider 在同场景下也会追加 `.cn`（同为 `vpc.cn-beijing.byteplusapi.com.cn`），若不希望追加 `.cn`，请通过 `setEndpoint(...)` 显式指定 Endpoint。

是否 Global 服务由具体调用的服务决定，不可修改。可以参考列表：[`../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/StandardEndpointProvider.java`](../byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/StandardEndpointProvider.java) 中的 `SERVICE_INFOS`。

##### 代码示例

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import com.byteplus.endpoint.StandardEndpointProvider;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setEndpointResolver(new StandardEndpointProvider()) // 设置标准寻址
                .setRegion(regionId)                                 // 设置region
                .setUseDualStack(true);                              // 设置是否双栈
    }
}
```

---

[← 访问凭据](1-Credentials-zh.md) | Endpoint 配置[(English)](2-Endpoint.md) | [Transport →](3-Transport-zh.md)
