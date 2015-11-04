package org.jnit.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;

//First level cache is provided by Hibernate
//First level cache is at session level
//Hibernate doesn't fire a second query for an object already present in the session with the same identifier
//if your load the object in two different sessions hibernate will fire a second query to load the object again
//Second level cache
//the objects are stored at your session factory level
//all the session will have access to that data
public class FirstLevelCacheMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//select * from customer where id = ? //? with the id //resultset //to create the customer object
		Customer customer = (Customer) session.load(Customer.class, new Integer(1));
		
		System.out.println(customer.getName());
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Customer customer1 = (Customer)session2.load(Customer.class, new Integer(1));
		System.out.println(customer1.getName());
		Customer customer2 = (Customer)session2.load(Customer.class, new Integer(1));
		System.out.println(customer2.getName());
		
		session2.close();	
		sessionFactory.close();
	}

}
