import java.util.List;

import org.com.model.Address;
import org.com.model.Person;
import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneTest1 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSF();
		Session session = sf.openSession();
		Person person = new Person();

		person.setId(1);

		Transaction tr = session.beginTransaction();
		tr.begin();

		session.delete(person);

		tr.commit();

		System.out.println("after removal ");

		List<Person> plist1 = session.createQuery("from Person").list();
		for (Person p : plist1) {
			Address addr1 = p.getAddress();
			System.out.println("" + p.getId() + "\t" + p.getName()
					+ "\t city id " + addr1.getId() + "\t" + addr1.getStreet()
					+ "\t" + addr1.getCity());
		}

	}
}
