package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

import java.io.Serial;
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

	@Serial
	private static final long serialVersionUID = -50843L;
	/**
	 * authTicket
	 */
	private String authTicket;
	/**
	 * expiresIn
	 */
	private String expiresIn;

	/**
	 * getter
	 * 
	 * @return authTicket
	 */
	public String getAuthTicket() {
		return authTicket;
	}

	/**
	 * setter 
	 * 
	 * @param authTicket authTicket
	 */
	public void setAuthTicket(String authTicket) {
		this.authTicket = authTicket;
	}

	/**
	 * getter
	 * 
	 * @return expiresIn
	 */
	public String getExpiresIn() {
		return expiresIn;
	}

	/**
	 * setter
	 * 
	 * @param expiresIn expiresIn
	 */
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}


}
