package cn.lnkdoc.sdk.uia.instance.bjtoon.domain

import java.io.Serializable


/**
 *
 * AuthTicket Object to be returned
 *
 * @author qinyi
 * @version  v 1.0 2018-10-23
 */
@Suppress("unused")
open class AuthTicket : Serializable {
    /**
     * authTicket
     */
    var authTicket: String? = null
    /**
     * expiresIn
     */
    var expiresIn: String? = null

    companion object {
        private const val serialVersionUID = -50843L
    }
}

