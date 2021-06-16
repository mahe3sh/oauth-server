/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.repository;

import java.util.List;

import com.hedgeness.app.userroles.model.AppUserRole;

/**
 * Base interface for User Management CRUD operations and common queries
 * 
 * @author Veeranjaneyulu
 *
 */
public interface UserRoleRepoIntf
{
	List<AppUserRole> getUserRolesByUserName(String username);
}