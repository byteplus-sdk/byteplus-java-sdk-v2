package com.byteplus.interceptor;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.byteplus.ApiException;
import com.byteplus.Pair;
import com.byteplus.ProgressRequestBody;
import com.byteplus.auth.CredentialProvider;
import com.byteplus.auth.CredentialValue;
import com.byteplus.sign.Credentials;
import com.byteplus.sign.ServiceInfo;
import com.byteplus.sign.ByteplusSign;
import okio.Buffer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SignRequestInterceptor implements RequestInterceptor {

    public static String name = "volcengine-sign-request-interceptor";

    @Override
    public String name() {
        return name;
    }

    @Override
    public InterceptorContext intercept(InterceptorContext context) throws ApiException {
        String path = context.getRequestContext().getPath();
        String method=context.getRequestContext().getMethod();
        Map<String, String> headerParams = context.getRequestContext().getHeaderParams();
        List<Pair> queryParams = context.getRequestContext().getQueryParams();
        ServiceInfo serviceInfo = context.getRequestContext().getServiceInfo();
        String[] authNames = context.getRequestContext().getAuthNames();
        RequestBody reqBody = context.getRequestContext().getRequestBody();
        ProgressRequestBody.ProgressRequestListener progressRequestListener = context.getInitInterceptorContext().getProgressRequestListener();

        //sign
        final Buffer buffer = new Buffer();
        try {
            if (reqBody != null) {
                reqBody.writeTo(buffer);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }
        ByteplusSign volcengineSign = new ByteplusSign();
        if (context.getApiClient().getCredentials() != null) {
            volcengineSign.setCredentials(context.getApiClient().getCredentials());
        } else {
            CredentialProvider credentialProvider = context.getApiClient().getCredentialProvider();
            if (credentialProvider == null) {
                throw new ApiException("one of credentials and credentialProvider must set");
            }
            CredentialValue credentialValue = credentialProvider.get();
            if (credentialValue == null) {
                throw new ApiException("credentialProvider return null");
            }
            Credentials credentials = Credentials.getCredentials(credentialValue.getAk(), credentialValue.getSk(), credentialValue.getSessionToken());
            volcengineSign.setCredentials(credentials);
        }
        volcengineSign.setRegion(context.getApiClient().getRegion());
        volcengineSign.setService(serviceInfo.getServiceName());
        volcengineSign.setMethod(serviceInfo.getMethod().toUpperCase());

        if (volcengineSign.getCredentials() == null) {
            throw new RuntimeException("Credentials must set when ApiClient init");
        }
        if (StringUtils.isEmpty(volcengineSign.getCredentials().getAccessKey()) || StringUtils.isEmpty(volcengineSign.getCredentials().getSecretKey())) {
            throw new RuntimeException("AccessKey and SecretKey must set when ApiClient init Credentials");
        }
        if (StringUtils.isEmpty(volcengineSign.getRegion())) {
            throw new RuntimeException("Region must set when ApiClient init");
        }
        volcengineSign.applyToParams(queryParams, headerParams, buffer.readUtf8());

        //build final call
        StringBuilder url = new StringBuilder();
        url.append(context.getRequestContext().getSchema());
        url.append("://");
        url.append(context.getRequestContext().getHost());
        url.append(path);
        context.getApiClient().buildQueryParams(path, url, queryParams);

        final Request.Builder reqBuilder = new Request.Builder().url(url.toString());

        for (Map.Entry<String, String> param : headerParams.entrySet()) {
            reqBuilder.header(param.getKey(), context.getApiClient().parameterToString(param.getValue()));
        }
        //构建最终的请求Request
        Request request = null;

        if (progressRequestListener != null && reqBody != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(reqBody, progressRequestListener);
            request = reqBuilder.method(method, progressRequestBody).build();
        } else {
            request = reqBuilder.method(method, reqBody).build();
        }
        Call call = context.getApiClient().getHttpClient().newCall(request);
        context.getRequestContext().setCall(call);

        return context;
    }
}
