package org.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory;
	static Configuration configuration;
	static {
		
		configuration=new Configuration().configure();
	}
	
	public static SessionFactory retrieveSessionfactory(){
		if(sessionFactory==null)
			sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}
}
