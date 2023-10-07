package cn.lnkdoc.sdk.uia.instance.bjtoon.converter

import cn.lnkdoc.sdk.uia.common.converter.IUiaConverter
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse
import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.CryptoClient
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
        val tuple = body as Tuple2<UserInfoRequest, BjtoonProperty>
        return okhttp3.FormBody.Builder()
            .addEncoded(UiaConstants.ACCESS_TOKEN, tuple._1.body())
            .build() as T
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    override fun <T, R> convertResponse(body: R): T {
        val tuple = body as Tuple2<String, BjtoonProperty>
        // convert json
        val wrapper = tuple._1.into<BjtoonResponse<UserInfo>>()
        // decrypt
        //CertNo Returned in AES256 Encryption
        if (tuple._2.isNeedsDecrypt && wrapper.data?.certLevel?.compareTo(UiaConstants.CERT_LEVEL_L1)!! > 0) {
            val decryptCertNo = wrapper.data!!.certNo?.let { CryptoClient.decryptWithAES(it, tuple._2.clientSecret) }
            wrapper.data?.certNo = decryptCertNo
        }
        return wrapper.data as T
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

