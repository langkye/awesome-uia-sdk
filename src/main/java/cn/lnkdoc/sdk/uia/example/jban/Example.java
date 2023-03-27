package cn.lnkdoc.sdk.uia.example.jban;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.jban.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.jban.domain.MobileInfo;
import cn.lnkdoc.sdk.uia.instance.jban.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanAccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanMobileMd5UserRequest;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanUserInfoRequest;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class Example {
    private static final Logger log = LoggerFactory.getLogger(Example.class);
    
    public static void main(String[] args) {
        // third-party platform's code
        String code = "";

        // authenticate
        AccessToken accessToken = authenticate(code);
        System.out.println(JSONObject.toJSONString(accessToken));

        // get user's info 
        UserInfo userInfo = getUserInfo(accessToken);
        System.out.println(JSONObject.toJSONString(userInfo));
        
        // get openid
        String mobile = "";
        MobileInfo openid = getOpenid(mobile);
        System.out.println(JSONObject.toJSONString(openid));
    }

    private static JbanProperty loadProperty() {
        JbanProperty property = new JbanProperty();
        property.setDomain("https://open.jzb.beijing.gov.cn");
        property.setClientId("");
        property.setClientSecret("");
        property.setOpenTeamId("");
        //property.setPrintStack(true);
        return property;
    }

    private static AccessToken authenticate(String code) {
        // load your property
        JbanProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);
        
        // build request
        JbanAccessTokenRequest request = new JbanAccessTokenRequest();
        request.setBody(code);

        // execute
        UiaResponse<AccessToken> executeResponse = instance.getAccessToken(request);

        // check success
        if (executeResponse.isFailed()) {
            log.error(executeResponse.getMessage());
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }
    
    private static UserInfo getUserInfo(AccessToken accessToken) {
        // load your property
        JbanProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request
        JbanUserInfoRequest request = new JbanUserInfoRequest();
        request.setBody(accessToken.getAccessToken());

        // execute
        UiaResponse<AccessToken> executeResponse = instance.getAccessToken(request);

        // check success
        if (executeResponse.isFailed()) {
            log.error(executeResponse.getMessage());
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }
    
    private static MobileInfo getOpenid(String mobile) {
        // load your property
        JbanProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);
        
        // build request
        JbanMobileMd5UserRequest request = new JbanMobileMd5UserRequest();
        request.setBody(mobile);

        // execute
        UiaResponse<MobileInfo> executeResponse = instance.execute(request);

        // check success
        if (executeResponse.isFailed()) {
            log.error(executeResponse.getMessage());
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }
}
