package cn.lnkdoc.sdk.uia.instance.jban.convert;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.jban.domain.MobileInfo;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanMobileMd5UserRequest;
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse;
import cn.lnkdoc.sdk.uia.instance.jban.util.ApiUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.*;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class MobileConverter implements IUiaConverter {
    /**
     * convert response
     *
     * @param body response
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertResponse(R body) {
        String json = (String) body;
        JbanResponse<MobileInfo> jbanResponse = JSON.parseObject(json, new TypeReference<JbanResponse<MobileInfo>>(){});
        if (Integer.valueOf("0").equals(jbanResponse.getCode())) {
            return (T) jbanResponse.getData();
        }
        throw new UiaException(jbanResponse.getMsg());
    }

    /**
     * convert body
     *
     * @param body body
     * @return response converted result
     */
    @SuppressWarnings("ALL")
    @Override
    public <T, R> T convertRequest(R body) {
        io.vavr.Tuple3<JbanProperty, OkHttpClient, JbanMobileMd5UserRequest> tuple = (io.vavr.Tuple3<JbanProperty, OkHttpClient, JbanMobileMd5UserRequest>) body;
        String teamAccessToken = ApiUtil.getTeamAccessToken(tuple._1, tuple._2);
        
        // build header
        Headers headers = new Headers.Builder()
                .add("Authorization", "Bearer " + teamAccessToken)
                .build();

        // build mediaType
        MediaType mediaType = MediaType.parse("text/plain");
        
        // build httpRequest
        Request httpRequest = new Request.Builder()
                .url(tuple._3.getUrl())
                .method(HttpMethod.GET.getMethod(), null)
                .headers(headers)
                .build();
        return (T) httpRequest;
    }

    /**
     * converter name
     *
     * @return converter name
     */
    @Override
    public String name() {
        return JbanMobileMd5UserRequest.class.getName();
    }
}
