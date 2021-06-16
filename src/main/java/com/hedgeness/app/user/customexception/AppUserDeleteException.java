/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.customexception;

/**
 * Exception that gets thrown on problem occurred while deleting user.
 *
 * @author Pavan
 * 
 */
public class AppUserDeleteException extends Exception{
	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = -8790119160635280411L;

	/**
	 * Constructor for AppUserDeleteException.
	 */
	public AppUserDeleteException() {
		//  no code to be added
	}

	/**
	 * Constructor for AppUserDeleteException.
	 * 
	 * @param message the detail message
	 */
	public AppUserDeleteException(String message) {
		super(message);
	}
}
