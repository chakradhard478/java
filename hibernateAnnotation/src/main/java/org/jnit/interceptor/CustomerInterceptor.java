package org.jnit.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.jnit.entities.Employee;

public class CustomerInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Employee) {
			Employee e = (Employee) entity;
			System.out.println(e.getName() + " is deleted");
		}
	}
	
	

}
