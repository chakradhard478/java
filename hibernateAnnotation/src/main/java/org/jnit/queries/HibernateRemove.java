package org.jnit.queries;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;

public class HibernateRemove {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria ct = session.createCriteria(Customer.class);
		ct.add(Restrictions.eq("customerId", 21));
		Customer customer = (Customer) ct.uniqueResult();
		session.delete(customer);
		session.close();
		sessionFactory.close();
	}

}
