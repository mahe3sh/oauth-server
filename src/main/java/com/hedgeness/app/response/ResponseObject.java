/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.response;

/**
 * Model For Custom Response
 * 
 * @author Pavan
 *
 */
public class ResponseObject {

	private byte statusCode;
	private String message;
	private Object result;

	public ResponseObject() {

	}

	public ResponseObject(byte statusCode,String message,Object result) {

		this.statusCode=statusCode;
		this.message=message;
		this.result=result;
		
	}

	/**
	 * @return the statusCode
	 */
	public byte getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(byte statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

}
