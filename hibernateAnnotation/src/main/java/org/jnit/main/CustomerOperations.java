package org.jnit.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.entities.Order;
import org.jnit.entities.OrderStatus;
import org.jnit.entities.PhoneInformation;
import org.jnit.util.HibernateUtil;
//onetoone
//onetomany
//manytomany
public class CustomerOperations {

	//hibernate configuration, create a class, map the class to the db table, define the class in hibernate configuration file, obtain sessionfactory, open a session,db operation
	public static void main(String[] args) {
	//get a session
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
//		Customer c1 = new Customer();
//		c1.setName("Jimmy");
//		c1.setCity("Irving");
//		PhoneInformation pi = new PhoneInformation();
//		pi.setCell("1111111211");
//		pi.setWork("1211211221");
//		c1.setPhoneInfo(pi);
//		pi.setCustomer(c1);
//		List<Order>orders = new ArrayList<>();
//		Order o1 = new Order();
//		o1.setItem("Monitor");
//		o1.setStatus(OrderStatus.NEW);
//		o1.setCustomer(c1);
//
//		Order o2 = new Order();
//		o2.setItem("Keyboard");
//		o2.setStatus(OrderStatus.NEW);
//		o2.setCustomer(c1);
//		
//		orders.add(o1);
//		orders.add(o2);
//		c1.setOrdersPlaced(orders);

		
//		session.save(c1);//we need two session.save's if we dont have cascade set to all
		//load vs get
		//load will throw an ObjectNotFoundexception when there is no record with the primary key
		//get returns a null when the object you are looking for is not found in the database
		//Customer customer = (Customer) session.load(Customer.class, 97);
		Customer customer = (Customer) session.get(Customer.class, 100);
		System.out.println(customer.getName());
		System.out.println(customer.getOrdersPlaced().size());
		for (Order order : customer.getOrdersPlaced()) {
			System.out.println(order.getItem());
		}
		//customer.setName("Tomy");
		//session.update(customer);//saveOrUpdate(new+existing)
		//session.delete(customer);
		//session.flush();
		session.close();
		sf.close();

	}

}
