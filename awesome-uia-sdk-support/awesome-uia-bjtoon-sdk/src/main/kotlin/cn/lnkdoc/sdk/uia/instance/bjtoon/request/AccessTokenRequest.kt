package cn.lnkdoc.sdk.uia.instance.bjtoon.request

import cn.lnkdoc.sdk.uia.common.GrantType
import cn.lnkdoc.sdk.uia.common.HttpMethod
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.common.request.AbstractUiaRequest
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest
import cn.lnkdoc.sdk.uia.common.util.Assert.required
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused", "MemberVisibilityCanBePrivate")
class AccessTokenRequest : AbstractUiaRequest(), IUiaRequest {
    /**
     * grant code
     */
    var body: String? = null
    /**
     * url
     */
    var url: String? = null
    /**
     * grantType
     */
    var grantType = GrantType.AUTHORIZATION_CODE
    /**
     * authToken
     */
    var authToken: String? = null
    /**
     * scope
     */
    var scope = GrantType.AUTHORIZATION_CODE
    /**
     * toonType
     */
    var toonType = ""
    /**
     * state
     */
    var state = ""
    /**
     * inType
     */
    var inType = ""
    /**
     * localCheck
     */
    var localCheck = ""

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
        val varProperty = property as BjtoonProperty?
        required(varProperty, "北京通配置不能为空")
        return try {
            (varProperty!!.domain
                    + varProperty.accessTokenPath)
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
