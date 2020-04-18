package com.tupple.institute.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tupple.institute.data.repoInterface.StudentRepository;
import com.tupple.institute.model.StudentTb;

public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	public StudentRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public void addStudent (StudentTb studentTb) {
		studentRepo.save(studentTb);
	}
	
	public void findById(Long id) {
		studentRepo.findById(id);
	}

}
