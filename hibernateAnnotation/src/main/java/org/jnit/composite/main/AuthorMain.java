package org.jnit.composite.main;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jnit.composite.Author;
import org.jnit.composite.AuthorId;
import org.jnit.util.HibernateUtil;

public class AuthorMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		Author a = new Author();
//		AuthorId aid = new AuthorId("Harry","Dietel","How to Program Java");
//		a.setAuthorId(aid);
//		a.setIsbn("012345");
//		a.setMiddleName("Henry");
//		session.save(a);
		Criteria criteria = session.createCriteria(Author.class);
		criteria.add(Restrictions.eq("middleName", "mary"));
		Author a1 = (Author) criteria.uniqueResult();
		a1.setIsbn("123456");
		session.update(a1);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}
}
