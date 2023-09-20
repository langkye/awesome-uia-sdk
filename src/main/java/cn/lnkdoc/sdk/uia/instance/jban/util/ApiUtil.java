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

    /**
     * getter
     * 
     * @param property property
     * @param client client
     * @return team_access_token
     */
    public static String getTeamAccessToken(JbanProperty property, OkHttpClient client) {
        String accessToken = getAppAccessToken(property, client);

        // build request url
        String url = String.join("", property.getDomain(), property.getTeamAccessTokenPath());

        String logMessage = String.format("[%s][%s]", HttpMethod.POST.getMethod(), url);
        boolean success = false;
        String string = "";

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

            string = responseBody.string();
            JbanResponse<TeamAccessToken> jbanResponse = JSONObject.parseObject(string, new TypeReference<JbanResponse<TeamAccessToken>>() {
            });

            success = true;
            boolean responseSuccess = Integer.valueOf("0").equals(jbanResponse.getCode());
            if (responseSuccess) {
                return jbanResponse.getData().getTeamAccessToken();
            }
            
            throw new UiaException(jbanResponse.getMsg());
        } catch (UiaException e) {
            throw e;
        } catch (Exception e) {
            throw new UiaException(e);
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string);
        }

    }

    /**
     * getter
     * 
     * @param property property
     * @param client client
     * @return app_access_token
     */
    public static String getAppAccessToken(JbanProperty property, OkHttpClient client) {
        // build request url
        String url = String.join("", property.getDomain(), property.getAppAccessTokenPath());

        String logMessage = String.format("[%s][%s]", HttpMethod.POST.getMethod(), url);
        boolean success = false;
        String string = "";

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

            string = responseBody.string();

            JbanResponse<AppAccessToken> jbanResponse = JSONObject.parseObject(string, new TypeReference<JbanResponse<AppAccessToken>>() {
            });

            success = true;
            boolean responseSuccess = Integer.valueOf("0").equals(jbanResponse.getCode());
            if (responseSuccess) {
                return jbanResponse.getData().getAppAccessToken();
            }

            throw new UiaException(jbanResponse.getMsg());
        } catch (UiaException e) {
            throw e;
        } catch (Exception e) {
            throw new UiaException(e);
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string);
        }
    }
}
