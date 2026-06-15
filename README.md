# BytePlus SDK for Java

## Table of Contents

* Requirements
* Usage
* API Docs
* Notes

### Requirements

The SDK requires **Java 1.8.0_131+**. You can download the latest version from: http://developers.sun.com/downloads/.

If your Java version is **Java 9 or later**, add `javax.annotation-api` because it was removed from JDK 9+.

```xml
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```

For detailed SDK documentation (credentials, endpoint, transport, timeout, retry, error handling, debugging), see: [SDK Integration Guide](./docs/0-Overview.md)

### Usage

* Getting Started
* Example

#### Getting Started

##### Installation

It is recommended to use Maven. Add dependencies for the modules you need.

##### Importing the BOM

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.byteplus</groupId>
	  <artifactId>byteplus-java-sdk-v2-bom</artifactId>
       <version>0.1.64</version>
	  <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

##### Using SDK Maven modules

```xml
<dependencies>
  <dependency>
    <groupId>com.byteplus</groupId>
    <artifactId>byteplus-java-sdk-v2-vpc</artifactId>
   <version>0.1.64</version>
  </dependency>
  <dependency>
    <groupId>com.byteplus</groupId>
    <artifactId>byteplus-java-sdk-v2-ecs</artifactId>
   <version>0.1.64</version>
  </dependency>
</dependencies>
```

##### Credentials

**Import via environment variables**:

```
export BYTEPLUS_ACCESS_KEY=your ak
export BYTEPLUS_SECRET_KEY=your sk
# If using token
export BYTEPLUS_SESSION_TOKEN=token
```

**Import in code**:

```java
Credentials credentials = Credentials.getCredentials(ak, sk);
// If using token
Credentials credentials = Credentials.getCredentials(ak, sk, token);
```

##### Endpoint

To customize the SDK endpoint:

```java
ApiClient apiClient = new ApiClient()
        .setCredentials(Credentials.getCredentials(ak, sk))
        .setRegion(region).setEndpoint("ecs.ap-southeast-1.byteplusapi.com");
```

Standard endpoint rules:

| Regional Service | Global Service |
|---|---|
| `{service}.{region}.byteplusapi.com` <br> e.g. `ecs.ap-southeast-1.byteplusapi.com` | `{service}.byteplusapi.com` <br> e.g. `iam.byteplusapi.com` |

Note:

- If the service name contains `_`, it should be converted to `-` in the endpoint. Use lowercase for all characters.

#### SDK Example

```java
import com.byteplus.ApiClient;
import com.byteplus.ApiException;
import com.byteplus.sign.Credentials;
import com.byteplus.vpc.VpcApi;
import com.byteplus.vpc.model.DescribeVpcsRequest;
import com.byteplus.vpc.model.DescribeVpcsResponse;

import java.util.ArrayList;
import java.util.List;

public class TestVpc {
    public static void main(String[] args) throws Exception {
        String ak = "your ak";
        String sk = "your sk";
        String region = "ap-southeast-1";

        ApiClient apiClient = new ApiClient()
                .setCredentials(Credentials.getCredentials(ak, sk))
                .setRegion(region);
        VpcApi vpcApi = new VpcApi(apiClient);
        DescribeVpcsRequest request = new DescribeVpcsRequest();
        List<String> list = new ArrayList<>();
        list.add("vpc-13fpdgwk7rxfk3n6nu44wisg7");
        request.setVpcIds(list);
        try {
            DescribeVpcsResponse response = vpcApi.describeVpcs(request);
            System.out.println(response);
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
    }
}
```

For more code examples, please refer to the [SDK Integration Guide](./SDK_Integration.md) and the [docs/](./docs/) directory.

## Security and privacy
This project takes security seriously.
For vulnerability reporting and supported versions, see [SECURITY.md](SECURITY.md)