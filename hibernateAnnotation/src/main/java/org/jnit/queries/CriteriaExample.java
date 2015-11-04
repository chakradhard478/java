package org.jnit.queries;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;

public class CriteriaExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer customer = new Customer();
		customer.setState("NJ");
		customer.setCity("Parlin");
		
		Criteria criteria = session.createCriteria(Customer.class);
		//criteria.add(Example.create(customer));
		criteria.add(Example.create(customer).excludeProperty("city"));//dont consider city
		List<Customer>customers  = criteria.list();
		for (Customer cust : customers) {
			System.out.println(cust.getName());
			System.out.println(cust.getCity());
			System.out.println(cust.getState());
			System.out.println(cust.getZipCode());
		}
		session.close();
		sessionFactory.close();
	}

}
