package org.jnit.main;

import org.hibernate.Session;
import org.jnit.inheritance.person.Student;
import org.jnit.util.HibernateUtil;

public class PersonMain {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 
        session.beginTransaction();
        
//        Person p = new Person();
//        p.setFirstName("Frank");
//        p.setLastName("Steve");
//        session.save(p);
        
        Student student = new Student();
        student.setInstructor("Joe");
        student.setFirstName("harry");
        student.setLastName("ried");  
        student.setStandard("1");
        session.save(student);
        
        
//        Teacher teacher = new Teacher();
//        teacher.setMainSubject("java");
//        teacher.setSalary(1000);
//        teacher.setFirstName("Gosling");
//        teacher.setType("Employee");
//        teacher.setLastName("opensource");
        
        //session.save(teacher);
        session.getTransaction().commit();
	}

}
