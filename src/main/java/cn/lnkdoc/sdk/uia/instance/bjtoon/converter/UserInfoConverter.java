package cn.lnkdoc.sdk.uia.instance.bjtoon.converter;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.UserInfoRequest;
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse;
import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.CyptoClient;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.FormBody;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class UserInfoConverter implements IUiaConverter {
    /**
     * convert request
     *
     * @param body tuple
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertRequest(R body) {
        io.vavr.Tuple2<UserInfoRequest, BjtoonProperty> tuple = (io.vavr.Tuple2<UserInfoRequest, BjtoonProperty>) body;
        return (T) new FormBody.Builder()
                .addEncoded(UiaConstants.ACCESS_TOKEN, tuple._1.body())
                .build();
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertResponse(R body) {
        io.vavr.Tuple2<String, BjtoonProperty> tuple = (io.vavr.Tuple2<String, BjtoonProperty>) body;
        // convert json
        BjtoonResponse<UserInfo> wrapper = JSONObject.parseObject(tuple._1, new TypeReference<BjtoonResponse<UserInfo>>() {
        });

        // decrypt
        //CertNo Returned in AES256 Encryption
        if(tuple._2.isNeedsDecrypt() && wrapper.getData().getCertLevel().compareTo(UiaConstants.CERT_LEVEL_L1)>0){
            String decryptCertNo = CyptoClient.decryptWithAES(wrapper.getData().getCertNo(), tuple._2.getClientSecret());
            wrapper.getData().setCertNo(decryptCertNo);
        }

        return (T) wrapper.getData();
    }

    /**
     * converter name
     *
     * @return converter name
     */
    @Override
    public String name() {
        return UserInfoRequest.class.getName();
    }
}
