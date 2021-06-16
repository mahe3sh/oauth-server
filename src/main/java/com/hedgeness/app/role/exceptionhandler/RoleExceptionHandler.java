/** 
* Copyright (c) Hedgeness Inc 2016-2018
* All rights reserved. 
*/

package com.hedgeness.app.role.exceptionhandler;

import java.util.Date;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hedgeness.app.exception.ExceptionResponse;
import com.hedgeness.app.role.customexception.RoleDeleteException;
import com.hedgeness.app.role.customexception.RoleRightsSaveException;
import com.hedgeness.app.role.customexception.RoleUpdateException;
import com.hedgeness.app.role.customexception.RolesNotFoundException;


/**
 * Global exception handler for RoleManagement services having order 2
 * 
 * @author Pavan
 *
 */
@ControllerAdvice
@Order(3)
public class RoleExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * exception handler to handle RoleRightsSaveException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(RoleRightsSaveException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleRoleRightsSaveException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * exception handler to handle RolesNotFoundException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(RolesNotFoundException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleRolesNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * exception handler to handle RoleDeleteException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(RoleDeleteException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleRoleDeleteException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * exception handler to handle RoleUpdateException exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity having custom exception details as response
	 */
	@ExceptionHandler(RoleUpdateException.class)
	@ResponseBody
	public final ResponseEntity<ExceptionResponse> handleRoleUpdateException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
