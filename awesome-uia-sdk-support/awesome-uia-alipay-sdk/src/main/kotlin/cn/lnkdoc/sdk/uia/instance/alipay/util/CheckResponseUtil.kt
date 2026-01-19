package cn.lnkdoc.sdk.uia.instance.alipay.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import com.alibaba.fastjson2.toJSONString
import com.alipay.api.AlipayResponse
import org.slf4j.LoggerFactory

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
     * @param response json
     */
    @Synchronized
    fun check(response: AlipayResponse?) {
        check(response, false)
    }

    /**
     * check
     *
     * @param response json
     * @param isPrintStack isPrintStack
     */
    @Synchronized
    fun check(response: AlipayResponse?, isPrintStack: Boolean?) {
        if (response?.isSuccess != true) {
            if (isPrintStack == true) {
                log.error(response.toJSONString())
            }
            throw UiaException(response?.subMsg)
        }
    }
}
