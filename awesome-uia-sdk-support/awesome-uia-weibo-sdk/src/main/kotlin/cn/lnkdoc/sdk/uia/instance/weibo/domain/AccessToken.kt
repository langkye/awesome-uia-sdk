package cn.lnkdoc.sdk.uia.instance.weibo.domain

import cn.lnkdoc.sdk.uia.instance.weibo.response.ErrorResponse
import com.alibaba.fastjson2.annotation.JSONField

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
open class AccessToken: ErrorResponse() {
    /**
     * 访问令牌。通过该令牌调用需要授权类接口
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null
    /**
     * remind_in
     */
    @set:JSONField(name = "remind_in")
    var remindIn: Int? = null
    /**
     * expires_in
     */
    @set:JSONField(name = "expires_in")
    var expiresIn: Int? = null
    /**
     * uid
     */
    @set:JSONField(name = "uid")
    var uid: String? = null
    /**
     * isRealName
     */
    @set:JSONField(name = "isRealName")
    var isRealName: String? = null
}