package org.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.entities.PhoneInformation;
import org.jnit.util.HibernateUtil;

public class CustomerDbservice {

	public static void main(String[] args) {
		
		getCustomerFromDB(86);
		//UpdateCustomerToDB(81);
		//deleteCustomerFromDB(82);
		//createCustomerWithPhone();
	}
	
	public static void createCustomer(){	//Cofiguration->SessionFactory->session->perform a database operation

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//insert a record to the database
		Customer customer = new Customer();
		customer.setName("Ramu");
		customer.setCountry("IND");
		customer.setCity("Hyderabad");
		customer.setState("TL");
		customer.setZipCode("522002");
		customer.setStreet("Ameerpet");
		
		session.save(customer);//save the customer record to the database
		session.close();
		sf.close();

	}
	
	public static void createCustomerWithPhone(){	//Cofiguration->SessionFactory->session->perform a database operation

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		//insert a record to the database
		Customer customer = new Customer();
		customer.setName("Toby");
		customer.setCountry("IND");
		customer.setCity("Hyderabad");
		customer.setState("TL");
		customer.setZipCode("522002");
		customer.setStreet("Ameerpet");
		
		PhoneInformation p = new PhoneInformation();
		p.setCell("1234567890");
		p.setCustomer(customer);
		customer.setPhoneInfo(p);
		
		session.save(customer);//save the customer record to the database
		//session.save(p);
		session.close();
		sf.close();

	}

	//load - throws ObjectNotFoundException if the record doesn't exist in the db
	//get - returns null
	public static void getCustomerFromDB(int id){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Customer customer = (Customer) session.load(Customer.class, id);
		System.out.println(customer);
		session.close();
		System.out.println(customer);
		sf.close();
		
	}
	//save = insert
	//update = update
	//saveOrUpdate  insert and update
	public static void UpdateCustomerToDB(int id){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		customer.setStreet("Hudson St");
		customer.setCity("JerseyCity");
		session.update(customer);
		session.flush();//hibernate tries to queue the queries and will try to push them at once
		session.close();
		sf.close();
		
	}
	
	//delete
	public static void deleteCustomerFromDB(int id){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.delete(customer);
		session.flush();
		session.close();
		sf.close();
		
	}



}
