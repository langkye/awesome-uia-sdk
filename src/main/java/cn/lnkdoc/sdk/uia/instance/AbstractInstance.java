package cn.lnkdoc.sdk.uia.instance;

import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings("unchecked")
public abstract class AbstractInstance implements ISdkInstance {
    /**
     * client
     */
    protected IUiaClient client;

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
