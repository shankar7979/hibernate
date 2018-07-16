package org.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static Configuration configuration;
	static SessionFactory factory;

	static {
		configuration = new Configuration().configure();
	}

	public static SessionFactory retrieveSF() {
		if (factory == null)
			factory = configuration.
		buildSessionFactory();
		return factory;

	}

}
