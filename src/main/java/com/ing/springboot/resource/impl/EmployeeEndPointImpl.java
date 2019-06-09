package com.ing.springboot.resource.impl;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.constants.ExceptionMessageConstants;
import com.ing.springboot.exceptions.EmployeeNotFoundException;
import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;
import com.ing.springboot.resource.EmployeeEndPoint;
import com.ing.springboot.service.EmployeeService;


/**
* 
*<h1>EmployeeEndPointImpl</h1>
*<h3>Employee entity related EndPoint Implementation Class</h3>
*<p>
This Class provide the implementation details for the Employee EndPoint URL's
* 
* Using this below EndPoints we can able to perform CRUD operations on employees data.
* 
* <b> Note : These EndPoints will internally connects to the external public API which is 
* configured in the application property files </b> 
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/

@RestController
@RequestMapping(ApplicationConstants.API_VERSION)
@Api(
		tags = {ApplicationConstants.EMPLOYEE_ENDPOINT_VALUE},
				description = ApplicationConstants.EMPLOYEE_ENDPOINT_DESCRIPTION
	 )
public class EmployeeEndPointImpl implements EmployeeEndPoint {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * This EndPoint is used to add the employee details by connect through the external public API 
	 * which is configured in property files
	 * 
	 * @param employee This parameter is used to map 
	 * 					the employee details from request body 
	 * @return Employee This parameter will hold the 
						persisted employee information and return in response 
	 */
	@Override
	public ResponseEntity<Employee> addEmployee(Employee employee) {
		employee = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}


	/**
	 * This EndPoint is used to get the employee details based on employee id from the public API
	 * 
	 * @param id This parameter is used to uniquely identify the employee entity
	 * @return EmployeeResponse This parameter will retrieve the matched employee entity and return in response 
	 */
	@Override
	public ResponseEntity<EmployeeResponse> getEmployee(String id) {
		EmployeeResponse employee = employeeService.getEmployeeById(id);
		if(null == employee){
			throw new EmployeeNotFoundException(ExceptionMessageConstants.EMPLOYEE_NOT_FOUND+":"+id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

}
