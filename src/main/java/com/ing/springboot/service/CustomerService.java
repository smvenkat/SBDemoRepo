package com.ing.springboot.service;

import com.ing.springboot.model.Customer;



/**
 * <h1>CustomerService</h1>
 * <h3>Customer Service Layer</h3>
 *<p>
* This interface holds the service methods to handle the customer CRUD operations  
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
public interface CustomerService {

	/**
	 * This method is used to connect to the customer DAO layer
	 * to add the customer in DB
	 * 
	 * @param customer This parameter is used to persist customer entity in DB context
	 * @return customer - This returns the persisted customer entity with unique key
	 */
	public Customer addCustomer(Customer customer);
	
	/**
	 * This method will connect to customer DAO layer to 
	 * remove unique customer based on the id.
	 * 
	 * @param customerId This parameter is used to delete the customer entity in DB context
	 */
	public void removeCustomer(Integer customerId);
	
	/**
	 * This method will retrieve the customer entity
	 * based on the primary key value from the DAO layer
	 * 
	 * @param customerId This parameter is used to identify unique customer record in DB
	 * @return Customer - This returns the matched customer entity with unique key from DB
	 */
	public Customer getCustomerById(Integer customerId);
}
