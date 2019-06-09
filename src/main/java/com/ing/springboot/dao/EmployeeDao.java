package com.ing.springboot.dao;

import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;


/**
 * <h1>EmployeeDao</h1>
 * <h3>Employee DAO Layer</h3>
 *<p>
* This interface holds the CRUD operations for the employee entity.<br/>  
* <b>Note : This will connect to the external public API which is configured in the
* application property file to persist the entity. It will not connect to DB</b> 
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
public interface EmployeeDao {

	/**
	 * This method is used to persist the employee 
	 * entity into the configured external public API
	 * 
	 * @param employee This parameter is used to persist employee entity in external public API
	 * @return employee - This returns the persisted employee entity with unique key
	 */
	public Employee save(Employee employee);
	
	
	/**
	 * This method will retrieve the employee entity
	 * based on the primary key value from external public API
	 * 
	 * @param empId This parameter is used to retrieve Employee entity from external public API
	 * @return EmployeeResponse - This returns the employee entity from public API
	 */
	public EmployeeResponse get(String empId);
}
