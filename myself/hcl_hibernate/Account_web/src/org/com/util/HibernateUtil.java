package org.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sf;
    static	Configuration configuration;
	
	static{
		configuration=new Configuration().configure();
	}
	
	public static  SessionFactory getSF(){
		if(sf==null)
			sf=configuration.buildSessionFactory();
		
		return sf;
	}
	
}
