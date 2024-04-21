package cn.lnkdoc.sdk.uia.instance.wx.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.TypeReference
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
        val wxResponse = JSONObject.parseObject(json, object : TypeReference<WxResponse?>() {})
        if (Objects.nonNull(wxResponse?.errcode)) {
            if (isPrintStack == true) {
                log.error(json)
            }
            throw UiaException(wxResponse?.errmsg)
        }
    }
}
