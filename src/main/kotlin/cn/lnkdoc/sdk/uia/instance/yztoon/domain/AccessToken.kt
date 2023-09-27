package cn.lnkdoc.sdk.uia.instance.yztoon.domain

import com.alibaba.fastjson2.annotation.JSONField
import java.io.Serializable

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class AccessToken : Serializable {
    /**
     * expiresIn
     */
    @set:JSONField(name = "expires_in")
    var expiresIn = 0
    /**
     * tokenType
     */
    @set:JSONField(name = "token_type")
    var tokenType: String? = null
    /**
     * accessToken
     */
    @set:JSONField(name = "access_token")
    var accessToken: String? = null
}
