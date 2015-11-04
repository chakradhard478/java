package org.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.entities.Order;
import org.jnit.entities.Reviewer;
import org.jnit.entities.Task;
import org.jnit.util.HibernateUtil;

public class CustomerMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//session.lo
		//select * from customer where id = ? //? with the id //resultset //to create the customer object
		Customer customer = (Customer) session.load(Customer.class, 87);
		System.out.println(customer.getName());
		System.out.println(customer.getOrdersPlaced().size());
		for (Order order : customer.getOrdersPlaced()) {
			System.out.println(order.getItem());
		}

		//we can also use session.get(), but it returns null is object is not found with the id we are looking for
		//Where as session.load throws ObjectNotFoundException if the object with the matching id is not found
		//session.load is more performant too..(http://www.mkyong.com/hibernate/different-between-session-get-and-session-load/)
		//Reviewer reviewer = (Reviewer) session.get(Reviewer.class,new Integer(1));
		
		Reviewer reviewer = (Reviewer) session.load(Reviewer.class,10);
		System.out.println(reviewer.getName());
		for (Task t : reviewer.getTasks()) {
			System.out.println(t.getTaskName());
		}
		session.close();
		sessionFactory.close();
	}
}
