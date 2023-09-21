package cn.lnkdoc.sdk.uia.instance.bjtoon.util.sign;

import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.MD5Coder;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * AbstractUiaClient
 *
 * @author shizongwang
 * @version v 1.0 2017-12-28
 */
@SuppressWarnings(value = {"unused"})
public class SignUtil {

    /**
     * getter
     * 
     * @param params sign map
     * @return sign (String)
     */
    public static String getSignContent(Map<String, String> params) {
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        int index = 0;
        for (String key : keys) {
            String value = params.get(key);
            //参数不为空的按照key=value用&拼接
            if (StringUtils.isNoneBlank(key, value)) {
                content.append((index == 0 ? "" : "&")).append(key).append("=").append(value);
                index++;
            }
        }
        return content.toString();

    }

    /**
     * getter
     * 
     * @param content content
     * @param signType signType
     * @return sign
     */
    public static String getSign(String content,String signType){

        if(StringUtils.equalsIgnoreCase("md5",signType)){
            return MD5Coder.MD5(content);
        }
        return null;

    }



}
