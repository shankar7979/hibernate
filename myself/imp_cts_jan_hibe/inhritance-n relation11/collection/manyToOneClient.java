import many_to_one.Address;
import many_to_one.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class manyToOneClient {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Person person1 = new Person();
		Person person2 = new Person();

		Person person3 = new Person();

		Address address = new Address();

		person1.setName("ram");
		person2.setName("shyam");
		person3.setName("mohan");

		address.setCity("delhi");
		
		person1.setAddrress(address);
		person2.setAddrress(address);

		person3.setAddrress(address);

	session.getTransaction().begin();
	
	session.save(person1);
	session.save(person2);
	session.save(person3);
session.save(address);
	

session.getTransaction().commit();


	}
	
	
}
