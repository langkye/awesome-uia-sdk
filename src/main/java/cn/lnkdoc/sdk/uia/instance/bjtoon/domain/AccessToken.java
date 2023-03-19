package cn.lnkdoc.sdk.uia.instance.bjtoon.domain;

import com.alibaba.fastjson2.annotation.JSONField;

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
	private static final long serialVersionUID = -508722906865178L;
	
	private String accessToken;
	
	private String tokenType;
	
	private String expiresIn;
	
	private String refreshToken;

	public String getAccessToken() {
		return accessToken;
	}
	@JSONField(name = "access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}
	@JSONField(name = "token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getExpiresIn() {
		return expiresIn;
	}
	@JSONField(name = "expires_in")
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}
	@JSONField(name = "refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}