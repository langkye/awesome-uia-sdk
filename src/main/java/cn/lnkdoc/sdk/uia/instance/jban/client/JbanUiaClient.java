package cn.lnkdoc.sdk.uia.instance.jban.client;

import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.jban.property.JbanProperty;
import io.vavr.Tuple;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"Duplicates"})
public class JbanUiaClient implements IUiaClient {
    private static final Logger log = LoggerFactory.getLogger(JbanUiaClient.class);
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private JbanProperty property;

    public static JbanUiaClient getInstance(JbanProperty property) {
        JbanUiaClient client = new JbanUiaClient();
        client.property = property;

        checkMustRequired(property);

        return client;
    }

    private JbanUiaClient() {
    }
    
    /**
     * execute
     *
     * @param request request implementation
     * @return response implementation`
     * @throws UiaException UiaException
     */
    @SuppressWarnings({"unchecked", "rawtypes", "all"})
    @Override
    public <RESP> IUiaResponse<RESP> execute(IUiaRequest request) throws UiaException {
        try {
            // send request
            String string = this.sendRequest(request);

            // convert 
            List<IUiaConverter> converts = request.getConvert();

            Assert.required(converts, "not found converter for [" + request.getClass().getName() + "]");

            IUiaConverter convert = converts.get(0);
            RESP resp = (RESP) convert.convertResponse(string);

            // check success
            return UiaResponse.success(resp);
        } catch (UiaException e) {
            return UiaResponse.fail(e.getMessage());
        } catch (Exception e) {
            return UiaResponse.fail(e.getMessage());
        }
    }

    private String sendRequest(IUiaRequest request) {
        // build request url
        String url = request.url(property);
        
        String logMessage = String.format("[%s][%s]", request.method(), url);
        log.debug(logMessage);

        IUiaConverter convert = request.getConvert().get(0);

        // build httpRequest
        Request httpRequest = convert.convertRequest(Tuple.of(property, client, request));

        // call 
        try (Response response = client.newCall(httpRequest).execute()) {

            // fetch request
            ResponseBody responseBody = response.body();
            Assert.required(responseBody, "请求无响应内容：[" + url + "]");

            return responseBody.string();
        } catch (Exception e) {
            log.error(logMessage + "[errorMessage:{}]", e.getMessage());
            throw new UiaException(e);
        }
    }

    private static void checkMustRequired(JbanProperty property) {
        Assert.required(property, "the yztoonConfiguration is required");
        Assert.required(property.getDomain(), "the domain configuration is required");
        Assert.required(property.getClientId(), "the clientId configuration is required");
        Assert.required(property.getClientSecret(), "the clientSecret configuration is required");
        Assert.required(property.getOpenTeamId(), "the redirectUrl configuration is required");
    }
}
