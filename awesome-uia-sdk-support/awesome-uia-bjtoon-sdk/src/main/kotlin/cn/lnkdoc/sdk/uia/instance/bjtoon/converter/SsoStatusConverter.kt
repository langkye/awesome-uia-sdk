package cn.lnkdoc.sdk.uia.instance.bjtoon.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.SsoStatusRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse
import cn.lnkdoc.sdk.uia.serializer.extensions.into
import com.google.auto.service.AutoService
import io.vavr.Tuple2
import okhttp3.FormBody


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
@AutoService(IUiaConverter::class)
class SsoStatusConverter : IUiaConverter {
    private val name: String = SsoStatusRequest::class.java.getName()

    /**
     * convert body
     *
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple2<SsoStatusRequest, BjtoonProperty>
        val a: String = tuple._1.body()
        return FormBody.Builder()
            .addEncoded(UiaConstants.ACCESS_TOKEN, a)
            .build() as T
    }

    /**
     * convert body
     *
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, BjtoonProperty>
        // convert json
        val wrapper = tuple._1.into<BjtoonResponse<String>>()

        return wrapper as T
    }

    /**
     * converter name
     *
     * @return converter name
     */
    override fun name(): String {
        return name
    }
}
