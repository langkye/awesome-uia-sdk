package cn.lnkdoc.sdk.uia.instance.bjtoon.util.encryption;


import org.apache.commons.lang3.StringUtils;

/**
 * @author langkye
 */
public class HexUtil {

	/**
	 * 把hex转数组
	 * @param hexString hexString
	 * @return byte[]
	 */
	public static byte[] hexStr2ByteArray(String hexString) {  
	    if (StringUtils.isEmpty(hexString)) {
			throw new IllegalArgumentException("this hexString must not be empty");
		}  
	  
	    hexString = hexString.toLowerCase();  
	    final byte[] byteArray = new byte[hexString.length() / 2];  
	    int k = 0;  
	    for (int i = 0; i < byteArray.length; i++) {  
	                    //因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先  
	                    //将hex 转换成byte   "&" 操作为了防止负数的自动扩展  
	                    // hex转换成byte 其实只占用了4位，然后把高位进行右移四位  
	                    // 然后“|”操作  低四位 就能得到 两个 16进制数转换成一个byte.  
	        byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
	        byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);  
	        byteArray[i] = (byte) (high << 4 | low);  
	        k += 2;  
	    }  
	    return byteArray;  
	}

	/**
	 * byte to hex
	 * 
	 * @param byteArray byteArray
	 * @return string
	 */
	public static String byteArray2HexStr(byte[] byteArray) {
		if (byteArray == null || byteArray.length < 1) {
			throw new IllegalArgumentException("this byteArray must not be null or empty");
		}
		final StringBuilder hexString = new StringBuilder();
		for (byte b : byteArray) {
			if ((b & 0xff) < 0x10)// 0~F前面不零
			{
				hexString.append("0");
			}
			hexString.append(Integer.toHexString(0xFF & b));
		}
		return hexString.toString().toLowerCase();

	}
}
