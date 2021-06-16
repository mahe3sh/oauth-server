/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.customexception;

/**
 * Exception that gets thrown on problem occurred while adding user.
 *
 * @author Pavan
 * 
 */
public class AppUserSaveException extends Exception {

	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = -8790119160635280411L;

	/**
	 * Constructor for AppUserSaveException.
	 */
	public AppUserSaveException() {
		// no code to be added
	}

	/**
	 * Constructor for AppUserSaveException.
	 * 
	 * @param message the detail message
	 */
	public AppUserSaveException(String message) {
		super(message);
	}
}
