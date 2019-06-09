package com.ing.springboot.exceptions;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ing.springboot.constants.ApplicationConstants;


/**
* <h1>GenericExceptionAdvice</h1>
* <h3>Generic Common Application Exception  Class</h3>
*<p>
* This Class will hold all application exceptions which will be intercepts by the 
* spring rest controller EndPoints and the corresponding error code and message will be written 
* in the HTTP response.
* 
* Also it will validate the HTTP request body based on the
* annotation configuration in the request entity
* <p>
* 
* 
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@ControllerAdvice
public class GenericExceptionAdvice extends ResponseEntityExceptionHandler {

	
	/**
	 * 
	 * This method will be the handler for the customer not found exception 
	 * and throws the appropriate error code.
	 * 
	 * This exception will be mapped to the HTTP response with response 404 with 
	 *the custom message
	 * @param exception This parameter will hold the CustomerNotFound exception
	 * @param response  This parameter will hold the HTTP response object
	 * 					to send the error code
	 * @throws IOException  throws IO related Exception
	 */
	@ExceptionHandler({CustomerNotFoundException.class})
	public void CustomerNotFoundExceptionHandler(CustomerNotFoundException exception,HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	/**
	 * 
	 * This method will be the handler for the employee not found exception 
	 * and throws the appropriate error code.
	 * 
	 * This exception will be mapped to the HTTP response with response 404 with 
	 * the custom message
	 * @param exception This parameter will hold the EmployeeNotFound exception
	 * @param response  This parameter will hold the HTTP response object
	 * 					to send the error code
	 * @throws IOException throws IO related Exception
	 */
	@ExceptionHandler({EmployeeNotFoundException.class})
	public void EmployeeNotFoundExceptionHandler(EmployeeNotFoundException exception,HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	
	
	 /**
	  * This method will validate the HTTP request body with the configured annotation
	  * and error code and description will be added in the response body in errors string
	  * 
	  * @param ex This parameter holds the actual exception 
	  * @param headers This parameter holds the HTTP headers to send in response
	  * @param status This parameter holds the HTTP status to send in response
	  * @param request This parameter holds the web request object
	  * @return ResponseEntity<Object> - it will return the response object to the EndPoint
	  */
	 @Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers,
	                                                                  HttpStatus status, WebRequest request) {
		 	Map<String, Object> body = new LinkedHashMap<String,Object>();
	        body.put(ApplicationConstants.TIMESTAMP, new Date());
	        body.put(ApplicationConstants.STATUS, status.value());
	        //Get all errors
	        List<String> errorMessageList = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList());
	        //Add errors in the errors key
	        body.put(ApplicationConstants.ERRORS, errorMessageList);
	        return new ResponseEntity<Object>(body, headers, status);
		

	    }
}
