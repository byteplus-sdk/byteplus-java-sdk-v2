English | [简体中文](./SDK_Integration_zh.md)

# Table of Contents

- [Integrate the SDK](#integrate-the-sdk)
  - [Environment Requirements](#environment-requirements)
  - [Credentials](#credentials)
    - [AK/SK](#aksk)
    - [STS Token](#sts-token-configuration)
    - [AssumeRole](#assumerole)
- [Endpoint Configuration](#endpoint-configuration)
  - [Custom Endpoint](#custom-endpoint)
  - [Custom RegionId](#custom-regionid)
  - [Automatic Endpoint Resolution](#automatic-endpoint-resolution)
    - [Default Endpoint Resolution](#default-endpoint-resolution)
- [HTTP Connection-Pool Settings](#http-connection-pool-settings)
- [HTTPS Request Settings](#https-request-settings)
  - [Specify the Scheme](#specify-the-scheme)
  - [Skip SSL Verification](#skip-ssl-verification)
- [Http(s) proxy configuration](#https-proxy-configuration)
  - [Configure Http(s) proxy](#configure-https-proxy)
  - [Notes](#notes)
- [Timeouts](#timeouts)
- [Retry Mechanism](#retry-mechanism)
  - [Retry code configuration](#retry-code-configuration)
  - [Retry conditions](#retry-conditions)
    - [Default retry conditions](#default-retry-conditions)
    - [Custom retry conditions](#custom-retry-conditions)
  - [Backoff strategy](#backoff-strategy)
    - [Built-in backoff strategy](#built-in-backoff-strategy)
    - [Custom backoff strategy](#custom-backoff-strategy)
- [Error Handling](#error-handling)
- [Debugging](#debugging)
    - [Enable Debug Mode](#enable-debug-mode)

---

# Integrate the SDK

When calling BytePlus APIs, we recommend integrating the official SDK into your project.
Using the SDK simplifies development, speeds up integration, and significantly reduces long-term maintenance costs.
SDK integration generally involves three steps:

1. **Add the SDK** to your project.
2. **Configure access credentials**.
3. **Write the API-calling code**.

This guide explains each step in detail, with tips for common scenarios.

---

# Environment Requirements

- To run the SDK, you need JDK Java 1.8.0_131+. You can download the latest version from: http://developers.sun.com/downloads/.
- If the SDK version is Java 9 or above, please add a dependency on javax.annotation-api because it has been removed in Java 9 and later.

---
# Securely Configuring Access Credentials

To prevent credential leakage, it is recommended **not** to hardcode your access credentials in plain text within your code. BytePlus provides several secure methods for loading credentials, such as storing them in environment variables.

## Setting Environment Variables

### Linux Configuration

> ⚠️ **Note**
>
> **Environment variables configured using the `export` command are temporary and only valid for the current session. Once the session ends, the environment variables will be lost. To persist the environment variables, add the `export` command to the appropriate startup configuration file of your operating system.**

| Key                    | Command                                                |
| ---------------------- | ------------------------------------------------------ |
| BYTEPLUS_ACCESS_KEY    | export BYTEPLUS_ACCESS_KEY=yourAccessKeyID            |
| BYTEPLUS_SECRET_KEY    | export BYTEPLUS_SECRET_KEY=yourSecretAccessKey        |
| BYTEPLUS_SESSION_TOKEN | export BYTEPLUS_SESSION_TOKEN=yourSessionToken        |

**To verify if the environment variables are set successfully:**  
Run the command `echo $BYTEPLUS_ACCESS_KEY`. If the correct AccessKey ID is returned, the configuration is successful.

### Windows Configuration

Both **Graphical User Interface (GUI)** and **Command Line** methods are supported.

**To verify if the environment variables are set successfully:**  
Click **Start** (or press **Win+R**) > **Run** (type `cmd`) > **OK** (or press Enter) to open Command Prompt, and run the following commands:  
`echo %BYTEPLUS_ACCESS_KEY%`, `echo %BYTEPLUS_SECRET_KEY%`, `echo %BYTEPLUS_SESSION_TOKEN%`.  
If the correct values are returned, the configuration is successful.

#### GUI Configuration

Below are the steps to set environment variables using the graphical interface in Windows 10:  
Right-click **This PC** on the desktop, select **Properties > Advanced system settings > Environment Variables > System variables/User variables > New**, and configure as follows:

| Variable           | Example                                                  |
| ------------------ | -------------------------------------------------------- |
| AccessKey Id       | Variable Name: BYTEPLUS_ACCESS_KEY<br />Value: *****     |
| AccessKey Secret   | Variable Name: BYTEPLUS_SECRET_KEY<br />Value: *****     |
| Session Token      | Variable Name: BYTEPLUS_SESSION_TOKEN<br />Value: *****  |

#### Command Line Configuration

Open Command Prompt as Administrator and use the following commands to add environment variables to the system:
- setx BYTEPLUS_ACCESS_KEY yourAccessKeyID /M  
- setx BYTEPLUS_SECRET_KEY yourAccessKeySecret /M  
- setx BYTEPLUS_SESSION_TOKEN yourSessionToken /M


> ⚠️ **Note**
>
> The `/M` flag sets the environment variable at the system level. You can omit this flag to set the variable at the user level.



---
# Credentials

To ensure resource access security, BytePlus SDK supports three mainstream authentication methods: `AK/SK` and `STS temporary credentials` and `AssumeRole`.   
Different authentication methods are suitable for different scenarios, and developers can choose the appropriate method to access according to business needs.    For environment variable settings, please refer to: [**Environment variable settings**](#Environment variable settings)

## AK/SK

AK (AccessKey) and SK (SecretKey) are permanent credentials created in the BytePlus console.

> ⚠️ **Best Practices**
>
> 1. **Never** embed AK/SK in client apps.
> 2. Store keys in a **configuration service** or **environment variables**.
> 3. Apply the **principle of least privilege**.

AK/SK is a pair of permanent access keys created by BytePlus users in the console. The SDK uses this key to sign each request to complete the identity authentication.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String ak = "Your AK";
        String sk = "Your SK";
        String region = "ap-southeast-1";

        // 1. Inputting static ak and sk may cause leakage of AK/SK. This cannot be used in production environment.
        Credentials akSkCredential = Credentials.getCredentials(ak, sk);
        // 2. It is recommended to use environment variables to obtain AK/SK to avoid code leakage; the environment variables will be read: BYTEPLUS_ACCESS_KEY, BYTEPLUS_SECRET_KEY
        //Credentials akSkCredential = Credentials.getEnvCredentials();

        ApiClient apiClient = new ApiClient()
                .setCredentials(akSkCredential)
                .setRegion(region);
    }
}
```

## STS Token Configuration

STS (Security Token Service) is a temporary credential mechanism provided by BytePlus. Developers can call the STS API on the server side to obtain temporary credentials (temporary AK, SK, and Token). The validity period is configurable, making it suitable for scenarios with high security requirements.

> ⚠️ **Note**
>
> 1. **Least Privilege Principle:** Only grant the minimum permissions necessary for the caller to access required resources. Avoid using the `*` wildcard to grant full resource and action permissions.
> 2. **Set a Reasonable Expiration Time:** Configure an appropriate validity period based on actual needs. The shorter, the safer — it is recommended not to exceed 1 hour.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
  public static void main(String[] args) {
      String ak = "Your AK";
      String sk = "Your SK";
      String sessionToken = "Your Session Token";
      String region = "ap-southeast-1";
  
      // 1. Inputting static AK/SK and Session Token may cause leakage of AK/SK and Session Token. This cannot be used in production environment.
      Credentials sessionTokenCredential = Credentials.getCredentials(ak, sk, sessionToken);
      // 2. It is recommended to use environment variables to obtain AK/SK and Session Token to avoid code leakage; the environment variables will be read: BYTEPLUS_ACCESS_KEY, BYTEPLUS_SECRET_KEY and BYTEPLUS_SESSION_TOKEN
      //Credentials sessionTokenCredential = Credentials.getEnvCredentials();
  
      ApiClient apiClient = new ApiClient()
              .setCredentials(sessionTokenCredential)
              .setRegion(region);
  }
}
```

## AssumeRole

Dynamic access to credential information, supports dynamic refresh, and will automatically refresh 60 seconds before the STS temporary Token expires to avoid Token expiration at critical time points.

> ⚠️ Notes
>
> 1. Minimum permissions: Grant the caller only the minimum permissions to access the required resources, and avoid using the * wildcard to grant full resource and full operation permissions.
> 2. Set a reasonable validity period: Please set a reasonable validity period according to the actual situation. The shorter the better, and the longest cannot exceed 12 hours.
> 3. Fine-grained roles: Roles should be bound to fine-grained access control policies to only allow access to specific services, resources, and operations to prevent role abuse.

```java
import com.byteplus.auth.CredentialProvider;
import com.byteplus.auth.StsAssumeRoleProvider;

public class SampleCode {
  public static void main(String[] args) {
    String region = "cn-beijing";
    StsAssumeRoleProvider stsAssumeRoleProvider = new StsAssumeRoleProvider(
            "YourAccessKey",            // Sub-Account AK
            "YourSecretKey",            // Sub-Account SK
            "YourRoleName",             // Name of the role
            "YourAccountId");           // The ID of the main account being played, that is, the ID of the main account to which the role belongs

    // 选填字段
    stsAssumeRoleProvider.setHost("sts.volcengineapi.com"); // STS服务地址，default: sts.volcengineapi.com
    stsAssumeRoleProvider.setRegion("cn-north-1"); // STS service region, default: cn-north-1
    stsAssumeRoleProvider.setTimeout(30); // STS request expiration time,default: 30 seconds
    stsAssumeRoleProvider.setDurationSeconds(3600); // STS temporary credential expiration time，default: 3600 seconds
    stsAssumeRoleProvider.setExpireBufferSeconds(60); // STS expiration buffer time. How many seconds before expiration should the credentials be refreshed to avoid call failures during the expiration period，default: 60 seconds
    stsAssumeRoleProvider.setSchema("https"); // STS schema，default: https
    CredentialProvider credentialProvider = new CredentialProvider(stsAssumeRoleProvider);

    ApiClient apiClient = new ApiClient()
            .setCredentialProvider(credentialProvider)
            .setRegion(region);
  }

}
```

---

# Endpoint Configuration

## Custom Endpoint

> **Default**
> * if no endpoint is specified, the SDK falls back to [Automatic Endpoint Resolution](#automatic-endpoint-resolution).

Users can specify the `Endpoint` when initializing the client.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String region = "ap-southeast-1";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(region)
                .setEndpoint("<example>.<regionId>.byteplusapi.com"); // Custom endpoint
    }
}
```

## Custom RegionId
Users can specify the `RegionId` when initializing the client.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-2";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId);
    }
}
```

## Automatic Endpoint Resolution

> **Default**  
> * enabled; no manual configuration required.

BytePlus constructs the endpoint from service name and region, and supports IPv6 “DualStack”.

### Default Endpoint Resolution

1. **Auto-discoverable Regions**  
   Built-in automatic addressing Region list code:[./byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java#BOOTSTRAP_REGION](./byteplus-java-sdk-v2-core/src/main/java/com/byteplus/endpoint/DefaultEndpointProvider.java#L30)  
   Automatic resolution applies only to predefined regions (e.g. `ap-southeast-2`).
   Extend the list via the `BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF` env var or `customBootstrapRegion`.
2. **DualStack (IPv6)**
   Enable with `setUseDualStack(true)` or `BYTEPLUS_ENABLE_DUALSTACK`(Priority `useDualStack` > `BYTEPLUS_ENABLE_DUALSTACK`).
   The domain suffix changes from `byteplusapi.com` to `byteplus-api.com`.
3. **Address Format**

   * **Global services** (e.g. `BILLING`, `IAM`): `<service>.byteplusapi.com`
   * **Regional services** (e.g. `ECS`, `VPC`): `<service>.<region>.byteplusapi.com`

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;
import java.util.HashSet;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-2";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setUseDualStack(true) // Defines whether to enable dual stack network (IPv4 + IPv6) access address, default is false; you can also use the environment variable BYTEPLUS_ENABLE_DUALSTACK=true
                .setCustomBootstrapRegion(new HashSet<String>() {{
                    add("custom_example_region1");
                    add("custom_example_region2");
                }}); // Customize the automatic addressing Region list; you can also use the environment variable BYTEPLUS_BOOTSTRAP_REGION_LIST_CONF
    }
}
```

---

# HTTP Connection-Pool Settings

> **Default**
>
> * `maxIdleConns` - `5`
> * `keepAliveDurationMs` - `5 * 60 * 1000`

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-2";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setMaxIdleConns(5) // Maximum number of idle connections
                .setKeepAliveDurationMs(5 * 60 * 1000); // Idle connection lifetime
    }
}
```

---

# HTTPS Request Settings

## Specify the Scheme

> **Default**
>
> * `disableSSL` - `false` (indicates https)

Java SDK uses https requests by default. If you need to use http requests, you can set `disableSSL` to `true`.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-2";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setDisableSSL(false);
    }
}
```

## Skip SSL Verification

> **Default**
> * `verifyingSsl` - `true` (indicates SSL verification is enabled)

The Java SDK enables SSL verification by default. If you want to ignore SSL verification, you can set `verifyingSsl` to `false`.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-2";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setVerifyingSsl(false); // Ignore SSL Verification
    }
}
```
---
# Http(s) proxy configuration

> **Default**
> * No proxy

## Configure Http(s) proxy

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public static void main(String[] args) {
    String regionId = "ap-southeast-2";
    ApiClient apiClient = new ApiClient()
            .setCredentials(Credentials.getEnvCredentials())
            .setRegion(regionId)
            .setHttpProxy("http://your_http_proxy:proxy_port") // set http proxy
            .setHttpsProxy("http://your_https_proxy:proxy_port"); // set https proxy
}
```

## Notes

Supports proxy configuration via the following environment variables:

http_proxy/HTTP_PROXY, https_proxy/HTTPS_PROXY

Priority: Code-specified > Environment variables
---


# Timeouts

> **Default (milliseconds)**
> * `connectTimeout` - `10 * 1000` (maximum waiting time for the client to try to establish a TCP connection with the server)
> * `writeTimeout` - `10 * 1000` (maximum waiting time for a single write operation in the process of sending request data to the server)
> * `readTimeout` - `10 * 1000` (maximum waiting time for reading server response data after the connection is established)

Java SDK Client uses `com.squareup.okhttp.OkHttpClient`, and you can control the request timeout by setting `connectTimeout`, `readTimeout`, and `writeTimeout`.

```java
import com.byteplus.ApiClient;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String regionId = "ap-southeast-2";
        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(regionId)
                .setConnectTimeout(10 * 1000)
                .setReadTimeout(15 * 1000)
                .setWriteTimeout(15 * 1000);
    }
}
```


---

# Retry Mechanism

> **Default**
>
> * `autoRetry` - `true` (retry is enabled by default)
> * `minRetryDelayMs` - `300`
> * `maxRetryDelayMs` - `300 * 1000`
> * `retryCondition` - `com.byteplus.retryer.DefaultRetryCondition`
> * `backoffStrategy` - `com.byteplus.retryer.ExponentialBackoffStrategy`
> * `retryErrorCode` - `empty set`

The request processing logic has built-in network exception retry logic, that is, when encountering network exception problems or current limiting errors, the system will automatically try to re-initiate the request to ensure the stability and reliability of the service. If the request is reported due to a business logic error, such as parameter errors, resource non-existence, etc., the SDK will not perform a retry operation. This is because business-level errors usually require the application to make corresponding processing or adjustments based on the specific error information, rather than simply repeating the attempt.

## Retry code configuration
```java
import com.byteplus.ApiClient;
import com.byteplus.retryer.DefaultRetryCondition;
import com.byteplus.retryer.ExponentialBackoffStrategy;
import com.byteplus.sign.Credentials;

public class SampleCode {
    public static void main(String[] args) {
        String region = "ap-southeast-1";

        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getEnvCredentials())
                .setRegion(region)
                .setDebugging(true)
                .setAutoRetry(true) // Enable retry
                .setNumMaxRetries(3) // Maximum number of retries
                .setMinRetryDelayMs(1000) // Minimum retry interval
                .setMaxRetryDelayMs(3000) // Maximum retry interval
                .setRetryCondition(new DefaultRetryCondition()) // Retry conditions
                .setBackoffStrategy(new ExponentialBackoffStrategy()) // Retry interval strategy
                .addRetryErrorCode("InvalidAuthorization") // Retry error code
                /*.addRetryErrorCodes(new HashSet<String>(){{
                    add("InvalidAuthorization");
                    add("InvalidAccessKeyId");
                 }})*/
                ;
    }

}
```

## Retry conditions
Retry conditions define the circumstances under which a retry is required. The SDK has built-in default retry conditions, and users can also customize retry conditions based on their business needs.
### Default retry conditions
Default retry condition`DefaultRetryCondition`,Contains the following retry conditions：
1. Network errors will be retried
2. Server-side current limiting errors will be retried
3. Includes customer-defined error codes `retryErrorCodes`

### Custom retry conditions
Users can customize retry conditions according to their business needs.  

1. Inherit the base class `RetryCondition` and implement `boolean shouldRetry(ApiResponse response, Exception error)`
```java
import com.byteplus.retryer.RetryCondition;

public abstract class CustomRetryCondition extends RetryCondition {
    @Override
    public boolean shouldRetry(ApiResponse response, Exception error) {
        // #................Implement your own logic
        return false;
    }
}
```
2. Reuse the default `DefaultRetryCondition` logic
```java
import com.byteplus.retryer.DefaultRetryCondition;

public class CustomRetryCondition extends DefaultRetryCondition{
    @Override
    public boolean shouldRetry(ApiResponse response, Exception error) {
        boolean shouldRetry = super.shouldRetry(response, error);
        // #................Implement your own logic
        return false;
    }

}
```

## Backoff strategy
The backoff strategy defines the delay time between each retry. The SDK has a built-in default backoff strategy, and users can also customize the backoff strategy according to their business needs.
>**Default**  
> * `ExponentialWithRandomJitterBackoffStrategy`
### Built-in backoff strategy

| Backoff Strategy name                        | Description | Formula (boundary values: `minRetryDelay` minimum delay time, `maxRetryDelay` maximum delay time;`n`: number of retries) |
|----------------------------------------------| ---------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `NoBackoffStrategy`                          | No backoff is used. Each retry is executed immediately with zero delay. | `delay=0.0` |
| `ExponentialBackoffStrategy`                 | The delay of each retry increases in 2ⁿ order, subject to the minimum/maximum delay constraints. It can quickly reduce the request frequency. | `delay=min(minRetryDelay*2ⁿ, maxRetryDelay)` |
| `ExponentialWithRandomJitterBackoffStrategy` | Takes a value between [base, 2·base]: always ≥ base, and the jitter amplitude is the same width as the baseline. | `base = min(minRetryDelay · 2ⁿ, maxRetryDelay )` <br/>`delay = base + U(0, base)` |

### Custom backoff strategy
Users can customize the backoff strategy according to their needs.  

1. Inherit the base class `BackoffStrategy` and implement the function `public long computeDelay(int retryCount)` 
```java
import com.byteplus.retryer.BackoffStrategy;

class CustomBackoffStrategy extends BackoffStrategy {
    public long computeDelay(int retryCount){
        long minRetryDelayMs = this.minRetryDelayMs;
        long maxRetryDelayMs = this.maxRetryDelayMs;
        // ....Implement your own logic
        return 0;
    }
}
```
2. You can also reuse the built-in backoff strategy `ExponentialBackoffStrategy` or `ExponentialWithRandomJitterBackoffStrategy`
```java
import com.byteplus.retryer.ExponentialWithDecayBackoffStrategy;

class CustomBackoffStrategy extends ExponentialWithDecayBackoffStrategy{
    public long computeDelay(int retryCount){
        long base = super.computeDelay(retryCount); // Calling the parent class's implementation
        long minRetryDelayMs = this.minRetryDelayMs;
        long maxRetryDelayMs = this.maxRetryDelayMs;
        // ....Implement your own logic
        return 0;
    }
}
```

---

# Error Handling

When calling an interface, different types of errors may be returned. Customers can adopt targeted processing strategies based on the specific error type and error code. For example, for network anomalies, you can choose to retry, and for business logic errors, you should adjust parameters or modify business logic based on the error information, thereby improving the robustness of the system and user experience.

**Error classification:**

| Error type               | Error description | Return error type | Description |
|--------------------------| ------------------------------------ | ------------------------------------------------------------------------------------------------- | ------------------------------------------------- |
| `1. Client Error`          | Request did not reach the server, verify the parameters | ApiException | See the code example for details |
| `2. Network/Timeout Error` | DNS resolution error or request timeout | `SocketTimeoutException` `UnknownHostException` <br/> `UnknownServiceException` `SocketException` | See the code example for details |
| `3. Server Error`          | Request successfully reaches the server, returns business logic error | ApiException | You can get requestId for troubleshooting, see the code example for details |
| `4. Other Error`           | Other error handling not included in the first 4 errors | Exception | No details, see the code example |

(See the full sample code for detailed handling.)

```java
import com.byteplus.ApiClient;
import com.byteplus.ApiException;
import com.byteplus.ecs.EcsApi;
import com.byteplus.ecs.model.CreateKeyPairRequest;
import com.byteplus.ecs.model.CreateKeyPairResponse;
import com.byteplus.sign.Credentials;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import com.byteplus.model.Error;
import org.apache.commons.lang.StringUtils;

public class SampleCode {
    public static void main(String[] args) {
        String region = "ap-southeast-1";
        ApiClient apiClient = null;

        try {
            apiClient = new ApiClient()
                    .setCredentials(Credentials.getEnvCredentials())
                    .setRegion(region)
            ;
        }catch (Exception e) {
            System.out.println("1. Client Error: " + e.getMessage());
        }

        EcsApi api = new EcsApi(apiClient);

        CreateKeyPairRequest createKeyPairRequest = new CreateKeyPairRequest();
        createKeyPairRequest.setKeyPairName("ssh_key_pair");

        try {
            CreateKeyPairResponse response = api.createKeyPair(createKeyPairRequest);
            System.out.println(response);
        } catch (ApiException e) {

            Throwable cause = e.getCause();
            if (cause == null){
                if (e.getCode() == 0 &&  !StringUtils.isEmpty(e.getMessage())) {
                    System.out.println("1. Client Error: " + e.getMessage());
                }
            }else {
                if (cause instanceof SocketTimeoutException ||
                        cause instanceof UnknownHostException ||
                        cause instanceof UnknownServiceException ||
                        cause instanceof SocketException
                ) {
                    System.out.println("2. Network/Timeout Error： " + cause.getMessage());
                }else {
                    System.out.println("4. Other Error: " + cause.getMessage());
                }
            }

            if (e.getResponseMetadata() != null && e.getResponseMetadata().getError()!= null) {
                Error error = e.getResponseMetadata().getError();
                System.out.println("3. Server Error: code: " + error.getCode() + ", message: " + error.getMessage() + ", requestId: " + e.getResponseMetadata().getRequestId());
            }

        } catch (Exception e){
            System.out.println("4. Other Error: " + e.getMessage());
        }

    }

}
```

---

# Debugging
The Java SDK uses `com.squareup.okhttp.OkHttpClient`, and you can enable debug mode by setting `debugging`.

## Enable Debug Mode

> **Default**
> * `debug` - `false` (Indicates that debug mode is not enabled)

The Java SDK log uses slf4j and depends on the customer's configuration file. Customers can configure the log level according to their needs.

**配置示例：**

```xml
<!--Enable Debug Mode-->
<logger name="com.byteplus.sdkcore" level="debug"/>
```