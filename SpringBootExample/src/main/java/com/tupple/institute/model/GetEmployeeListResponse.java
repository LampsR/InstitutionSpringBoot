package com.tupple.institute.model;


import java.util.List;

public class GetEmployeeListResponse {
	List <Employee> EmployeeList;
	String errorMessage;


	public List<Employee> getEmployeeList() {
		return EmployeeList;
	}
	public void setEmployeeList(List<Employee> EmployeeList) {
		this.EmployeeList = EmployeeList;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
