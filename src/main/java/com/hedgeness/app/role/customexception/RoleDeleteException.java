/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.customexception;

/**
 * Exception that gets thrown on problem occurred while deleting role
 * which is registered.
 * 
 * @author Pavan
 *
 */
public class RoleDeleteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3849121720654280963L;
	
	/**
	 * Constructor for RoleDeleteException.
	 * 
	 */
	public RoleDeleteException() {
		// no code to be added
	}
	
	/**
	 * parameterized constructor for RoleDeleteException.
	 * 
	 * @param message the exception detail message
	 */
	public RoleDeleteException(String message) {
		super(message);
	}
}
