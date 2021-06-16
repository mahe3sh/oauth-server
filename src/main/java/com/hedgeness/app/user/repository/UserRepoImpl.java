/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hedgeness.app.user.model.AppUser;

/**
 * Direct implementation for {@link UserRepoIntf} having all CURD
 * operation implementations
 * 
 * @author Pavan
 *
 */
@Repository("appUserManagementRepoImpl")
public class UserRepoImpl implements UserRepoIntf {
	
	public static final Logger logger = LoggerFactory.getLogger(UserRepoImpl.class);

	@Value("${hedgeapp.repo.collection.users}") // inject via application.properties
	private String userCollection;
	@Value("${hedgeapp.query.batch.size}")
	private Integer collectionMaxSize;

	@Autowired
	private MongoTemplate mongoTemplate;// inject mongoTemplate instance
	
	public AppUser getUserByUserName(String username) 
	{
		Criteria where = Criteria.where("username").in(username);
		return mongoTemplate.findOne(Query.query(where), AppUser.class, userCollection);
	}
}
