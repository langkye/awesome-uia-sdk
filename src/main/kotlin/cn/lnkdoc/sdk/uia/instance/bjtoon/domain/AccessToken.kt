package cn.lnkdoc.sdk.uia.instance.bjtoon.domain

import com.alibaba.fastjson2.annotation.JSONField
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
    @set:JSONField(name = "access_token")
    @get:JSONField(name = "accessToken")
    var accessToken: String? = null
    /**
     * tokenType
     */
    @set:JSONField(name = "token_type")
    var tokenType: String? = null
    /**
     * expiresIn
     */
    @set:JSONField(name = "expires_in")
    var expiresIn: String? = null
    /**
     * refreshToken
     */
    @set:JSONField(name = "refresh_token")
    var refreshToken: String? = null
    
    companion object {
        private const val serialVersionUID = -508722906865178L
    }
}