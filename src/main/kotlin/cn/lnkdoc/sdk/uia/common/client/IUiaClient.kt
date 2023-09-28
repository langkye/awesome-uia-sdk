package cn.lnkdoc.sdk.uia.common.client

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
interface IUiaClient {
    /**
     * execute
     *
     * @param <RESP> type
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    @Throws(UiaException::class)
    fun <RESP> execute(request: IUiaRequest): IUiaResponse<RESP>
}