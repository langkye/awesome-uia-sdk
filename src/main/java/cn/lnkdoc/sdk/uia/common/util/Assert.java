package cn.lnkdoc.sdk.uia.common.util;


import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class Assert {
    /**
     * required
     * 
     * @param obj obj
     */
    public static void required(Object obj) {
        required(obj, null);
    }

    /**
     * required
     * 
     * @param obj obj
     * @param message message
     */
    public static void required(Object obj, String message) {
        if (obj == null) {
            String msg = "the argument is null";
            throw new UiaException(StringUtils.isBlank(message) ? msg : message);
        }

        if (obj instanceof String) {
            if ("".equals(((String) obj).trim())) {
                String msg = "the string argument is blank";
                throw new UiaException(StringUtils.isBlank(message) ? msg : message);
            }
        }

        if (obj instanceof Collection) {
            if (((Collection<?>) obj).isEmpty()) {
                String msg = "the collection argument is empty";
                throw new UiaException(StringUtils.isBlank(message) ? msg : message);
            }
        }
        if (obj instanceof Map) {
            if (((Map<?, ?>) obj).isEmpty()) {
                String msg = "the map argument is empty";
                throw new UiaException(StringUtils.isBlank(message) ? msg : message);
            }
        }
    }
}
