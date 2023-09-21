package cn.lnkdoc.sdk.uia.instance.jban.util;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.jban.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class CheckResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(CheckResponseUtil.class);

    /**
     * check
     * 
     * @param json json
     */
    public static synchronized void check(String json) {
        check(json, false);
    }

    /**
     * check
     * 
     * @param json json
     * @param printStack printStack
     */
    public static synchronized void check(String json, Boolean printStack) {
        JbanResponse<AccessToken> jbanResponse = JSON.parseObject(json, new TypeReference<JbanResponse<AccessToken>>(){});
        if (!Objects.equals(0, jbanResponse.getCode())) {
            if (Objects.equals(true, printStack)) {
                log.error(json);
            }
            throw new UiaException(jbanResponse.getMsg());
        }
    }
}
