package cn.lnkdoc.sdk.uia.instance.weibo.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.weibo.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.weibo.property.WeiboProperty
import cn.lnkdoc.sdk.uia.instance.weibo.request.UserInfoRequest
import com.alibaba.fastjson2.into
import io.vavr.Tuple2

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused", "Unchecked_cast", "Duplicated_code_fragment")
open class UserInfoConverter : IUiaConverter {
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
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        @Suppress("Duplicated_code_fragment")
        val tuple = body as Tuple2<String, WeiboProperty>
        // convert json
        
        val string = tuple._1
        
        val data = string.into<UserInfo>()
        data.raw = string

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
        return UserInfoRequest::class.java.getName()
    }
}
