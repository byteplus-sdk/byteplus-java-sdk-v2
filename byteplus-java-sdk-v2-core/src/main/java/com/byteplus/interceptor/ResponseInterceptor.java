package com.byteplus.interceptor;

import com.byteplus.ApiException;

public interface ResponseInterceptor {
    String name();
    InterceptorContext intercept(InterceptorContext context) throws ApiException;
}