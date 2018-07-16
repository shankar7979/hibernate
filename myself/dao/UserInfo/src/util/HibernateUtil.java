package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	static SessionFactory sf=null;
	
	static{
	sf=new Configuration().configure()
			.buildSessionFactory();	
	}
	
public static SessionFactory
      getSessionFactory(){
	return sf;
}

}
