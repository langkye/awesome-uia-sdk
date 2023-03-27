package cn.lnkdoc.sdk.uia.instance.yztoon.convert;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.yztoon.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.AccessTokenRequest;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.vavr.Tuple2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class AccessTokenConverter implements IUiaConverter {
    private static final Logger log = LoggerFactory.getLogger(AccessToken.class);
    
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertResponse(R body) {
        Tuple2<String, YztoonProperty> tuple = ((Tuple2<String, YztoonProperty>) body);
        String json = tuple._1; 
        AccessToken accessToken = JSONObject.parseObject(json, AccessToken.class);
        if (StringUtils.isBlank(accessToken.getAccessToken())) {
            String message = "convert to AccessToken failed from json: [" + json + "]. because 'accessToken' not fund from response's json";

            try {
                JSONObject jsonObject = JSON.parseObject(json);
                message = jsonObject.getString("error_description");
            } catch (Exception e) {
                if (tuple._2.isPrintStack()) {
                    log.error("", e);
                }
            }

            throw new UiaException(message);
        }
        return (T) accessToken;
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    @Override
    public <T, R> T convertRequest(R body) {
        throw new UiaException("TODO");
    }

    /**
     * converter name
     *
     * @return converter name
     */
    @Override
    public String name() {
        return AccessTokenRequest.class.getName();
    }
}
