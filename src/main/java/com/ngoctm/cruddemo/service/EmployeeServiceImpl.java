package com.ngoctm.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngoctm.cruddemo.dao.EmployeeDAO;
import com.ngoctm.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> list = employeeDAO.findAll();
		return list;
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		Employee employee = employeeDAO.findById(id);
		
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {

        employeeDAO.save(employee);
		
	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		
		employeeDAO.delete(employee);
		
	}

}
