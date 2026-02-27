package cn.lnkdoc.sdk.uia.instance.yztoon.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField
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
    @set:UiaJsonField(name = "expires_in")
    var expiresIn = 0
    /**
     * tokenType
     */
    @set:UiaJsonField(name = "token_type")
    var tokenType: String? = null
    /**
     * accessToken
     */
    @set:UiaJsonField(name = "access_token")
    var accessToken: String? = null
}
