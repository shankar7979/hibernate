import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import bean.Stud;

public class Client1 {
	public static void main(String[] args) {
		try {
			Session session = new Configuration().configure()
					.buildSessionFactory().openSession();
			
			Stud s1 = new Stud();
//			s1.setRoll(99);
			s1.setName("shankar");
			session.save(s1);
			session.flush();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
