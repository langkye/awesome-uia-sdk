package cn.lnkdoc.sdk.uia.instance.yztoon.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import cn.lnkdoc.sdk.uia.instance.yztoon.request.LogoutRequest
import io.vavr.Tuple2

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class LogoutConverter : IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, YztoonProperty>
        val string = tuple._1
        return string as T
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
        return LogoutRequest::class.java.getName()
    }
}
