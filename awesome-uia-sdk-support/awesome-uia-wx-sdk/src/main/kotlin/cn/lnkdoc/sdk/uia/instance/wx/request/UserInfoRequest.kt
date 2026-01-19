package cn.lnkdoc.sdk.uia.instance.wx.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class UserInfoRequest : AbstractUiaRequest(), IUiaRequest {
    /**
     * body
     */
    var body: Body? = null

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
        val varProperty = property as WxProperty
        required(property, "微信配置不能为空")
        required(body, "请求体内容不能为空")
        required(body?.accessToken, "AccessToken不能为空")
        required(body?.openid, "openid不能为空")
        return java.lang.String.join(
            "",
            varProperty.domain,
            varProperty.userInfoPath,
            "?",
            "access_token=" + body?.accessToken,
            "&openid=" + body?.openid
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

    /**
     * body class
     */
    class Body {
        /**
         * accessToken
         */
        var accessToken: String? = null
        /**
         * openid
         */
        var openid: String? = null
    }
}
