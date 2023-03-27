package cn.lnkdoc.sdk.uia.instance.yztoon.client;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.yztoon.property.YztoonProperty;
import io.vavr.Tuple;
import okhttp3.*;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class YztoonUiaClient implements IUiaClient {
    private static final Logger log = LoggerFactory.getLogger(YztoonUiaClient.class);
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    
    private YztoonProperty property;
    
    private YztoonUiaClient() {
    }

    public static YztoonUiaClient getInstance(YztoonProperty property) {
        YztoonUiaClient uiaClient = new YztoonUiaClient();
        uiaClient.property = property;

        checkMustRequired(property);

        return uiaClient;
    }
    
    /**
     * execute
     *
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    @Override
    public <RESP> IUiaResponse<RESP> execute(IUiaRequest request) throws UiaException {
        try {
            // send request
            String string = this.sendRequest(request);

            // match converter
            List<IUiaConverter> converters = request.getConvert();
            Assert.required(converters, "not found converter for [" + request.getClass().getName() + "]");

            // convert
            IUiaConverter converter = converters.get(0);
            RESP t = converter.convertResponse(Tuple.of(string, property));
            return UiaResponse.success(t);
        } catch (Exception e) {
            if (property.isPrintStack()) {
                log.error("", e);
            }
            return UiaResponse.fail(e.getMessage());
        }
    }

    private static void checkMustRequired(YztoonProperty property) {
        Assert.required(property, "the yztoonConfiguration is required");
        Assert.required(property.getDomain(), "the domain configuration is required");
        Assert.required(property.getClientId(), "the clientId configuration is required");
        Assert.required(property.getClientSecret(), "the clientSecret configuration is required");
        Assert.required(property.getRedirectUrl(), "the redirectUrl configuration is required");
    }

    @SuppressWarnings(value = {"Duplicates"})
    private String sendRequest(IUiaRequest request) {
        // build request url
        String url = request.url(property);

        String logMessage = String.format("[%s][%s]", request.method(), url);
        boolean success = false;
        String string = "";

        // build mediaType
        MediaType mediaType = MediaType.parse(ContentType.TEXT_PLAIN.getMimeType());

        // build requestBody
        RequestBody body = RequestBody.create("", mediaType);

        // build httpRequest
        Request httpRequest = new Request.Builder()
                .url(url)
                .method(request.method().getMethod(), HttpMethod.POST.equals(request.method()) ? body : null)
                .build();

        // call 
        try (Response response = client.newCall(httpRequest).execute()) {

            // fetch request
            ResponseBody responseBody = response.body();
            Assert.required(responseBody, "请求无响应内容：[" + url + "]");

            string = responseBody.string();
            success = true;
            
            return string;
        } catch (Exception e) {
            throw new UiaException(e);
        } finally {
            log.debug("{}[{}][{}]", logMessage, success, string);
        }
    }
}
