package com.ing.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.springboot.model.Customer;

/**
 * <h1>CustomerRepository</h1>
 * <h3>Customer DAO Repository interface</h3>
*<p>
* This interface holds the CRUD operations for the customer entity.  
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
