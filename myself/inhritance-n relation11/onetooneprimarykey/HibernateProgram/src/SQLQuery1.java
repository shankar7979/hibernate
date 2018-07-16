import java.util.List;

import org.com.model.Student;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;

public class SQLQuery1 {
	public static void main(String[] args) {

		Session session = HibernateUtil.retrieveSessionFactory().openSession();

		SQLQuery qr = session
				.createSQLQuery("select * from  student");
		qr.addEntity("student",Student.class);
		
	List<Student> list2 = qr.list();
		for (Student obj : list2) {
			System.out.println(obj.getRoll()+"\t"+obj.getName());
		}
	}
}
