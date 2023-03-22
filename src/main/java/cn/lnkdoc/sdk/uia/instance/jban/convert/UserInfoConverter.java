package cn.lnkdoc.sdk.uia.instance.jban.convert;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.instance.jban.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.jban.request.JbanUserInfoRequest;
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse;
import cn.lnkdoc.sdk.uia.instance.jban.util.ApiUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.*;
import org.apache.http.entity.ContentType;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class UserInfoConverter implements IUiaConverter {
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
        JbanResponse<UserInfo> jbanResponse = JSON.parseObject(json, new TypeReference<JbanResponse<UserInfo>>(){});
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
        io.vavr.Tuple3<JbanProperty, OkHttpClient, JbanUserInfoRequest> tuple = (io.vavr.Tuple3<JbanProperty, OkHttpClient, JbanUserInfoRequest>) body;
        String appAccessToken = ApiUtil.getAppAccessToken(tuple._1, tuple._2);

        //请求头
        Headers headers = new Headers.Builder()
                .add("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .build();

        //请求体
        JSONObject reqBody = new JSONObject();
        reqBody.put("appAccessToken", appAccessToken);
        reqBody.put("code", tuple._3.getBody());

        //请求对象
        Request request = new Request.Builder()
                .url(tuple._3.getUrl())
                //.method(HttpMethod.POST.name(), null)
                .post(RequestBody.create(MediaType.parse("application/json"), reqBody.toJSONString()))
                .headers(headers)
                .build();
        
        return (T) request;
    }

    /**
     * converter name
     *
     * @return converter name
     */
    @Override
    public String name() {
        return JbanUserInfoRequest.class.getName();
    }
}
