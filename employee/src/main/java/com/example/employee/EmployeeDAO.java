package com.example.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAO {
	private SessionFactory sessionFactory;
	public EmployeeDAO() {
		sessionFactory=Utility.getSessionFactory();
	}
	private Session getSession() {
		return sessionFactory.openSession();
	}
	public void insert(Employee e) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		session.persist(e);
		transaction.commit();
		session.close();
	}
	public Employee find(int id) {
		Session session=getSession();
		Employee employee=session.find(Employee.class, id);
		session.close();
		return employee;
	}
	public List<Employee> findAll(){
		Session session=getSession();
		List<Employee> employees=session.createQuery("From Employee",Employee.class).getResultList();
		session.close();
		return employees;
	}
	public Employee update(Employee e) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Employee employee=session.merge(e);
		transaction.commit();
		session.close();
		return employee;
	}
	public void delete(int id) {
		Session session=getSession();
		Employee employee=session.find(Employee.class, id);
		Transaction transaction=session.beginTransaction();
		session.remove(employee);
		transaction.commit();
		session.close();
	}
}
