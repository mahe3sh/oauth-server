/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.constants;

/**
 * contains status constants for app user management responses
 * 
 * @author Pavan
 *
 */
public interface UserStatusConstants{
	byte USER_OPER_SUCCESSFUL=1;// User Management operation success constant
	byte USER_OPER_FAIL=0;// User Management operation fail constant
	
	boolean USER_IS_ENABLED=true;// indicates user enable or not
	boolean USER_IS_DISABLED=false;// indicates user disable or not
	
	boolean USER_IS_DELETED=true;// indicates user deleted or not
	boolean USER_IS_NOT_DELETED=false;// indicates user existed or not
	
	String USER_STATUS_FOR_ACTIVE="Active"; // indicates user active or not
	String USER_STATUS_FOR_DEACTIVE="Deactive"; // indicates user deactive or not

	
	int USER_ACTIVATION_TOKEN_LEN=10; // to define activation token length
	byte USER_MAIL_SENT_SUCESS=1;
	byte USER_MAIL_NOT_SENT=0;

	String SELF="SELF";
}
