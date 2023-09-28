package cn.lnkdoc.sdk.uia.common.util

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import org.apache.commons.codec.binary.Hex
import org.apache.commons.lang3.StringUtils
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
object EncryptUtils {
    /**
     * encrypt
     *
     * @param plainText plainText
     * @return encrypt data
     */
    @JvmStatic
    fun mD5EncryptAsHex(plainText : String) : String {
        return mD5EncryptAsHex(plainText, null)
    }

    /**
     * encrypt
     *
     * @param plainText plainText
     * @param saltValue saltValue
     * @return encrypt data
     */
    @JvmStatic
    fun mD5EncryptAsHex(plainText : String, saltValue : String?) : String {
        return try {
            val alg = MessageDigest.getInstance("MD5")
            val message = java.lang.String.join("_", saltValue, plainText)
            val encryptBytes = alg.digest(
                if (StringUtils.isBlank(saltValue)) plainText.toByteArray(StandardCharsets.UTF_8) else message.toByteArray(
                    StandardCharsets.UTF_8
                )
            )
            Hex.encodeHexString(encryptBytes)
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }
}