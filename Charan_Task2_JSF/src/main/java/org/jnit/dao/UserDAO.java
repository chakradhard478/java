package org.jnit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jnit.entity.User;
import org.jnit.hibUtils.HibernateUtils;


public class UserDAO {
	Session session = HibernateUtils.getSessionFactory().openSession();
	
	
	public void save(User user){
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<User> getallUsers() {
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).setCacheable(true);
		List<User>user = criteria.list();
		return user;
	}
	
	
	
	public List<User> searchByCity(String passedcity ){
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("city",passedcity));
		List<User> user = criteria.list();
		return user;
		
	}
	
	public void updateUser(User user) {
		
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteUser(User user) {
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		
	}
}
