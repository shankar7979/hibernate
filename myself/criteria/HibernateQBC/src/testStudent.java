import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class testStudent {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();

		Criteria cr = session.createCriteria(Student.class);
		// cr.setMaxResults(2);

		// Query qr = session.createQuery("from Student");
		List<Student> list = cr.list();
		// for (Student student : list) {
		// System.out.println("===============");
		// System.out.println(student.getMarks() + "\t" + student.getName()
		// + "\t" + student.getRoll() + "\t" + student.getSubject());
		// }

		// cr.add(Restrictions.like("name", "%sh"));
		System.out.println("===============");
		// list = cr.list();
		// for (Student student : list) {
		//
		// System.out.println(student.getMarks() + "\t" + student.getName()
		// + "\t" + student.getRoll() + "\t" + student.getSubject());
		// }

		// cr.add(Restrictions.in("name", new String[] { "ramesh", "mahesh" }));
		// System.out.println("===============");
		// list = cr.list();
		// for (Student student : list) {
		//
		// System.out.println(student.getMarks() + "\t" + student.getName()
		// + "\t" + student.getRoll() + "\t" + student.getSubject());
		// }

		cr.addOrder(Order.asc("name"));

//		list = cr.list();
//		for (Student student : list) {
//
//			System.out.println(student.getMarks() + "\t" + student.getName()
//					+ "\t" + student.getRoll() + "\t" + student.getSubject());
//		}
		cr.setProjection(Projections.rowCount());
		// cr.add(Projections.rowCount());

		list = cr.list();
		System.out.println(list);
	}
}
