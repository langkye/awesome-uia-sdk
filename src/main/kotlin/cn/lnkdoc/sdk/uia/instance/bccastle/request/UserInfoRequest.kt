package cn.lnkdoc.sdk.uia.instance.bccastle.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class UserInfoRequest : AbstractUiaRequest(), IUiaRequest {
    /**
     * body
     */
    var body: String? = null

    /**
     * request body
     *
     * @return request body
     */
    override fun <T> body(): T {
        return body as T
    }

    /**
     * url
     *
     * @param property property
     * @return request url
     */
    override fun url(property: IUiaProperty): String {
        val varProperty = property as BccastleProperty
        required(property, "统一认证配置不能为空")
        required(body, "AccessToken不能为空")
        return java.lang.String.join(
            "",
            varProperty.domain,
            varProperty.userInfoPath,
            "?",
            "client_id=" + property.clientId,
            "&access_token=" + body
        )
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
