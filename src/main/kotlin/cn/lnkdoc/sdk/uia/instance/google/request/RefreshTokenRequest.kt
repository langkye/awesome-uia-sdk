package cn.lnkdoc.sdk.uia.instance.google.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.instance.google.property.GoogleProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
class RefreshTokenRequest: AbstractUiaRequest(), IUiaRequest {
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
        val varProperty = property as GoogleProperty
        return varProperty.refreshTokenUil
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