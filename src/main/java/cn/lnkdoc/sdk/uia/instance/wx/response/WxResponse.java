package cn.lnkdoc.sdk.uia.instance.wx.response;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class WxResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer errcode;
    private String errmsg;
    private String rid;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
