package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class AppAccessToken  implements Serializable {
    @Serial
    private static final long serialVersionUID = -508722906865178L;
    /**
     * appAccessToken
     */
    private String appAccessToken;
    /**
     * expireIn
     */
    private String expireIn;

    /**
     * getter
     * 
     * @return appAccessToken
     */
    public String getAppAccessToken() {
        return appAccessToken;
    }

    /**
     * setter
     * 
     * @param appAccessToken appAccessToken
     */
    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }

    /**
     * getter
     * 
     * @return expireIn
     */
    public String getExpireIn() {
        return expireIn;
    }

    /**
     * setter
     * 
     * @param expireIn expireIn
     */
    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }
}
