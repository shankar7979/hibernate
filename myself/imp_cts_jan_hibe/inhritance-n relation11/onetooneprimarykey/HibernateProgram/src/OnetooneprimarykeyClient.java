import java.util.Date;

import onetooneforeignkey.Address;
import onetooneforeignkey.Person;
import onetooneprimarykey.Exam;
import onetooneprimarykey.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class OnetooneprimarykeyClient {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.retrieveSessionFactory();

		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();
		Student st1 = new Student();
		Exam exam = new Exam();
		exam.setMarks(50);
		st1.setName("suresh");
		st1.setExam(exam);

		session.save(st1);
		tr.commit();
	 System.out.println("Record added");

	}
}
