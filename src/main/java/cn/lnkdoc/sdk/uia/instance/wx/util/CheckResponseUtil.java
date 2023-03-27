package cn.lnkdoc.sdk.uia.instance.wx.util;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse;
import com.alibaba.fastjson2.JSONObject;
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
    
    public static synchronized void check(String json) {
        check(json, false);
    }
    
    public static synchronized void check(String json, Boolean isPrintStack) {
        WxResponse wxResponse = JSONObject.parseObject(json, new TypeReference<WxResponse>() {
        });
        
        if (Objects.nonNull(wxResponse.getErrcode())) {
            if (!Objects.equals(0, wxResponse.getErrcode())) {
                if (Objects.equals(isPrintStack, true)) {
                    log.error(json);
                }
                throw new UiaException(wxResponse.getErrmsg());
            }
        }
        
    }
}
