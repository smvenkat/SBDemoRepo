package com.ing.springboot.endpoint.test;


import static org.junit.Assert.*;

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
import com.ing.springboot.model.Customer;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class CustomerEndpointRestTemplateTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testAddCustomer(){
		Customer customer = new Customer();
		customer.setEmail("sample@gmail.com");
		customer.setFirstName("Chris");
		customer.setLastName("Thomas");
        HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);
        ResponseEntity<Customer> response = restTemplate.exchange(
        createURLWithPort(ApplicationConstants.API_VERSION+ApplicationConstants.ADD_CUSTOMER_URI), HttpMethod.POST, entity, Customer.class);
        assertEquals(response.getStatusCodeValue(),201);
	}
	
	@Test
	public void testRetrieveCustomer(){
		ResponseEntity<Customer> response = retrieveCustomerEntity("1");
		assertEquals(response.getStatusCodeValue(),200);
	}
	
	@Test
	public void testCustomerNotFound(){
		ResponseEntity<Customer> response = retrieveCustomerEntity("2");
		assertEquals(response.getStatusCodeValue(),404);
	}
	
	@Test
	public void testDeleteCustomer(){
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<Customer> response = restTemplate.exchange(
				createURLWithPort(ApplicationConstants.API_VERSION+ApplicationConstants.DELETE_CUSTOMER_URI.replaceAll(ApplicationConstants.ID_PLACE_HOLDER,"1")),
				HttpMethod.DELETE,entity,Customer.class);
		assertEquals(response.getStatusCodeValue(),204);
	}
	
	@Test
	public void testDeleteCustomerNotFoundException(){
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<Customer> response = restTemplate.exchange(
				createURLWithPort(ApplicationConstants.API_VERSION+ApplicationConstants.DELETE_CUSTOMER_URI.replaceAll(ApplicationConstants.ID_PLACE_HOLDER,"2")),
				HttpMethod.DELETE,entity,Customer.class);
		assertEquals(response.getStatusCodeValue(),404);
	}
	
	public ResponseEntity<Customer> retrieveCustomerEntity(String customerID){
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<Customer> response = restTemplate.exchange(
				createURLWithPort(ApplicationConstants.API_VERSION+ApplicationConstants.GET_CUSTOMER_BY_ID_URI.replaceAll(ApplicationConstants.ID_PLACE_HOLDER,customerID)),
				HttpMethod.GET,entity,Customer.class);
		return response;
	}
	
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;

    }
}
