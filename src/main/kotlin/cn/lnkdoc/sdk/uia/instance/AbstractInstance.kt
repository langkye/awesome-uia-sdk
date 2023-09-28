package cn.lnkdoc.sdk.uia.instance

import cn.lnkdoc.sdk.uia.common.client.IUiaClient
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.response.UiaResponse


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("UNCHECKED_CAST")
abstract class AbstractInstance : ISdkInstance {
    /**
     * client
     */
    lateinit var client: IUiaClient

    /**
     * extra
     *
     * @param request request
     * @return extra info
     */
    override fun <T, R> execute(request: R): UiaResponse<T> {
        return client.execute<Any>(request as IUiaRequest) as UiaResponse<T>
    }
}

