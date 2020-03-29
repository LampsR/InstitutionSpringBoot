package com.tupple.institute.data;

import java.util.ArrayList;
import java.util.List;

import com.tupple.institute.model.Employee;
import com.tupple.institute.model.Student;

public class ResponseDataSource {
	
	public static List <Student> getStudentData(){
		List <Student> studentList = new ArrayList <>();
		
		Student s = null;
		for(int i=0; i<5; i++) {
			s = new Student ();
			s.setFirstName("FirstName: " + i);
			s.setLastName("LastName: " + i);
			s.setCity("City: " + i);
			s.setState("State: " + i);
			s.setStudentId(100+ i);
			s.setHasLaptop(true);
			
			studentList.add(s);		
		}
		
		return studentList;
		
	}

	public static List<Employee> getEmployeeData() {
		List <Employee> employeeList = new ArrayList <>();
		
		Employee e = null;
		for(int i=0; i<5; i++) {
			e = new Employee ();
			e.setFirstName("FirstName: " + i);
			e.setLastName("LastName: " + i);
			e.setCity("City: " + i);
			e.setState("State: " + i);
			e.setEmpId(100+ i);
			e.setHasLaptop(true);
			
			employeeList.add(e);		
		}
		
		return employeeList;
		
	}

}
