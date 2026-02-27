package cn.lnkdoc.sdk.uia.instance.bjtoon.domain

import cn.lnkdoc.sdk.uia.serializer.annotation.UiaJsonField
import java.io.Serializable


/**
 *
 * AccessToken Object to be returned
 *
 * @author qinyi
 * @version  v 1.0 2018-10-23
 */
@Suppress("unused")
open class AccessToken : Serializable {
    /**
     * accessToken
     */
    @set:UiaJsonField(name = "access_token")
    @get:UiaJsonField(name = "accessToken")
    var accessToken: String? = null
    /**
     * tokenType
     */
    @set:UiaJsonField(name = "token_type")
    var tokenType: String? = null
    /**
     * expiresIn
     */
    @set:UiaJsonField(name = "expires_in")
    var expiresIn: String? = null
    /**
     * refreshToken
     */
    @set:UiaJsonField(name = "refresh_token")
    var refreshToken: String? = null
    
    companion object {
        private const val serialVersionUID = -508722906865178L
    }
}
