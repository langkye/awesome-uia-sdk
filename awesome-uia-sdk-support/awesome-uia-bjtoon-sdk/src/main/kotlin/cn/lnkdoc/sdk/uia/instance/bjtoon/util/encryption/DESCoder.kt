package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption

import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec


/**
 * @author langkye
 */
@Suppress("unused")
object DESCoder {
    /**
     * ENCODE_TYPE
     */
    const val ENCODE_TYPE = "DES"

    /**
     * ENCODE_TYPE_PADDING
     */
    const val ENCODE_TYPE_PADDING = "DES/ECB/PKCS5Padding"

    /**
     * CHARSET
     */
    const val CHARSET = "UTF-8"

    /**
     * encrypt
     *
     * @param datasource data
     * @param password pwd
     * @return encrypt byte[]
     */
    @JvmStatic
    fun encrypt(datasource: ByteArray?, password: String): ByteArray? {
        try {
            val random = SecureRandom()
            val desKey = DESKeySpec(password.toByteArray())
            val keyFactory = SecretKeyFactory.getInstance("DES")
            val secureKey = keyFactory.generateSecret(desKey)
            val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secureKey, random)
            return cipher.doFinal(datasource)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * decrypt
     *
     * @param src data
     * @param password pwd
     * @return decrypt data
     */
    @JvmStatic
    fun decrypt(src: ByteArray, password: String): ByteArray {
       val random = SecureRandom()
            val desKey = DESKeySpec(password.toByteArray())
            val keyFactory = SecretKeyFactory.getInstance("DES")
            val securekey = keyFactory.generateSecret(desKey)
            val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(Cipher.DECRYPT_MODE, securekey, random)
            return cipher.doFinal(src)
    }
}