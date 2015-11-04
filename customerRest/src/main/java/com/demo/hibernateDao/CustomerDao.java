package com.demo.hibernateDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Customer;

@Repository
@Transactional
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		Query query = session().createQuery("from Customer");
		List<Customer> customers = query.list();
		return customers;
	}

	public Customer get(String customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, customerId);
		session.close();
		return customer;
	}

	public List<Customer> getbyCity(String city) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer where city=?");
		query.setParameter(0, city);
		List<Customer> customers = query.list();
		session.close();
		return customers;
	}

	public void deleteCust(String customerId) throws Exception {
		// Query
		// query=session.createQuery("delete from Customer where customerId=:customerId");
		// query.setString("customerId", customerId);
		// System.out.println("Row affcted: "+query.executeUpdate());
		// above code also working
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Customer customer = get(customerId);
		session.delete(customer);
		t.commit();
		session.close();
		System.out.println("Record delted for id: " + customerId);

	}

	public void save(Customer customer) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(customer);
		t.commit();
		session.close();
	}

}
