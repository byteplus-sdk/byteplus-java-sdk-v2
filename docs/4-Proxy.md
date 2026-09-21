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
| `setProxyUrl(String)` | HTTP forward proxy, `http://[user:password@]host:port`, with an explicit port in `1..65535`. Supports Basic authentication and HTTPS CONNECT. No TLS-to-proxy or SOCKS support. |
| `setCaFile(String)` | PEM CA bundle for STS certificate verification. Empty together with `insecureSkipVerify=false` restores the original transport TLS settings, possibly custom. JVM default trust applies only if those settings were not customized. |
| `setInsecureSkipVerify(boolean)` | Defaults to `false`. `true` disables certificate and hostname verification and takes precedence over CAFile. Debugging only; never enable in production. |

Explicit provider proxy settings take precedence over the bound client's explicitly configured `httpProxy` or `httpsProxy`, selected by the **STS URL** scheme, not the business API scheme. With neither configured, OIDC/SAML retain URLConnection proxy selection, including JVM `http.proxyHost` / `http.proxyPort` and `https.proxyHost` / `https.proxyPort` system properties. They do not parse `HTTP_PROXY` / `HTTPS_PROXY` or their lowercase variants. AssumeRole retains its original ApiClient proxy selection, including supported proxy environment variables. Environment variables are not copied into provider options.

For these three exact built-in classes supplied directly through `CredentialProvider`, `ApiClient` lazily snapshots provider configuration on first credential access. Each client owns a separate credential cache and refresh lock; the supplied provider is never updated with client fallback. Configure the source provider before first access.

`setHttpProxy`, `setHttpsProxy`, or `setCredentialProvider` invalidates that client's binding for future requests; an already signed request retains its binding through retries. To apply later source-provider changes, call `setCredentialProvider` again. Custom providers, subclasses, and the default credential chain retain their existing identity and are not recursively copied or given this fallback.

AssumeRole preserves its existing endpoint, region, source credentials, custom TLS factory, client keys and timeouts. Changing `insecureSkipVerify` or replacing/clearing `caFile` reconciles provider-owned TLS overrides. Only an empty `caFile` together with `insecureSkipVerify=false` removes all provider TLS overrides and restores the original transport TLS settings, including any custom factory. JVM default trust applies only if the original settings were not customized. Removing proxy credentials also removes the provider-owned proxy authentication override.

Authenticated HTTPS STS requests through an HTTP proxy use a private, bounded CONNECT handshake compatible with OkHttp 2.7.5, including a proxy that closes its 407 response connection. Credentials are sent only after a Basic challenge and never on the HTTPS origin request; rejected credentials stop authentication. This branch does not follow redirects. TLS-to-proxy (`https://` proxy URLs), SOCKS, and other non-HTTP proxy protocols are unsupported.

### Snapshot Migration

Code that relied on updating a shared source provider must rebind each affected client after changing the source role, source credentials, proxy, TLS, expiry, or retry settings: call `apiClient.setCredentialProvider(credentialProvider)` again, or bind a replacement provider for constructor-only settings. Setting the source AssumeRole provider's expiration time to `0` no longer forces an existing binding to refresh. An already signed request and its retries keep the original binding. Separate client caches may increase STS calls compared with sharing the source provider's cache.

AssumeRole's internal ApiClient snapshot isolates the SDK retry count, backoff delay bounds, and `retryErrorCodes` set between the source and each binding. Custom strategies retain their runtime types; additional mutable references require overriding `BackoffStrategy.copy()` / `RetryCondition.copy()`, calling `super.copy()`, and copying those fields on the result. This does not promise deep copies of arbitrary JSON helpers, interceptors, TLS factories, or other caller-owned objects. OIDC/SAML snapshot their retry count and interval; OIDC token-file contents are still read at refresh time.

---

[← Transport](3-Transport.md) | Proxy[(中文)](4-Proxy-zh.md) | [Timeout →](5-Timeout.md)
