package com.ing.springboot.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;

/**
* <h1>EmployeeEndPoint</h1>
* <h3>Employee entity related EndPoints</h3>
*<p>
* This interface holds URI configurations and HTTP method configuration to expose
* Employee EndPoint  for REST Services.
* 
* Using the below EndPoints we can able to perform CRUD operations on employees data.
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
public interface EmployeeEndPoint {

	/**
	 * This EndPoint is used to add the employee details by connect through the external public API 
	 * which is configured in property files
	 * 
	 * @param employee This parameter is used to map 
	 * 					the employee details from request body 
	 * @return Employee - This parameter will hold the 
						persisted employee information and return in response 
	 */
	@ApiOperation(
			value=ApplicationConstants.ADD_EMPLOYEE_ENDPOINT_DESCRIPTION,
			notes=ApplicationConstants.ADD_EMPLOYEE_ENDPOINT_NOTES,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
		)
	@ApiResponses(value = {
			@ApiResponse(code=201,message=ApplicationConstants.ADD_EMPLOYEE_RESPONSE_MESSAGE)
	})
	@PostMapping(value=ApplicationConstants.ADD_EMPLOYEE_URI,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Employee> addEmployee(@ApiParam(ApplicationConstants.ADD_EMPLOYEE_PARAM) @Valid @RequestBody Employee employee);
	
	
	/**
	 * This EndPoint is used to get the employee details based on employee id from the public API
	 * 
	 * @param id This parameter is used to uniquely identify the employee entity
	 * @return EmployeeResponse - This parameter will retrieve the matched employee entity and return in response 
	 */
	@ApiOperation(
			value=ApplicationConstants.GET_EMPLOYEE_ENDPOINT_DESCRIPTION,
			notes=ApplicationConstants.GET_EMPLOYEE_ENDPOINT_NOTES,
			produces=MediaType.APPLICATION_JSON_VALUE
		)
	@ApiResponses(value = {
			@ApiResponse(code=200,message = ApplicationConstants.SUCCESS),
			@ApiResponse(code=404,message = ApplicationConstants.GET_EMPLOYEE_RESPONSE_ERROR_MESSAGE)
			
	})
	@GetMapping(value=ApplicationConstants.GET_EMPLOYEE_BY_ID_URI,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<EmployeeResponse> getEmployee(@ApiParam(ApplicationConstants.GET_EMPLOYEE_ID_PARAM)@PathVariable String id);
}
