package com.ngoctm.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoctm.cruddemo.dao.EmployeeRepository;
import com.ngoctm.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImplJPA implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
