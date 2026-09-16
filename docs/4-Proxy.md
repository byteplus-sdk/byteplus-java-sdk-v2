[← Transport](3-Transport.md) | Proxy[(中文)](4-Proxy-zh.md) | [Timeout →](5-Timeout.md)

---

## HTTP(S) Proxy

> **Default**
>
> No proxy.

### Configure HTTP(S) Proxy

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-singapore-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setHttpProxy("http://your_http_proxy:proxy_port")
                .setHttpsProxy("http://your_https_proxy:proxy_port");
    }
}
```

### Notes

The following environment variables are supported:

- `http_proxy` / `HTTP_PROXY`
- `https_proxy` / `HTTPS_PROXY`

Priority: code > environment variables.

## STS Credential Providers

`StsAssumeRoleProvider`, `OidcCredentialProvider`, and `SamlCredentialProvider` support:

| Setter | Description |
|---|---|
| `setProxyUrl(String)` | HTTP forward proxy, `http://[user:password@]host:port`. Supports Basic authentication and HTTPS CONNECT. |
| `setCaFile(String)` | PEM CA bundle for STS certificate verification; empty restores original trust settings. |
| `setInsecureSkipVerify(boolean)` | Defaults to `false`. `true` disables certificate and hostname verification and takes precedence over CAFile. Debugging only; never enable in production. |

Explicit provider proxy settings take precedence over the bound client's `httpProxy` or `httpsProxy`, selected by the **STS URL** scheme. With neither configured, OIDC/SAML retain JVM URLConnection proxy selection and AssumeRole retains its ApiClient transport; environment variables are not copied into provider options.

For these three built-in classes, `ApiClient` lazily snapshots provider configuration on first credential access. Each client owns a separate credential cache and refresh lock; the supplied provider is never updated with client fallback. Configure the source provider before first access.

`setHttpProxy`, `setHttpsProxy`, or `setCredentialProvider` invalidates that client's binding for future requests; an already signed request retains its binding through retries. To apply later source-provider changes, call `setCredentialProvider` again. Custom providers, subclasses, and the default credential chain retain their existing identity and are not recursively copied or given this fallback.

AssumeRole preserves its existing endpoint, region, source credentials, custom TLS factory, client keys and timeouts. Disabling `insecureSkipVerify`, replacing/clearing `caFile`, or removing proxy credentials reconciles prior provider-owned overrides. Clearing overrides restores the original caller settings, which may themselves be custom.

Authenticated HTTPS proxies use a private, bounded CONNECT handshake compatible with OkHttp 2.7.5, including a proxy that closes its 407 response connection. Credentials are sent only after a Basic challenge and never on the HTTPS origin request; rejected credentials stop authentication. This branch does not follow redirects. TLS-to-proxy (`https://` proxy URLs) and non-HTTP proxy protocols are unsupported.

---

[← Transport](3-Transport.md) | Proxy[(中文)](4-Proxy-zh.md) | [Timeout →](5-Timeout.md)
