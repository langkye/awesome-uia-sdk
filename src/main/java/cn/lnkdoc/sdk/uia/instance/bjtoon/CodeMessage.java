package cn.lnkdoc.sdk.uia.instance.bjtoon;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 *
 * CodeMessage
 *
 * @author qinyi
 * @version  v 1.0 2018-10-22
 */
public class CodeMessage {

	private int code;

	private String message;

	public CodeMessage() {
	}

	public CodeMessage(int code, String message) {
		setCode(code);
		setMessage(message);
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage(String paramValue) {
		return StringUtils.replacePattern(this.message, "\\$\\{.*\\}",
				paramValue);
	}

	public String getMessage(Map<String, String> paramValues) {
		String msg = this.message;
		for (Map.Entry entry : paramValues.entrySet()) {
			msg = StringUtils.replacePattern(msg,
					"\\$\\{" + entry.getKey() + "\\}",
					(String) entry.getValue());
		}
		return msg;
	}
	@Override
	public String toString() {
		return "code = " + this.code + ",message = " + this.message;
	}

}
