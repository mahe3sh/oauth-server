/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.customexception;

/**
 * RoleRightErrorCodes Enum is to define custom Error codes for roles management
 * 
 * @author Pavan
 *
 */
public enum RoleRightErrorCodes {
	ROLE_ALREADY_EXISTED(1);
	
	private int id;
	
	/**
	 * Constructor for RoleRightErrorCodes
	 * 
	 * @param id 
	 */
	RoleRightErrorCodes(int id){
		id=this.id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
