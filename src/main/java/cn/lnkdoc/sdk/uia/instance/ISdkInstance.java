package cn.lnkdoc.sdk.uia.instance;

import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public interface ISdkInstance {
    /**
     * get accessToken
     *
     * @param r code
     * @param <R> type
     * @param <T> type
     * @return accessToken
     */
    <T,R> UiaResponse<T> getAccessToken(R r);

    /**
     * get UserInfo
     *
     * @param accessToken accessToken
     * @param <R> type
     * @param <T> type
     * @return UserInfo
     */
    <T, R> UiaResponse<T> getUserInfo(R accessToken);

    /**
     * extra
     *
     * @param request request
     * @param <R> type
     * @param <T> type
     * @return extra'info
     */
    default <T, R> UiaResponse<T> execute(R request) {
        throw new UiaException("TODO");
    }
}
