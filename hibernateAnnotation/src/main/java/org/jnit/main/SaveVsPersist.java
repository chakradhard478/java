package org.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jnit.entities.Employee;
import org.jnit.util.HibernateUtil;
//save vs persist both can be used save an entity to the database
//session.persist doesn't return anything
//session.save returns primary key
//session.persist doesn't return the primary key
public class SaveVsPersist {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setName("Jim");
		e1.setActive(true);
		e1.setDesignation("Sr.Manager");
		Long primaryKey = (Long) session.save(e1);
		System.out.println(primaryKey);
		//session.persist(e1);
		tran.commit();
		session.close();
		sessionFactory.close();
	}

}
