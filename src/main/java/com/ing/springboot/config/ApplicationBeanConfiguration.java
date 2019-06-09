package com.ing.springboot.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


/**
 *
 *<h1>ApplicationBeanConfiguration</h1>
 *<h3>Application Bean Configuration</h3>
* 
* It will load all application related beans on startup 
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Configuration
public class ApplicationBeanConfiguration {

	
	
	/**
	 * This method will return the resttemplate bean which is used to connect external API 
	 * to perform CRUD Operations
	 * 
	 * @return RestTemplate
	 */
	@Bean
	RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		// Note: here we are making this converter to process any kind of response, 
		// application/json & text/html. Also we can add based on the requirement.
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML ));       
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		return restTemplate;
	}
}
