package com.ngoctm.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ngoctm.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		// using JPA
		
		//List<Employee> employees2 = entityManager.createQuery("from Employee", Employee.class).getResultList();
		
		return employees;
		
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		// using JPA
		
		//Employee employee2 = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
		
		// using JPA
		
		//Employee employee2 = entityManager.merge(employee);
		
		//employee.setId(employee2.getId());
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(employee);
		
		//entityManager.remove(employee);
	}

}
