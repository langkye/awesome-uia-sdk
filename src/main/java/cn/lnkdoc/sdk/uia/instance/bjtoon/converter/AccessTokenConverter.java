package cn.lnkdoc.sdk.uia.instance.bjtoon.converter;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;
import cn.lnkdoc.sdk.uia.instance.bjtoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.request.AccessTokenRequest;
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse;
import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.CyptoClient;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.FormBody;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class AccessTokenConverter implements IUiaConverter {
    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertRequest(R body) {
        io.vavr.Tuple2<AccessTokenRequest, BjtoonProperty> tuple = (io.vavr.Tuple2<AccessTokenRequest, BjtoonProperty>) body;
        BjtoonProperty bjtoonProperty = tuple._2;
        AccessTokenRequest accessTokenRequest = tuple._1;

        String authToken =  CyptoClient.encryptWithAES(
                bjtoonProperty.getClientId() + ":" + bjtoonProperty.getClientSecret() + ":" + System.currentTimeMillis()
                , bjtoonProperty.getClientSecret());

        return (T) new FormBody.Builder()
                .addEncoded(UiaConstants.CLIENT_ID, bjtoonProperty.getClientId())
                .addEncoded(UiaConstants.CLIENT_SECRET, bjtoonProperty.getClientSecret())
                .addEncoded(UiaConstants.REDIRECT_URI, bjtoonProperty.getRedirectUri())
                .addEncoded(UiaConstants.GRANT_CODE, accessTokenRequest.getGrantCode())
                .addEncoded(UiaConstants.GRANT_TYPE, bjtoonProperty.getGrantType())
                .addEncoded(UiaConstants.AUTH_TOKEN, authToken)
                .addEncoded(UiaConstants.SCOPE, bjtoonProperty.getScope())
                .addEncoded(UiaConstants.TOON_TYPE, accessTokenRequest.getToonType())
                .addEncoded(UiaConstants.STATE, accessTokenRequest.getState())
                .addEncoded(UiaConstants.IN_TYPE, accessTokenRequest.getInType())
                .addEncoded(UiaConstants.LOCAL_CHECK, accessTokenRequest.getLocalCheck())

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
        return JSONObject.parseObject(tuple._1, new TypeReference<BjtoonResponse<AccessToken>>() {
        });
    }

    /**
     * converter name
     *
     * @return converter name
     */
    @Override
    public String name() {
        return AccessTokenRequest.class.getSimpleName();
    }
}
