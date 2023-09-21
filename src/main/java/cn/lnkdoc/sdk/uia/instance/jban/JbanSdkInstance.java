package cn.lnkdoc.sdk.uia.instance.jban;

import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.AbstractInstance;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.jban.client.JbanUiaClient;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;

/**
 * @author langkye
 */
@SuppressWarnings("unchecked")
public class JbanSdkInstance extends AbstractInstance implements ISdkInstance {
    /**
     * instance
     * 
     * @param property property
     */
    public JbanSdkInstance(JbanProperty property) {
        this.client = JbanUiaClient.getInstance(property);
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
     * @param r r
     * @return UserInfo
     */
    @Override
    public <T, R> UiaResponse<T> getUserInfo(R r) {
        return (UiaResponse<T>) client.execute((IUiaRequest) r);
    }
}