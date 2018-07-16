import java.util.List;

import org.com.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;


public class StudentMain2 {

	public static void main(String[] args) {
		SessionFactory	sf=HibernateUtil.retrieveSessionFactory();

		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(Student.class);
		//criteria.setMaxResults(2);
		//criteria.add(Restrictions.in("name", new String[]{"suresh","mahesh"}));
		//criteria.addOrder(Order.desc("marks"));
		
		criteria.add(Restrictions.sqlRestriction("length({alias}.name)>?",5,Hibernate.INTEGER));
		List<Student> slist=  criteria.list();
		
		
		for (Student student : slist) {
			System.out.println(student.getRoll()+"\t"+student.getName()+"\t"+student.getMarks());
		}	

	}
}




