package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @author langkye
 */
@SuppressWarnings(value = {"unused"})
public class DESCoder {
	public static final String ENCODE_TYPE = "DES";
	public static final String ENCODE_TYPE_PADDING = "DES/ECB/PKCS5Padding";
	public static final String CHARSET = "UTF-8";


	public static byte[] encrypt(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());

			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);

			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);

			return cipher.doFinal(datasource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] src, String password) {
		try {
			SecureRandom random = new SecureRandom();

			DESKeySpec desKey = new DESKeySpec(password.getBytes());

			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

			SecretKey securekey = keyFactory.generateSecret(desKey);

			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, securekey, random);

			return cipher.doFinal(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}