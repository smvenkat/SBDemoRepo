package com.ing.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
* 
* <h1>Employee Not Found Exception Class</h1>
*<p>
* This Class is used to throws employee not found exception if there is no 
* matching record found in public API for the unique id
* <p>
*
* This exception will be mapped to the http response with response 404 with 
* the custom message
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String message){
		super(message);
	}
}
