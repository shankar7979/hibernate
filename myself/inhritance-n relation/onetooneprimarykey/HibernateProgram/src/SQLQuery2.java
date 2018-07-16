import java.util.List;

import org.com.model.Student;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;

public class SQLQuery2 {
	public static void main(String[] args) {

		Session session = HibernateUtil.retrieveSessionFactory().openSession();

		SQLQuery qr = session
				.createSQLQuery("select roll  as roll from  student");

		// qr.addScalar("sname",Hibernate.STRING);
		qr.addScalar("roll", Hibernate.INTEGER);
		List<Integer> list2 = qr.list();
		for (Integer nm : list2) {
			System.out.println(nm);
		}
		qr=session
		.createSQLQuery("select upper(name) as sname from  student");

		qr.addScalar("sname", Hibernate.STRING);
		List<String> list = qr.list();
		for (String nm : list) {
			System.out.println(nm);
		}

	}
}
