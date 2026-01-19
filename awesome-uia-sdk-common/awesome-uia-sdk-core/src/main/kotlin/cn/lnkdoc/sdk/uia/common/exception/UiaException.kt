package cn.lnkdoc.sdk.uia.common.exception

import java.io.Serializable


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UiaException : RuntimeException, Serializable {
    /**
     * code
     */
    var code = 401

    /**
     * message
     */
    override var message: String? = null

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.
     *
     *Note that the detail message associated with
     * `cause` is *not* automatically incorporated in
     * this runtime exception's detail message.
     *
     *
     * by the [.getMessage] method).
     * @param cause   the cause (which is saved for later retrieval by the
     * [.getCause] method).  (A  null  value is
     * permitted, and indicates that the cause is nonexistent or
     * unknown.)
     * @since 1.4
     */
    constructor(cause: Throwable) : super(cause) {
        message = cause.message
    }

    /**
     * Constructs a new runtime exception with `null` as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to [.initCause].
     * @param message message
     */
    constructor(message: String?) {
        this.message = message
    }

    /**
     * Constructs a new runtime exception with `null` as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to [.initCause].
     *
     * @param code code
     */
    constructor(code: Int) {
        this.code = code
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to [.initCause].
     *
     * @param code code
     * @param message the detail message. The detail message is saved for
     * later retrieval by the [.getMessage] method.
     */
    constructor(code: Int, message: String?) : super(message) {
        this.code = code
        this.message = message
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}

