package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption

import cn.lnkdoc.sdk.uia.common.exception.UiaException
import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.AES256Coder.decrypt
import cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption.AES256Coder.encrypt
import org.apache.commons.codec.binary.Base64


/**
 * @author langkye
 */
@Suppress("unused")
object CryptoClient {
    /**
     * CHARSET default utf-8
     */
    const val CHARSET = "UTF-8"

    /**
     * encrypt
     *
     * @param info message
     * @param aesKey key
     * @return encrypt message
     */
    @JvmStatic
    fun encryptWithAES(info: String, aesKey: String): String {
        return try {
            val key = HexUtil.hexStr2ByteArray(aesKey)
            val bytes = info.toByteArray()
            val encrypt = encrypt(bytes, key)
            HexUtil.byteArray2HexStr(encrypt)
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * decrypt
     *
     * @param info message
     * @param aesKey key
     * @return decrypt message
     */
    @JvmStatic
    fun decryptWithAES(info: String, aesKey: String): String {
        return try {
            val key = HexUtil.hexStr2ByteArray(aesKey)
            val bytes = HexUtil.hexStr2ByteArray(info)
            val decrypt = decrypt(bytes, key)
            String(decrypt)
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * encrypt
     *
     * @param data data
     * @param key key
     * @param isUrlSafe url_safe
     * @return encrypt data
     */
    @JvmStatic
    fun encryptWithDES(data: String, key: String, isUrlSafe: Boolean): String {
        return try {
            val md5 = MD5Coder.MD5(key)
            val encrypt = DESCoder
                .encrypt(data.toByteArray(charset("UTF-8")), md5)
            if (isUrlSafe) {
                Base64.encodeBase64URLSafeString(encrypt)
            } else Base64.encodeBase64String(encrypt)
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * decrypt
     *
     * @param encryptData data
     * @param key key
     * @return decrypt data
     */
    @JvmStatic
    fun decryptWithDES(encryptData: String, key: String): String {
        return try {
            val md5 = MD5Coder.MD5(key)
            val encodeBase64 = Base64.decodeBase64(
                encryptData
                    .toByteArray(charset("UTF-8"))
            )
            val encrypt = DESCoder.decrypt(encodeBase64, md5)
            String(encrypt, charset("UTF-8"))
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * encrypt
     *
     * @param data data
     * @param key key
     * @param isUrlSafe url_safe
     * @return encrypt data
     */
    @JvmStatic
    fun encryptWithRSA(data: String, key: String?, isUrlSafe: Boolean): String {
        return try {
            val encrypt = RSACoder.encryptByPublicKey(data.toByteArray(charset("UTF-8")), key)
            if (isUrlSafe) {
                Base64.encodeBase64URLSafeString(encrypt)
            } else Base64.encodeBase64String(encrypt)
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * decrypt
     *
     * @param encryptData encrypt_data
     * @param key key
     * @return decrypt data
     */
    @JvmStatic
    fun decryptWithRSA(encryptData: String, key: String?): String {
        return try {
            val encodeBase64 = Base64.decodeBase64(
                encryptData
                    .toByteArray(charset("UTF-8"))
            )
            val encrypt = RSACoder.decryptByPrivateKey(encodeBase64, key)
            String(encrypt, charset("UTF-8"))
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }

    /**
     * encrypt
     *
     * @param data data
     * @return encrypt data
     */
    @JvmStatic
    fun encryptWithMD5(data: String): String {
        return try {
            MD5Coder.MD5(data)
        } catch (e: Exception) {
            throw UiaException(e)
        }
    }
}