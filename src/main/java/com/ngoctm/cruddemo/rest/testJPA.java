package com.ngoctm.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoctm.cruddemo.entity.Employee;
import com.ngoctm.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/jpa")
public class testJPA {

	@Autowired
	@Qualifier("employeeServiceImplJPA")
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public List<Employee> list(){
		
		return employeeService.findAll();
	}
}
