package cn.lnkdoc.sdk.uia.instance.bccastle.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.bccastle.response.BccastleResponse
import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.TypeReference
import com.alibaba.fastjson2.isJSONObject
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
        val success: Boolean = Objects.nonNull(json) && json.isJSONObject()
        
        if (!success) {
            throw UiaException("response is null or not json: $json")
        }
        val bccastleResponse = JSONObject.parseObject(json, object : TypeReference<BccastleResponse?>() {})
        if (Objects.nonNull(bccastleResponse?.errcode)) {
            if (isPrintStack == true) {
                log.error(json)
            }
            throw UiaException(bccastleResponse?.msg)
        }
    }
}
