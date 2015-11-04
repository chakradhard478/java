package org.jnit.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jnit.entities.Reviewer;
import org.jnit.entities.Task;
import org.jnit.util.HibernateUtil;

public class ReviewerTaskMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Reviewer reviewer = new Reviewer();
		reviewer.setName("Mike");
		Set<Task> tasks = new HashSet<>();
		Task t1 = new Task();
		t1.setTaskName("Purchasing");
		Task t2 = new Task();
		t2.setTaskName("Selling");
		tasks.add(t1);
		tasks.add(t2);
		reviewer.setTasks(tasks);
		try {
			session.save(reviewer);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
