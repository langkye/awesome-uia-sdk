package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption

import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Key
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec


/**
 * AbstractUiaClient
 *
 * @author qinyi
 * @version v 1.0 2018-10-22
 */
@Suppress("unused")
object AES256Coder {
    /**
     * KEY_ALGORITHM default AES
     */
    private const val KEY_ALGORITHM = "AES"

    /**
     * CIPHER_ALGORITHM default AES/ECB/PKCS5Padding
     */
    private const val CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"

    /**
     * KEY_LENGTH default 256
     */
    const val KEY_LENGTH = 256

    /**
     * init key
     * @return byte[]
     * @throws Exception ex
     */
    @Throws(Exception::class)
    @JvmStatic
    fun initKey(): ByteArray {
        Security.addProvider(BouncyCastleProvider())
        val kg = KeyGenerator.getInstance(KEY_ALGORITHM, "BC")
        val secretKey = kg.generateKey()
        return secretKey.encoded
    }

    /**
     * to key
     *
     * @param key key
     * @return Key
     */
    @JvmStatic
    fun toKey(key: ByteArray?): Key {
        return SecretKeySpec(key, KEY_ALGORITHM)
    }

    /**
     * encrypt
     *
     * @param data data
     * @param key key
     * @return byte[]
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun encrypt(data: ByteArray?, key: ByteArray?): ByteArray {
        val k = toKey(key)
        Security.addProvider(BouncyCastleProvider())
        val cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC")
        cipher.init(Cipher.ENCRYPT_MODE, k)
        return cipher.doFinal(data)
    }

    /**
     * decrypt
     *
     * @param data data
     * @param key key
     * @return byte[]
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun decrypt(data: ByteArray?, key: ByteArray?): ByteArray {
        val k = toKey(key)
        val cipher = Cipher.getInstance(CIPHER_ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, k)
        return cipher.doFinal(data)
    }
}