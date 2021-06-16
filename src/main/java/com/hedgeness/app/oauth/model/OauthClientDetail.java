package com.hedgeness.app.oauth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class OauthClientDetail {
    @Id
    private String clientId;

    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizeGrantType;
    private String webServerRedirectUri;
    private String authorities;
    private String additionalInformation;
    private String autoapprove;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizeGrantType() {
        return authorizeGrantType;
    }

    public void setAuthorizeGrantType(String authorizeGrantType) {
        this.authorizeGrantType = authorizeGrantType;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OauthClientDetail that = (OauthClientDetail) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(resourceIds, that.resourceIds) &&
                Objects.equals(clientSecret, that.clientSecret) &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(authorizeGrantType, that.authorizeGrantType) &&
                Objects.equals(webServerRedirectUri, that.webServerRedirectUri) &&
                Objects.equals(authorities, that.authorities) &&
                Objects.equals(additionalInformation, that.additionalInformation) &&
                Objects.equals(autoapprove, that.autoapprove) &&
                Objects.equals(accessTokenValidity, that.accessTokenValidity) &&
                Objects.equals(refreshTokenValidity, that.refreshTokenValidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, resourceIds, clientSecret, scope, authorizeGrantType, webServerRedirectUri, authorities, additionalInformation, autoapprove, accessTokenValidity, refreshTokenValidity);
    }
}
