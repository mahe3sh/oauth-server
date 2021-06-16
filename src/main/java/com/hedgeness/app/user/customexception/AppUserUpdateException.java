/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.customexception;

/**
 * Exception that gets thrown on problem occurred while updating/editing user.
 *
 * @author Pavan
 * 
 */
public class AppUserUpdateException extends Exception {
	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = -5301726984107751089L;

	/**
	 * Constructor for AppUserUpdateException.
	 */
	public AppUserUpdateException() {
		//  no code to be added
	}

	/**
	 * Constructor for AppUserSaveException.
	 * 
	 * @param message the detail message
	 */
	public AppUserUpdateException(String message) {
		super(message);
	}
}
