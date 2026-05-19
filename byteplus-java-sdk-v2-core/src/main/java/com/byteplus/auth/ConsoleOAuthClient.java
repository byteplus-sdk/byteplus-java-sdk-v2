package com.byteplus.auth;

import com.byteplus.ApiException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Minimal HTTP client for the Byteplus Console OAuth token endpoint used by
 * the console-login credential flow.
 *
 * <p>Mirrors the protocol surface of the byteplus-cli {@code consolelogin}
 * command: this SDK side only needs the {@code refresh_token} grant — the
 * authorization-code + PKCE leg is performed exclusively by the CLI.
 *
 * <p>Uses {@link HttpURLConnection} for consistency with
 * {@link SsoPortalClient} and {@link EcsRoleCredentialProvider}.
 */
class ConsoleOAuthClient {

    static final String DEFAULT_ENDPOINT_URL = "https://signin.byteplus.com";
    static final String TOKEN_PATH = "/authorize/oauth/token";

    private static final int CONNECT_TIMEOUT_MS = 10_000;
    private static final int READ_TIMEOUT_MS = 30_000;
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_INTERVAL_MS = 1000;
    private static final String LOG_ID_HEADER = "X-Tt-Logid";
    private static final Set<Integer> RETRYABLE_STATUSES =
            new HashSet<>(Arrays.asList(408, 429, 500, 502, 503, 504));

    private final String endpointUrl;
    private final Gson gson = new Gson();

    ConsoleOAuthClient(String endpointUrl) {
        this.endpointUrl = (endpointUrl == null || endpointUrl.trim().isEmpty())
                ? DEFAULT_ENDPOINT_URL
                : trimTrailingSlash(endpointUrl.trim());
    }

    /**
     * Exchange a refresh token for a fresh console access token.
     */
    ConsoleTokenResponse refreshToken(String clientId, String refreshToken, String scope)
            throws ApiException {
        if (isNullOrEmpty(clientId)) {
            throw new ApiException("ConsoleOAuthClient: client_id is required for refresh");
        }
        if (isNullOrEmpty(refreshToken)) {
            throw new ApiException("ConsoleOAuthClient: refresh_token is required for refresh");
        }

        StringBuilder form = new StringBuilder();
        appendForm(form, "grant_type", "refresh_token");
        appendForm(form, "client_id", clientId);
        appendForm(form, "refresh_token", refreshToken);
        if (!isNullOrEmpty(scope)) {
            appendForm(form, "scope", scope);
        }

        String url = endpointUrl + TOKEN_PATH;
        String responseBody = doFormPostWithRetry(url, form.toString());

        ConsoleTokenResponse resp;
        try {
            resp = gson.fromJson(responseBody, ConsoleTokenResponse.class);
        } catch (Exception e) {
            throw new ApiException("ConsoleOAuthClient: failed to parse token response - " + e.getMessage());
        }
        if (resp == null || resp.accessToken == null || resp.accessToken.isJsonNull()) {
            throw new ApiException("ConsoleOAuthClient: token response did not contain access_token");
        }
        if (resp.expiresIn <= 0) {
            throw new ApiException("ConsoleOAuthClient: token response did not contain valid expires_in");
        }
        return resp;
    }

    // ---- HTTP helpers -------------------------------------------------------

    private String doFormPostWithRetry(String urlStr, String formBody) throws ApiException {
        ApiException lastException = null;
        for (int attempt = 0; attempt < MAX_RETRIES; attempt++) {
            try {
                return doFormPost(urlStr, formBody);
            } catch (RetryableException e) {
                lastException = new ApiException(e.getMessage());
                if (attempt < MAX_RETRIES - 1) {
                    trySleep();
                }
            } catch (ApiException e) {
                // Non-retryable error: fail immediately.
                throw e;
            }
        }
        throw lastException != null
                ? lastException
                : new ApiException("ConsoleOAuthClient: token request failed after " + MAX_RETRIES + " attempts");
    }

    private String doFormPost(String urlStr, String formBody) throws ApiException, RetryableException {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(CONNECT_TIMEOUT_MS);
            conn.setReadTimeout(READ_TIMEOUT_MS);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept", "application/json");

            byte[] payload = formBody.getBytes(StandardCharsets.UTF_8);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload);
            }

            int statusCode = conn.getResponseCode();
            String body = readResponseBody(conn, statusCode);
            if (statusCode / 100 != 2) {
                String logId = conn.getHeaderField(LOG_ID_HEADER);
                String msg = "ConsoleOAuthClient: token POST " + urlStr
                        + " failed with status " + statusCode
                        + (logId != null ? " (RequestId=" + logId + ")" : "")
                        + ": " + body;
                if (RETRYABLE_STATUSES.contains(statusCode)) {
                    throw new RetryableException(msg);
                }
                throw new ApiException(msg);
            }
            return body;
        } catch (RetryableException e) {
            throw e;
        } catch (ApiException e) {
            throw e;
        } catch (IOException e) {
            // Network-level failures are retryable.
            throw new RetryableException("ConsoleOAuthClient: token request failed - " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static String readResponseBody(HttpURLConnection conn, int statusCode) {
        try {
            java.io.InputStream is = (statusCode / 100 == 2)
                    ? conn.getInputStream()
                    : conn.getErrorStream();
            if (is == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                boolean first = true;
                while ((line = reader.readLine()) != null) {
                    if (!first) {
                        sb.append('\n');
                    }
                    sb.append(line);
                    first = false;
                }
            }
            return sb.toString();
        } catch (IOException e) {
            return "";
        }
    }

    private static void appendForm(StringBuilder sb, String key, String value) {
        if (sb.length() > 0) {
            sb.append('&');
        }
        sb.append(urlEncode(key)).append('=').append(urlEncode(value));
    }

    private static String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return value;
        }
    }

    private static String trimTrailingSlash(String s) {
        int end = s.length();
        while (end > 0 && s.charAt(end - 1) == '/') {
            end--;
        }
        return s.substring(0, end);
    }

    private static void trySleep() {
        try {
            Thread.sleep(RETRY_INTERVAL_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    /** Internal marker exception to drive the retry loop. */
    private static final class RetryableException extends Exception {
        private static final long serialVersionUID = 1L;

        RetryableException(String msg) {
            super(msg);
        }
    }

    // ---- DTO ---------------------------------------------------------------

    /**
     * Response body of {@code POST /authorize/oauth/token}.
     *
     * <p>{@code accessToken} is exposed as a raw {@link JsonElement} because
     * the upstream may serialize it as either a JSON object (containing STS
     * credentials) or a JSON-encoded string. Callers normalize before use.
     */
    static class ConsoleTokenResponse {
        @SerializedName("access_token")
        JsonElement accessToken;
        @SerializedName("token_type")
        String tokenType;
        @SerializedName("expires_in")
        long expiresIn;
        @SerializedName("refresh_token")
        String refreshToken;
        @SerializedName("scope")
        String scope;
        @SerializedName("id_token")
        String idToken;
    }
}
