package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

import java.io.Serializable;

/**
 *
 * AuthTicket Object to be returned
 *
 * @author qinyi
 * @version  v 1.0 2018-10-23
 */
@SuppressWarnings(value = {"unused"})
public class AuthTicket implements Serializable {

	private static final long serialVersionUID = -50843L;

	private String authTicket;

	private String expiresIn;

	public String getAuthTicket() {
		return authTicket;
	}

	public void setAuthTicket(String authTicket) {
		this.authTicket = authTicket;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}


}
