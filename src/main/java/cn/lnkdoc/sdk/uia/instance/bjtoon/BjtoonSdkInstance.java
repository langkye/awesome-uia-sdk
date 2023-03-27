package cn.lnkdoc.sdk.uia.instance.bjtoon;


import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.AbstractInstance;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.bjtoon.client.BjtoonUiaClient;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class BjtoonSdkInstance extends AbstractInstance implements ISdkInstance {
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
     * @param r accessToken
     * @return UserInfo
     */
    @Override
    public <T, R> UiaResponse<T> getUserInfo(R r) {
        return (UiaResponse<T>) client.execute((IUiaRequest) r);
    }
}
