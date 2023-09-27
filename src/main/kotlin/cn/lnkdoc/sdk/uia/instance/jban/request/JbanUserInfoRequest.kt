package cn.lnkdoc.sdk.uia.instance.jban.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class JbanUserInfoRequest : AbstractUiaRequest(), IUiaRequest {
    /**
     * body
     */
    var body: String? = null
    /**
     * url
     */
    var url: String? = null

    /**
     * request body
     *
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
        if (url == null) {
            val jbanProperty = property as JbanProperty
            url = java.lang.String.join("", jbanProperty.domain, jbanProperty.accessTokenPath)
        }
        return url!!
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
