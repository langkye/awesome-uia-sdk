package cn.lnkdoc.sdk.uia.instance.bjtoon;

import org.apache.commons.lang3.RegExUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * CodeMessage
 *
 * @author qinyi
 * @version  v 1.0 2018-10-22
 */
@SuppressWarnings(value = {"unused"})
public class CodeMessage {

	private int code;

	private String message;

	/**
	 * constructor
	 */
	public CodeMessage() {
	}

	/**
	 * constructor
	 * 
	 * @param code code
	 * @param message message
	 */
	public CodeMessage(int code, String message) {
		setCode(code);
		setMessage(message);
	}

	/**
	 * getter
	 * 
	 * @return code
	 */
	public Integer getCode() {
		return this.code;
	}

	/**
	 * setter
	 * 
	 * @param code code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * getter
	 * 
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * setter
	 * 
	 * @param message message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * getter
	 * 
	 * @param paramValue paramValue
	 * @return message
	 */
	public String getMessage(String paramValue) {
		return RegExUtils.replacePattern(this.message, "\\$\\{.*\\}", paramValue);
	}

	/**
	 * getter
	 * 
	 * @param paramValues paramValues
	 * @return message
	 */
	public String getMessage(Map<String, String> paramValues) {
		AtomicReference<String> msg = new AtomicReference<>(this.message);
		paramValues.forEach((k,v) -> {
			String string = RegExUtils.replacePattern(msg.get(), "\\$\\{" + k + "\\}", v);
			msg.set(string);
		});
		return msg.get();
	}
	@Override
	public String toString() {
		return "code = " + this.code + ",message = " + this.message;
	}

}
