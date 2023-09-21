package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * AbstractUiaClient
 *
 * @author qinyi
 * @version v 1.0 2018-10-22
 */
@SuppressWarnings(value = {"unused"})
public class AES256Coder {
	/**
	 * KEY_ALGORITHM default AES
	 */
	public static final String KEY_ALGORITHM = "AES";
	/**
	 * CIPHER_ALGORITHM default AES/ECB/PKCS5Padding
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	/**
	 * KEY_LENGTH default 256
	 */
	public static final Integer KEY_LENGTH = 256;

	/**
	 * init key
	 * @return byte[]
	 * @throws Exception ex
	 */
	public static byte[] initKey() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * to key
	 * 
	 * @param key key
	 * @return Key
	 */
	public static Key toKey(byte[] key) {
		return new SecretKeySpec(key, KEY_ALGORITHM);
	}

	/**
	 * encrypt
	 * 
	 * @param data data
	 * @param key key
	 * @return byte[]
	 * @throws Exception ex
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Security.addProvider(new BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	/**
	 * decrypt
	 * 
	 * @param data data
	 * @param key key
	 * @return byte[]
	 * @throws Exception ex
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

}