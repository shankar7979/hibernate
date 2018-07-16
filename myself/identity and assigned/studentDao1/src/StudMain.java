import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.com.stud;
import org.com.util.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudMain {

	public static void main(String[] args) throws ParseException {
		SessionFactory sf = SessionFactoryProvider.getSessionFactory();
		Session session = sf.openSession();

		stud s1 = new stud();
	//	s1.setRoll(108);
		s1.setName("ram raj");

		Transaction tr = session.beginTransaction();
		session.save(s1);
		tr.commit();
		System.out.println("Record added");

		List<stud> list = session.createQuery("from stud").list();

		System.out.println("Roll\tName");
		for (stud s2 : list) {
			System.out.println(s2.getRoll() + "\t" + s2.getName()
		);
		}

	}
}
