package cn.lnkdoc.sdk.uia.instance.yztoon.convert

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter
import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty
import cn.lnkdoc.sdk.uia.instance.yztoon.request.UserInfoRequest
import com.alibaba.fastjson2.into
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
        val tuple = body as Tuple2<String, YztoonProperty>
        val json = tuple._1
        val userInfo = json.into<UserInfo>()
        userInfo.parseExtInfo()
        return userInfo as T
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
        return UserInfoRequest::class.java.getName()
    }
}
