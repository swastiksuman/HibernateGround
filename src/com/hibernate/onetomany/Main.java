package com.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {
	public static void main(String[] args){
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Gixxer");
		User user = new User();
		user.setUserName("Swastik");
		user.getVehicle().add(vehicle);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Pep+");
		user.getVehicle().add(vehicle2);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("com/hibernate/onetomany/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
