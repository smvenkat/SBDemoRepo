package com.ing.springboot.constants;


/**
 * 
 * <h1>ApplicationConstants</h1>
 * <h3>Application Constants Index file</h3>
 *<p>
*  This class holds all application related string constants for easy access & maintainability.
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
public class ApplicationConstants {
	
	//URI Constants
	public static final String API_VERSION = "SBDemo/api/v1";
	public static final String ADD_CUSTOMER_URI = "/add/customer";
	public static final String GET_CUSTOMER_BY_ID_URI = "/get/customer/{id}";
	public static final String DELETE_CUSTOMER_URI = "/delete/customer/{id}";
	
	public static final String ADD_EMPLOYEE_URI = "/add/employee";
	public static final String GET_EMPLOYEE_BY_ID_URI = "/get/employee/{id}";

	//Common Constants
	public static final String TIMESTAMP = "timestamp";
	public static final String STATUS = "status";
	public static final String ERRORS = "errors";
	public static final String ID_PLACE_HOLDER = "\\{id\\}";
	
	//Swagger Constants
	public static final String SUCCESS = "Success";
	public static final String CUSTOMER_ENDPOINT_VALUE = "Customer Controller";
	public static final String CUSTOMER_ENDPOINT_DESCRIPTION = "Set of Endpoints to Create,Delete,Retrive customer entity";
	public static final String CUSTOMER_ENTITY_DESCRIPTION = "All details about the Customer Entity";
	public static final String CUSTOMER_FIRST_NAME_MANDATORY = "FirstName of the Customer";
	public static final String CUSTOMER_LAST_NAME_MANDATORY = "LastName of the Customer";
	public static final String CUSTOMER_EMAIL_MANDATORY = "Valid Email of the Customer";
	public static final String ADD_CUSTOMER_ENDPOINT_DESCRIPTION = "Add New Customer";
	public static final String ADD_CUSTOMER_ENDPOINT_NOTES = "Returns the newly added customer entity in response with status code 201";
	public static final String ADD_CUSTOMER_PARAM = "Customer Information for a new customer to be added.";
	public static final String GET_CUSTOMER_ID_PARAM = "Id of the customer to be obtained.Cannot be empty";
	public static final String DELETE_CUSTOMER_PARAM = "Id of the customer to be deleted.Cannot be empty";
	public static final String GET_CUSTOMER_ENDPOINT_DESCRIPTION = "Find customer by Id";
	public static final String GET_CUSTOMER_ENDPOINT_NOTES = "Returns customer by their Id. Returns 404 if does not exist.";
	public static final String DELETE_CUSTOMER_ENDPOINT_DESCRIPTION = "Delete Customer by Id.";
	public static final String DELETE_CUSTOMER_ENDPOINT_NOTES = "It will return status code as 204 with no response body.";
	public static final String ADD_CUSTOMER_RESPONSE_MESSAGE = "Customer Added SuccessFully";
	public static final String GET_CUSTOMER_RESPONSE_ERROR_MESSAGE = "Customer Not Found";
	public static final String DELETE_CUSTOMER_RESPONSE_MESSAGE = "Customer deleted SuccessFully";
	
	public static final String EMPLOYEE_ENDPOINT_VALUE = "Employee Controller";
	public static final String EMPLOYEE_ENDPOINT_DESCRIPTION = "Set of Endpoints to Create,Retrive Employee entity";
	public static final String EMPLOYEE_ENTITY_DESCRIPTION = "All details about the Employee Entity";
	public static final String EMPLOYEE_NAME_MANDATORY = "Name of the Employee.It should be unique";
	public static final String EMPLOYEE_AGE_MANDATORY = "Age of the Employee";
	public static final String EMPLOYEE_SALARY_MANDATORY = "Salary of the Employee";
	public static final String ADD_EMPLOYEE_PARAM = "Employee Information for a new employee to be added.";
	public static final String GET_EMPLOYEE_ID_PARAM = "Id of the Employee to be obtained.Cannot be empty";
	public static final String ADD_EMPLOYEE_ENDPOINT_DESCRIPTION = "Add New Employee";
	public static final String ADD_EMPLOYEE_ENDPOINT_NOTES = "Returns the newly added employee entity in response with status code 201";
	public static final String GET_EMPLOYEE_ENDPOINT_DESCRIPTION = "Find employee by id ";
	public static final String GET_EMPLOYEE_ENDPOINT_NOTES = "Returns employee entity in response.Returns 404 if it does not exist.";
	public static final String ADD_EMPLOYEE_RESPONSE_MESSAGE = "Employee Added SuccessFully";
	public static final String GET_EMPLOYEE_RESPONSE_ERROR_MESSAGE = "Employee Not Found";
	
}
