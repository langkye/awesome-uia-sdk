package cn.lnkdoc.sdk.uia.common.response;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"unused"})
public class UiaResponse<T> implements IUiaResponse<T>, Serializable {
    /**
     * data
     */
    private T data;
    /**
     * success
     */
    private boolean success;
    /**
     * message
     */
    private String message;

    /**
     * success
     * 
     * @param data data
     * @return response
     * @param <T> type
     */
    public static <T> UiaResponse<T> success(T data) {
        UiaResponse<T> response = new UiaResponse<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    /**
     * fail
     * 
     * @param data data
     * @return response
     * @param <T> type
     */
    public static <T> UiaResponse<T> fail(T data) {
        UiaResponse<T> response = new UiaResponse<>();
        response.setData(data);
        response.setSuccess(false);
        return response;
    }

    /**
     * fail
     * 
     * @param message message
     * @return response
     * @param <T> type
     */
    public static <T> UiaResponse<T> fail(String message) {
        UiaResponse<T> response = new UiaResponse<>();
        response.setMessage(message);
        return response;
    }

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
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * getter
     * 
     * @return failed
     */
    public boolean isFailed() {
        return !isSuccess();
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

    /**
     * setter
     * 
     * @param success success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
