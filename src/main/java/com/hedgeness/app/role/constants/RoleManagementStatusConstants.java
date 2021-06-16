/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.constants;

/**
 * contains status constants for role management responses
 * 
 * @author Pavan
 *
 */
public interface RoleManagementStatusConstants {
	byte ROLE_MNGT_OPER_SUCCESSFUL=1;// Role Management operation success constant
	byte ROLE_MNGT_OPER_FAIL=0;// Role Management operation fail constant
	
	boolean ROLE_IS_ENABLED=true;// indicates Role enable or not
	boolean ROLE_IS_DISABLED=false;// indicates Role disable or not
	
	boolean ROLE_IS_DELETED=true;// indicates Role deleted or not
	boolean ROLE_IS_NOT_DELETED=false;// indicates Role existed or not
	
	String ROLE_STATUS_FOR_ACTIVE="Active"; // indicates Role active or not
	String ROLE_STATUS_FOR_DEACTIVE="Deactive"; // indicates Role deactive or not
}
