/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.customexception;

/**
 * Exception that gets thrown on problem occurred while adding user.
 *
 * @author Kuljeet
 * 
 */
public class AppUserRoleSaveException extends Exception {

	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = 3350581580166292531L;

	/**
	 * Constructor for AppUserSaveException.
	 */
	public AppUserRoleSaveException() {
		// no code to be added
	}

	/**
	 * Constructor for AppUserSaveException.
	 * 
	 * @param message the detail message
	 */
	public AppUserRoleSaveException(String message) {
		super(message);
	}
}
