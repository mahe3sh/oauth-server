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
public class RolesNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8561920954474948066L;
	
	/**
	 * Constructor for RolesNotFoundException.
	 * 
	 */
	public RolesNotFoundException() {
		// no code to be added
	}
	
	/**
	 * parameterized constructor for RolesNotFoundException.
	 * 
	 * @param message the exception detail message
	 */
	public RolesNotFoundException(String message) {
		super(message);
	}

}
