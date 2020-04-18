package com.tupple.institute.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tupple.institute.data.repoInterface.StudentRepository;
import com.tupple.institute.model.Employee;
import com.tupple.institute.model.Student;
import com.tupple.institute.model.StudentTb;

@Service
public class ResponseDataSource {
	
	@Autowired
	StudentRepository studentRepo;
	
	public static List <Student> getStudentData(){
		List <Student> studentList = new ArrayList <>();
		
		Student s = null;
		for(int j=0; j<5; j++) {
			
			for(int i=0; i<j+4; i++) {
				s = new Student ();
				s.setFirstName("FirstName: " + i);
				s.setLastName("LastName: " + i);
				s.setCity("City: " + i);
				s.setState("State: " + i);
				s.setStudentId(100+ i);
				s.setHasLaptop(true);
				s.setClassId("class"+ j);
				
				studentList.add(s);		
			}
			
		}
		
		
		return studentList;
		
	}
	
	public List <Student> getStudentDataFromDB(){
		List<Student> studnetList = new ArrayList<>();
		Iterable<StudentTb> studentTbIterator = studentRepo.findAll();
		Student s = null;
		if(null==studentTbIterator) {
			return null;
		}
		for(StudentTb studentTb : studentTbIterator) {
			s = new Student();
			s.setFirstName(studentTb.getFirstName());
			s.setLastName(studentTb.getLastName());
			s.setAddress(studentTb.getAddress());
			s.setClassId(studentTb.getClassId());
			s.setHasLaptop(studentTb.isHasLaptop());
			s.setStudentId(studentTb.getStudentId());
			studnetList.add(s);
			
		}
		return studnetList;
	}
	
	public StudentTb addStudentToDB(Student s) {
		StudentTb studentTb = new StudentTb();
		studentTb.setFirstName(s.getFirstName());
		studentTb.setLastName(s.getLastName());
		studentTb.setHasLaptop(s.isHasLaptop());
		studentTb.setAddress(s.getAddress());
		studentTb.setClassId(s.getClassId());
		
		return studentRepo.save(studentTb);
	}

	public static List<Employee> getEmployeeData() {
		List <Employee> employeeList = new ArrayList <>();
		
		Employee e = null;
		
		for(int j=0; j<5; j++) {
			for(int i=0; i<5; i++) {
				e = new Employee ();
				e.setFirstName("FirstName: " + i);
				e.setLastName("LastName: " + i);
				e.setCity("City: " + i);
				e.setState("State: " + i);
				e.setEmpId(200+ i);
				e.setHasLaptop(true);
				e.setClassId("class"+i);
				
				employeeList.add(e);	
			}
		}
		
		return employeeList;
		
	}

}
