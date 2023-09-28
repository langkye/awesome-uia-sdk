package cn.lnkdoc.sdk.uia.instance

import cn.lnkdoc.sdk.uia.common.response.UiaResponse

/**
 *
 *
 * @author langkye
 * @since 1.0.0.RELEASE
 */
interface ISdkInstance {
    /**
     * get accessToken
     *
     * @param r code
     * @param <R> type
     * @param <T> type
     * @return accessToken
     */
    fun <T, R> getAccessToken(r: R): UiaResponse<T>

    /**
     * get UserInfo
     *
     * @param accessToken accessToken
     * @param <R> type
     * @param <T> type
     * @return UserInfo
     */
    fun <T, R> getUserInfo(accessToken: R): UiaResponse<T>

    /**
     * extra
     *
     * @param request request
     * @param <R> type
     * @param <T> type
     * @return extra'info
     */
    fun <T, R> execute(request: R): UiaResponse<T>
}