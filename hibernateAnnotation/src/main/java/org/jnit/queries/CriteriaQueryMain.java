package org.jnit.queries;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.jnit.entities.Customer;
import org.jnit.entities.PhoneInformation;
import org.jnit.util.HibernateUtil;
//criteria API
//HQL- Hibernate Query lanuage
public class CriteriaQueryMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		//criteria.add(Restrictions.like("name", "chris", MatchMode.ANYWHERE));
		criteria.add(Restrictions.eq("name", "suresh"));
		criteria.add(Restrictions.eq("city", "parlin"));
		List<Customer> customers = criteria.setCacheable(true).list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		Criteria phoneInfoCriteria = session.createCriteria(PhoneInformation.class);
		List<PhoneInformation> phoneInfos = phoneInfoCriteria.list();
		for (PhoneInformation info : phoneInfos) {
			System.out.println(info.getCell());
		}

		session.close();
		sessionFactory.close();

	}

}
