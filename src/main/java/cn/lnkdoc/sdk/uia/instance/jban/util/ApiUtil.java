package cn.lnkdoc.sdk.uia.instance.jban.util;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.jban.domain.AppAccessToken;
import cn.lnkdoc.sdk.uia.instance.jban.domain.TeamAccessToken;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import cn.lnkdoc.sdk.uia.instance.jban.response.JbanResponse;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import okhttp3.*;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"Duplicates"})
public class ApiUtil {
    private static final Logger log = LoggerFactory.getLogger(ApiUtil.class);
    
    public static String getTeamAccessToken(JbanProperty property, OkHttpClient client) {
        String accessToken = getAppAccessToken(property, client);

        // build request url
        String url = String.join("", property.getDomain(), property.getTeamAccessTokenPath());

        String logMessage = String.format("[%s][%s]", HttpMethod.POST.getMethod(), url);
        log.debug(logMessage);

        // build mediaType
        MediaType mediaType = MediaType.parse(ContentType.APPLICATION_JSON.getMimeType());

        //body
        JSONObject reqBody = new JSONObject();
        reqBody.put("appAccessToken", accessToken);
        reqBody.put("openTeamId", property.getOpenTeamId());

        // build requestBody
        RequestBody body = RequestBody.create(reqBody.toJSONString(), mediaType);

        // build httpRequest
        Request httpRequest = new Request.Builder()
                .url(url)
                .method(HttpMethod.POST.getMethod(), body)
                .build();

        // call 
        try (Response response = client.newCall(httpRequest).execute()) {

            // fetch request
            ResponseBody responseBody = response.body();
            Assert.required(responseBody, "请求无响应内容：[" + url + "]");

            JbanResponse<TeamAccessToken> jbanResponse = JSONObject.parseObject(responseBody.string(), new TypeReference<JbanResponse<TeamAccessToken>>() {
            });

            boolean success = Integer.valueOf("0").equals(jbanResponse.getCode());
            if (success) {
                return jbanResponse.getData().getTeamAccessToken();
            }
            
            throw new UiaException(jbanResponse.getMsg());
        } catch (UiaException e) {
            throw e;
        } catch (Exception e) {
            log.error(logMessage + "[errorMessage:{}]", e.getMessage());
            throw new UiaException(e);
        }

    }

    public static String getAppAccessToken(JbanProperty property, OkHttpClient client) {
        // build request url
        String url = String.join("", property.getDomain(), property.getAppAccessTokenPath());

        String logMessage = String.format("[%s][%s]", HttpMethod.POST.getMethod(), url);
        log.debug(logMessage);

        // build mediaType
        MediaType mediaType = MediaType.parse(ContentType.APPLICATION_JSON.getMimeType());


        //body
        JSONObject reqBody = new JSONObject();
        reqBody.put("appKey", property.getClientId());
        reqBody.put("appSecret", property.getClientSecret());

        // build requestBody
        RequestBody body = RequestBody.create(reqBody.toJSONString(), mediaType);

        // build httpRequest
        Request httpRequest = new Request.Builder()
                .url(url)
                .method(HttpMethod.POST.getMethod(), body)
                .build();

        // call 
        try (Response response = client.newCall(httpRequest).execute()) {

            // fetch request
            ResponseBody responseBody = response.body();
            Assert.required(responseBody, "请求无响应内容：[" + url + "]");

            JbanResponse<AppAccessToken> jbanResponse = JSONObject.parseObject(responseBody.string(), new TypeReference<JbanResponse<AppAccessToken>>() {
            });

            boolean success = Integer.valueOf("0").equals(jbanResponse.getCode());
            if (success) {
                return jbanResponse.getData().getAppAccessToken();
            }

            throw new UiaException(jbanResponse.getMsg());
        } catch (UiaException e) {
            throw e;
        } catch (Exception e) {
            log.error(logMessage + "[errorMessage:{}]", e.getMessage());
            throw new UiaException(e);
        }
    }
}
