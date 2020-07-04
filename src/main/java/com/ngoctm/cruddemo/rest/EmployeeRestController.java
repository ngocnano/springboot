package com.ngoctm.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ngoctm.cruddemo.entity.Employee;
import com.ngoctm.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getList(){
		
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if(employee == null) {
			
			throw new RuntimeException("Not Found Employee");
		}
		
		return employee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if(employee == null) {
			
			throw new RuntimeException("Not Found Employee");
		}
		
		employeeService.delete(employee);
		
		System.out.println(employee);
		
		return "Delete employee" + id;
		
	}
	
}
