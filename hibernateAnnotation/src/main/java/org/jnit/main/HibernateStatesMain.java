package org.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Employee;
import org.jnit.util.HibernateUtil;
//transient = not existent state - row or object doesn't exist in your database
//persistent = persist/save/saveOrUpdate = persistent state- object details are now in your database
//detached = object is not loner associated to a session - session.close() will make the object loaded in the session a detached object
//removed = it no longer exist in your database

public class HibernateStatesMain {

	public static void main(String[] args) {
		// SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// Session session = sessionFactory.openSession();
		// Transaction tran = session.beginTransaction();
		// Employee e = new Employee();
		// e.setName("Harish");
		// e.setActive(true);
		// e.setDesignation("Manager");
		// session.save(e);
		// tran.commit();
		// session.close();
		// sessionFactory.close();
		loadEmployee();
	}

	public static void loadEmployee() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, new Long(3));
		session.close();// emp object is now in detached state //in order to
						// make changes to the detached object you will have to
						// reattach the object to the session
		emp.setDesignation("Clerk");
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.update(emp);
		session2.getTransaction().commit();
		//session2.close();
		sessionFactory.close();
	}

}
