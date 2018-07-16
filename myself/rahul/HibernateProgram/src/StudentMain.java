import org.com.model.Student;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;


public class StudentMain {

	public static void main(String[] args) {
//	Configuration cfg=new Configuration();
//	cfg.configure();
//	
//	SessionFactory sf=cfg.buildSessionFactory();
SessionFactory	sf=HibernateUtil.retrieveSessionFactory();

	Session session=sf.openSession();
	
	Transaction tr=session.beginTransaction();
	
	
	Student st=new Student();
	
	st.setRoll(102);
	st.setName("shyam kumar");
	st.setMarks(55);
	
	//session.save(st);
	session.replicate(st,ReplicationMode.EXCEPTION);
	tr.commit();
	
	System.out.println("Record added");
	
	session.close();
	sf.close();
	
		
	
	
	
	}
}
