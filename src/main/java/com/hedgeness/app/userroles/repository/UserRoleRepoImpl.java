/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hedgeness.app.user.repository.UserRepoIntf;
import com.hedgeness.app.userroles.model.AppUserRole;

//import com.mongodb.WriteResult;

/**
 * Direct implementation for {@link UserRepoIntf} having all CURD operation
 * implementations
 * 
 * @author Veeranjaneyulu
 *
 */
@Repository("appUserRoleManagementRepoImpl")
public class UserRoleRepoImpl implements UserRoleRepoIntf {

	public static final Logger logger = LoggerFactory.getLogger(UserRoleRepoImpl.class);

	@Value("${hedgeapp.repo.collection.usersroles}") // inject via application.properties
	private String userRoleCollection;

	@Autowired
	private MongoTemplate mongoTemplate;// inject mongoTemplate instance
	
	public List<AppUserRole> getUserRolesByUserName(String username) 
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("username").in(username));
		return mongoTemplate.find(query, AppUserRole.class,userRoleCollection);
	}
	
	
}
