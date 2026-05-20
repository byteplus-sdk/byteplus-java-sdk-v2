package com.byteplus.interceptor;

import com.byteplus.ApiException;
import com.byteplus.Pair;
import com.byteplus.ProgressRequestBody;
import com.byteplus.auth.CredentialProvider;
import com.byteplus.auth.CredentialValue;
import com.byteplus.sign.ByteplusSign;
import com.byteplus.sign.Credentials;
import com.byteplus.sign.ServiceInfo;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import okio.Buffer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class SignRequestInterceptor implements RequestInterceptor {

    public static String name = "volcengine-sign-request-interceptor";

    @Override
    public String name() {
        return name;
    }

    @Override
    public InterceptorContext intercept(InterceptorContext context) throws ApiException {
        String path = context.getRequestContext().getPath();
        String method = context.getRequestContext().getMethod();
        Map<String, String> headerParams = context.getRequestContext().getHeaderParams();
        List<Pair> queryParams = context.getRequestContext().getQueryParams();
        ServiceInfo serviceInfo = context.getRequestContext().getServiceInfo();
        String[] authNames = context.getRequestContext().getAuthNames();
        RequestBody reqBody = context.getRequestContext().getRequestBody();

        //sign
        ByteplusSign byteplusSign = new ByteplusSign();
        if (context.getApiClient().getCredentials() != null) {
            byteplusSign.setCredentials(context.getApiClient().getCredentials());
        } else {
            CredentialProvider credentialProvider = context.getApiClient().getCredentialProvider();
            if (credentialProvider == null) {
                // No explicit credentials or provider set — use default credential chain
                credentialProvider = new com.byteplus.auth.CredentialProvider(
                    com.byteplus.auth.DefaultCredentialProvider.create()
                );
                context.getApiClient().setCredentialProvider(credentialProvider);
            }
            CredentialValue credentialValue = credentialProvider.get();
            if (credentialValue == null) {
                throw new ApiException("credentialProvider return null");
            }
            Credentials credentials = Credentials.getCredentials(credentialValue.getAk(), credentialValue.getSk(), credentialValue.getSessionToken());
            byteplusSign.setCredentials(credentials);
        }
        byteplusSign.setRegion(context.getApiClient().getRegion());
        byteplusSign.setService(serviceInfo.getServiceName());
        byteplusSign.setMethod(serviceInfo.getMethod().toUpperCase());

        if (byteplusSign.getCredentials() == null) {
            throw new RuntimeException("Credentials must set when ApiClient init");
        }
        if (StringUtils.isEmpty(byteplusSign.getCredentials().getAccessKey()) || StringUtils.isEmpty(byteplusSign.getCredentials().getSecretKey())) {
            throw new RuntimeException("AccessKey and SecretKey must set when ApiClient init Credentials");
        }
        if (StringUtils.isEmpty(byteplusSign.getRegion())) {
            throw new RuntimeException("Region must set when ApiClient init");
        }

        // Presigned branch
        if (context.getRequestContext().isPresigned()) {
            Map<String, String> queryParamsMap = new HashMap<>();
            for (Pair p : queryParams) {
                queryParamsMap.put(p.getName(), p.getValue());
            }

            String host = context.getRequestContext().getHost();
            try {
                Map<String, String> presignedParams = byteplusSign.presign(queryParamsMap, host);
                String presignedUrl = buildPresignedUrl(context.getRequestContext().getSchema(), host, presignedParams);
                context.getRequestContext().setPresignedUrl(presignedUrl);
            } catch (Exception e) {
                throw new ApiException(e);
            }
            return context;
        }

        // Normal sign branch
        final Buffer buffer = new Buffer();
        try {
            if (reqBody != null) {
                reqBody.writeTo(buffer);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }
        byteplusSign.applyToParams(queryParams, headerParams, buffer.readUtf8());

        ProgressRequestBody.ProgressRequestListener progressRequestListener = context.getInitInterceptorContext().getProgressRequestListener();

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

        context.getRequestContext().setRequest(request);

        return context;
    }

    private static String buildPresignedUrl(String scheme, String host, Map<String, String> presignedParams) {
        StringBuilder url = new StringBuilder();
        if (StringUtils.isNotEmpty(scheme) && StringUtils.isNotEmpty(host)) {
            url.append(scheme).append("://").append(host).append("?");
        }

        List<String> keys = new ArrayList<>(presignedParams.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = presignedParams.get(key);
            try {
                url.append(key)
                   .append("=")
                   .append(URLEncoder.encode(value, "UTF-8").replace("+", "%20"));
            } catch (UnsupportedEncodingException e) {
                url.append(key).append("=").append(value);
            }
            if (i < keys.size() - 1) {
                url.append("&");
            }
        }

        return url.toString();
    }
}
