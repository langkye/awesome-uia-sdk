package cn.lnkdoc.sdk.uia.instance.wx.response

import java.io.Serializable

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
open class WxResponse : Serializable {
    /**
     * errCode
     */
    var errcode: Int? = null
    /**
     * errMsg
     */
    var errmsg: String? = null
    /**
     * rid
     */
    var rid: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}
