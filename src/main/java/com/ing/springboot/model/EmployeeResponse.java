package com.ing.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
*<h1>EmployeeResponse<h1>
* <p>This class will represent the EmployeeResponse model which holds 
* employee properties and the corresponding annotation for JSON Deserialization.
* 
* This model is used to get the employee details from the external public API.
* </p>
*  
* @version 1.0
* @since   2019-06-07
* @author Venkat
*
*/
public class EmployeeResponse {

	
	private String id;
	@JsonProperty("employee_name")
	private String empName;
	@JsonProperty("employee_age")
	private Integer empAge;
	@JsonProperty("employee_salary")
	private Integer empSalary;
	@JsonProperty("profile_image")
	private String profileImage;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public Integer getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
}
