package cn.lnkdoc.sdk.uia.test.yztoon;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class YztoonTest {
    private static final Logger log = LoggerFactory.getLogger(YztoonTest.class);


    //@Test
    public void yztoonAuthenticationTest() {
        String code = "";

        YztoonProperty property = new YztoonProperty();
        property.setDomain("https://yzt.beijing.gov.cn/am");
        property.setClientId("");
        property.setClientSecret("");
        property.setRedirectUrl("");

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // test get AccessToken
        UiaResponse<AccessToken> accessTokenResponse = instance.getAccessToken(code);

        if (accessTokenResponse.isFailed()) {
            log.error(accessTokenResponse.getMessage());
            return;
        }

        log.info(JSONObject.toJSONString(accessTokenResponse));


        // test get UserInfo
        UiaResponse<UserInfo> userInfoResponse = instance.getUserInfo(accessTokenResponse.getData());
        if (userInfoResponse.isFailed()) {
            log.error(userInfoResponse.getMessage());
            return;
        }
        userInfoResponse.getData().parseExtInfo();
        log.info(JSONObject.toJSONString(userInfoResponse));
    }
}
