package com.hibernate.studentexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("Soujanya");
		Contact contact = new Contact();
		contact.setMobileNumber("7299942231");
		contact.setStudent(student);
		student.setRollNo(7);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("com/hibernate/studentexample/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*session.update(student);*/
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
