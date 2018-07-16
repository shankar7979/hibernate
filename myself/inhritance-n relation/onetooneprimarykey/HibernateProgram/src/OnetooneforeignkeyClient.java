import java.util.Date;

import onetooneforeignkey.Address;
import onetooneforeignkey.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class OnetooneforeignkeyClient {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

		Person person=new Person();
		Address addr=new Address();
		addr.setCity("gurgaon");
		addr.setState("haryana");
		
		
		person.setName("shyam");
		person.setAddr1(addr);
		
		
		
		Transaction tr = session.beginTransaction();

		session.save(person);
		tr.commit();
		//System.out.println("Record added");

	}
}
