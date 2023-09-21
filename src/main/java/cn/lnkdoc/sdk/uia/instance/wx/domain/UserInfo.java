package cn.lnkdoc.sdk.uia.instance.wx.domain;

import cn.lnkdoc.sdk.uia.instance.wx.response.WxResponse;

/**
 * 用户信息
 * <pre>
 * 建议：
 *    开发者最好保存用户unionID信息，以便以后在不同应用中进行用户信息互通。
 *    错误的Json返回示例:
 *    {
 *    "errcode":40003,"errmsg":"invalid openid"
 *    }
 * </pre>
 * 
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class UserInfo extends WxResponse {
    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    private String openid;
    /**
     * 普通用户昵称
     */
    private String nickname;
    /**
     * 普通用户性别，1为男性，2为女性
     */
    private Integer sex;
    /**
     * 普通用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    private String headimgurl;
    /**
     * 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     */
    private String privilege;
    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    private String unionid;

    /**
     * getter
     * 
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * setter
     * 
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * getter
     * 
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * setter
     * 
     * @param nickname nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * getter
     * 
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * setter
     * 
     * @param sex sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * getter
     * 
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * setter
     * 
     * @param province province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * getter
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * setter
     * 
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * getter
     * 
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * setter
     * 
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * getter
     * 
     * @return headimgurl
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * setter
     * 
     * @param headimgurl headimgurl
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * getter
     * 
     * @return privilege
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * setter
     * 
     * @param privilege privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    /**
     * getter
     * 
     * @return unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * setter
     * 
     * @param unionid unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
