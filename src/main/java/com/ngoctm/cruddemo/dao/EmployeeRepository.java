package com.ngoctm.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngoctm.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
