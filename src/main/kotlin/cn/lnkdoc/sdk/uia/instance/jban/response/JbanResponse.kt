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
     * code（返回码：0-表示运行成功，无错误返回；其它-运行出错后的错误代码。）
     */
    var code = 0
    /**
     * data
     */
    var data: T? = null
}
