package org.com.model;

import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentMain {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.retrieveSessionfactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Address address = new Address();
		address.setStreet("1st main, omr road");
		address.setCity("chennai");
		address.setState("tamil nadu");

		Student student = new Student();
		// transient state

		student.setRoll(11111);
		student.setName("mohan  kumar");
		student.setSubject("history");

		student.setAddress(address);

		transaction.begin();

		session.save(student);
		// persistent state
		student.setName("sohan  kumar");

		transaction.commit();
		System.out.println("Record added");
	}
}
