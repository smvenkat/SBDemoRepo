package com.ing.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.springboot.dao.CustomerDao;
import com.ing.springboot.model.Customer;
import com.ing.springboot.service.CustomerService;


/**
 * <h1>CustomerServiceImpl</h1>
* <h3>Customer Service Layer Implementation Class</h3>
* <p>
* This Class holds the service methods for the customer entity.
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDao customerDao; 
	
	
	/**
	 * This method is used to connect to the customer DAO layer
	 * to add the customer in DB
	 * 
	 * @param customer This parameter is used to persist customer entity in DB context
	 * @return customer - This returns the persisted customer entity with unique key
	 */
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	/**
	 * This method will connect to customer DAO layer to 
	 * remove unique customer based on the id.
	 * 
	 * @param customerId This parameter is used to delete the customer entity in DB context
	 */
	public void removeCustomer(Integer customerId) {
		customerDao.remove(customerId);
	}


	/**
	 * This method will retrieve the customer entity
	 * based on the primary key value from the DAO layer
	 * 
	 * @param customerId This parameter is used to identify unique customer record in DB
	 * @return Customer - This returns the matched customer entity with unique key from DB
	 */
	public Customer getCustomerById(Integer customerId) {
		return customerDao.get(customerId);
	}

}
