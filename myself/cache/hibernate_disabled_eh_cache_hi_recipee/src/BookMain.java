import org.com.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookMain {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session session1 = factory.openSession();
		try {
			Book book1 = (Book) session1.get(Book.class, 1001);
		} finally {
			session1.close();
		}
		Session session2 = factory.openSession();
		try {
			Book book2 = (Book) session2.get(Book.class, 1001);
		} finally {
			session2.close();
		}

	}

}
