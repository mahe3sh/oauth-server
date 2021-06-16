package com.hedgeness.app.oauth.repository;

import com.hedgeness.app.oauth.model.OauthClientDetail;

public interface OauthClientDetailRepoIntf {
    OauthClientDetail findByPrimaryKey(String pk);
   OauthClientDetail loadClientByClientId(String clientId);
}
