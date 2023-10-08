package cn.lnkdoc.sdk.uia.instance.github.request

import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.github.property.GithubProperty


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
        return body!! as T
    }

    /**
     * request url
     *
     * @param property property
     * @return request url
     */
    override fun url(property: IUiaProperty): String {
        val varProperty = property as GithubProperty
        required(varProperty, "北京通配置不能为空")
        return try {
            (varProperty.userInfoUrl)
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
        return HttpMethod.GET
    }
}

