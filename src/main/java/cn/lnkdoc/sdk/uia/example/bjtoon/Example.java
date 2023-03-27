package cn.lnkdoc.sdk.uia.example.bjtoon;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"ALL"})
public class Example {
    private static final Logger log = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        // third-party platform's code
        String code = ""; 
        
        // authenticate
        AccessToken accessToken = authenticate(code);
        String acessTokenJSONString = JSONObject.toJSONString(accessToken);
        System.out.println(acessTokenJSONString);
        
        // get user's info 
        UserInfo userInfo = getUserInfo(accessToken);
        String userInfoJSONString = JSONObject.toJSONString(userInfo);
        System.out.println(userInfoJSONString);
    }
    
    private static BjtoonProperty loadProperty() {
        BjtoonProperty property = new BjtoonProperty();
        property.setDomain("https://bjt.beijing.gov.cn/renzheng");
        property.setClientId("");
        property.setClientSecret("");
        //property.setPrintStack(true);
        return property;
    }
    
    private static AccessToken authenticate(String code) {
        // load your property
        BjtoonProperty property = loadProperty();
        
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
        
        return executeResponse.getData();
    }
    
    private static UserInfo getUserInfo(AccessToken accessToken) {
        // load your property
        BjtoonProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request
        UserInfoRequest request = new UserInfoRequest();
        request.setBody(((AccessToken)accessToken).getAccessToken());

        // execute
        UiaResponse<UserInfo> executeResponse = instance.getUserInfo(request);

        // check success
        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }
}
