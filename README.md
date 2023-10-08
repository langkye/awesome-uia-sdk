# Awesome Uia SDK - Java
<!-- TOC -->
* [Awesome Uia SDK - Java](#awesome-uia-sdk---java)
* [Supports](#supports)
  * [Usage](#usage)
    * [Add dependency](#add-dependency)
      * [Maven](#maven)
      * [Gradle](#gradle)
    * [Examples](#examples)
      * [Bjtoon（北京通）](#bjtoon北京通)
        * [Java](#java)
        * [Kotlin](#kotlin)
      * [More Examples:](#more-examples-)
<!-- TOC -->

---

## Supports

| SDK    | Version      | Description                                                                                                         |
|--------|--------------|---------------------------------------------------------------------------------------------------------------------|
| Bjtoon | base_on:1.1  | authenticate with “[北京市统一身份认证平台(自然人)](http://www.beijing.gov.cn/)”                                                  |
| Yztoon | None         | authenticate with “[北京市统一身份认证平台(法人)](https://yzt.beijing.gov.cn/)”                                                  |
| Jban   | None         | authenticate with “[京办](https://jzb.beijing.gov.cn/home/)”                                                          |
| Weixin | None         | authenticate with “[微信](https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html)” |
| Alipay | 4.38.90.ALL+ | authenticate with “[支付宝](https://opendocs.alipay.com/open/263/105808)”                                              |
| Github | None         | authenticate with “[Github](https://docs.github.com/zh/apps/oauth-apps/building-oauth-apps/authorizing-oauth-apps)” |
| Gitee  | None         | authenticate with “[Gitee](https://gitee.com/api/v5/oauth_doc#/)”  |



## Usage
### Add dependency
#### Maven
```xml
<dependency>
    <groupId>cn.lnkdoc.sdk</groupId>
    <artifactId>awesome-uia-sdk</artifactId>
    <version>${awesome-uia-sdk.version}</version>
</dependency>
```
#### Gradle
- groovy dsl
  ```groovy
  // https://mvnrepository.com/artifact/cn.lnkdoc.sdk/awesome-uia-sdk
  implementation 'cn.lnkdoc.sdk:awesome-uia-sdk:${awesome_uia_sdk_version}'
  ```

- kotlin dsl
  ```kts
  // https://mvnrepository.com/artifact/cn.lnkdoc.sdk/awesome-uia-sdk
  implementation("cn.lnkdoc.sdk:awesome-uia-sdk:${awesome_uia_sdk_version}")
  ```

### Examples
#### Bjtoon（北京通）
##### Java
- Authenticate
  ```java
  // load property
  cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty property = new cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty();
  property.setDomain("https://bjt.beijing.gov.cn/renzheng");
  property.setClientId("");
  property.setClientSecret("");
  property.setPrintStack(true);
  
  String code = "";
  
  // build instance
  cn.lnkdoc.sdk.uia.instance.ISdkInstance instance = cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance(property);
  
  // build request
  cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest request = new cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest();
  request.setBody(code);
  
  // execute
  cn.lnkdoc.sdk.uia.common.response.UiaResponse<cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken> executeResponse = instance.getAccessToken(request);
  
  // check success
  if (executeResponse.isFailed()) {
      throw new RuntimeException(executeResponse.getMessage());
  }
  
  // accessToken
  cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken accessToken = executeResponse.getData();
  ```

- Get UserInfo
  ```java
  // load property
  cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty property = new cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty();
  property.setDomain("https://bjt.beijing.gov.cn/renzheng");
  property.setClientId("");
  property.setClientSecret("");
  property.setPrintStack(true);
  
  String accessToken = "";
  
  // build instance
  cn.lnkdoc.sdk.uia.instance.ISdkInstance instance = cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance(property);
  
  // build request
  cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest request = new cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest();
  request.setBody(accessToken);
  
  // execute
  cn.lnkdoc.sdk.uia.common.response.UiaResponse<cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo> executeResponse = instance.getUserInfo(request);
  
  // check success
  if (executeResponse.isFailed()) {
      throw new RuntimeException(executeResponse.getMessage());
  }
  
  cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo userInfo = executeResponse.getData();
  ```
##### Kotlin
- Authenticate
  ```kotlin
  // load property
  val property = cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty()
  property.domain = "https://bjt.beijing.gov.cn/renzheng"
  property.clientId = ""
  property.clientSecret = ""
  property.printStack = true

  // third-party platform's code
  val code = ""

  // build instance
  val instance = cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance(property)

  // build request
  val request = cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest()
  request.body = code

  // execute
  val executeResponse = instance.getAccessToken<cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken, cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest>(request)

  // check success
  if (executeResponse.isFailed) {
      throw RuntimeException(executeResponse.message)
  }

  val accessToken = executeResponse.data
  ```
- Get UserInfo
  ```kotlin
  // load property
  val property = cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty()
  property.domain = "https://bjt.beijing.gov.cn/renzheng"
  property.clientId = ""
  property.clientSecret = ""
  property.printStack = true

  val accessToken = ""

  // build instance
  val instance = cn.lnkdoc.sdk.uia.UiaSdkInstance.getInstance(property)

  // build request
  val request = cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest()
  request.body = accessToken

  // execute
  val executeResponse = instance.getAccessToken<cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo, cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest>(request)

  // check success
  if (executeResponse.isFailed) {
      throw RuntimeException(executeResponse.message)
  }
  
  val userInfo = executeResponse.data
  ```

#### More Examples: 
> See: [**`src/main/kotlin/cn/lnkdoc/sdk/uia/example`**](https://github.com/langkye/awesome-uia-sdk/tree/master/src/main/kotlin/cn/lnkdoc/sdk/uia/example/)