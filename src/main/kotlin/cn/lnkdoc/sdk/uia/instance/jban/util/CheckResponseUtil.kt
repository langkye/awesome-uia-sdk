package cn.lnkdoc.sdk.uia.instance.jban.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.jban.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse
import com.alibaba.fastjson2.into
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
object CheckResponseUtil {
    private val log = LoggerFactory.getLogger(CheckResponseUtil::class.java)

    /**
     * check
     *
     * @param json json
     */
    @Synchronized
    fun check(json: String = "{}") {
        check(json, false)
    }

    /**
     * check
     *
     * @param json json
     * @param printStack printStack
     */
    @Synchronized
    fun check(json: String = "{}", printStack: Boolean = false) {
        val jbanResponse: JbanResponse<AccessToken> = json.into<JbanResponse<AccessToken>>()
        if (0 != jbanResponse.code) {
            if (printStack) {
                log.error(json)
            }
            throw UiaException(jbanResponse.msg)
        }
    }
}
