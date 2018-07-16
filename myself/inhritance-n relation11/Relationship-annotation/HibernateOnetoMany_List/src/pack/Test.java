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

		Phone p1 = new Phone();
		p1.setId(1008);
		p1.setName("samsung");

		Customer c = new Customer();
		c.setName("mohan");
		c.setId(1009);

		c.addPhone(p);
		c.addPhone(p1);

		tr.begin();
		session.save(c);
		// em.persist(p);
		tr.commit();
		System.out.println("added");

	}

}
