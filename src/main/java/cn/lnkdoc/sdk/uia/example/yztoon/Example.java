package cn.lnkdoc.sdk.uia.example.yztoon;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.AccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.LogoutRequest;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.UserInfoRequest;
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

    /**
     * main
     *
     * @param args args
     */
    public static void main(String[] args) {
        String code = "";

        // authenticate
        AccessToken accessToken = authenticate(code);
        System.out.println(JSONObject.toJSONString(accessToken));

        // get user's info 
        UserInfo userInfo = getUserInfo(accessToken);
        System.out.println(JSONObject.toJSONString(userInfo));

        // logout
        Object logout = logout();
        System.out.println(logout);
    }

    private static YztoonProperty loadProperty() {
        YztoonProperty property = new YztoonProperty();
        property.setDomain("https://yzt.beijing.gov.cn/am");
        property.setClientId("");
        property.setClientSecret("");
        property.setRedirectUrl("");
        property.setPrintStack(true);
        property.setTrustDomain(true);
        
        return property;
    }

    private static AccessToken authenticate(String code) {
        // load property
        YztoonProperty property = loadProperty();
        
        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request=
        AccessTokenRequest request = new AccessTokenRequest();
        request.setBody(code);

        // execute
        UiaResponse<AccessToken> executeResponse = instance.getAccessToken(request);

        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }
        
        return executeResponse.getData();
    }

    private static UserInfo getUserInfo(AccessToken accessToken) {
        // load property
        YztoonProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);
        
        // build request
        UserInfoRequest request = new UserInfoRequest();
        request.setBody(accessToken.getAccessToken());
        
        // execute
        UiaResponse<UserInfo> executeResponse = instance.getUserInfo(request);
        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }
        
        return executeResponse.getData();
    }

    private static Object logout() {
        // load property
        YztoonProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request=
        LogoutRequest request = new LogoutRequest();

        // execute
        UiaResponse<Object> executeResponse = instance.getAccessToken(request);

        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }
}
