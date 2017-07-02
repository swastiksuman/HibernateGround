package com.hibernate.onetoone;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class Main {
	public static void main(String[] args){
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Gixxer");
		User user = new User();
		user.setUserName("Swastik");
		user.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("com/hibernate/onetoone/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userID", 1));
		User user1=(User) criteria.uniqueResult();
		System.out.println(user1.getUserName());*/
		
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
