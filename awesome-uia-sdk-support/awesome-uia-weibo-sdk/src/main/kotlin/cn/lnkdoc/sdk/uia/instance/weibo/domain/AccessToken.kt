package cn.lnkdoc.sdk.uia.instance.weibo.domain

import cn.lnkdoc.sdk.uia.instance.weibo.response.ErrorResponse
import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
open class AccessToken: ErrorResponse() {
    /**
     * 访问令牌。通过该令牌调用需要授权类接口
     */
    @set:UiaJsonField(name = "access_token")
    var accessToken: String? = null
    /**
     * remind_in
     */
    @set:UiaJsonField(name = "remind_in")
    var remindIn: Int? = null
    /**
     * expires_in
     */
    @set:UiaJsonField(name = "expires_in")
    var expiresIn: Int? = null
    /**
     * uid
     */
    @set:UiaJsonField(name = "uid")
    var uid: String? = null
    /**
     * isRealName
     */
    @set:UiaJsonField(name = "isRealName")
    var isRealName: String? = null
}
