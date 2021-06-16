/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.customexception;

/**
 * Exception that gets thrown on problem occurred while getting role/roles
 * which is registered.
 * 
 * @author Pavan
 *
 */
public class RoleUpdateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8419505350699037473L;
	
	/**
	 * Constructor for RoleUpdateException.
	 * 
	 */
	public RoleUpdateException() {
		// no code to be added
	}
	
	/**
	 * parameterized constructor for RoleUpdateException.
	 * 
	 * @param message the exception detail message
	 */
	public RoleUpdateException(String message) {
		super(message);
	}
}
