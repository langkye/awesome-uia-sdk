package cn.lnkdoc.sdk.uia.instance.wx.convert;

import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.instance.wx.domain.AccessToken;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;
import cn.lnkdoc.sdk.uia.instance.wx.request.AccessTokenRequest;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.*;
import org.apache.http.entity.ContentType;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class AccessTokenConverter implements IUiaConverter {
    
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
        
        AccessToken accessToken = (AccessToken) JSON.parseObject(json, new TypeReference<AccessToken>() {
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
        io.vavr.Tuple3<WxProperty, OkHttpClient, AccessTokenRequest> tuple = (io.vavr.Tuple3<WxProperty, OkHttpClient, AccessTokenRequest>) body;

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
        return AccessTokenRequest.class.getName();
    }
}
