package cn.lnkdoc.sdk.uia.instance.jban.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.EncryptUtils.mD5EncryptAsHex
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class JbanMobileMd5UserRequest : AbstractUiaRequest(), IUiaRequest {
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
            val varProperty = property as JbanProperty
            url = java.lang.String.join(
                "", varProperty.domain, varProperty.mobileMd5Path, mD5EncryptAsHex(body!!)
            )
        }
        return url!!
    }

    /**
     * request method
     *
     * @return request method
     */
    override fun method(): HttpMethod {
        return HttpMethod.GET
    }
}
