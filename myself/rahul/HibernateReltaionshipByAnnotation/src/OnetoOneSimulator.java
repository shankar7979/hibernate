import onetoone.Customer;
import onetoone.Phone;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class OnetoOneSimulator {

	public static void main(String[] args) {
		
		Configuration cfg=new AnnotationConfiguration().configure();
		Session session=cfg.buildSessionFactory().openSession();
		
		Customer ctr=new Customer();
		Phone phone=new Phone();
		
		ctr.setName("ram kumar");
		//ctr.setId(1007);
		ctr.setPhone(phone);
		
		phone.setModel("samsung");
		//phone.setId(3456);
		
		session.getTransaction().begin();
		session.save(ctr);
		session.save(phone);
				
		session.getTransaction().commit();
		System.out.println("Record added");
		
	}
}
