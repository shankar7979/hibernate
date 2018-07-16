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

public class StudentMainHQLByObject {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

		Student st1=new Student();
		st1.setRoll(103);
		
		Query qr=session.createQuery("from Student where roll>:roll");
		qr.setProperties(st1);//object based
		
		
		List<Student> slist=qr.list();
		for (Student student : slist)		
		
		System.out.println(student.getRoll() + "\t" + student.getName() + "\t"
				+ student.getMarks());
	}

}
