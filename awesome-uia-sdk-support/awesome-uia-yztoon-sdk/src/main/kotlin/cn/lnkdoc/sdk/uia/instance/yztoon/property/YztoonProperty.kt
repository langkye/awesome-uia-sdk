package cn.lnkdoc.sdk.uia.instance.yztoon.property

import cn.lnkdoc.sdk.uia.common.GrantType
import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.yztoon.Scope

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class YztoonProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * domain
     */
    var domain: String? = null
    /**
     * clientId
     */
    var clientId: String? = null
    /**
     * clientSecret
     */
    var clientSecret: String? = null
    /**
     * scope
     */
    var scope: String = Scope.ALL.scope
    /**
     * accessTokenUrl
     */
    var accessTokenUrl = "/oauth2/access_token"
    /**
     * refreshTokenUrl
     */
    var refreshTokenUrl: String? = null
    /**
     * userInfoUrl
     */
    var userInfoUrl = "/oauth2/tokeninfo"
    /**
     * logoutUrl
     */
    var logoutUrl = "/UI/Logout"
    /**
     * redirectUrl
     */
    var redirectUrl: String? = null
    /**
     * keyStorePath
     */
    var keyStorePath = "classpath:yzttrust.jks"
    /**
     * keyStorePassword
     */
    var keyStorePassword = "123456"
    /**
     * service
     */
    var service = "bjzwService"
    /**
     * grantType
     */
    var grantType = GrantType.AUTHORIZATION_CODE.code
    /**
     * trustDomain
     */
    var isTrustDomain = false
    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}