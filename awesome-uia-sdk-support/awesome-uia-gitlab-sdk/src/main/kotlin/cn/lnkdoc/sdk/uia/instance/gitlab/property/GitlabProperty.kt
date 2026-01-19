package cn.lnkdoc.sdk.uia.instance.gitlab.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.gitlab.Scope

/**
 * property
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class GitlabProperty : IUiaProperty {
    /**
     * printStack
     */
    var printStack = false
    /**
     * client_id
     */
    lateinit var clientId: String
    /**
     * client_secret
     */
    lateinit var clientSecret: String
    /**
     * domain
     */
    var domain: String = "https://gitlab.com"
    /**
     * redirect_uri
     */
    var redirectUri: String? = null
    /**
     * user_info_url
     */
    var userInfoUrl: String = "https://gitlab.com/api/v4/user"
    /**
     * access_token_url
     */
    var accessTokenUil: String = "https://gitlab.com/oauth/token"
    /**
     * refresh_token_url
     */
    var refreshTokenUil: String = "https://gitlab.com/oauth/token"
    /**
     * scope
     */
    var scope: String = Scope.read_user.scope
    
    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
    
}