package com.ing.springboot.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 *<h1>SwaggerConfiguration</h1>
 * <h3>It holds configuration information for the swagger documentation header sections </h3> 
 *
 * @version 1.0
 * @since   2019-06-07
 * @author Venkat
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final Contact DEFAULT_CONTACT = new Contact(
		      "Venkat", "www.cogizant.com", "sample@gmail.com");
		  
		  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		      "SpringBoot Rest Application Demo", "Spring Boot Example API EndPoints", "1.0.1",
		      "urn:tos", DEFAULT_CONTACT, 
		      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json"));

		  @Bean
		  public Docket api() {
		    return new Docket(DocumentationType.SWAGGER_2)
		    		.select()
		    		.apis(RequestHandlerSelectors.basePackage("com.ing.springboot"))
		    		.build()
		    		.apiInfo(DEFAULT_API_INFO)
		            .produces(DEFAULT_PRODUCES_AND_CONSUMES)
		            .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
		}
}
