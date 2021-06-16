/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.exception;

/**
 * Exception that gets thrown on problem occurred while validating the json input.
 *
 * @author Pavan
 * 
 */
public class ValidationException extends Exception {
	/**
	 * serial version id for serialization and de serialization
	 */
	private static final long serialVersionUID = -5301726984107751111L;

	/**
	 * Constructor for ValidationException.
	 */
	public ValidationException() {
		//  no code to be added
	}

	/**
	 * Constructor for ValidationException.
	 * 
	 * @param message the detail message
	 */
	public ValidationException(String message) {
		super(message);
	}
}
