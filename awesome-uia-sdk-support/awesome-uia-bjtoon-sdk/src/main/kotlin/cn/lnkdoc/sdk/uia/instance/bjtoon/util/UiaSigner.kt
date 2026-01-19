package cn.lnkdoc.sdk.uia.instance.bjtoon.util

/**
 * Sign Interface
 *
 * @author qinyi
 * @version v 1.0 2018-10-22
 */
@Suppress("unused")
interface UiaSigner {
    /**
     * sign
     *
     * @param sourceContent content to be signed
     * @param signType signType
     * @param charset charset
     * @return String
     */
    fun sign(sourceContent: Any?, signType: String?, charset: String?): String?
}

