package cn.lnkdoc.sdk.uia.instance.bccastle.response

import java.io.Serializable

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
open class BccastleResponse : Serializable {
    /**
     * errCode
     */
    var errcode: Int? = null
    /**
     * errMsg
     */
    var msg: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}
