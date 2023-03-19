package cn.lnkdoc.sdk.uia.test.bjtoon;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class BjtoonTest {
    private static final Logger log = LoggerFactory.getLogger(BjtoonTest.class);

    //@Test
    public void bjtoonAuthenticationTest() {
        String code = "";

        BjtoonProperty property = new BjtoonProperty();
        property.setDomain("https://bjt.beijing.gov.cn/renzheng");
        property.setClientId("");
        property.setClientSecret("");

        // build instance
        ISdkInstance accessTokenInstance = UiaSdkInstance.getInstance(property);
        AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
        accessTokenRequest.setRequestBody(code);

        // test get accessToken
        UiaResponse<AccessToken> accessTokenResponse = accessTokenInstance.getAccessToken(accessTokenRequest);

        if (accessTokenResponse.isFailed()) {
            log.error(accessTokenResponse.getMessage());
            return;
        }

        log.info(JSONObject.toJSONString(accessTokenResponse));

        // test get userInfo
        UiaResponse<UserInfo> userInfoResponse = accessTokenInstance.getUserInfo(accessTokenResponse.getData());
        if (userInfoResponse.isFailed()) {
            log.error(userInfoResponse.getMessage());
            return;
        }
        log.info(JSONObject.toJSONString(userInfoResponse));
    }
}
