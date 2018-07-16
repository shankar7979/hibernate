import org.com.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;


public class StudentInterceptor {

	public static void main(String[] args) {
//	Configuration cfg=new Configuration();
//	cfg.configure();
//	
//	SessionFactory sf=cfg.buildSessionFactory();
SessionFactory	sf=HibernateUtil.retrieveSessionFactory();

	Session session=sf.openSession(new org.com.interceptor.StudentInterceptor());

	Transaction tr=session.beginTransaction();
	
	try{
	
	
	Student st=new Student();
	
	st.setRoll(102);
	st.setName("shyam kumar");
	st.setMarks(55);
	tr.begin();
	session.save(st);
	tr.commit();
	
	System.out.println("Record added");
	
	}
	catch (HibernateException e) {
         tr.rollback();
         System.out.println("Transaction is rollback ");
		session.close();
		sf.close();
}
		
	}
}
