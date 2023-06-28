package cn.lnkdoc.sdk.uia.instance.yztoon.convert;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import cn.lnkdoc.sdk.uia.instance.yztoon.request.LogoutRequest;
import io.vavr.Tuple2;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class LogoutConverter implements IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertResponse(R body) {
        Tuple2<String, YztoonProperty> tuple = ((Tuple2<String, YztoonProperty>) body);
        String string = tuple._1; 
        return (T) string;
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    @Override
    public <T, R> T convertRequest(R body) {
        throw new UiaException("TODO");
    }

    /**
     * converter name
     *
     * @return converter name
     */
    @Override
    public String name() {
        return LogoutRequest.class.getName();
    }
}
