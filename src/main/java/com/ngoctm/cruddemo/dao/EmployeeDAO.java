package com.ngoctm.cruddemo.dao;

import java.util.List;

import com.ngoctm.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(Employee employee);
}
