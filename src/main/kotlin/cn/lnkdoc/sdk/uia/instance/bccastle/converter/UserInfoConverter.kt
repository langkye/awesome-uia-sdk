package cn.lnkdoc.sdk.uia.instance.bccastle.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants
import cn.lnkdoc.sdk.uia.instance.bccastle.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.bccastle.property.BccastleProperty
import cn.lnkdoc.sdk.uia.instance.bccastle.request.UserInfoRequest
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.TypeReference
import io.vavr.Tuple2

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("Unchecked_cast", "unused")
class UserInfoConverter : IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val json = body as String
        val accessToken = JSON.parseObject(json, object : TypeReference<UserInfo?>() {}) as UserInfo
        return accessToken as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertRequest(body: R): T {
        val tuple = body as Tuple2<BccastleProperty, UserInfoRequest>
        val property = tuple._1
        val req = tuple._2

        //请求对象
        return req.body?.let {
            okhttp3.FormBody.Builder()
                .addEncoded(UiaConstants.CLIENT_ID, property.clientId)
                .addEncoded(UiaConstants.GRANT_TYPE_REFRESH, it)
                .build()
        } as T
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
