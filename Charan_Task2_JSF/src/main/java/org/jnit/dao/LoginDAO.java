package org.jnit.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jnit.entity.Login;
import org.jnit.entity.Login;
import org.jnit.hibUtils.HibernateUtils;

public class LoginDAO {
	
	
	Session session = HibernateUtils.getSessionFactory().openSession();
	
	public boolean loginValidator(String uname, String password) {
		  Criteria criteria = session.createCriteria(Login.class);
		  criteria.add(Restrictions.eq("userName", uname));
		  Login login = (Login) criteria.uniqueResult();
		  session.close();
		  if (login == null) {
		   return false;
		  } else {
		   if (login.getPassword().equals(password)) {
		    return true;
		   }
		  }
		  return false;

		 }
		
		
		
	}


