package cn.lnkdoc.sdk.uia.instance.bccastle.domain

import cn.lnkdoc.sdk.uia.instance.bccastle.response.BccastleResponse
import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
class RefreshToken : BccastleResponse() {
    /**
     * 授权令牌（授权服务器返回给第三方应用的授权令牌。）
     */
    @set:UiaJsonField(name = "access_token")
    var accessToken: String? = null
    /**
     * 授权令牌的有效期（授权服务器返回给应用的访问票据的有效期。注意：有效期以秒为单位。）
     */
    @set:UiaJsonField(name = "expires_in")
    var expiresIn: Long? = null
    /**
     * 刷新令牌（默认平台不返回。）
     */
    @set:UiaJsonField(name = "refresh_token")
    var refreshToken: String? = null
    /**
     * 授权用户唯一标识（登录用户uid。）
     */
    var uid: String? = null
}
