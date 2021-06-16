/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.repository;

import com.hedgeness.app.user.model.AppUser;

/**
 * Base interface for User Management CRUD operations and common queries
 * 
 * @author Veeranjaneyulu
 *
 */
public interface UserRepoIntf 
{
	public AppUser getUserByUserName(String username) ;
}
