package cn.lnkdoc.sdk.uia.instance.gitee.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.gitee.domain.RefreshToken
import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import cn.lnkdoc.sdk.uia.instance.gitee.request.RefreshTokenRequest
import com.alibaba.fastjson2.*
import io.vavr.Tuple2

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
open class RefreshTokenConverter : IUiaConverter {
    private var name: String = RefreshTokenRequest::class.java.getName()
    
    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val builder = okhttp3.FormBody.Builder()
        return builder.build() as T
    }

    /**
     * build headers
     *
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    override fun <T, R> buildHeaders(body: R): T {
        val builder = okhttp3.Headers.Builder()
        return builder
            .add("Accept", "application/json")
            .build() as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, GiteeProperty>
        // convert json
        val data = tuple._1.into<RefreshToken>()
        
        if (!data.success) {
            throw UiaException(data.message)
        }
        
        return data as T
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

