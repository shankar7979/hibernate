import java.util.List;

import org.com.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;


public class NamedQuery1 {
public static void main(String[] args) {

Session session=	
HibernateUtil.retrieveSessionFactory().openSession();
//Query qr=session.getNamedQuery("org.com.model.Student.getAll");
//from Student order by marks asc
//Query qr=session.getNamedQuery("getAll");//external named query 
Query qr=session.createQuery("from Student order by marks");

List<Student> slist= qr.list();

for (Student student : slist) {
	System.out.println(student.getRoll()+"\t"+student.getName()+"\t"+student.getMarks());
}

}
}
