package org.jnit.queries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;
//positional parameters = ? replace them with index
//named parameters= :parmaterName relace it with setParameter

public class HQLMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer where name=?");
		query.setString(0, "Suresh");
		Customer customer = (Customer) query.uniqueResult();
		System.out.println(customer.getState());

		// Query cityQuery =
		// session.createQuery("from Customer where name like '%:personName%'");
		// cityQuery.setParameter("personName", "chris");
		// List<Customer>customers = cityQuery.list();
		// for(Customer cust : customers){
		// System.out.println(cust.getName());
		// }

		Query q1 = session.createQuery("from Customer where customerId < :namedCustomerId");
		q1.setParameter("namedCustomerId", 3);
		List<Customer> customers = q1.list();
		for (Customer cust : customers) {
			System.out.println(cust.getName());
		}
		//native sql
		SQLQuery sqlQuery = session.createSQLQuery("select * from customer").addEntity(Customer.class);
		List<Customer> customerList = sqlQuery.list();
		for (Customer cust : customerList) {
			System.out.println(cust.getCity());
		}
		session.close();
		sessionFactory.close();

	}

}
