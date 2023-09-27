package cn.lnkdoc.sdk.uia.instance.jban.response

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class JbanResponse<T> {
    /**
     * msg
     */
    var msg: String? = null
    /**
     * code
     */
    var code = 0
    /**
     * data
     */
    var data: T? = null
}
