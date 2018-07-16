package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sf;

	public static SessionFactory retrieveSessionFactory() {
		Configuration cfg;
		cfg = new Configuration().configure();
		if (sf == null) {
			sf = cfg.buildSessionFactory();
		}
		return sf;

	}

}
