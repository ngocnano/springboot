package com.ngoctm.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngoctm.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
		
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(employee);
	}

}
