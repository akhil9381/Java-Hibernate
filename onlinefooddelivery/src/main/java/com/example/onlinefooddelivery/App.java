package com.example.onlinefooddelivery;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		SessionFactory sessionFactory=Utility.getSessionFactory();
    		Session session=sessionFactory.openSession();
    		Order order=new Order();
    		order.setId(1);
    		order.setCustomer_name("Javid");
    		order.setFood_item("Burger");
    		order.setOrder_date(LocalDate.parse("2026-06-19"));
    		order.setQuantity(2);
    		order.setTotal_amount(400);
    		order.setOrder_status(false);
    		Transaction transaction=session.beginTransaction();
    		session.persist(order);
    		transaction.commit();
    		session.close();
    		Utility.shutdown();
    		
    }
}
