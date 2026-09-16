[← Transport](3-Transport-zh.md) | 代理配置[(English)](4-Proxy.md) | [超时配置 →](5-Timeout-zh.md)

---

## HTTP(S) 代理配置

> **默认**
>
> 无代理。

### 配置 HTTP(S) 代理

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-singapore-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setHttpProxy("http://your_http_proxy:proxy_port") // 设置 http 代理
                .setHttpsProxy("http://your_https_proxy:proxy_port"); // 设置 https 代理
    }
}
```

### 注意事项

支持通过以下环境变量配置代理：

- `http_proxy` / `HTTP_PROXY`
- `https_proxy` / `HTTPS_PROXY`

优先级：代码指定 > 环境变量。

## STS 凭证 Provider

`StsAssumeRoleProvider`、`OidcCredentialProvider` 和 `SamlCredentialProvider` 支持：

| 参数 | 说明 |
|---|---|
| `setProxyUrl(String)` | HTTP 正向代理，格式 `http://[user:password@]host:port`，支持 Basic 认证及 HTTPS CONNECT。 |
| `setCaFile(String)` | 校验 STS 服务端证书的 PEM CA 文件；清空后恢复原信任设置。 |
| `setInsecureSkipVerify(boolean)` | 默认 `false`；`true` 关闭证书链及主机名校验，优先于 CAFile。仅限联调，生产环境禁止启用。 |

Provider 显式代理优先于绑定客户端的 `httpProxy` 或 `httpsProxy`，fallback 按 **STS URL** 的协议选择。均未指定时，OIDC/SAML 保留 JVM URLConnection 代理选择，AssumeRole 保留其 ApiClient 传输；不会将环境变量写入 Provider 配置。

对上述三个内置类，`ApiClient` 在首次访问凭证时创建配置快照，每个客户端拥有独立凭证缓存和刷新锁，不向源 Provider 回写 fallback。请在首次访问前配置源 Provider。

调用 `setHttpProxy`、`setHttpsProxy` 或 `setCredentialProvider` 后，该客户端的后续请求重新绑定，已签名请求及其重试继续使用原绑定。源 Provider 后续配置变更需再次调用 `setCredentialProvider` 才能应用。自定义 Provider、子类及默认凭证链保持原对象契约，不递归复制或注入该 fallback。

AssumeRole 保留原 endpoint、region、源凭证、自定义 TLS factory、客户端证书密钥及超时。关闭 `insecureSkipVerify`、替换/清空 `caFile`、移除代理凭据都会撤销相应的 Provider 覆盖；清空后恢复调用方原设置，原设置也可能是自定义配置。

HTTPS 认证代理使用兼容 OkHttp 2.7.5 的私有、有次数上限的 CONNECT 握手，支持代理在返回 407 后关闭连接。仅收到 Basic challenge 后发送代理凭据，不向 HTTPS 业务请求传递代理认证头，错误凭据终止认证。该分支不跟随重定向，不支持 TLS-to-proxy（`https://` 代理 URL）及非 HTTP 代理协议。

---

[← Transport](3-Transport-zh.md) | 代理配置[(English)](4-Proxy.md) | [超时配置 →](5-Timeout-zh.md)
