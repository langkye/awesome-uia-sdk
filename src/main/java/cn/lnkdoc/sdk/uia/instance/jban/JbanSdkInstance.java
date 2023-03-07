package cn.lnkdoc.sdk.uia.instance.jban;

import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.instance.ISdkInstance;
import cn.lnkdoc.sdk.uia.instance.jban.client.JbanUiaClient;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanAccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanUserInfoRequest;

/**
 * @author langkye
 */
public class JbanSdkInstance implements ISdkInstance {
    private final IUiaClient client;

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
        JbanAccessTokenRequest request = new JbanAccessTokenRequest();
        request.setBody((String) r);
        return (UiaResponse<T>) client.execute(request);
    }

    /**
     * get UserInfo
     *
     * @param r r
     * @return UserInfo
     */
    @Override
    public <T, R> UiaResponse<T> getUserInfo(R r) {
        JbanUserInfoRequest request = new JbanUserInfoRequest();
        request.setBody((String) r);
        return (UiaResponse<T>) client.execute(request);
    }

    /**
     * extra
     *
     * @param request request
     * @return extra'info
     */
    @Override
    public <T, R> UiaResponse<T> execute(R request) {
        return (UiaResponse<T>) client.execute((IUiaRequest) request);
    }
}