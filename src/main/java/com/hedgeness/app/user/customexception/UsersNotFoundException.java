/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.customexception;

/**
 * Exception that gets thrown on problem occurred while getting user.
 *
 * @author Pavan
 * 
 */
public class UsersNotFoundException extends Exception {
	

	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = 9101685649295364828L;

	/**
	 * Constructor for UsersNotFoundException.
	 */
	public UsersNotFoundException() {
		//  no code to be added
	}

	/**
	 * Constructor for UsersNotFoundException.
	 * 
	 * @param message the detail message
	 */
	public UsersNotFoundException(String message) {
		super(message);
	}
}
