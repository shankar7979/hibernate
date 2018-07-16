import org.com.bean.Book;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class BookMain {

	public static void main(String[] args) {
		
//	Configuration cfg=new AnnotationConfiguration().configure();
		Configuration cfg=new AnnotationConfiguration().configure("hibernate1.cfg.xml");
		
Session session=cfg.buildSessionFactory().openSession();
	session.getTransaction().begin();
	Book book=new Book();
	//book.setIsbn(34567);
	book.setName("hibernate beginner");
	book.setCost(450);
	session.save(book);
	session.getTransaction().commit();
	System.out.println("Book record added");
	
	}
}
