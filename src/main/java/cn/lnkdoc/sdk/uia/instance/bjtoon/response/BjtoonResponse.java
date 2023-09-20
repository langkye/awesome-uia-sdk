package cn.lnkdoc.sdk.uia.instance.bjtoon.response;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class BjtoonResponse<T> {
    private T data;
    private Meta meta;

    /**
     * getter
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

    /**
     * getter
     * 
     * @return meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * setter
     * 
     * @param meta meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * Meta class
     */
    public static class Meta {
        private Integer code;
        private String message;

        /**
         * getter
         * 
         * @return code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * setter
         * 
         * @param code code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * getter
         * 
         * @return message
         */
        public String getMessage() {
            return message;
        }

        /**
         * setter
         * 
         * @param message message
         */
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
