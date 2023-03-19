package cn.lnkdoc.sdk.uia.common.convert;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public interface IUiaConverter {
    /**
     * convert body 
     * 
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    <T, R> T convertRequest(R body);
    
    /**
     * convert body 
     * 
     * @param body body
     * @param <R> type
     * @param <T> type
     * @return response converted result
     */
    <T, R> T convertResponse(R body);

    /**
     * converter name
     * 
     * @return converter name
     */
    String name();
}
