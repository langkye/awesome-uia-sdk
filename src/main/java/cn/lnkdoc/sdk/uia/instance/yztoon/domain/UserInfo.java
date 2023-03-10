package cn.lnkdoc.sdk.uia.instance.yztoon.domain;

import cn.lnkdoc.sdk.uia.common.util.CaseFormat;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 一证通用户信息。
 * M：必填
 * C：条件必填
 * O：非必填
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class UserInfo implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserInfo.class);
    
    /**
     * M
     * 用户唯一标识
     */
    private String uid;
    /**
     * M
     * 单位名称
     */
    private String cn;
    /**
     * M
     * 组织机构代码
     */
    private String idCardNumber;
    /**
     * M
     * 账号类型
     * Credence_002 表示用户名口令账号、
     * Credence_001 表示证书或电子营业执照用户（其中 uid 以 EBL@开头为电子营业执照登录，其他为证书登录）
     */
    private String credenceClass;
    /**
     * M
     * 账号等级:账号等级从低到高为：L1、 L2、L3
     */
    private String trustLevel;
    /**
     * O
     * 被授权的事项及相关的说明
     */
    private String instruction;
    /**
     * tokenId
     */
    private String tokenId;

    /**
     * 扩展信息:
     * 必填字段：
     * UNION_CODE：统一社会信用代码
     * BLR_NAME：办理人姓名
     * BLR_CARDID：办理人身份证号
     * BLR_MOBILE：办理人手机（经办人手机号码，电子营 业执照登录用户无手机号）
     * BLR_EMAIL：办理人邮箱
     */
    private List<String> extProperties ;

    /**
     * 扩展信息中
     */
    private UserExtInfo extInfo;
    private boolean isParse = false;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getCredenceClass() {
        return credenceClass;
    }

    public void setCredenceClass(String credenceClass) {
        this.credenceClass = credenceClass;
    }

    public String getTrustLevel() {
        return trustLevel;
    }

    public void setTrustLevel(String trustLevel) {
        this.trustLevel = trustLevel;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public List<String> getExtProperties() {
        return extProperties;
    }

    public void setExtProperties(List<String> extProperties) {
        this.extProperties = extProperties;
        parseExtInfo();
    }

    public boolean isParse() {
        return isParse;
    }

    public void setParse(boolean parse) {
        isParse = parse;
    }

    public void parseExtInfo() {
        getExtInfo();
    }

    @SuppressWarnings("ALL")
    public UserExtInfo getExtInfo() {
        if (isParse) {
            return extInfo;
        }
        if (CollectionUtils.isNotEmpty(this.extProperties)) {
            final HashMap<String, String> map = new HashMap<>();
            for (String extProperty : extProperties) {
                if (StringUtils.isNotBlank(extProperty)) {
                    if (extProperty.contains("=")) {
                        String[] kv = extProperty.split("=");
                        String k = null;
                        try {
                            k = kv[0];
                        } catch (Exception e) {
                            logger.error("",e);
                        }

                        String v = null;
                        try {
                            v = kv[1];
                            if (v == null || "null".equals(v)) {
                                v = null;
                            }
                        } catch (Exception e) {
                            logger.error("",e);
                        }

                        map.put(
                                //k
                                CaseFormat.UPPER_UNDERSCORE_2_LOWER_CAMEL(k)
                                , v);
                    } else {
                        logger.warn("拓展信息不是以'='分割：{}", extProperty);
                    }
                }
            }

            if (MapUtils.isNotEmpty(map)) {
                try {
                    String string = JSONObject.toJSONString(map);
                    extInfo = JSONObject.parseObject(string, UserExtInfo.class);
                    isParse = true;
                } catch (Exception e) {
                    logger.error("",e);
                }
            }
        }
        if (extInfo == null) {
            extInfo = new UserExtInfo();
        }
        return extInfo;
    }

    public void setExtInfo(UserExtInfo extInfo) {
        this.extInfo = extInfo;
    }
}
