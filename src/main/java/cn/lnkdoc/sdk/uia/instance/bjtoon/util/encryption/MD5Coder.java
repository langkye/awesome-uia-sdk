package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author langkye
 */
public class MD5Coder {
	/**
	 * md5
	 * 
	 * @param s string
	 * @return md5 string
	 */
	@SuppressWarnings(value = {"SpellCheckingInspection", "ALL"})
	public static String MD5(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes(StandardCharsets.UTF_8);

			MessageDigest mdInst = MessageDigest.getInstance("MD5");

			mdInst.update(btInput);

			byte[] md = mdInst.digest();

			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (byte byte0 : md) {
				str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
				str[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}