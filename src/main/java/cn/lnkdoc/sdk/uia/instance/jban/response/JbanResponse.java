package cn.lnkdoc.sdk.uia.instance.jban.response;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class JbanResponse<T> {
    /**
     * msg
     */
    private String msg;
    /**
     * code
     */
    private int code;
    /**
     * data
     */
    private T data;

    /**
     * getter
     * 
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * setter
     * 
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * getter
     * 
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * setter
     * 
     * @param code code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * data
     * 
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * setter
     * 
     * @param data data
     */
    public void setData(T data) {
        this.data = data;
    }
}
