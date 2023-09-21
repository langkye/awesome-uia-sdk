package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class TeamAccessToken  implements Serializable {
    @Serial
    private static final long serialVersionUID = -508722906865178L;
    /**
     * teamAccessToken
     */
    private String teamAccessToken;
    /**
     * expireIn
     */
    private String expireIn;

    /**
     * getter
     * 
     * @return teamAccessToken
     */
    public String getTeamAccessToken() {
        return teamAccessToken;
    }

    /**
     * setter
     * 
     * @param teamAccessToken teamAccessToken
     */
    public void setTeamAccessToken(String teamAccessToken) {
        this.teamAccessToken = teamAccessToken;
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
