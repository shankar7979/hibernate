import org.com.model.Student;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;


public class Studentbatch {

	public static void main(String[] args) {
SessionFactory	sf=HibernateUtil.retrieveSessionFactory();

	Session session=sf.openSession();
	
		Query qr = session
			.createSQLQuery("insert into Student values(109,'mohan',77)");
	
		int x = qr.executeUpdate();
	System.out.println(x + "Record added  ");

	sf.close();
	
	System.out.println("Record added");
	
	session.close();
	sf.close();
	
		
	
	
	
	}
}
