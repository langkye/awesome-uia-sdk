package cn.lnkdoc.sdk.uia.instance.yztoon.domain;

import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class AccessToken implements Serializable {
    @JSONField(name="expires_in")
    private int expiresIn;
    @JSONField(name="token_type")
    private String tokenType;
    @JSONField(name="access_token")
    private String accessToken;

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
