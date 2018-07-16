import java.util.List;
import java.util.Scanner;

import org.com.model.Customer;
import org.com.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;

public class CustomerMain {

	public static void main(String[] args) {

		Configuration cfg;
		SessionFactory sf;
		Session session;
		Transaction tr;

		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();

		Scanner sc = new Scanner(System.in);

		Customer cts1 = new Customer();
		System.out.println("Enter id ");
		cts1.setCid(sc.nextInt());
		System.out.println("Enter country ");
		cts1.setCountry(sc.next());
		System.out.println("Enter name ");
		cts1.setName(sc.next());
		System.out.println("Enter age ");
		cts1.setAge(sc.nextInt());

		tr = session.beginTransaction();
		session.save(cts1);

		tr.commit();

		System.out.println("Record added");

		System.out.println("Find employee");
		System.out.println("Enter id ");

		cts1.setCid(sc.nextInt());
		System.out.println("Enter country ");
		cts1.setCountry(sc.next());

		Customer cts2 = (Customer) session.get(Customer.class, cts1);

		if (cts2 != null) {
			System.out.println("Customer found");
			System.out.println("id " + cts2.getCid());
			System.out.println("name " + cts2.getName());
			System.out.println("country " + cts2.getCountry());
			System.out.println("age " + cts2.getAge());
		} else {
			System.out.println("Record not found");
		}
	}

}
