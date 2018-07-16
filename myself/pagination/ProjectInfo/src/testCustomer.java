import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import cst.Customer;

public class testCustomer {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("project.cfg.xml");
		Session session = cfg.buildSessionFactory().openSession();
		session.getTransaction().begin();
		Customer cs = new Customer();
		cs.setCid(2001);
		cs.setCity("noida");
		cs.setCname("himanshu");
		cs.setCountry("india");
		 session.save(cs);
		 session.getTransaction().commit();
		 System.out.println("data added");
		Customer cs1 = new Customer();
		cs1.setCid(2001);
		cs1.setCountry("india");
		
		Customer css = (Customer) session.get(Customer.class, cs1);

			System.out.println("customer name" + css.getCname());
			System.out.println("customer id" + css.getCid());
			System.out.println("customer country" + css.getCountry());
			System.out.println("customer city" + css.getCity());
		
	}
}
