# Byteplus SDK for Java

## Table of Contents
* Requirements
* Usage
* API Dosc
* Note

### Requirements ###
运行 SDK需要jdk **Java 1.8.0_131+**. 你可以下载最新的版本： http://developers.sun.com/downloads/.
如果 SDK版本 高于或者等于 **Java 9** 请依赖javax.annotation-api
由于在高于或者等于 **Java 9** 中 javax.annotation-api 被移除

请在使用中引用
```xml
<dependency>
  <groupId>javax.annotation</groupId>
  <artifactId>javax.annotation-api</artifactId>
  <version>1.3.2</version>
</dependency>
```

### Usage ###
* Getting Started
* Example

#### Getting Started ####

##### 工程使用sdk #####

建议使用Maven构建自己的项目，添加需要的相应模块的依赖，示例如下：


##### Importing the pom #####

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.byteplus</groupId>
	  <artifactId>byteplus-java-sdk-v2-bom</artifactId>
       <version>0.1.18</version>
	  <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```


##### Using the SDK Maven modules #####

```xml
<dependencies>
  <dependency>
    <groupId>com.byteplus</groupId>
    <artifactId>byteplus-java-sdk-v2-vpc</artifactId>
   <version>0.1.18</version>
  </dependency>
  <dependency>
    <groupId>com.byteplus</groupId>
    <artifactId>byteplus-java-sdk-v2-ecs</artifactId>
   <version>0.1.18</version>
  </dependency>
</dependencies>
```

##### Credentials 配置 #####

**通过环境变量导入**:
```
export BYTEPLUS_ACCESS_KEY=your ak
export BYTEPLUS_SECRET_KEY=your sk
#如果使用token
export BYTEPLUS_SESSION_TOKEN=token
```

**代码方式引入**：

```java
Credentials credentials = Credentials.getCredentials(ak,sk);
//如果使用token
Credentials credentials = Credentials.getCredentials(ak,sk，token);
```

#### Example ####
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
  public static void main(String[] args)throws Exception {
    String ak = "your ak";
    String sk = "your sk";
    String region = "cn-beijing";

    ApiClient apiClient = new ApiClient()
            .setCredentials(Credentials.getCredentials(ak,sk))
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