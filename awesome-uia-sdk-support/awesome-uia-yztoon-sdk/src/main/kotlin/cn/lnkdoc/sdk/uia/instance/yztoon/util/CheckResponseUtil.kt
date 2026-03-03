package cn.lnkdoc.sdk.uia.instance.yztoon.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.yztoon.response.YztoonResponse
import cn.lnkdoc.sdk.uia.serializer.extensions.into
import org.apache.commons.lang3.StringUtils
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
    @Suppress("unused")
    @Synchronized
    @JvmStatic
    fun check(json: String) {
        check(json, isPrintStack = false, isTranslateMessage = false)
    }

    /**
     * check
     *
     * @param json json
     * @param isPrintStack isPrintStack
     */
    @JvmStatic
    @Synchronized
    fun check(json: String, isPrintStack: Boolean?, isTranslateMessage: Boolean?) {
        val response = json.into<YztoonResponse<*>>()

        // check success
        val isSuccess = StringUtils.isBlank(response.getError())
        if (!isSuccess) {
            if (true == isPrintStack) {
                log.error(json)
            }
            throw UiaException(translateMessage(response, isTranslateMessage))
        }
    }

    @JvmStatic
    fun translateMessage(response: YztoonResponse<*>, isTranslateMessage: Boolean?): String? {
        val error: String? = response.getError()
        val message: String? = response.message
        
        if (isTranslateMessage != true) {
            return message
        }
        
        if (StringUtils.isNotBlank(error)) {
            if (error == "Not found") {
                if (message == "Could not find token from CTS") {
                    return "code不合法或者已使用过"
                }
            }

            if (StringUtils.isNotBlank(message)) {
                return message
            }
            
            return "失败"
        }
        
        if (StringUtils.isNotBlank(message)) {
            return message
        }
        return "成功"
    }
}
