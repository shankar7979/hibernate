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

public class StudentMain3 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		//criteria.add(Restrictions.eq("roll", 106));
		criteria.add(Property.forName("marks").eq(60));

		// List<Student> slist= criteria.list();

		Student student = (Student) criteria.uniqueResult();

		System.out.println(student.getRoll() + "\t" + student.getName() + "\t"
				+ student.getMarks());
	}

}
