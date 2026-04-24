package com.byteplus.auth;

import com.byteplus.ApiException;

public class EnvironmentVariableCredentialProvider implements Provider {

    private static final String PROVIDER_NAME = "EnvironmentVariableCredentialProvider";

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void refresh() throws ApiException {
        // No-op: environment variable credentials do not expire.
    }

    @Override
    public CredentialValue retrieve() throws ApiException {
        String ak = getEnvWithFallback("BYTEPLUS_ACCESS_KEY");
        String sk = getEnvWithFallback("BYTEPLUS_SECRET_KEY");
        String token = getEnvWithFallback("BYTEPLUS_SESSION_TOKEN");

        if (isNullOrEmpty(ak) || isNullOrEmpty(sk)) {
            throw new ApiException(PROVIDER_NAME + ": required environment variables BYTEPLUS_ACCESS_KEY and "
                    + "BYTEPLUS_SECRET_KEY are not set");
        }

        return new CredentialValue(ak, sk, token, PROVIDER_NAME);
    }

    private static String getEnvWithFallback(String... names) {
        for (String name : names) {
            String value = System.getenv(name);
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        return null;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
