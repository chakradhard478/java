package org.jnit.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;

public class SessionUpdateMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer where name=?");
		query.setCacheable(true);
		query.setString(0, "Suresh");
		Customer customer = (Customer) query.uniqueResult();
		customer.setCity("MiddleTown");
		session.update(customer);
		customer.setState("CT");
		session.update(customer);
		session.getTransaction().commit();//here the changes are updated to the database with a update query
		session.close();
		sessionFactory.close();
	}

}
