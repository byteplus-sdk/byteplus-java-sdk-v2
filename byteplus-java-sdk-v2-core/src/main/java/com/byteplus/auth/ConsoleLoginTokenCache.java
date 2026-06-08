package com.byteplus.auth;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * POJO representing the cached console-login token JSON written by the
 * Byteplus CLI {@code bp login} command at
 * {@code ~/.byteplus/login/cache/<sha1(login_session)>.json}.
 *
 * <p>The {@code access_token} field is intentionally typed as a raw
 * {@link JsonElement}: the CLI writes a JSON object that contains the
 * STS credentials (access_key_id / secret_access_key / session_token),
 * but on a refresh roundtrip the OAuth endpoint may return it as a
 * JSON-encoded string. Keeping it as a {@link JsonElement} preserves
 * either shape so the consumer can decide how to parse it.
 */
class ConsoleLoginTokenCache {

    @SerializedName("login_session")
    private String loginSession;

    @SerializedName("access_token")
    private JsonElement accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("id_token")
    private String idToken;

    @SerializedName("scope")
    private String scope;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("endpoint_url")
    private String endpointUrl;

    @SerializedName("issued_at")
    private String issuedAt;

    @SerializedName("expires_in")
    private long expiresIn;

    @SerializedName("token_type")
    private String tokenType;

    public String getLoginSession() {
        return loginSession;
    }

    public void setLoginSession(String loginSession) {
        this.loginSession = loginSession;
    }

    public JsonElement getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(JsonElement accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
