package org.jnit.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.entities.Customer;
import org.jnit.util.HibernateUtil;

//querycache is like hashmap
//key is ("from Customer where name=",["benoy"] -> [12]) key is query criteria, value is primary key of the result
public class QueryLevelCacheMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer where name=?");//HQL
		query.setCacheable(true);
		query.setString(0, "Benoy");
		Customer customer = (Customer) query.uniqueResult();
		System.out.println(customer.getState());
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Query query2 = session2.createQuery("from Customer where name=?");
		//setCacheable not only caches the query but also looks at second level cache
		//we should be careful with query cache as queries generally endup in lot of results and updates to the data also requires updates to the cache
		query2.setCacheable(true);
		query2.setString(0, "Benoy");
		Customer customer2 = (Customer) query2.uniqueResult();
		System.out.println(customer2.getState());

		session2.close();
		
		sessionFactory.close();

	}

}
