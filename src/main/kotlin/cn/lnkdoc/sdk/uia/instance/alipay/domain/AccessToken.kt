package cn.lnkdoc.sdk.uia.instance.alipay.domain

import com.alibaba.fastjson2.annotation.JSONField
import java.util.*

/**
 * access_token
 * 
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
open class AccessToken {
    /**
     * 访问令牌。通过该令牌调用需要授权类接口
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null
    /**
     * 已废弃，请勿使用
     */
    @Deprecated("""已废弃，请勿使用""")
    @set:JSONField(name = "alipay_user_id")
    var alipayUserId: String? = null
    /**
     * 授权token开始时间，作为有效期计算的起点
     */
    @set:JSONField(name = "auth_start")
    var authStart: Date? = null
    /**
     * 令牌类型，permanent表示返回的access_token和refresh_token永久有效，非永久令牌不返回该字段
     */
    @set:JSONField(name = "auth_token_type")
    var authTokenType: String? = null
    /**
     * 访问令牌的有效时间，单位是秒。
     */
    @set:JSONField(name = "expires_in")
    var expiresIn: String? = null
    /**
     * 支付宝用户唯一标识
     */
    @set:JSONField(name = "open_id")
    var openId: String? = null
    /**
     * 刷新令牌的有效时间，单位是秒。
     */
    @set:JSONField(name = "re_expires_in")
    var reExpiresIn: String? = null
    /**
     * 刷新令牌。通过该令牌可以刷新access_token
     */
    @set:JSONField(name = "refresh_token")
    var refreshToken: String? = null
    /**
     * union_id是支付宝用户在开放平台的唯一标识符，在配置应用分组后会返回该值。
     * 同一用户的union_id在同一分组内应用保持一致。
     */
    @set:JSONField(name = "union_id")
    var unionId: String? = null
    /**
     * 支付宝用户的唯一标识。以2088开头的16位数字。
     */
    @set:JSONField(name = "user_id")
    var userId: String? = null
}