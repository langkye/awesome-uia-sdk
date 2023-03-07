package cn.lnkdoc.sdk.uia.common.response;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class UiaResponse<T> implements IUiaResponse<T>, Serializable {
    private T data;
    private boolean isSuccess;
    private String message;

    public static <T> UiaResponse<T> success(T data) {
        UiaResponse<T> response = new UiaResponse<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static <T> UiaResponse<T> fail(T data) {
        UiaResponse<T> response = new UiaResponse<>();
        response.setData(data);
        response.setSuccess(false);
        return response;
    }

    public static <T> UiaResponse<T> fail(String message) {
        UiaResponse<T> response = new UiaResponse<>();
        response.setMessage(message);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
