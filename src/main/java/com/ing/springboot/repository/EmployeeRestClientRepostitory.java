package com.ing.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ing.springboot.config.PublicApiConfigProperties;
import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;


/**
 * <h1>EmployeeRestClientRepostitory</h1>
 * <h3>Employee Rest Client Repository Class</h3>
*<p>
*  This class acts as a repository layer for employee DAO layer which implicitly
*  connects to the configured external public API to perform the CRUD operations on 
*  employee entity.<br/>
*  
*  It holds the public API Configuration property class reference along with the rest template class
*  to connect to the external API.
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Component
public class EmployeeRestClientRepostitory {

	@Autowired
	private PublicApiConfigProperties properties;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * 
	 * This method is used to connect the external public API 
	 * using the RestTemplate object
	 * and perform HTTP post method to 
	 * save the employee entity.
	 * 
	 * @param employee This parameter holds the employee object to send in HTTP request
	 * @return Employee This parameter holds the employee object from HTTP response
	 */
	public Employee create(Employee employee){
		Employee emp = restTemplate.postForObject(properties.getBaseUrl()+properties.getCreateURI(),employee,Employee.class);
		return emp;
	}
	
	/**
	 * 
	 * This method is used to connect the external API 
	 * using the RestTemplate object
	 * and perform HTTP post method to 
	 * save the employee entity.
	 * 
	 * @param employeeId This parameter holds the employeeId to send in HTTP request to 
	 * 					 uniquely match the record 
	 * @return EmployeeResponse This parameter holds the employee object from HTTP response
	 */
	public EmployeeResponse getById(String employeeId){
		try{
			String endpointURL = properties.getBaseUrl()+properties.getGetURI().replaceAll(ApplicationConstants.ID_PLACE_HOLDER, employeeId);
			return restTemplate.getForObject(endpointURL, EmployeeResponse.class);
		}catch(HttpMessageNotReadableException | RestClientException clientException){
			return null;
		}
	}
	

}
