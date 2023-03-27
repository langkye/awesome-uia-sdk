package cn.lnkdoc.sdk.uia.instance.bjtoon.util;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings({"rawtypes"})
public class CheckResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(CheckResponseUtil.class);
    
    public static synchronized void check(String json) {
        check(json, false);
    }
    
    public static synchronized void check(String json, Boolean isPrintStack) {
        BjtoonResponse response = JSONObject.parseObject(json, new TypeReference<BjtoonResponse>() {
        });

        // check success
        boolean isSuccess = UiaConstants.RETURN_CODE_SUCCESS.getCode().equals(response.getMeta().getCode())
                && response.getData() != null;

        if (!isSuccess) {
            if (Objects.equals(true, isPrintStack)) {
                log.error(json);
            }
            throw new UiaException(response.getMeta().getMessage());
        }
    }
}
