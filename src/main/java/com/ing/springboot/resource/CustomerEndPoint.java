package com.ing.springboot.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.model.Customer;


/**
* 
* <h1>CustomerEndPoint</h1>
* <h3>Customer entity related EndPoints</h3>
*<p>
* This interface holds URI configurations and HTTP method configurations to expose
* Customer EndPoints  for REST Services.
*
* Using the below EndPoints we can able to perform CRUD operations on customers data.
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/

public interface CustomerEndPoint {

	/**
	 * This EndPoint is used to add the customer details in the database
	 * 
	 * @param customer This parameter is used to map 
	 * 					the customer details from request body 
	 * @return Customer - This parameter will hold the 
						persisted customer information and return in response 
	 */
	@ApiOperation(
			 	value=ApplicationConstants.ADD_CUSTOMER_ENDPOINT_DESCRIPTION,
			 	notes=ApplicationConstants.ADD_CUSTOMER_ENDPOINT_NOTES,
			 	produces=MediaType.APPLICATION_JSON_VALUE,
			 	consumes=MediaType.APPLICATION_JSON_VALUE,
			 	code=201
			   )
	@ApiResponses(value = {
			@ApiResponse(code=201,message=ApplicationConstants.ADD_CUSTOMER_RESPONSE_MESSAGE)
	})
	@PostMapping(value=ApplicationConstants.ADD_CUSTOMER_URI,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Customer> addCustomer(@ApiParam(ApplicationConstants.ADD_CUSTOMER_PARAM) @Valid @RequestBody Customer customer);
	
	
	/**
	 * This EndPoint is used to get the customer details based on customer id
	 * 
	 * @param id This parameter is used to uniquely identify the customer entity
	 * @return Customer - This parameter will retrieve the matched customer entity and return in response 
	 */
	@ApiOperation(
				value=ApplicationConstants.GET_CUSTOMER_ENDPOINT_DESCRIPTION,
				notes=ApplicationConstants.GET_CUSTOMER_ENDPOINT_NOTES,
				produces=MediaType.APPLICATION_JSON_VALUE
			)
	@ApiResponses(value = {
			@ApiResponse(code=404,message=ApplicationConstants.GET_CUSTOMER_RESPONSE_ERROR_MESSAGE),
			@ApiResponse(code=200,message=ApplicationConstants.SUCCESS)
	})
	@GetMapping(value=ApplicationConstants.GET_CUSTOMER_BY_ID_URI,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Customer> getCustomer(@ApiParam(ApplicationConstants.GET_CUSTOMER_ID_PARAM) @PathVariable Integer id);
	
	
	/**
	 * This EndPoint is used to delete the customer details based on customer id
	 * 
	 * @param id - This parameter is used to uniquely identify the customer entity
	 * @return
	 */
	@ApiOperation(
			value=ApplicationConstants.DELETE_CUSTOMER_ENDPOINT_DESCRIPTION,
			notes=ApplicationConstants.DELETE_CUSTOMER_ENDPOINT_NOTES,
			produces=MediaType.APPLICATION_JSON_VALUE
		)
	@ApiResponses(value = {
			@ApiResponse(code=204,message=ApplicationConstants.DELETE_CUSTOMER_RESPONSE_MESSAGE),
			@ApiResponse(code=404,message=ApplicationConstants.GET_CUSTOMER_RESPONSE_ERROR_MESSAGE)
	})
	@DeleteMapping(value=ApplicationConstants.DELETE_CUSTOMER_URI)
	ResponseEntity<Void> deleteCustomer(@ApiParam(ApplicationConstants.DELETE_CUSTOMER_PARAM) @PathVariable Integer id);
	
}