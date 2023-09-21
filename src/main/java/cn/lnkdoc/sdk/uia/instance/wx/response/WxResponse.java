package cn.lnkdoc.sdk.uia.instance.wx.response;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class WxResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * errcode
     */
    private Integer errcode;
    /**
     * errmsg
     */
    private String errmsg;
    /**
     * rid
     */
    private String rid;

    /**
     * getter
     * 
     * @return errcode
     */
    public Integer getErrcode() {
        return errcode;
    }

    /**
     * setter
     * 
     * @param errcode errcode
     */
    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    /**
     * getter
     * 
     * @return errmsg
     */
    public String getErrmsg() {
        return errmsg;
    }

    /**
     * setter
     * 
     * @param errmsg errmsg
     */
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * getter
     * 
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * setter
     * 
     * @param rid rid
     */
    public void setRid(String rid) {
        this.rid = rid;
    }
}
