package cn.lnkdoc.sdk.uia.common.response

import java.io.Serializable


/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@Suppress("unused")
class UiaResponse<T> : IUiaResponse<T>, Serializable {
    /**
     * data
     */
    var data: T? = null
    /**
     * success
     */
    var isSuccess = false

    /**
     * message
     */
    var message: String? = null

    val isFailed: Boolean
        /**
         * getter
         *
         * @return failed
         */
        get() = !isSuccess

    companion object {
        /**
         * success
         *
         * @param data data
         * @return response
         * @param <T> type
         */
        @JvmStatic
        fun <T> success(data: T): UiaResponse<T> {
            val response: UiaResponse<T> = UiaResponse()
            response.data =data
            response.isSuccess = true
            return response
        }

        /**
         * fail
         *
         * @param data data
         * @return response
         * @param <T> type
         */
        @JvmStatic
        fun <T> fail(data: T): UiaResponse<T> {
            val response: UiaResponse<T> = UiaResponse()
            response.data = data
            response.isSuccess = false
            return response
        }

        /**
         * fail
         *
         * @param message message
         * @return response
         * @param <T> type
         */
        @JvmStatic
        fun <T> fail(message : String? = "unknown"): UiaResponse<T> {
            val response: UiaResponse<T> = UiaResponse()
            response.message = message
            return response
        }
    }
}

