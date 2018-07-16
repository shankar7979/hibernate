package org.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure();
		if (sf == null) {
			sf = cfg.buildSessionFactory();

		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}

}
