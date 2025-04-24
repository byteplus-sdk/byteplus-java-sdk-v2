package com.byteplus.interceptor;

import com.byteplus.ApiException;

public class BuildRequestInterceptor implements RequestInterceptor {

    public final static String name = "volcengine-build-request-interceptor";

    @Override
    public String name() {
        return name;
    }

    @Override
    public InterceptorContext intercept(InterceptorContext context) throws ApiException {
        context.buildRequest();
        return context;
    }


}
