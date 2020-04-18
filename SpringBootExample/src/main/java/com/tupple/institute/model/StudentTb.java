package com.tupple.institute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentTb {
	
	public StudentTb() {};
	@Id
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	private String firstName;
	private String lastName;
	
	private String address;
	private int zipCode;
	private boolean hasLaptop;
	private String classId;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isHasLaptop() {
		return hasLaptop;
	}
	public void setHasLaptop(boolean hasLaptop) {
		this.hasLaptop = hasLaptop;
	}
	

}
