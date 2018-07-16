import java.util.Date;

import org.com.model.Birthday;
import org.com.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class PersonMain {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		Person person = new Person();
		Birthday bday = new Birthday();
		person.setId(101);
		person.setAge(22);
		person.setName("ishaan");

		bday.setDate(new Date("18-dec-2008"));
		bday.setDayname("friday");
		person.setBday(bday);

		session.save(person);
		tr.commit();
		//System.out.println("Record added");

	}
}
