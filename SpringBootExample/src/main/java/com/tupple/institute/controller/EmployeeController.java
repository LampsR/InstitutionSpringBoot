package com.tupple.institute.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tupple.institute.data.ResponseDataSource;
import com.tupple.institute.exception.ServiceException;
import com.tupple.institute.model.Employee;
import com.tupple.institute.model.EmployeeDataRequest;
import com.tupple.institute.model.GetEmployeeByIdResponse;
import com.tupple.institute.model.GetEmployeeListResponse;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ResponseEntity<GetEmployeeListResponse> EmployeeList(){
		GetEmployeeListResponse response = new GetEmployeeListResponse();
		response.setEmployeeList(ResponseDataSource.getEmployeeData());
		
		if(null!=response.getEmployeeList()&& !response.getEmployeeList().isEmpty()) {
			return new ResponseEntity <> (response, HttpStatus.OK);
		}else {
			throw new ServiceException("DATA_NOT_FOUND");
		}
	}
	
	@RequestMapping(value = "employeeDataById/{empId}", method =RequestMethod.GET)
	public ResponseEntity <GetEmployeeByIdResponse> employeeDataById(@PathVariable(value = "empId")int empId){
		GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		
		if(StringUtils.isEmpty(empId)) {
			throw new ServiceException("EMP_ID_NOT_FOUND");
		}
		
		List <Employee> employeeList = ResponseDataSource.getEmployeeData();
		Optional <Employee> employeeOptional = employeeList
				.stream()
				.filter(Employee -> empId == Employee.getEmpId())
				.findFirst();
		
		if(!employeeOptional.isPresent()) {
			response.setErrorMessage("Employee_ID_NOT_FOUND");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}else {
			response.setEmployee(employeeOptional.get());
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<GetEmployeeListResponse> addEmployee(@RequestBody EmployeeDataRequest EmployeeDataRequest){
		GetEmployeeListResponse response = new GetEmployeeListResponse();
		if(null == EmployeeDataRequest
				|| null == EmployeeDataRequest.getEmployee()
				|| StringUtils.isEmpty(EmployeeDataRequest.getEmployee().getFirstName())) {
			response.setErrorMessage("Employee details not found in request.");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		List <Employee> employeeList = ResponseDataSource.getEmployeeData();
		employeeList.add(EmployeeDataRequest.getEmployee());
		response.setEmployeeList(employeeList);
		return new ResponseEntity <> (response, HttpStatus.OK);
	}
}
