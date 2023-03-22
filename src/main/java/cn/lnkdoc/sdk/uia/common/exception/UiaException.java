package cn.lnkdoc.sdk.uia.common.exception;

import java.io.Serializable;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class UiaException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = 401;
    private String message;

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     * <p>
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public UiaException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     * @param message message
     */
    public UiaException(String message) {
        this.message = message;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     * 
     * @param code code
     */
    public UiaException(int code) {
        this.code = code;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param code code
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UiaException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @SuppressWarnings(value = {"unused"})
    public void setMessage(String message) {
        this.message = message;
    }
}
