package cn.lnkdoc.sdk.uia.common.convert

/**
 *
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
interface IUiaConverter {
    /**
     * convert body
     *
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    fun <T, R> convertRequest(body: R): T

    /**
     * convert body
     *
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    fun <T, R> convertResponse(body: R): T

    /**
     * converter name
     *
     * @return converter name
     */
    fun name(): String
}