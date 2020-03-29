package com.tupple.institute.model;

import java.util.List;

public class GetStudetListResponse {
	List <Student> studentList;
	String errorMessage;


	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
