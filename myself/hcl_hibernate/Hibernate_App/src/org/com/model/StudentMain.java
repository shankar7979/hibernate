package org.com.model;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

public class StudentMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sf = configuration.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tr=null;
		try {
		 tr= session.beginTransaction();

			Student st1 = new Student();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter roll");
			st1.setRoll(scanner.nextInt());
			System.out.println("Enter name");
			scanner.nextLine();

			st1.setName(scanner.nextLine());
			System.out.println("Enter subject");
			st1.setSubject(scanner.next());

			System.out.println("Enter city");
			st1.setCity(scanner.next());

			tr.begin();

			session.save(st1);
			tr.commit();

			System.out.println("Record added");

			Query qr = session.createQuery("from Student");

			List<Student> list1 = qr.list();
			for (Student student : list1) {
				System.out.println(student.getRoll() + "\t" + student.getName()
						+ "\t" + student.getSubject() + "\t"
						+ student.getCity());
			}
		}			
		
		catch(ConstraintViolationException e){
			System.out.println("You have added duplicate key");
		}
		
		catch (HibernateException e) {
			System.out.println(e);
			tr.rollback();
		}
		finally{
			session.close();
			sf.close();
		}

	}
}
