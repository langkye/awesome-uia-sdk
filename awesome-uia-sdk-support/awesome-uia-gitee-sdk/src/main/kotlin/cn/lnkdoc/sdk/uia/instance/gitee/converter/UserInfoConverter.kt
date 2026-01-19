package cn.lnkdoc.sdk.uia.instance.gitee.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.gitee.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.gitee.request.UserInfoRequest
import cn.lnkdoc.sdk.uia.instance.gitee.property.GiteeProperty
import com.alibaba.fastjson2.into
import io.vavr.Tuple2


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast")
open class UserInfoConverter : IUiaConverter {
    private var name: String = UserInfoRequest::class.java.getName()
    
    /**
     * convert request
     *
     * @param body tuple
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
        
        builder.add("Accept", "application/json")
        
        return builder.build() as T
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
        val data = tuple._1.into<UserInfo>()

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

