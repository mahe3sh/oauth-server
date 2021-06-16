/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.userroles.customexception;

/**
 * Exception that gets thrown on problem occurred while getting user.
 *
 * @author Kuljeet
 * 
 */
public class UsersRoleNotFoundException extends Exception {

	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = 6515579168152265788L;

	/**
	 * Constructor for UsersNotFoundException.
	 */
	public UsersRoleNotFoundException() {
		// no code to be added
	}

	/**
	 * Constructor for UsersNotFoundException.
	 * 
	 * @param message
	 *            the detail message
	 */
	public UsersRoleNotFoundException(String message) {
		super(message);
	}
}
