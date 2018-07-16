package pack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		Phone p = new Phone();
		p.setId(1007);
		p.setName("nokia");

		Customer c = new Customer();
		c.setName("mohan");
		c.setId(1009);
		c.setPhone(p);

		tr.begin();
		session.save(c);
		tr.commit();
		System.out.println("added");

	}

}
