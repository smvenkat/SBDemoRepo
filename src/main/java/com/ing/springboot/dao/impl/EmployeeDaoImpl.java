package com.ing.springboot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ing.springboot.dao.EmployeeDao;
import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;
import com.ing.springboot.repository.EmployeeRestClientRepostitory;



/**
 * <h1>EmployeeDaoImpl</h1>
 * <h3>Employee DAO Implementation Class</h3>
 *<p>
*  Implementation class for the employee DAO layer
*  which internally connects to the employee rest client repository methods to perform CRUD operations.<br/>
*  This will connect to the configured external public API to perform the CRUD operations
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRestClientRepostitory empRestClient;
	
	/**
	 * This method is used to persist the employee 
	 * entity into the configured external public API
	 * 
	 * @param employee This parameter is used to persist employee entity in external public API
	 * @return employee - This returns the persisted employee entity with unique key
	 */
	@Override
	public Employee save(Employee employee) {
		return empRestClient.create(employee);
	}

	/**
	 * This method will retrieve the employee entity
	 * based on the primary key value from external public API
	 * 
	 * @param empId This parameter is used to retrieve Employee entity from external public API
	 * @return EmployeeResponse - This returns the employee entity from public API
	 */
	@Override
	public EmployeeResponse get(String empId) {
		return empRestClient.getById(empId);
	}

}
