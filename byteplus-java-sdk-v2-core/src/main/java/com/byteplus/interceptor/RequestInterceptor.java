package com.byteplus.interceptor;

import com.byteplus.ApiException;

public interface RequestInterceptor {
    String name();
    InterceptorContext intercept(InterceptorContext context) throws ApiException;
}