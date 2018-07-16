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

public class StudentMainHQL {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

/*		Query qr=session.createQuery("from Student where roll>?");
		qr.setInteger(0, 104);//position based
*/		
		
		Query qr=session.createQuery("from Student where roll>:myroll");
		//qr.setInteger("myroll", 104);//name based 
	     qr.setParameter("myroll", 104);
		
		List<Student> slist=qr.list();
		for (Student student : slist)		
		
		System.out.println(student.getRoll() + "\t" + student.getName() + "\t"
				+ student.getMarks());
	}

}
