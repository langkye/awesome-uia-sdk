package cn.lnkdoc.sdk.uia.example.wx;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.wx.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.wx.domain.RefreshToken;
import cn.lnkdoc.sdk.uia.instance.wx.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;
import cn.lnkdoc.sdk.uia.instance.wx.request.AccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.wx.request.RefreshTokenRequest;
import cn.lnkdoc.sdk.uia.instance.wx.request.UserInfoRequest;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
        // third-party platform's code
        String code = "";

        // authenticate
        AccessToken accessToken = getAccessToken(code);
        System.out.println(JSONObject.toJSONString(accessToken));

        // get user's info
        UserInfo userInfo = getUserInfo(accessToken);
        System.out.println(JSONObject.toJSONString(userInfo));

        // refresh token
        RefreshToken refreshToken = refreshToken(accessToken);
        System.out.println(JSONObject.toJSONString(refreshToken));
    }

    private static WxProperty loadProperty() {
        WxProperty property = new WxProperty();
        property.setClientId("");
        property.setClientSecret("");
        //property.setPrintStack(true);

        return property;
    }

    private static AccessToken getAccessToken(String code) {
        // load property
        WxProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request
        AccessTokenRequest request = new AccessTokenRequest();
        request.setBody(code);

        UiaResponse<AccessToken> executeResponse = instance.getAccessToken(request);

        // check success
        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }

    private static RefreshToken refreshToken(AccessToken accessToken) {
        // load property
        WxProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request
        RefreshTokenRequest request = new RefreshTokenRequest();
        request.setBody(accessToken.getRefreshToken());

        // execute
        UiaResponse<RefreshToken> executeResponse = instance.execute(request);

        // check success
        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }

    private static UserInfo getUserInfo(AccessToken accessToken) {
        // load property
        WxProperty property = loadProperty();

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // build request
        UserInfoRequest request = new UserInfoRequest();
        request.setBody(new UserInfoRequest.Body(accessToken.getAccessToken(), accessToken.getOpenid()));

        // execute
        UiaResponse<UserInfo> executeResponse = instance.execute(request);

        // check success
        if (executeResponse.isFailed()) {
            throw new RuntimeException(executeResponse.getMessage());
        }

        return executeResponse.getData();
    }

    private static String buildLoginUrl() {
        String redirectUri = "";
        String encode = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);

        String state = "";

        WxProperty property = loadProperty();

        return String.join(""
                , "https://open.weixin.qq.com/connect/qrconnect?"
                , "appid=" + property.getClientId()
                , "&redirect_uri=" + encode
                , "&response_type=" + "code"
                , "&scope=" + "snsapi_login"
                , StringUtils.isBlank(state) ? "" : "&state=" + state
                , "#wechat_redirect"
        );
    }
}
