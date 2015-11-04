package org.jnit.jsf;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionfactory;
	 public static SessionFactory getsf(){
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
