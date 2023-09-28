package cn.lnkdoc.sdk.uia.instance.yztoon.convert

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.AccessToken
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import cn.lnkdoc.sdk.uia.instance.yztoon.request.AccessTokenRequest
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.into
import io.vavr.Tuple2
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class AccessTokenConverter : IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, YztoonProperty>
        val json = tuple._1
        val accessToken = json.into<AccessToken>()
        if (StringUtils.isBlank(accessToken.accessToken)) {
            var message =
                "convert to AccessToken failed from json: [$json]. because 'accessToken' not fund from response's json"
            try {
                val jsonObject = JSON.parseObject(json)
                message = jsonObject.getString("error_description")
            } catch (e: Exception) {
                if (tuple._2.isPrintStack()) {
                    log.error("", e)
                }
            }
            throw UiaException(message)
        }
        return accessToken as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        throw UiaException("TODO")
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return AccessTokenRequest::class.java.getName()
    }

    companion object {
        private val log = LoggerFactory.getLogger(AccessToken::class.java)
    }
}
