package com.hibernate.embedding;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class Main {
	public static void main(String[] args){
		Address address = new Address();
		address.setCity("HYD");
		address.setPincode("500081");
		address.setState("TELANGANA");
		address.setStreet("Madhapur");
		User user = new User();
		user.setName("Swastik");
		user.setAddress(address);
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("com/hibernate/embedding/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userID", 1));
		User user1=(User) criteria.uniqueResult();
		System.out.println(user1.getUserName());*/
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
