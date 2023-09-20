package cn.lnkdoc.sdk.uia.instance.yztoon;

import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.AbstractInstance;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.yztoon.client.YztoonUiaClient;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;

/**
 * @author langkye
 */
@SuppressWarnings("unchecked")
public class YztoonSdkInstance extends AbstractInstance implements ISdkInstance {

    /**
     * constructor
     * 
     * @param property property
     */
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
        return (UiaResponse<T>) client.execute((IUiaRequest) r);
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