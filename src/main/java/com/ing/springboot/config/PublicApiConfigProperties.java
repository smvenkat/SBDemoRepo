package com.ing.springboot.config;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


/**
 * <h1>PublicApiConfigProperties</h1>
 *<h3>Public API Configuration property loader</h3>
 *<p>
* This class is used to map the sever property details from the application property file.<br/>
* All the declared fields are mandatory. <br/>
* It will be validated on the application startup
* <p>
*
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@Validated
@Configuration
@ConfigurationProperties("server")
public class PublicApiConfigProperties {

	@NotNull
	private String baseUrl;
	
	@NotNull
	private String getURI;
	
	@NotNull
	private String createURI;
	
	@NotNull
	private String deleteURI;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getGetURI() {
		return getURI;
	}

	public void setGetURI(String getURI) {
		this.getURI = getURI;
	}

	public String getCreateURI() {
		return createURI;
	}

	public void setCreateURI(String createURI) {
		this.createURI = createURI;
	}

	public String getDeleteURI() {
		return deleteURI;
	}

	public void setDeleteURI(String deleteURI) {
		this.deleteURI = deleteURI;
	}
	
	@Override
	public String toString() {
		
		return "[BaseUrl :"+this.baseUrl+"\n"
				+ "GetURI :"+this.getURI+"\n"
				+ "CreateURI : "+this.createURI+"\n"
				+"DeleteURI :"+this.deleteURI+"]";
	}
	
}
