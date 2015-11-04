package org.jnit.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.inheritance.cd.CD;
import org.jnit.inheritance.cd.InternationalCD;
import org.jnit.inheritance.cd.SpecialEditionCD;
import org.jnit.util.HibernateUtil;

public class CDMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//CD cd = new CD("Grace", "Peter", new Date(), 8.44);
		SpecialEditionCD scd = new SpecialEditionCD("Joyful", "Mary",new Date(), 15.20, "widescreen");
		//InternationalCD icd = new InternationalCD("Grace Under Pressute","Rush", new Date(), 9.99, "Spanish", 4);
		
		//session.save(cd);
		session.save(scd);
		//session.save(icd);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
