package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import org.apache.commons.codec.binary.Base64;

@SuppressWarnings("ALL")
public class CyptoClient {
	public static final String CHARSET = "UTF-8";
	
	public static String encryptWithAES(String info, String aeskey) {
		try {
			byte[] key = HexUtil.hexStr2ByteArray(aeskey);
			byte[] bytes = info.getBytes();
			byte[] encrypt = AES256Coder.encrypt(bytes, key);
			return HexUtil.byteArray2HexStr(encrypt);
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

	public static String decryptWithAES(String info, String aeskey) {
		try {
			byte[] key = HexUtil.hexStr2ByteArray(aeskey);
			byte[] bytes = HexUtil.hexStr2ByteArray(info);
			byte[] decrypt = AES256Coder.decrypt(bytes, key);
			return new String(decrypt);
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

	public static String encryptWithDES(String data, String key,
										boolean isUrlSafe) {
		try {
			String md5 = MD5Coder.MD5(key);
			byte[] encrypt = DESCoder
					.encrypt(data.getBytes("UTF-8"), md5);
			if (isUrlSafe) {
				return Base64.encodeBase64URLSafeString(encrypt);
			}
			return Base64.encodeBase64String(encrypt);
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

	public static String decryptWithDES(String encryptData, String key) {
		try {
			String md5 = MD5Coder.MD5(key);
			byte[] encodeBase64 = Base64.decodeBase64(encryptData
					.getBytes("UTF-8"));
			byte[] encrypt = DESCoder.decrypt(encodeBase64, md5);
			return new String(encrypt, "UTF-8");
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

	public static String encryptWithRSA(String data, String key, boolean isUrlSafe) {
		try {
			byte[] encrypt = RSACoder.encryptByPublicKey(data.getBytes("UTF-8"), key);
			if (isUrlSafe) {
				return Base64.encodeBase64URLSafeString(encrypt);
			}
			return Base64.encodeBase64String(encrypt);
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

	public static String decryptWithRSA(String encryptData, String key) {
		try {
			byte[] encodeBase64 = Base64.decodeBase64(encryptData
					.getBytes("UTF-8"));
			byte[] encrypt = RSACoder.decryptByPrivateKey(encodeBase64, key);
			return new String(encrypt, "UTF-8");
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

	public static String encryptWithMD5(String data) {
		try {
			return MD5Coder.MD5(data);
		} catch (Exception e) {
			throw new UiaException(e);
		}
	}

}