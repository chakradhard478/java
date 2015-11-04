package org.chakri.hibernate.dto;

import java.util.Date;

import org.chakri.java.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest 
{
	public static void main(String[] args) 
	{
		UserDetails user1 = new UserDetails();
//		user.setUserid(1);
		user1.setUsername("First User");
		
		UserDetails user2 = new UserDetails();
		user2.setUsername("Second User");
//		user.setAddress("First User Address");
//		user.setJoinedDate(new Date());
//		user.setDescription("First User Description");	
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(user1);
		s.save(user2);
		s.getTransaction().commit();
		s.close();
		
//		user = null;
//		Session s1 = sf.openSession();
//		s1.beginTransaction();
//		user = (UserDetails)s1.get(UserDetails.class,1);
//		System.out.println("User Name retrived is "+user.getUsername());
//		
		
	}

}
