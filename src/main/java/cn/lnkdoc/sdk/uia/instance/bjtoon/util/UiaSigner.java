package cn.lnkdoc.sdk.uia.instance.bjtoon.util;

/**
 * Sign Interface
 *
 * @author qinyi
 * @version v 1.0 2018-10-22
 */
@SuppressWarnings(value = {"unused"})
public interface UiaSigner {
	
	/**
	 * sign
	 * 
	 * @param sourceContent content to be signed
	 * @param signType signType
	 * @param charset charset
	 * @return String
	 */
	String sign(Object sourceContent, String signType, String charset);

}
