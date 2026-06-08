package com.byteplus.auth;

import com.byteplus.ApiException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Minimal OAuth client for the BytePlus signin {@code /authorize/oauth/token}
 * endpoint. Only the {@code refresh_token} grant is implemented because the SDK
 * never participates in interactive authorization flows.
 */
class ConsoleOAuthClient {

    static final String DEFAULT_ENDPOINT_URL = "https://signin.byteplus.com";
    static final String TOKEN_PATH = "/authorize/oauth/token";

    private static final int CONNECT_TIMEOUT_MS = 10_000;
    private static final int READ_TIMEOUT_MS = 30_000;

    private final String endpointBase;

    ConsoleOAuthClient(String endpointBase) {
        if (endpointBase == null || endpointBase.trim().isEmpty()) {
            this.endpointBase = DEFAULT_ENDPOINT_URL;
        } else {
            String trimmed = endpointBase.trim();
            while (trimmed.endsWith("/")) {
                trimmed = trimmed.substring(0, trimmed.length() - 1);
            }
            this.endpointBase = trimmed;
        }
    }

    ConsoleTokenResponse refreshToken(String clientId, String scope, String refreshToken)
            throws ApiException, InvalidGrantException {
        if (clientId == null || clientId.trim().isEmpty()) {
            throw new ApiException("ConsoleOAuthClient: client_id is required");
        }
        if (refreshToken == null || refreshToken.trim().isEmpty()) {
            throw new ApiException("ConsoleOAuthClient: refresh_token is required");
        }

        StringBuilder form = new StringBuilder();
        appendForm(form, "grant_type", "refresh_token");
        appendForm(form, "client_id", clientId);
        appendForm(form, "refresh_token", refreshToken);
        if (scope != null && !scope.trim().isEmpty()) {
            appendForm(form, "scope", scope);
        }
        byte[] body = form.toString().getBytes(StandardCharsets.UTF_8);

        String url = endpointBase + TOKEN_PATH;
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(CONNECT_TIMEOUT_MS);
            conn.setReadTimeout(READ_TIMEOUT_MS);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(body);
            }

            int code = conn.getResponseCode();
            String respBody = readBody(conn, code);
            if (code / 100 == 2) {
                ConsoleTokenResponse parsed;
                try {
                    parsed = new Gson().fromJson(respBody, ConsoleTokenResponse.class);
                } catch (Exception e) {
                    throw new ApiException("ConsoleOAuthClient: failed to parse token response - " + e.getMessage());
                }
                if (parsed == null || parsed.accessToken == null || parsed.accessToken.isEmpty()) {
                    throw new ApiException("ConsoleOAuthClient: refresh response missing access_token");
                }
                if (parsed.expiresIn <= 0) {
                    throw new ApiException("ConsoleOAuthClient: refresh response missing valid expires_in");
                }
                return parsed;
            }

            String errCode = "";
            try {
                JsonObject obj = new JsonParser().parse(respBody).getAsJsonObject();
                if (obj.has("error") && !obj.get("error").isJsonNull()) {
                    errCode = obj.get("error").getAsString();
                }
            } catch (Exception ignored) {
                // body was not JSON; treat it as a generic OAuth failure.
            }
            if (code == 400 && "invalid_grant".equals(errCode)) {
                throw new InvalidGrantException(
                        "console-login refresh_token rejected (invalid_grant): " + respBody);
            }
            throw new ApiException("ConsoleOAuthClient: refresh failed with HTTP " + code
                    + (respBody == null || respBody.isEmpty() ? "" : ": " + respBody));
        } catch (IOException e) {
            throw new ApiException("ConsoleOAuthClient: refresh request failed - " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static void appendForm(StringBuilder sb, String k, String v) {
        if (sb.length() > 0) {
            sb.append('&');
        }
        try {
            sb.append(URLEncoder.encode(k, "UTF-8")).append('=').append(URLEncoder.encode(v, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not supported by this JVM", e);
        }
    }

    private static String readBody(HttpURLConnection conn, int code) {
        InputStream stream = null;
        try {
            stream = (code / 100 == 2) ? conn.getInputStream() : conn.getErrorStream();
            if (stream == null) {
                return "";
            }
            java.io.ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
            byte[] chunk = new byte[4096];
            int n;
            while ((n = stream.read(chunk)) > 0) {
                buf.write(chunk, 0, n);
            }
            return buf.toString("UTF-8");
        } catch (IOException e) {
            return "";
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ignored) {
                    // best-effort close
                }
            }
        }
    }

    static class ConsoleTokenResponse {
        @SerializedName("access_token")
        String accessToken;
        @SerializedName("token_type")
        String tokenType;
        @SerializedName("expires_in")
        long expiresIn;
        @SerializedName("refresh_token")
        String refreshToken;
        @SerializedName("id_token")
        String idToken;
        @SerializedName("scope")
        String scope;
    }

    static class InvalidGrantException extends Exception {
        private static final long serialVersionUID = 1L;

        InvalidGrantException(String msg) {
            super(msg);
        }
    }
}
