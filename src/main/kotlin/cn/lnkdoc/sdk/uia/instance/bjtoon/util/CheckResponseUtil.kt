package cn.lnkdoc.sdk.uia.instance.bjtoon.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.TypeReference
import org.slf4j.LoggerFactory


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
object CheckResponseUtil {
    private val log = LoggerFactory.getLogger(CheckResponseUtil::class.java)

    /**
     * check
     *
     * @param json json
     */
    @Synchronized
    @JvmStatic
    fun check(json: String) {
        check(json, false)
    }

    /**
     * check
     *
     * @param json json
     * @param isPrintStack isPrintStack
     */
    @JvmStatic
    @Synchronized
    fun check(json: String, isPrintStack: Boolean?) {
        val response = JSONObject.parseObject<BjtoonResponse<*>>(json, object : TypeReference<BjtoonResponse<*>?>() {})

        // check success
        val isSuccess = UiaConstants.RETURN_CODE_SUCCESS.code == response.meta!!.code && response.data != null
        if (!isSuccess) {
            if (true == isPrintStack) {
                log.error(json)
            }
            throw UiaException(response.meta!!.message)
        }
    }
}

