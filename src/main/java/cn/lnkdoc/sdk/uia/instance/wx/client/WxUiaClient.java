package cn.lnkdoc.sdk.uia.instance.wx.client;

import cn.lnkdoc.sdk.uia.common.client.IUiaClient;
import cn.lnkdoc.sdk.uia.common.convert.IUiaConverter;
import cn.lnkdoc.sdk.uia.common.exception.UiaException;
import cn.lnkdoc.sdk.uia.common.request.IUiaRequest;
import cn.lnkdoc.sdk.uia.common.response.IUiaResponse;
import cn.lnkdoc.sdk.uia.common.response.UiaResponse;
import cn.lnkdoc.sdk.uia.common.util.Assert;
import cn.lnkdoc.sdk.uia.instance.wx.property.WxProperty;
import cn.lnkdoc.sdk.uia.instance.wx.util.CheckResponseUtil;
import io.vavr.Tuple;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author langkye
 * @since 1.0.0.RELEASE
 */
@SuppressWarnings(value = {"Duplicates"})
public class WxUiaClient implements IUiaClient {
    private static final Logger log = LoggerFactory.getLogger(WxUiaClient.class);
    
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private WxProperty property;

    public static WxUiaClient getInstance(WxProperty property) {
        WxUiaClient client = new WxUiaClient();
        client.property = property;

        checkMustRequired(property);

        return client;
    }

    private WxUiaClient() {}


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
            
            // check success
            CheckResponseUtil.check(string);

            // convert 
            List<IUiaConverter> converts = request.getConvert();

            Assert.required(converts, "not found converter for [" + request.getClass().getSimpleName() + "]");
            
            IUiaConverter convert = converts.get(0);
            RESP resp = (RESP) convert.convertResponse(string);

            // check success
            return UiaResponse.success(resp);
        } catch (Exception e) {
            if (property.isPrintStack()) {
                log.error("", e);
            }
            return UiaResponse.fail(e.getMessage());
        }
    }

    private String sendRequest(IUiaRequest request) {
        // build request url
        String url = request.url(property);

        String logMessage = String.format("[%s][%s]", request.method(), url);
        boolean success = false;
        String string = "";

        IUiaConverter convert = request.getConvert().get(0);

        // build httpRequest
        Request httpRequest = convert.convertRequest(Tuple.of(property, client, request));

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

    private static void checkMustRequired(WxProperty property) {
        Assert.required(property, "the wxConfiguration is required");
        Assert.required(property.getDomain(), "the domain configuration is required");
        Assert.required(property.getClientId(), "the clientId configuration is required");
        Assert.required(property.getClientSecret(), "the clientSecret configuration is required");
    }
    
}
