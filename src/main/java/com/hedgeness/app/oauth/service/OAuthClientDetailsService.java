package com.hedgeness.app.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.hedgeness.app.oauth.model.OauthClientDetail;
import com.hedgeness.app.oauth.repository.OauthClientDetailRepoIntf;

@Service("oAuthClientDetailsService")
public class OAuthClientDetailsService implements ClientDetailsService
{
	 @Value("${hedgeapp.repo.collection.OauthClientDetail}")
	 private String collectionName;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private OauthClientDetailRepoIntf clientDetailRepoIntf;

    //private PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

    /*
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails client = mongoTemplate.findOne(new Query(Criteria.where("clientId").is(clientId)), BaseClientDetails.class, CONLLECTION_NAME);
        if(client==null){
            throw new RuntimeException ("no client information found");
        }
        return client;
    } */
    
    /**
     * Load a client by the client id. This method must not return null.
     *
     * @param clientId The client id.
     * @return The client details (never null).
     * @throws ClientRegistrationException If the client account is locked, expired, disabled, or invalid for any other reason.
     */

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException 
    {
        OauthClientDetail oauthClientDetail= clientDetailRepoIntf.loadClientByClientId(clientId);
        BaseClientDetails baseClientDetails =null;
        if(oauthClientDetail!=null)
        {
            baseClientDetails= new  BaseClientDetails(clientId, oauthClientDetail.getResourceIds(),
                    oauthClientDetail.getScope(), oauthClientDetail.getAuthorizeGrantType(), oauthClientDetail.getAuthorities());
            baseClientDetails.setClientSecret(oauthClientDetail.getClientSecret());
        }else{
            throw new ClientRegistrationException("client not registered with us");
        }
        return baseClientDetails;
    }

    public void addClientDetails(ClientDetails clientDetails) {
        mongoTemplate.insert(clientDetails, collectionName);
    }

    public void updateClientDetails(ClientDetails clientDetails) {
        Update update = new Update();
        update.set("resourceIds", clientDetails.getResourceIds());
        update.set("clientSecret", clientDetails.getClientSecret());
        update.set("authorizedGrantTypes", clientDetails.getAuthorizedGrantTypes());
        update.set("registeredRedirectUris", clientDetails.getRegisteredRedirectUri());
        update.set("authorities", clientDetails.getAuthorities());
        update.set("accessTokenValiditySeconds", clientDetails.getAccessTokenValiditySeconds());
        update.set("refreshTokenValiditySeconds", clientDetails.getRefreshTokenValiditySeconds());
        update.set("additionalInformation", clientDetails.getAdditionalInformation());
        update.set("scope", clientDetails.getScope());
        mongoTemplate.updateFirst(new Query(Criteria.where("clientId").is(clientDetails.getClientId())), update, collectionName);
    }

    public void updateClientSecret(String clientId, String secret) {
        Update update = new Update();
        update.set("clientSecret", secret);
        mongoTemplate.updateFirst(new Query(Criteria.where("clientId").is(clientId)), update, collectionName);
    }

    public void removeClientDetails(String clientId) {
        mongoTemplate.remove(new Query(Criteria.where("clientId").is(clientId)), collectionName);
    }

    public List<ClientDetails> listClientDetails(){
        return mongoTemplate.findAll(ClientDetails.class, collectionName);
    }
    
	@Bean
	public PasswordEncoder encoder() {
	     return new BCryptPasswordEncoder();
	}
}