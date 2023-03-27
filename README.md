# Awesome Uia SDK - Java
<!-- TOC -->
* [Awesome Uia SDK - Java](#awesome-uia-sdk---java)
  * [Supports](#supports)
  * [Usage](#usage)
    * [Bjtoon](#bjtoon)
<!-- TOC -->

## Supports

| SDK    | Version     | Description                                                                                                         |
|--------|-------------|---------------------------------------------------------------------------------------------------------------------|
| Bjtoon | base_on:1.1 | authenticate with “[北京市统一身份认证平台(自然人)](http://www.beijing.gov.cn/)”                                          |
| Yztoon | None        | authenticate with “[北京市统一身份认证平台(法人)](https://yzt.beijing.gov.cn/)”                                           |
| Jban   | None        | authenticate with “[京办](https://jzb.beijing.gov.cn/home/)”                                                          |
| Weixin | None        | authenticate with “[微信](https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html)” |



## Usage
> examples:
### Bjtoon（北京通）
- Authenticate
  ```java
  // load property
  BjtoonProperty property = new BjtoonProperty();
  property.setDomain("https://bjt.beijing.gov.cn/renzheng");
  property.setClientId("");
  property.setClientSecret("");
  //property.setPrintStack(true);
  
  String code = "";
  
  // build instance
  ISdkInstance instance = UiaSdkInstance.getInstance(property);
  
  // build request
  AccessTokenRequest request = new AccessTokenRequest();
  request.setBody(code);
  
  // execute
  UiaResponse<AccessToken> executeResponse = instance.getAccessToken(request);
  
  // check success
  if (executeResponse.isFailed()) {
      throw new RuntimeException(executeResponse.getMessage());
  }
  
  // accessToken
  AccessToken accessToken = executeResponse.getData();
  ```

- Get UserInfo
  ```java
  // load property
  BjtoonProperty property = new BjtoonProperty();
  property.setDomain("https://bjt.beijing.gov.cn/renzheng");
  property.setClientId("");
  property.setClientSecret("");
  //property.setPrintStack(true);
  
  String accessToken = "";
  
  // build instance
  ISdkInstance instance = UiaSdkInstance.getInstance(property);
  
  // build request
  UserInfoRequest request = new UserInfoRequest();
  request.setBody(accessToken);
  
  // execute
  UiaResponse<UserInfo> executeResponse = instance.getUserInfo(request);
  
  // check success
  if (executeResponse.isFailed()) {
      throw new RuntimeException(executeResponse.getMessage());
  }
  
  UserInfo userInfo = executeResponse.getData();
  ```
  
More Examples: 
> See: [**`src/main/java/cn/lnkdoc/sdk/uia/example`**](https://github.com/langkye/awesome-uia-sdk/tree/master/src/main/java/cn/lnkdoc/sdk/uia/example/)