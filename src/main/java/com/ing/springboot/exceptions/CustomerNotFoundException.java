package com.ing.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
*<h1>CustomerNotFoundException</h1>
*<h3>Customer Not Found Exception Class</h3>
*<p>
* This Class is used to throws customer not found exception if there is no 
* matchind record found in database for the unique id
* <p>
* 
* This exception will be mapped to the HTTP response with response status code - 404 with 
* the custom message
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String message){
		super(message);
	}
}
