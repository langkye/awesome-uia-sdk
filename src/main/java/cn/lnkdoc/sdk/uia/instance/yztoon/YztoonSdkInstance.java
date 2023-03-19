package cn.lnkdoc.sdk.uia.instance.yztoon;

import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.yztoon.client.YztoonUiaClient;
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.AccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.UserInfoRequest;

/**
 * @author langkye
 */
public class YztoonSdkInstance implements ISdkInstance {
    private final IUiaClient client;

    public YztoonSdkInstance(YztoonProperty property) {
        this.client = YztoonUiaClient.getInstance(property);
    }

    /**
     * get accessToken
     *
     * @param r code
     * @return accessToken
     */
    @Override
    public <T, R> UiaResponse<T> getAccessToken(R r) {
        AccessTokenRequest request = new AccessTokenRequest();
        request.setBody((String) r);
        return (UiaResponse<T>) client.execute(request);
    }

    /**
     * get UserInfo
     *
     * @param accessToken accessToken
     * @return UserInfo
     */
    @Override
    public <T, R> UiaResponse<T> getUserInfo(R accessToken) {
        UserInfoRequest request = new UserInfoRequest();
        request.setBody(((AccessToken)accessToken).getAccessToken());
        return (UiaResponse<T>) client.execute(request);
    }
}