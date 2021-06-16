package com.hedgeness.app.oauth.repository;

import com.hedgeness.app.oauth.model.OauthClientDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OauthClientDetailRepoImpl implements OauthClientDetailRepoIntf {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${hedgeapp.repo.collection.OauthClientDetail}")
    private String collectionName;

    @Override
    public OauthClientDetail findByPrimaryKey(String pk) {
        return mongoTemplate.findById(pk,OauthClientDetail.class,collectionName);
    }


  @Override
    public OauthClientDetail loadClientByClientId(String clientId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientId").is(clientId));
        return mongoTemplate.findOne(query,OauthClientDetail.class,collectionName);
    }

}

