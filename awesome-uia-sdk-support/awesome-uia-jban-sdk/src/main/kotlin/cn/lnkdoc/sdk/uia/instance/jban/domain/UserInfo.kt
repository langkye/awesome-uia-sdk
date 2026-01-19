package cn.lnkdoc.sdk.uia.instance.jban.domain

import java.io.Serializable

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
open class UserInfo : Serializable {
    /**
     * 第三方用户 ID,无则返回 null
     */
    var thirdUserId: String? = null
    /**
     * 开放平台租户 ID
     */
    var openTeamId: String? = null
    /**
     * 头像地址
     */
    var avatarUrl: String? = null
    /**
     * 访问 accessToken
     * 失效时间,单位是秒
     */
    var accessTokenExpireIn: String? = null
    /**
     * 刷新 accessToken
     * 失效时间,单位是秒
     */
    var refreshTokenExpireIn: String? = null
    /**
     * 开放平台用户 ID
     */
    var openUserId: String? = null
    /**
     * 访问 accessToken
     */
    var accessToken: String? = null
    /**
     * 员工账号
     */
    var userCode: String? = null
    /**
     * 刷新访问
     * accessToken 用
     */
    var refreshToken: String? = null

    companion object {
        private const val serialVersionUID = -508722906865178L
    }
}
