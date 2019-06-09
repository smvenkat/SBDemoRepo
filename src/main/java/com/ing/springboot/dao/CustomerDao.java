package com.ing.springboot.dao;

import org.springframework.stereotype.Repository;

import com.ing.springboot.model.Customer;

/**
 * 
 * <h1>CustomerDao</h1>
 * 
 *
 *<p>
 * <h3>Customer DAO Layer</h3>
* This interface holds the CRUD operations for the customer entity.  
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Repository
public interface CustomerDao {

	/**
	 * This method is used to persist the customer 
	 * entity into the configured database
	 * 
	 * @param customer This parameter is used to persist customer entity in DB context
	 * @return Customer - This returns the persisted customer entity with unique key
	 */
	public Customer save(Customer customer);
	
	/**
	 * This method will remove unique customer 
	 * entity based on the primary key
	 * @param customerId This parameter is used to delete the customer entity in DB context
	 */
	public void remove(Integer customerId);
	
	
	/**
	 * This method will retrieve the customer entity
	 * based on the primary key value
	 * 
	 * @param customerId This parameter is used to identify unique customer record in DB
	 * @return Customer - This returns the matched customer entity with unique key from DB
	 */
	public Customer get(Integer customerId);
}
