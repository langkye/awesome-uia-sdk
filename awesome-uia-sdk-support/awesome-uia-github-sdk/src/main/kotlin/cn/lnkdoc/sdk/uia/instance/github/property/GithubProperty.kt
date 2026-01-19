package cn.lnkdoc.sdk.uia.instance.github.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.github.Scope

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class GithubProperty : IUiaProperty {
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
    lateinit var clientId: String
    /**
     * clientSecret
     */
    lateinit var clientSecret: String
    /**
     * scope
     */
    var scope = Scope.READ__USER.scope
    /**
     * redirect_uri
     */
    var redirectUri: String? = null
    /**
     * accessTokenUrl
     */
    var accessTokenUrl = "https://github.com/login/oauth/access_token"
    /**
     * userInfoUrl
     */
    var userInfoUrl = "https://api.github.com/user"
    
    /**
     * isPrintStack
     *
     * @return boolean
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
}