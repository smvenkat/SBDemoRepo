package com.ing.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.springboot.dao.EmployeeDao;
import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;
import com.ing.springboot.service.EmployeeService;


/**
 * <h1>EmployeeServiceImpl</h1>
 * <h3>Employee Service Layer Implementation Class.</h3>
 * <p>
*  This class holds the service methods to interact with the Employee DAO layer.  
*  <p><br/>
*
* <b>Note : Internally the DAO layer will connect to configured public API
* to persist the employee entity<b/>
* 
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	/**
	 * This method is used to save employee entity using the employee DAO layer
	 * 
	 * @param employee This parameter is used to persist employee entity 
	 * @return employee - This returns the persisted employee entity with unique key
	 */
	@Override
	public Employee addEmployee(Employee employee) {
		return empDao.save(employee);
	}

	/**
	 * This method is used to retrieve the employee entity based
	 * on employee Id
	 * 
	 * @param empId This parameter is used to retrieve the employee entity 
	 * @return EmployeeResponse - This returns the employee entity from public API
	 */
	@Override
	public EmployeeResponse getEmployeeById(String empId) {
		return empDao.get(empId);
	}

}
