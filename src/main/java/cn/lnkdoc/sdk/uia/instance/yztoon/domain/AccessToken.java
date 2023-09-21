package cn.lnkdoc.sdk.uia.instance.yztoon.domain;

import com.alibaba.fastjson2.annotation.JSONField;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class AccessToken implements Serializable {
    /**
     * expiresIn
     */
    @JSONField(name="expires_in")
    private int expiresIn;
    /**
     * tokenType
     */
    @JSONField(name="token_type")
    private String tokenType;
    /**
     * accessToken
     */
    @JSONField(name="access_token")
    private String accessToken;

    /**
     * getter
     * 
     * @return expiresIn
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    /**
     * setter
     * 
     * @param expiresIn expiresIn
     */
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
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
     * @param tokenType tokenType
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

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
     * @param accessToken accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
