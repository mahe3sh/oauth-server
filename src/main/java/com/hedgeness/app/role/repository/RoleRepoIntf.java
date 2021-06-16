/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.repository;

import java.util.List;

import com.hedgeness.app.role.model.RoleRights;

/**
 * Base interface for Role Management CRUD operations and common queries
 * 
 * @author Veeranjaneyulu
 *
 */
public interface RoleRepoIntf 
{
	public RoleRights getRoleIdByRoleName(String roleDisplayName,String organizationId);
	public List<RoleRights> findRoleRightsByRoleId(String id);
}
