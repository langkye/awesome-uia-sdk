package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption

import org.apache.commons.codec.binary.Base64
import java.io.ByteArrayOutputStream
import java.security.Key
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.Signature
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher


/**
 * @author langkye
 */
@Suppress("unused", "Duplicated_code_fragment")
object RSACoder {
    /**
     * KEY_ALGORITHM
     */
    private const val KEY_ALGORITHM = "RSA"

    /**
     * SIGNATURE_ALGORITHM
     */
    private const val SIGNATURE_ALGORITHM = "MD5withRSA"

    /**
     * PUBLIC_KEY
     */
    private const val PUBLIC_KEY = "RSAPublicKey"

    /**
     * PRIVATE_KEY
     */
    private const val PRIVATE_KEY = "RSAPrivateKey"

    /**
     * MAX_ENCRYPT_BLOCK
     */
    private const val MAX_ENCRYPT_BLOCK = 117

    /**
     * MAX_DECRYPT_BLOCK
     */
    private const val MAX_DECRYPT_BLOCK = 128

    /**
     * sign
     *
     * @param data data
     * @param privateKey privateKey
     * @return result
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun sign(data: ByteArray?, privateKey: String?): String {
        // 解密由base64编码的私钥  
        val keyBytes = Base64.decodeBase64(privateKey)

        // 构造PKCS8EncodedKeySpec对象  
        val pkcs8KeySpec = PKCS8EncodedKeySpec(keyBytes)

        // KEY_ALGORITHM 指定的加密算法  
        val keyFactory = KeyFactory.getInstance(KEY_ALGORITHM)

        // 取私钥匙对象  
        val priKey = keyFactory.generatePrivate(pkcs8KeySpec)

        // 用私钥对信息生成数字签名  
        val signature = Signature.getInstance(SIGNATURE_ALGORITHM)
        signature.initSign(priKey)
        signature.update(data)
        return Base64.encodeBase64String(signature.sign())
    }

    /**
     * vierfy
     *
     * @param data data
     * @param publicKey publicKey
     * @param sign sign
     * @return result
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun verify(data: ByteArray?, publicKey: String?, sign: String?): Boolean {

        // 解密由base64编码的公钥  
        val keyBytes = Base64.decodeBase64(publicKey)

        // 构造X509EncodedKeySpec对象  
        val keySpec = X509EncodedKeySpec(keyBytes)

        // KEY_ALGORITHM 指定的加密算法  
        val keyFactory = KeyFactory.getInstance(KEY_ALGORITHM)

        // 取公钥匙对象  
        val pubKey = keyFactory.generatePublic(keySpec)
        val signature = Signature.getInstance(SIGNATURE_ALGORITHM)
        signature.initVerify(pubKey)
        signature.update(data)

        // 验证签名是否正常  
        return signature.verify(Base64.decodeBase64(sign))
    }

    /**
     * decrypt
     *
     * @param data data
     * @param key key
     * @return decrypt data
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun decryptByPrivateKey(data: ByteArray, key: String?): ByteArray {
        val keyBytes = Base64.decodeBase64(key)
        val pkcs8KeySpec = PKCS8EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(KEY_ALGORITHM)
        val privateK: Key = keyFactory.generatePrivate(pkcs8KeySpec)
        val cipher = Cipher.getInstance(keyFactory.algorithm)
        return decrypt(cipher, privateK, data)
    }

    /**
     * decrypt
     *
     * @param data data
     * @param key key
     * @return decrypt data
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun decryptByPublicKey(data: ByteArray, key: String?): ByteArray {
        val keyBytes = Base64.decodeBase64(key)
        val x509KeySpec = X509EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(KEY_ALGORITHM)
        val publicK: Key = keyFactory.generatePublic(x509KeySpec)
        val cipher = Cipher.getInstance(keyFactory.algorithm)
        return decrypt(cipher, publicK, data)
    }

    /**
     * encrypt
     *
     * @param data data
     * @param key key
     * @return encrypt data
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun encryptByPublicKey(data: ByteArray, key: String?): ByteArray {
        val keyBytes = Base64.decodeBase64(key)
        val x509KeySpec = X509EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(KEY_ALGORITHM)
        val publicK: Key = keyFactory.generatePublic(x509KeySpec)
        // 对数据加密  
        val cipher = Cipher.getInstance(keyFactory.algorithm)
        return encrypt(cipher, publicK, data)
    }

    /**
     * encrypt
     *
     * @param data data
     * @param key key
     * @return encrypt data
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun encryptByPrivateKey(data: ByteArray, key: String?): ByteArray {
        val keyBytes = Base64.decodeBase64(key)
        val pkcs8KeySpec = PKCS8EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(KEY_ALGORITHM)
        val privateK: Key = keyFactory.generatePrivate(pkcs8KeySpec)
        val cipher = Cipher.getInstance(keyFactory.algorithm)
        return encrypt(cipher, privateK, data)
    }
    
    /**
     * getter
     *
     * @param keyMap km
     * @return pk
     */
    @JvmStatic
    fun getPrivateKey(keyMap: Map<String?, Any?>): String {
        val key = keyMap[PRIVATE_KEY] as Key?
        //String privateKey = new String(key.getEncoded(),"iso-8859-1");
        return Base64.encodeBase64String(key!!.encoded)
    }

    /**
     * getter
     *
     * @param keyMap km
     * @return pk
     */
    @JvmStatic
    fun getPublicKey(keyMap: Map<String?, Any?>): String {
        val key = keyMap[PUBLIC_KEY] as Key?
        //String publicKey = new String(key.getEncoded(), "iso-8859-1");
        return Base64.encodeBase64String(key!!.encoded)
    }

    /**
     * init
     *
     * @return km
     * @throws Exception ex
     */
    @JvmStatic
    @Throws(Exception::class)
    fun initKey(): Map<String, Any> {
        val keyPairGen = KeyPairGenerator
            .getInstance(KEY_ALGORITHM)
        keyPairGen.initialize(1024)
        val keyPair = keyPairGen.generateKeyPair()

        // 公钥  
        val publicKey = keyPair.public as RSAPublicKey

        // 私钥  
        val privateKey = keyPair.private as RSAPrivateKey
        val keyMap: MutableMap<String, Any> = HashMap(2)
        keyMap[PUBLIC_KEY] = publicKey
        keyMap[PRIVATE_KEY] = privateKey
        return keyMap
    }

    /**
     * decrypt
     * 
     * @param cipher cipher
     * @param privateK privateK
     * @param data data
     * @return decrypt
     */
    private fun decrypt(cipher: Cipher, privateK: Key, data: ByteArray): ByteArray {
        cipher.init(Cipher.DECRYPT_MODE, privateK)
        val inputLen = data.size
        val out = ByteArrayOutputStream()
        var offSet = 0
        var cache: ByteArray
        var i = 0
        // 对数据分段解密  
        while (inputLen - offSet > 0) {
            cache = if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK)
            } else {
                cipher.doFinal(data, offSet, inputLen - offSet)
            }
            out.write(cache, 0, cache.size)
            i++
            offSet = i * MAX_DECRYPT_BLOCK
        }
        val decryptedData = out.toByteArray()
        out.close()
        return decryptedData
    }

    /**
     * encrypt
     *
     * @param cipher cipher
     * @param privateK privateK
     * @param data data
     * @return encrypt
     */
    private fun encrypt(cipher: Cipher, privateK: Key, data: ByteArray): ByteArray {
        cipher.init(Cipher.ENCRYPT_MODE, privateK)
        val inputLen = data.size
        val out = ByteArrayOutputStream()
        var offSet = 0
        var cache: ByteArray
        var i = 0
        // 对数据分段加密  
        while (inputLen - offSet > 0) {
            cache = if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK)
            } else {
                cipher.doFinal(data, offSet, inputLen - offSet)
            }
            out.write(cache, 0, cache.size)
            i++
            offSet = i * MAX_ENCRYPT_BLOCK
        }
        val encryptedData = out.toByteArray()
        out.close()
        return encryptedData
    }
}