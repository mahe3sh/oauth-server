/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * model to carry Exception Response
 * 
 * @author Pavan
 *
 */
public class ExceptionResponse {
	private Date timestamp;
	private String errorMessage;
	private String details;
	private HttpStatus errorCode;
	private int statusCode;
	
	public ExceptionResponse(Date timestamp, String errorMessage, String details, HttpStatus errorCode, int statusCode) { //parameterized constructor to initialize all instance variables
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.details = details;
		this.errorCode = errorCode;
		this.statusCode = statusCode;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the errorCode
	 */
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
