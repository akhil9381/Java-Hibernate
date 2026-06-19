package com.example.librarymanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LibraryDAO {
	private SessionFactory sessionFactory;
	public LibraryDAO() {
		sessionFactory=Utility.getSessionFactory();
	}
	private Session getSession() {
		return sessionFactory.openSession();
	}
	public void insert(Library b) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		session.persist(b);
		transaction.commit();
		session.close();
	}
	public Library find(int id) {
		Session session=getSession();
		Library library=session.find(Library.class, id);
		session.close();
		return library;
	}
	public List<Library> findAll(){
		Session session=getSession();
		List<Library> books=session.createQuery("From Library",Library.class).getResultList();
		session.close();
		return books;
	}
	public Library update(Library b) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Library book=session.merge(b);
		transaction.commit();
		session.close();
		return book;
	}
	public void delete(int id) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Library book=session.find(Library.class, id);
		session.remove(book);
		transaction.commit();
		session.close();
	}
}
