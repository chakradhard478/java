package org.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Employee;
import org.jnit.util.HibernateUtil;
//both session.update and session.merge re attaches the detached object to your session
//update - when you do a session.update on a detached object then it will fail if there is similar object in new session 
//update - when you do a session.update in a new session for a detached object where there is no similar object then it fires an update
//merge - when you do a session.merge on a detached object then the values get merged if there is similar object in session and during transaction commit an update query is fired
//merge - when you do a session.merge in a new session for a detached object where there is no similar object then it fires an update as well
//SaveOrUpdate = check if the entity exists it just updates it, if not creates it
//Save = saves a new entity

public class UpdateVsMerge {

	public static void performUpdate() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, new Long(4));//object loaded with one session
		session.close();//session is closed emp now is detached
		emp.setName("Jeff");//here change the name for my detached object
		Session session2 = sessionFactory.openSession();//created a new session
		session2.beginTransaction();
		//Employee emp1 = (Employee) session2.get(Employee.class, new Long(4));//loaded the same row from the db in a different session
		session2.update(emp);//trying to update the object loaded in session 1 with session 2 which wont work
		//System.out.println(emp1.getName());
		session2.getTransaction().commit();
		session2.close();
		sessionFactory.close();
	}

	public static void performMerge() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, new Long(4));//loaded object in session 1
		session.close();//closed session 1 now emp is in detached state
		emp.setName("Harry");//changing the name of my object in detached state
		Session session2 = sessionFactory.openSession();//opening a new sesion session 2
		session2.beginTransaction();
		Employee emp1 = (Employee) session2.get(Employee.class, new Long(4));//loaded same record in a new session
		System.out.println(emp1.getName());
		session2.merge(emp);//now doing the merge with the object loaded with first session
		System.out.println(emp1.getName());//here the changes are merged between both the objects
		session2.getTransaction().commit();//here hibernate fires an update query to persist it in the db
		session2.close();
		sessionFactory.close();
	}

	public static void main(String[] args) {
		//performUpdate();
		performMerge();
	}

}
