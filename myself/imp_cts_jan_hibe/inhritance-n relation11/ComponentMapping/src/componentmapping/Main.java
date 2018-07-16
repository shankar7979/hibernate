package componentmapping;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address
					("Sect-12", "Noida", "up", "12995");
			Student student = new Student
					("Ram", address);
			session.save(student);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

}
