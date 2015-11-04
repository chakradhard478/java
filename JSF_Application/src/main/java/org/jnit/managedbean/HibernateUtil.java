package org.jnit.managedbean;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionfactory;

	public static SessionFactory getsf() {
		return sessionfactory;
	}

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		sessionfactory = configuration.buildSessionFactory(builder.build());
	}
}
