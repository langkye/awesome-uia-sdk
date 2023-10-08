package cn.lnkdoc.sdk.uia.instance.gitee.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class GiteeProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * domain
     */
    var domain: String = "https://gitee.com"
    /**
     * clientId
     */
    lateinit var clientId: String
    /**
     * clientSecret
     */
    lateinit var clientSecret: String
    /**
     * accessTokenUrl
     */
    var accessTokenUrl = "/oauth/token"
    /**
     * refresh_token
     */
    var refreshTokenUrl = "/oauth/token"
    /**
     * userInfoUrl
     */
    var userInfoUrl = "/api/v5/user"
    /**
     * redirect_uri
     */
    var redirectUri: String? = null
    
    /**
     * isPrintStack
     *
     * @return boolean
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}