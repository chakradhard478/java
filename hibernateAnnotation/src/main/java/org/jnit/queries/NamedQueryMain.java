package org.jnit.queries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.entities.Employee;
import org.jnit.util.HibernateUtil;

public class NamedQueryMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//Hql with named query
		Query query = session.getNamedQuery("findEmployeeByName");
		query.setString("name", "Jim");
		List<Employee> list = query.list();
		if (!list.isEmpty()) {
			Employee employee = (Employee) list.get(0);
			System.out.println(employee.getName());
		}
		//native sql with named query
		Query customerQuery = session.getNamedQuery("findCustomerByCity");
		customerQuery.setString("city", "Parlin");
		List<Customer> clist = customerQuery.list();
		if (!clist.isEmpty()) {
			for (Customer customer : clist) {
				System.out.println(customer.getName());				
			}
		}
		//calling stored proc in hibernate
		Query spquery = session.getNamedQuery("callFetchCustomers");
		spquery.setParameter("customerId", 1);
		List<Customer> result = spquery.list();
		if (!result.isEmpty()) {
			for (Customer customer : result) {
				System.out.println(customer.getName());				
			}
		}
		session.close();
		sessionFactory.close();


	}

}
