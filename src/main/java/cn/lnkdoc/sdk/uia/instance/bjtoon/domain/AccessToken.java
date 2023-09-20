package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * AccessToken Object to be returned
 *
 * @author qinyi
 * @version  v 1.0 2018-10-23
 */
@SuppressWarnings(value = {"unused"})
public class AccessToken implements Serializable {
	@Serial
	private static final long serialVersionUID = -508722906865178L;
	/**
	 * accessToken
	 */
	private String accessToken;
	/**
	 * tokenType
	 */
	private String tokenType;
	/**
	 * expiresIn
	 */
	private String expiresIn;
	/**
	 * refreshToken
	 */
	private String refreshToken;

	/**
	 * getter
	 * 
	 * @return accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * setter
	 * 
	 * @param accessToken  accessToken
	 */
	@JSONField(name = "access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * getter
	 *
	 * @return tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * setter
	 * 
	 * @param tokenType  tokenType
	 */
	@JSONField(name = "token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
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
	@JSONField(name = "expires_in")
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	/**
	 * getter
	 *
	 * @return refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * setter
	 * 
	 * @param refreshToken refreshToken
	 */
	@JSONField(name = "refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}