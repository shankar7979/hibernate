import org.com.bean.Address;
import org.com.bean.Project;
import org.com.bean.Student;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class ProjectMain {

	public static void main(String[] args) {
		Configuration cfg=new AnnotationConfiguration().
				configure();
		
Session session=cfg.buildSessionFactory().openSession();
	
Project prj=new Project();

prj.setId(1001);
prj.setName("web learning");

prj.setDuration(10);
prj.setLocation("chennai");
prj.setCost(23000);



session.getTransaction().begin();

	session.save(prj);
	session.getTransaction().commit();
	System.out.println("Record added");

	
	
	
	
	
	
	
	
	}
}
