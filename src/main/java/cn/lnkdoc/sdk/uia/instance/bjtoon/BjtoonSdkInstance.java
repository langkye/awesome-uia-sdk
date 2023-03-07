package cn.lnkdoc.sdk.uia.instance.bjtoon;


import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.bjtoon.client.BjtoonUiaClient;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class BjtoonSdkInstance implements ISdkInstance {
    private final IUiaClient client;

    public BjtoonSdkInstance(BjtoonProperty property) {
        this.client = BjtoonUiaClient.getInstance(property);
    }

    /**
     * get accessToken
     *
     * @param r code
     * @return accessToken
     */
    @Override
    public <T, R> UiaResponse<T> getAccessToken(R r) {
        return (UiaResponse<T>) client.execute((AccessTokenRequest)r);
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
