package com.ngoctm.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoctm.cruddemo.dao.EmployeeDAO;
import com.ngoctm.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employee")
	public List<Employee> getList(){
		
		return employeeDAO.findAll();
		
	}
	
	
}
