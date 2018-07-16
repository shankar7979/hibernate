import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import bean.Emp;


public class testEmp {
	public static void main(String[] args) {
		Configuration cfg=new AnnotationConfiguration();
		cfg=cfg.configure();
		Session ses=cfg.buildSessionFactory().openSession();
		
		Emp e=new Emp();
		e.setName("aaaaa");
		
		ses.save(e);
		ses.flush();
		ses.close();
		System.out.println("record added");
		
		
	}

}
