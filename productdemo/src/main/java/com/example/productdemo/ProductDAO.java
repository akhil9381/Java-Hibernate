package com.example.productdemo;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDAO {
	private SessionFactory sessionFactory;
	public ProductDAO() {
		sessionFactory=Utility.getSessionFactory();
	}
	private Session getSession() {
		return sessionFactory.openSession();
	}
	public void addProduct(Product p) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		session.persist(p);
		transaction.commit();
		session.close();
	}
	public Product find(int id) {
		Session session=getSession();
		Product p=session.find(Product.class, id);
		session.close();
		return p;
	}
	public List<Product> findAll(){
		Session session=getSession();
		List<Product> products=session.createQuery("From Product",Product.class).getResultList();
		session.close();
		return products;
	}
	public Product update(Product p) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Product product=session.merge(p);
		transaction.commit();
		session.close();
		return product;
	}
	public void delete(int id) {
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
		Product product=session.find(Product.class,id);
		session.remove(product);
		transaction.commit();
		session.close();
	}
}
