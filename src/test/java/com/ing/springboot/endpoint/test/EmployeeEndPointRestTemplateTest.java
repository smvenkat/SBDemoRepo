package com.ing.springboot.endpoint.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.model.Employee;
import com.ing.springboot.model.EmployeeResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class EmployeeEndPointRestTemplateTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testAddEmployee(){
		Employee employee = new Employee();
		employee.setName("sample"+ThreadLocalRandom.current().nextInt(1000, 2000 + 1));
		employee.setAge(12);
		employee.setSalary(12333);
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		ResponseEntity<Employee> response = restTemplate.exchange(
				createURLWithPort(ApplicationConstants.API_VERSION+ApplicationConstants.ADD_EMPLOYEE_URI), HttpMethod.POST, entity, Employee.class);
		assertEquals(response.getStatusCodeValue(),201);
	}
	
	
	@Test
	public void testRetrieveEmployee(){
		ResponseEntity<EmployeeResponse> empRes = retrieveEmployeeEntity("19613");
			Assert.assertNotNull(empRes.getStatusCodeValue());
		
	}
	
	@Test
	public void testEmployeeNotFound(){
		ResponseEntity<EmployeeResponse> empRes = retrieveEmployeeEntity("1");
		assertEquals(empRes.getStatusCodeValue(),404);
		
	}
	
	public ResponseEntity<EmployeeResponse> retrieveEmployeeEntity(String empId){
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<EmployeeResponse> response = restTemplate.exchange(
				createURLWithPort(ApplicationConstants.API_VERSION+ApplicationConstants.GET_EMPLOYEE_BY_ID_URI.replaceAll(ApplicationConstants.ID_PLACE_HOLDER,empId)),
				HttpMethod.GET,entity,EmployeeResponse.class);
		return response;
	}
	
	private String createURLWithPort(String uri) {

		return "http://localhost:" + port + uri;

	}
}
