package cn.lnkdoc.sdk.uia.instance.bccastle.property

import cn.lnkdoc.sdk.uia.common.GrantType
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class BccastleProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * useInterceptor
     */
    var useInterceptor = false
    /**
     * domain
     */
    var domain: String? = null
    /**
     * clientId
     */
    lateinit var clientId: String
    /**
     * clientSecret
     */
    lateinit var clientSecret: String
    /**
     * 通过code获取Token
     */
    var accessTokenPath = "/idp/oauth2/getToken"
    /**
     * 刷新Token接口
     */
    var refreshTokenPath = "/idp/oauth2/refreshToken"
    /**
     * 检查Token是否有效接口
     */
    var accessTokenStatusPath = "/idp/oauth2/checkTokenValid"
    /**
     * 查询Token接口
     */
    var accessTokenGetPath = "/idp/oauth2/getTokenInfo"
    /**
     * 回收Token接口
     */
    var revokeTokenPath = "/idp/oauth2/revokeToken"
    /**
     * 获取用户基本信息
     */
    var userInfoPath = "/idp/oauth2/getUserInfo"
    /**
     * grantType
     */
    var grantType = GrantType.AUTHORIZATION_CODE.code
    /**
     * refreshTokenGrantType
     */
    var refreshTokenGrantType = GrantType.REFRESH_TOKEN.code
    /**
     * redirectUri
     */
    var redirectUri: String? = null

    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }

    /**
     * isPrintStack
     *
     * @return boolean
     */
    override fun isUseInterceptor(): Boolean {
        return this.useInterceptor
    }
}
