package com.hedgeness.app.oauth.service;

import com.hedgeness.app.oauth.model.OauthClientDetail;
import com.hedgeness.app.oauth.repository.OauthClientDetailRepoIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class OauthClientDetailServiceImpl implements OauthClientDetailServiceIntf {
    @Autowired
    private OauthClientDetailRepoIntf clientDetailRepoIntf;


/**
     * Load a client by the client id. This method must not return null.
     *
     * @param clientId The client id.
     * @return The client details (never null).
     * @throws ClientRegistrationException If the client account is locked, expired, disabled, or invalid for any other reason.
     */

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
         OauthClientDetail oauthClientDetail= clientDetailRepoIntf.loadClientByClientId(clientId);

        BaseClientDetails baseClientDetails =null;
        if(oauthClientDetail!=null){
           // logger.info("baseClientDetails::"+oauthClientDetail);
            baseClientDetails= new  BaseClientDetails(clientId, oauthClientDetail.getResourceIds(),
                    oauthClientDetail.getScope(), oauthClientDetail.getAuthorizeGrantType(), oauthClientDetail.getAuthorities());
            baseClientDetails.setClientSecret(oauthClientDetail.getClientSecret());
        }else{
            throw new ClientRegistrationException("client not registered with us");
        }
        return baseClientDetails;
    }


}

