package com.ing.springboot.resource.impl;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.constants.ExceptionMessageConstants;
import com.ing.springboot.exceptions.CustomerNotFoundException;
import com.ing.springboot.model.Customer;
import com.ing.springboot.resource.CustomerEndPoint;
import com.ing.springboot.service.CustomerService;


/**
* 
* <h1>CustomerEndPointImpl</h1>
* 
* <h3>Customer entity related Endpoint Implementation Class</h3>
*<p>
* This Class provide the implementation details for the customer endpoint URLs
* 
* Using this below endpoint implementations we can able to perform CRUD operations on Customers data.
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/


@Api(
		tags ={ApplicationConstants.CUSTOMER_ENDPOINT_VALUE},
		description = ApplicationConstants.CUSTOMER_ENDPOINT_DESCRIPTION 
	)
@RestController
@RequestMapping(ApplicationConstants.API_VERSION)
public class CustomerEndPointImpl implements CustomerEndPoint {
	
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * This EndPoint is used to add the customer details in the database
	 * 
	 * @param customer This parameter is used to map 
	 * 					the customer details from request body 
	 * @return Customer - This parameter will hold the 
						persisted customer information and return in response 
	 */
	@Override
	public ResponseEntity<Customer> addCustomer(Customer customer) {
		customer = customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

	/**
	 * This endpoint is used to get the customer details based on customer id
	 * 
	 * @param id This parameter is used to uniquely identify the customer entity
	 * @return Customer - This parameter will retrieve the matched customer entity and return in response 
	 */
	@Override
	public ResponseEntity<Customer> getCustomer(Integer id) {
		Customer customer = customerService.getCustomerById(id);
		if(null == customer){
			throw new CustomerNotFoundException(ExceptionMessageConstants.CUSTOMER_NOT_FOUND + ":" +id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}

	/**
	 * This endpoint is used to delete the customer details based on customer id
	 * 
	 * @param id This parameter is used to uniquely identify the customer entity
	 * @return void
	 */
	@Override
	public ResponseEntity<Void> deleteCustomer(Integer id) {
		try{
			customerService.removeCustomer(id);
		}catch(EmptyResultDataAccessException e){
			throw new CustomerNotFoundException(ExceptionMessageConstants.CUSTOMER_NOT_FOUND + ":" +id);
		}
		 return ResponseEntity.noContent().build();
	}

	

}
