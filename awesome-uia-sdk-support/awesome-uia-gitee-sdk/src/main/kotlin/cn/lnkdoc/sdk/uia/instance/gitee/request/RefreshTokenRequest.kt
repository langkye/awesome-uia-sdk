package cn.lnkdoc.sdk.uia.instance.gitee.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.Assert
import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused", "MemberVisibilityCanBePrivate")
class RefreshTokenRequest : AbstractUiaRequest(), IUiaRequest {
    /**
     * grant code
     */
    var body: String? = null

    /**
     * request body
     *
     * @return request body
     */
    override fun <T> body(): T {
        return body!! as T
    }

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    override fun url(property: IUiaProperty): String {
        val varProperty = property as GiteeProperty
        Assert.required(varProperty, "配置不能为空")
        return try {
            (varProperty.domain + varProperty.refreshTokenUrl
                + "?grant_type=refresh_token"
                + "&refresh_token=${body}"
            )
        } catch (e: Exception) {
            throw UiaException(e)
        }
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