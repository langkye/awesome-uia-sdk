package cn.lnkdoc.sdk.uia.common.client;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public interface IUiaClient {
    /**
     * execute
     *
     * @param <RESP> type
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    <RESP> IUiaResponse<RESP> execute(IUiaRequest request) throws UiaException;

}
