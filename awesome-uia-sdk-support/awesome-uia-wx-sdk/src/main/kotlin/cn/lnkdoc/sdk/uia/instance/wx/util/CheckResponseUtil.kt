package cn.lnkdoc.sdk.uia.instance.wx.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse
import cn.lnkdoc.sdk.uia.serializer.extensions.into
import org.slf4j.LoggerFactory
import java.util.*


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
object CheckResponseUtil {
    private val log = LoggerFactory.getLogger(CheckResponseUtil::class.java)

    /**
     * check
     *
     * @param json json
     */
    @Synchronized
    fun check(json: String?) {
        check(json, false)
    }

    /**
     * check
     *
     * @param json json
     * @param isPrintStack isPrintStack
     */
    @Synchronized
    fun check(json: String?, isPrintStack: Boolean?) {
        val wxResponse = json.into<WxResponse>()
        if (Objects.nonNull(wxResponse.errcode)) {
            if (isPrintStack == true) {
                log.error(json)
            }
            throw UiaException(wxResponse.errmsg)
        }
    }
}
