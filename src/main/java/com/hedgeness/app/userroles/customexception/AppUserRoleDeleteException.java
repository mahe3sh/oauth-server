/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.customexception;

/**
 * Exception that gets thrown on problem occurred while deleting user.
 *
 * @author Kuljeet
 * 
 */
public class AppUserRoleDeleteException extends Exception{
	
	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = 919431417609516501L;

	/**
	 * Constructor for AppUserDeleteException.
	 */
	public AppUserRoleDeleteException() {
		//  no code to be added
	}

	/**
	 * Constructor for AppUserDeleteException.
	 * 
	 * @param message the detail message
	 */
	public AppUserRoleDeleteException(String message) {
		super(message);
	}
}
