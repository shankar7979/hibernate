import many_to_one.Address;
import many_to_one.Person;

import one_to_one.Exam;
import one_to_one.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class oneToOne_foreignClient {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Student st = new Student();
		Exam exam = new Exam();

		st.setName("ram kumar");
		
		
		
		exam.setName("math");
		st.setExam(exam);
		
		
		
		session.getTransaction().begin();
		session.save(exam);
		session.save(st);

		session.getTransaction().commit();

	}

}
