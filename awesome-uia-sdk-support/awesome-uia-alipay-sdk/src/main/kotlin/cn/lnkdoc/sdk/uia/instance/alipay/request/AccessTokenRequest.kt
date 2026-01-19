package cn.lnkdoc.sdk.uia.instance.alipay.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.instance.alipay.property.AlipayProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "UNCHECKED_CAST")
class AccessTokenRequest : AbstractUiaRequest(), IUiaRequest {
    var body: String? = null

    /**
     * request body
     *
     * @param <T> type
     * @return request body
     */
    override fun <T> body(): T {
        return body as T
    }

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    override fun url(property: IUiaProperty): String {
        return (property as AlipayProperty).alipayGatewayUrl
    }

    /**
     * request method
     *
     * @return request method
     */
    override fun method(): HttpMethod {
        return HttpMethod.POST
    }
}