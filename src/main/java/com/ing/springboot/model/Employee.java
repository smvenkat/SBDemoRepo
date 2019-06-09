package com.ing.springboot.model;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import com.ing.springboot.constants.ApplicationConstants;
import com.ing.springboot.constants.ExceptionMessageConstants;


/**
*<h1>Employee</h1>
*
* <p>This class will represent the Employee Entity model which holds 
* employee properties and the corresponding validation annotation.
* 
* This model is used to send request to the external public API to persist
* the entity object.</p>
* 
*  
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
@ApiModel(description=ApplicationConstants.EMPLOYEE_ENTITY_DESCRIPTION)
public class Employee {

	@ApiModelProperty(hidden = true)
	private String id;
	
	@ApiModelProperty(notes=ApplicationConstants.EMPLOYEE_NAME_MANDATORY,required=true,position=1)
	@NotNull(message = ExceptionMessageConstants.EMPLOYEE_NAME_REQUIRED)
	private String name;
	
	@ApiModelProperty(notes=ApplicationConstants.EMPLOYEE_AGE_MANDATORY,required=true,position=2)
	@NotNull(message = ExceptionMessageConstants.EMPLOYEE_AGE_REQUIRED)
	private Integer age;
	
	@ApiModelProperty(notes=ApplicationConstants.EMPLOYEE_SALARY_MANDATORY,required=true,position=3)
	@NotNull(message = ExceptionMessageConstants.EMPLOYEE_SALARY_REQUIRED)
	private Integer salary;
	
	private String profileImage;
	
	public Employee(){}
	
	public Employee(String name,Integer age,Integer salary,String profileImage){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.profileImage = profileImage;
	}
	
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Integer getSalary() {
		return salary;
	}
	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	public String getProfileImage() {
		return profileImage;
	}
	
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
	
}
