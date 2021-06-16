/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hedgeness.app.role.model.RoleRights;

/**
 * Direct implementation for {@link RoleRepoIntf} having all CURD
 * operation implementations
 * 
 * @author Pavan
 *
 */
@Repository("roleManagementRepoImpl")
public class RoleRepoImpl implements RoleRepoIntf{
	
	public static final Logger logger = LoggerFactory.getLogger(RoleRepoImpl.class);

	@Value("${hedgeapp.repo.collection.previliges}") // inject via application.properties
	private String roleRightsCollection;
	
	@Autowired
	private MongoTemplate mongoTemplate; // inject mongoTemplate instance
	
	@Override
	public RoleRights getRoleIdByRoleName(String roleDisplayName,String organizationId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("displayName").is(roleDisplayName)
				.and("organizationId").is(organizationId));
		query.fields().include("id");
		
		return mongoTemplate.findOne(query, RoleRights.class, roleRightsCollection);
	}
	
	@Override
	public List<RoleRights> findRoleRightsByRoleId(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		List<RoleRights> listRoles = mongoTemplate.find(query, RoleRights.class,roleRightsCollection);
		return listRoles;
	}
	
	
	
}
