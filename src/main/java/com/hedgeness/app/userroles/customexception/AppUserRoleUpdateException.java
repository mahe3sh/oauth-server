/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.customexception;

/**
 * Exception that gets thrown on problem occurred while updating/editing user.
 *
 * @author Kuljeet
 * 
 */
public class AppUserRoleUpdateException extends Exception {
	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = 8794867317890622180L;

	/**
	 * Constructor for AppUserUpdateException.
	 */
	public AppUserRoleUpdateException() {
		//  no code to be added
	}

	/**
	 * Constructor for AppUserSaveException.
	 * 
	 * @param message the detail message
	 */
	public AppUserRoleUpdateException(String message) {
		super(message);
	}
}
