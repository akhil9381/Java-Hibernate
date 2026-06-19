package com.example.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {
	private SessionFactory sessionFactory;
	public StudentDAO() {
		sessionFactory=Utility.getSessionFactory();
	}
	private Session getSession() {
		return sessionFactory.openSession();
	}
	public void insert(Student s) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		session.persist(s);
		transaction.commit();
		session.close();
	}
	public Student update(Student s) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Student student=session.merge(s);
		transaction.commit();
		session.close();
		return student;
	}
	public Student find(int id) {
		Session session=getSession();
		Student student=session.find(Student.class,id);
		session.close();
		return student;
	}
	public List<Student> findAll(){
		Session session=getSession();
		List<Student> students=session.createQuery("From Student",Student.class).getResultList();
		session.close();
		return students;
	}
	public void delete(int id) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Student student=session.find(Student.class,id);
		session.remove(student);
		transaction.commit();
		session.close();
	}
}
