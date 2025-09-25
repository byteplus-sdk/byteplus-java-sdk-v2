package com.byteplus.retryer;

import com.byteplus.ApiException;
import com.byteplus.ApiResponse;

import java.util.Set;

public abstract class RetryCondition {
    protected Set<String> retryErrorCodes;

    public abstract boolean shouldRetry(ApiResponse response, ApiException apiException);

    public Set<String> getRetryErrorCodes() {
        return retryErrorCodes;
    }

    public void setRetryErrorCodes(Set<String> retryErrorCodes) {
        this.retryErrorCodes = retryErrorCodes;
    }

    public void addRetryErrorCode(String retryErrorCode) {
        this.retryErrorCodes.add(retryErrorCode);
    }

    public void addRetryErrorCodes(Set<String> retryErrorCodes) {
        this.retryErrorCodes.addAll(retryErrorCodes);
    }

}
