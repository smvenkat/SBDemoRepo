package com.ing.springboot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ing.springboot.dao.CustomerDao;
import com.ing.springboot.model.Customer;
import com.ing.springboot.repository.CustomerRepository;


/**
 * <h1>CustomerDaoImpl</h1>
 * <h3>Customer DAO Implementation class</h3>
 *<p>
*  Implementation class for the customer DAO layer
*  which internally connects to the customer repository methods to perform CRUD operations
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Component
public class CustomerDaoImpl implements CustomerDao {

	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * This method is used to persist the customer 
	 * entity into the configured database
	 * 
	 * @param customer This parameter is used to persist customer entity in DB context
	 * @return customer - This returns the persisted customer entity with unique key
	 */
	@Override
	public Customer save(Customer customer) {
		return this.customerRepository.save(customer);
	}


	/**
	 * This method will remove unique customer 
	 * entity based on the primary key
	 * @param customerId This parameter is used to delete the customer entity in DB context
	 */
	@Override
	public void remove(Integer customerId) {
		this.customerRepository.deleteById(customerId);
	}

	/**
	 * This method will retrieve the customer entity
	 * based on the primary key value
	 * 
	 * @param customerId This parameter is used to identify unique customer record in DB
	 * @return Customer - This returns the matched customer entity with unique key from DB
	 */
	@Override
	public Customer get(Integer customerId) {
		return this.customerRepository.findById(customerId).orElse(null);
	}


	

}
