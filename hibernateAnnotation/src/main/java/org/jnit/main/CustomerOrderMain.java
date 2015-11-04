package org.jnit.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jnit.entities.Customer;
import org.jnit.entities.Order;
import org.jnit.entities.OrderStatus;
import org.jnit.entities.PhoneInformation;
import org.jnit.util.HibernateUtil;

public class CustomerOrderMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("Marini");
		customer.setCity("Lewisville");
		customer.setCountry("US");
		customer.setState("TX");
//		PhoneInformation phoneInfo = new PhoneInformation();
//		phoneInfo.setCustomer(customer);
//		phoneInfo.setCell("6666666666");
//		phoneInfo.setHome("5555555555");
//		customer.setPhoneInfo(phoneInfo);
		List<Order>orders = new ArrayList<>();
		Order order =new Order();
		order.setItem("Calculator");
		order.setCustomer(customer);
		order.setStatus(OrderStatus.PLACED);
		Order order1 =new Order();
		order1.setItem("Book");
		order1.setCustomer(customer);
		order1.setStatus(OrderStatus.PLACED);
		
		orders.add(order1);
		orders.add(order);
		
		customer.setOrdersPlaced(orders);
		session.save(customer);//mutliple session.save's(if you dont use cascade)
		tran.commit();
		session.close();
		sessionFactory.close();
	}

}
