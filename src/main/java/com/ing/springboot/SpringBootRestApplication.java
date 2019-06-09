package com.ing.springboot;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ing.springboot.config.PublicApiConfigProperties;


/**
 * <h1>SpringBootRestApplication</h1>
 *<p>
* Class that can be used to bootstrap and launch a Spring application from a Java main
 * method. 
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@SpringBootApplication
public class SpringBootRestApplication  {

	private static Logger logger = LoggerFactory.getLogger(SpringBootRestApplication.class);
	
	@Autowired
	private PublicApiConfigProperties externalApiConfigProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	@PostConstruct
	public void init(){
		logger.info("External API Configured Successfully!!");
		logger.info(externalApiConfigProperties.toString());
	}
	
	
}
