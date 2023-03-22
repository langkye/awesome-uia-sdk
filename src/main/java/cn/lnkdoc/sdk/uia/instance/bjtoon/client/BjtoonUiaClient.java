package cn.lnkdoc.sdk.uia.instance.bjtoon.client;

import cn.lnkdoc.sdk.uia.common.HttpMethod;
import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.bjtoon.UiaConstants;
import cn.lnkdoc.sdk.uia.instance.bjtoon.property.BjtoonProperty;
import cn.lnkdoc.sdk.uia.instance.bjtoon.response.BjtoonResponse;
import io.vavr.Tuple;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
public class BjtoonUiaClient implements IUiaClient {
    private static final Logger log = LoggerFactory.getLogger(BjtoonUiaClient.class);
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private BjtoonProperty property;

    public static BjtoonUiaClient getInstance(BjtoonProperty property) {
        BjtoonUiaClient client = new BjtoonUiaClient();
        client.property = property;

        checkMustRequired(property);

        return client;
    }

    private BjtoonUiaClient() {
    }

    /**
     * execute
     *
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    @Override
    public <RESP> UiaResponse<RESP> execute(IUiaRequest request) throws UiaException {
        try {
            // send request
            String string = this.sendRequest(request);

            // convert
            // match converter
            IUiaConverter converter = request.getConvert()
                    .stream()
                    .filter(it -> it.name().equals(request.getClass().getName() + ""))
                    .findFirst()
                    .orElseThrow(() -> new UiaException("not found converter for [" + request.getClass().getName() + "]"));
            
            Assert.required(converter, "not found converter for [" + request.getClass().getName() + "]");

            BjtoonResponse<RESP> responseWrapper = converter.convertResponse(Tuple.of(string, property));

            RESP data = responseWrapper.getData();
            // check success
            boolean isSuccess = UiaConstants.RETURN_CODE_SUCCESS.getCode().equals(responseWrapper.getMeta().getCode())
                    && data != null;

            if (isSuccess) {
                return UiaResponse.success(data);
            } else {
                return UiaResponse.fail(responseWrapper.getMeta().getMessage());
            }
            
        } catch (Exception e) {
            log.error("[errorMessage:{}]", e.getMessage(), e);
            return UiaResponse.fail(e.getMessage());
        }
    }

    private String sendRequest(IUiaRequest request) {
        // match converter
        IUiaConverter converter = request.getConvert()
                .stream()
                .filter(it -> it.name().equals(request.getClass().getName()))
                .findFirst()
                .orElseThrow(() -> new UiaException("not found converter for [" + request.getClass().getName() + "]"));
        Assert.required(converter, "not found converter for [" + request.getClass().getName() + "]");

        // build request url
        String url = request.url(property);

        String logMessage = String.format("[%s][%s]", request.method(), url);
        log.debug(logMessage);

        RequestBody body = converter.convertRequest(Tuple.of(request, property));

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

            return responseBody.string();
        } catch (Exception e) {
            throw new UiaException(e);
        }
    }

    private static void checkMustRequired(BjtoonProperty property) {
        Assert.required(property, "the yztoonConfiguration is required");
        Assert.required(property.getDomain(), "the domain configuration is required");
        Assert.required(property.getClientId(), "the clientId configuration is required");
        Assert.required(property.getClientSecret(), "the clientSecret configuration is required");
        Assert.required(property.getRegisterPath(), "the registerPath configuration is required");
    }
}
