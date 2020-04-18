package com.tupple.institute.data.repoInterface;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tupple.institute.model.StudentTb;

public interface StudentRepository extends CrudRepository <StudentTb, Long>{
	
	@Query(value="SELECT * FROM StudentTb WHERE hasLaptop = true", nativeQuery = true)
	List<StudentTb> findByHasLaptop();
	
	
	@Query(value="SELECT * FROM StudentTb" , nativeQuery = true)
	List<StudentTb> findAllStudents();
	
//	public List <StudentTb> findByHasLaptop();
//	
//	@Query("Select * FROM StudentTb WHERE hasLaptop=true")
//	

}

