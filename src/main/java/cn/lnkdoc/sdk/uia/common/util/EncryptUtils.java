package cn.lnkdoc.sdk.uia.common.util;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class EncryptUtils {

    @SuppressWarnings("ALL")
    public static String MD5EncryptAsHex(String plainText) {
       return MD5EncryptAsHex(plainText, null);
    }

    @SuppressWarnings("ALL")
    public static String MD5EncryptAsHex(String plainText, String saltValue) {
        try {
            MessageDigest alg = MessageDigest.getInstance("MD5");
            String message = String.join("_", saltValue, plainText);
            byte[] encryptBytes = alg.digest(
                    StringUtils.isBlank(saltValue) ?
                    plainText.getBytes(StandardCharsets.UTF_8) :
                            message.getBytes(StandardCharsets.UTF_8) 
                            
            );
            return Hex.encodeHexString(encryptBytes);
        } catch (Exception e) {
            throw new UiaException(e);
        }
    }
}
