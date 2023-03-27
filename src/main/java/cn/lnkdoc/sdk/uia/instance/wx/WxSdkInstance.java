package cn.lnkdoc.sdk.uia.instance.wx;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.AbstractInstance;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.wx.client.WxUiaClient;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class WxSdkInstance extends AbstractInstance implements ISdkInstance {

    public WxSdkInstance(WxProperty property) {
        this.client = WxUiaClient.getInstance(property);
    }

    /**
     * get accessToken
     *
     * @param r code
     * @return accessToken
     */
    @Override
    public <T, R> UiaResponse<T> getAccessToken(R r) {
        return (UiaResponse<T>) client.execute((IUiaRequest) r);
    }

    /**
     * get UserInfo
     *
     * @param accessToken accessToken
     * @return UserInfo
     */
    @Override
    public <T, R> UiaResponse<T> getUserInfo(R accessToken) {
        throw new UiaException("NOT IMPLEMENT");
    }
}
