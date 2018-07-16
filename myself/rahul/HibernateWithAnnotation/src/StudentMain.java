import org.com.bean.Address;
import org.com.bean.Student;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class StudentMain {

	public static void main(String[] args) {
	/*	Configuration cfg=new AnnotationConfiguration().
				configure("hibernate1.cfg.xml");*/
		
		Configuration cfg=new Configuration().
				configure("hibernate1.cfg.xml");
Session session=cfg.buildSessionFactory().openSession();
	
	Address addr1=new Address();
	addr1.setCity("new delhi");
	addr1.setState("delhi");
	addr1.setPin(5766788);
	
	Student st1=new Student();
	st1.setRoll(111);
	st1.setName("ram kumar");
	st1.setSubject("it");
	st1.setAddr(addr1);
	
	session.getTransaction().begin();

	session.save(st1);
	session.getTransaction().commit();
	System.out.println("Record added");
	}
}
