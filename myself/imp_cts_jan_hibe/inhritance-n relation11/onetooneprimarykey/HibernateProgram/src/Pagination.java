import java.util.List;

import org.com.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class Pagination {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

		/*
		 * Query qr = session.createQuery("from Student");
		 * qr.setComment("This is pagination program ");
		 */
		Query qr = session.createQuery("from Student")
				.setComment("This is pagination program ")
				.setMaxResults(50)
				.setFirstResult(100);

		// qr.setMaxResults(50);
		// qr.setFirstResult(200);
		// qr.setFetchSize(150);

		List<Student> slist = qr.list();

		int size = slist.size();

		int x = size / 20;

		for (int i = 1; i <= x; i++) {

			/*
			 * qr = session.createQuery("from Student"); qr.setMaxResults(20);
			 */

			qr = session.createQuery("from Student").setMaxResults(20);

			slist = qr.list();
			for (Student student : slist)

				System.out.println(student.getRoll() + "\t" + student.getName()
						+ "\t" + student.getMarks());
			System.out
					.println("\n\n---------------- ---------------------------------------------\n\n");
		}

	}

}
