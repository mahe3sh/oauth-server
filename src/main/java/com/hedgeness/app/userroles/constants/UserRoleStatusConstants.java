/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.constants;

/**
 * contains status constants for app user roles management responses
 * 
 * @author Kuljeet
 *
 */
public interface UserRoleStatusConstants{
	
	byte USER_ROLES_OPER_SUCCESSFUL=1;// User Management operation success constant
	byte USER_ROLES_OPER_FAIL=0;// User Management operation fail constant
	String ROLE_ADMIN="ROLE_ADMIN";
	String ROLE_ORG_ADMIN="ROLE_ORG_ADMIN";
	String ROLE_GROUP_ADMIN="GROUP_ADMIN";
	String ROLE_USER="ROLE_USER";
	int ADD = 1;
	int DELETE = 2;
	int RETAIN = 3;
}
