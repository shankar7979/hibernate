import java.util.List;

import org.com.model.Address;
import org.com.model.Person;
import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneTest2 {

	public static void main(String[] args) {

		SessionFactory sf;
		Session session1;
		Transaction tr;
		Query qr;

		sf = HibernateUtil.getSF();
		session1 = sf.openSession();

		Person person = new Person();
		Address address = new Address();

//		person.setId(1001);
		person.setName("md. irfan ");

	//	address.setId(2003);

		address.setStreet("sector1");
		address.setCity("karimnagar");

		person.setAddress(address);

		// ===============
		Person person1 = new Person();
		Address address1 = new Address();

		//person1.setId(1002);
		person1.setName("md. masoom ");

		//address1.setId(2004);

		address1.setStreet("sector2");
		address1.setCity("mahboobnanagr");

		person1.setAddress(address1);

		tr = session1.beginTransaction();
		tr.begin();

		session1.save(person);
		 //session1.save(address);

		session1.save(person1);
		 //session1.save(address1);

		tr.commit();

		System.out.print("Record added");

		List<Person> plist = session1.createQuery("from Person").list();
		for (Person p : plist) {
			Address addr1 = p.getAddress();
			System.out.println("" + p.getId() + "\t" + p.getName()
					+ "\t city id " + addr1.getId() + "\t" + addr1.getStreet()
					+ "\t" + addr1.getCity());
		}

		person.setId(1);

		tr = session1.beginTransaction();
		tr.begin();

		session1.delete(person);

		tr.commit();
		
		System.out.println("after removal ");
				
		List<Person> plist1 = session1.createQuery("from Person").list();
		for (Person p : plist1) {
			Address addr1 = p.getAddress();
			System.out.println("" + p.getId() + "\t" + p.getName()
					+ "\t city id " + addr1.getId() + "\t" + addr1.getStreet()
					+ "\t" + addr1.getCity());
		}
	}
}
