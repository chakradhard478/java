package org.jnit.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;

public class FirstAndSecondLevelCacheMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//select * from customer where id = ? //? with the id //resultset //to create the customer object
		Customer customer = (Customer) session.load(Customer.class, new Integer(1));
		System.out.println(customer.getName());
		//customer.setName("Sunny");
		Customer customer1 = (Customer) session.load(Customer.class, new Integer(1));
		System.out.println(customer1.getName());
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Customer customerSess2 = (Customer) session2.load(Customer.class, new Integer(1));
		System.out.println(customerSess2.getName());
		
		session2.close();

		sessionFactory.close();
	}

}
