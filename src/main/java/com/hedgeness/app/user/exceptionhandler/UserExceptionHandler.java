/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.user.exceptionhandler;

import java.util.Date;

import com.hedgeness.app.user.customexception.*;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hedgeness.app.exception.ExceptionResponse;

/**
 * Global Exception handler for UserManagement
 * 
 * @author Pavan
 *
 */
@ControllerAdvice
@Order(1)
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * exception handler to handle all exception that are sub class to Exception
	 * class
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		ex.printStackTrace();
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * exception handler to handle UsersNotFoundException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(UsersNotFoundException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * exception handler to handle AppUserSaveException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(AppUserSaveException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleAppUserSaveException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * exception handler to handle AppUserUpdateException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(AppUserUpdateException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleAppUserUpdateException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * exception handler to handle AppUserDeleteException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(AppUserDeleteException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleAppUserDeleteException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(TokenGenrationException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleTokenGenrationException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/*@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		String bodyOfResponse = "Internal server problem....please try again";

		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}*/



}
