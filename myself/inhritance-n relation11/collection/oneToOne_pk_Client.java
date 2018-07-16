import one_to_one_primary_key.Customer;
import one_to_one_primary_key.Home;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class oneToOne_pk_Client {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Home home = new Home();
		Customer customer = new Customer();

		customer.setName("suresh kumar");

		home.setName("my home");

		customer.setHome(home);

		session.getTransaction().begin();

		session.save(customer);
		session.save(home);

		session.getTransaction().commit();

	}

}
