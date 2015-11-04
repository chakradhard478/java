package org.jnit.queries;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.jnit.entities.Customer;
import org.jnit.entities.Order;
import org.jnit.entities.OrderStatus;
import org.jnit.entities.PhoneInformation;
import org.jnit.util.HibernateUtil;
//criteria API
//HQL- Hibernate Query lanuage
public class AssociationCriteriaQueryMain {

	public static void main(String[] args) {
		//load all customers who has order status set to new
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.createCriteria("ordersPlaced").add(Restrictions.eq("status", OrderStatus.NEW));
		List<Customer>customers = criteria.list();
		System.out.println(customers.size());
		//load all customers whose name starts with J and an item in their order starts with c
		Criteria criteriaX = session.createCriteria(Customer.class);
		criteriaX.add(Restrictions.like("name", "J%"));
		criteriaX.createCriteria("ordersPlaced").add(Restrictions.like("item", "C%"));
		List<Customer>customersx = criteriaX.list();
		System.out.println(customersx.size());
		for (Customer customer : customersx) {
			System.out.println(customer.getName());
			for (Order order : customer.getOrdersPlaced()) {
				System.out.println(order.getItem());  
			}
		}
		session.close();
		sessionFactory.close();

	}

}
