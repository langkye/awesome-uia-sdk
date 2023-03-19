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
		return RegExUtils.replacePattern(this.message, "\\$\\{.*\\}", paramValue);
	}

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
