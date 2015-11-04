package org.jnit.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jnit.inheritance.vehicle.FourWheeler;
import org.jnit.inheritance.vehicle.TwoWheeler;
import org.jnit.inheritance.vehicle.Vehicle;
import org.jnit.util.HibernateUtil;

public class VehicleMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle v = new Vehicle();		
		v.setVehicleName("Ford");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Scooter");
		twoWheeler.setSteeringTwoWheeler("regular");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("car");
		fourWheeler.setSteeringFourWheeler("steering");
		
		session.save(v);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
