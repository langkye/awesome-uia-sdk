package cn.lnkdoc.sdk.uia.instance.bjtoon.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class LogoutRequest : AbstractUiaRequest(), IUiaRequest {
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
     * request method
     *
     * @return request method
     */
    override fun method(): HttpMethod {
        return HttpMethod.GET
    }

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    override fun url(property: IUiaProperty): String {
        return (property as BjtoonProperty).domain + property.logoutPath + "?access_token=" + body
    }
}
