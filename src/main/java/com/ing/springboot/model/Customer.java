package com.ing.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import springfox.documentation.annotations.ApiIgnore;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.constants.ExceptionMessageConstants;


/**
*
*<h1>Customer</h1>
* <p>This class will represent the Customer Entity model which holds 
* customer properties and the corresponding validation and JPA annotations</p>
* 
*  
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@ApiModel(description=ApplicationConstants.CUSTOMER_ENTITY_DESCRIPTION)
@Entity
public class Customer {

	@Id
	@GeneratedValue
	@ApiModelProperty(hidden = true)
	public Integer customerId;
	
	@ApiModelProperty(notes=ApplicationConstants.CUSTOMER_FIRST_NAME_MANDATORY,required=true,position=1)
	@NotNull(message = ExceptionMessageConstants.FIRST_NAME_REQUIRED)
	public String firstName;
	
	@ApiModelProperty(notes=ApplicationConstants.CUSTOMER_LAST_NAME_MANDATORY,required=true,position=2)
	@NotNull(message = ExceptionMessageConstants.LAST_NAME_REQUIRED)
	public String lastName;
	
	@ApiModelProperty(notes=ApplicationConstants.CUSTOMER_EMAIL_MANDATORY,required=true,position=3)
	@NotNull(message = ExceptionMessageConstants.EMAIL_REQUIRED)
	@Email(message=ExceptionMessageConstants.INVALID_EMAIL)
	public String email;
	
	public Customer(){}
	
	public Customer(Integer customerId,String firstName,String lastName,String email){
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
