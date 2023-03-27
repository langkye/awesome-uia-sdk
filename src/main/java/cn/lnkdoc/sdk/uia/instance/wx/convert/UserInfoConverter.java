package cn.lnkdoc.sdk.uia.instance.wx.convert;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.instance.wx.domain.UserInfo;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;
import cn.lnkdoc.sdk.uia.instance.wx.request.UserInfoRequest;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
    @SuppressWarnings("all")
    @Override
    public <T, R> T convertResponse(R body) {
        String json = (String) body;

        UserInfo accessToken = (UserInfo) JSON.parseObject(json, new TypeReference<UserInfo>() {
        });

        return (T) accessToken;
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
        io.vavr.Tuple3<WxProperty, OkHttpClient, UserInfoRequest> tuple = (io.vavr.Tuple3<WxProperty, OkHttpClient, UserInfoRequest>) body;

        //请求头
        Headers headers = new Headers.Builder()
                .add("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .build();

        //请求体
        JSONObject reqBody = new JSONObject();

        //请求对象
        Request request = new Request.Builder()
                .url(tuple._3.url(tuple._1))
                .get()
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
        return UserInfoRequest.class.getName();
    }
}
