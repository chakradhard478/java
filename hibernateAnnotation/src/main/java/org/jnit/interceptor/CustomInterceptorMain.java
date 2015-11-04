package org.jnit.interceptor;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jnit.entities.Employee;
import org.jnit.util.HibernateUtil;

public class CustomInterceptorMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.withOptions()
				.interceptor(new CustomerInterceptor()).openSession();
		session.beginTransaction();
		Criteria ct = session.createCriteria(Employee.class);
		ct.add(Restrictions.eq("employeeId", new Long(5)));
		Employee employee = (Employee) ct.uniqueResult();
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
