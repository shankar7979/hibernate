import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class testEmp {
	public static void main(String[] args) {
		Configuration cf=new AnnotationConfiguration().configure();
		
		SessionFactory fact=cf.buildSessionFactory();
		Session ses=fact.openSession();
		
		Emp e=new Emp();
		e.setId(11);
		e.setName("sohan");
		ses.save(e);
		ses.flush();
		ses.close();
	}

}
