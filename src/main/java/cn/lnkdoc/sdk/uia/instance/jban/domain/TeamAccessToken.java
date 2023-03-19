package cn.lnkdoc.sdk.uia.instance.jban.domain;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class TeamAccessToken  implements Serializable {
    private static final long serialVersionUID = -508722906865178L;
    private String teamAccessToken;
    private String expireIn;

    public String getTeamAccessToken() {
        return teamAccessToken;
    }

    public void setTeamAccessToken(String teamAccessToken) {
        this.teamAccessToken = teamAccessToken;
    }

    public String getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }
}
