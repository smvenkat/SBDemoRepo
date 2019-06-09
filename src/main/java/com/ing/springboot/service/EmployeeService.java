package com.ing.springboot.service;

import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;


/**
 * <h1>EmployeeService<h1>
 * <h3>Employee Service Layer</h3>
 *<p>
* This interface holds the service methods to handle the Employee CRUD operations  
* <p><br/>
*
* <b>Note : Internally the DAO layer will connect to configured public API
* to persist the employee entity</b>
* 
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
public interface EmployeeService {

	/**
	 * This method is used to save employee entity using the employee DAO layer
	 * 
	 * @param employee This parameter is used to persist employee entity 
	 * @return employee - This returns the persisted employee entity with unique key
	 */
	public Employee addEmployee(Employee employee);
	
	/**
	 * This method is used to retrieve the employee entity based
	 * on employee Id
	 * 
	 * @param empId This parameter is used to retrieve the employee entity 
	 * @return - EmployeeResponse This returns the employee entity from public API
	 */
	public EmployeeResponse getEmployeeById(String empId);
}
