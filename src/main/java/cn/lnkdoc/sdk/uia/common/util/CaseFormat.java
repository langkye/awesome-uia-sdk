package cn.lnkdoc.sdk.uia.common.util;

import java.util.Locale;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class CaseFormat {

    /**
     * UPPER_UNDERSCORE_2_LOWER_CAMEL
     * 
     * @param string string
     * @return UPPER_UNDERSCORE_2_LOWER_CAMEL
     */
    @SuppressWarnings("ALL")
    public static String UPPER_UNDERSCORE_2_LOWER_CAMEL(String string) {
        if (string == null) {
            return string;
        }

        StringBuilder lowerCamelBuilder = new StringBuilder();
        
        String[] array = string.split("_");
        for (int i = 0; i < array.length; i++) {
            String item = array[i];
            if (item != null && item.length() > 1) {
                item = item.toLowerCase(Locale.ROOT);
                String head = item.substring(0, 1);
                String tail = item.substring(1);
                
                lowerCamelBuilder.append(i == 0 ? head : head.toUpperCase(Locale.ROOT)).append(tail);
            }
        }
        
        return lowerCamelBuilder.toString();
    } 
}
