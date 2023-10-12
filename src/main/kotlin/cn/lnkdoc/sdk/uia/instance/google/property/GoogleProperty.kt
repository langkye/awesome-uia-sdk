package cn.lnkdoc.sdk.uia.instance.google.property

import cn.lnkdoc.sdk.uia.common.property.IUiaProperty
import cn.lnkdoc.sdk.uia.instance.google.Scope

/**
 * property
 *
 * @document https://console.cloud.google.com/apis/credentials/oauthclient
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class GoogleProperty : IUiaProperty {
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
    var domain: String = "https://oauth2.googleapis.com"
    /**
     * redirect_uri
     */
    var redirectUri: String? = null
    /**
     * access_type
     * 推荐
     * 指示当用户不在浏览器时，您的应用能否刷新访问令牌。有效的参数值包括 online（默认值）和 offline。
     *
     * 如果您的应用需要在用户不在浏览器前刷新访问令牌，请将该值设为 offline。这是刷新访问令牌的方法，本文档后面部分将对其进行介绍。此值指示 Google 授权服务器在您的应用首次用授权代码交换令牌时返回刷新令牌和访问令牌。
     */
    var accessType: String = "offline"
    /**
     * user_info_url
     */
    var userInfoUrl: String = "https://openidconnect.googleapis.com/v1/userinfo"
    /**
     * access_token_url
     */
    var accessTokenUil: String = "https://oauth2.googleapis.com/token"
    /**
     * refresh_token_url
     */
    var refreshTokenUil: String = "https://oauth2.googleapis.com/token"
    /**
     * scope
     */
    var scope: String = Scope.auth___userinfo__profile.scope
    /**
     * OpenID Connect 协议要求使用多个端点来验证用户身份以及请求资源（包括令牌、用户信息和公钥）。
     *
     * 为了简化实现并提高灵活性，OpenID Connect 允许使用“Discovery”文档，此 JSON 文档位于一个知名的键值对位置，其中包含有关 OpenID Connect 提供方配置的详细信息，包括授权、令牌、撤消、userinfo 和公钥端点的 URI。可以从以下位置检索 Google OpenID Connect 服务的发现文档
     */
    var wellKnown = "https://accounts.google.com/.well-known/openid-configuration"

    /**
     * getter
     *
     * @return printStack
     */
    override fun isPrintStack(): Boolean {
        return printStack
    }
    
}