/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.customexception;

/**
 * Exception that gets thrown on problem occurred while adding role
 * which is registered.
 * 
 * @author Pavan
 *
 */
public class RoleRightsSaveException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7540900723733933730L;
	
	private RoleRightErrorCodes code; //to store error code
	
	/**
	 * Constructor for RoleRightsSaveException.
	 * 
	 */
	public RoleRightsSaveException() {
		// no code to be added
	}
	
	/**
	 * parameterized constructor for RoleDeleteException.
	 * 
	 * @param message the exception detail message
	 */
	public RoleRightsSaveException(String message) {
		super(message);
	}
	
	/**
	 * two parameterized constructor for RoleDeleteException.
	 * 
	 * @param message the exception detail message
	 * @param code the error code
	 */
	public RoleRightsSaveException(String message,RoleRightErrorCodes code) {
		super(message);
		this.code=code;
	}

	/**
	 * @return the code
	 */
	public RoleRightErrorCodes getCode() {
		return code;
	}
}
