package com.byteplus.auth;

import com.byteplus.ApiException;

public interface Provider {
    public boolean isExpired();

    public void refresh() throws ApiException;

    public CredentialValue retrieve() throws ApiException;
}
