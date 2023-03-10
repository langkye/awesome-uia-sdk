package cn.lnkdoc.sdk.uia.test.jban;

import cn.lnkdoc.sdk.uia.UiaSdkInstance;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.jban.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.jban.domain.MobileInfo;
import cn.lnkdoc.sdk.uia.instance.jban.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanMobileMd5UserRequest;
import com.alibaba.fastjson2.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class JbanTest {
    private static final Logger log = LoggerFactory.getLogger(JbanTest.class);
    

    @SuppressWarnings("ALL")
    @Test
    public void jbanAuthenticationTest() {
        String code = "e1476bac-17d0-44cf-8e90-ea780d653469";

        JbanProperty property = new JbanProperty();
        //property.setDomain("https://yzt.beijing.gov.cn/am");
        property.setClientId("39jSukEWsiYgtgsRtHds"); //pKW41cpMGEGcKPxJpACW
        property.setClientSecret("aOy84xB+gwQGOQG13C67ag=="); //BX1Y2Lq0XvYky1jYaKPHXQ==
        property.setOpenTeamId("19dfffdb19af01c601a525ebb0d05731"); //c08a5d671441dd68815638dc8282c669

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // test get AccessToken
        UiaResponse<AccessToken> accessTokenResponse = instance.getAccessToken(code);

        if (!accessTokenResponse.isSuccess()) {
            log.error(accessTokenResponse.getMessage());
            return;
        }

        log.info(JSONObject.toJSONString(accessTokenResponse));


        // test get UserInfo
        UiaResponse<UserInfo> userInfoResponse = instance.getUserInfo(accessTokenResponse.getData());
        if (!userInfoResponse.isSuccess()) {
            log.error(userInfoResponse.getMessage());
            return;
        }
        log.info(JSONObject.toJSONString(userInfoResponse));
    }
    

    @SuppressWarnings("ALL")
    @Test
    public void mobile() {
        String mobile = "";
        JbanMobileMd5UserRequest request = new JbanMobileMd5UserRequest();
        request.setBody(mobile);

        JbanProperty property = new JbanProperty();
        property.setDomain("https://jzb-open-pre.jdcloud.com");
        property.setClientId("");
        property.setClientSecret("");
        property.setOpenTeamId("");

        // build instance
        ISdkInstance instance = UiaSdkInstance.getInstance(property);

        // test get extra
        UiaResponse<MobileInfo> mobileInfoUiaResponse = instance.execute(request);

        if (!mobileInfoUiaResponse.isSuccess()) {
            log.error(mobileInfoUiaResponse.getMessage());
            return;
        }
        log.info(JSONObject.toJSONString(mobileInfoUiaResponse));
    }
}
