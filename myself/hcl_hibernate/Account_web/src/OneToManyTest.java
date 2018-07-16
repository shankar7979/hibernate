import java.util.ArrayList;
import java.util.List;

import org.com.model.Book;
import org.com.model.Chapter;
import org.com.model.Person;
import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class OneToManyTest {

	public static void main(String[] args) {

		SessionFactory sf=HibernateUtil.getSF();
		Session session=sf.openSession();
		
		
		Book book=new Book();
		
		Chapter chapter1=new Chapter();
		Chapter chapter2=new Chapter();
		Chapter chapter3=new Chapter();
		
		
		book.setName("java beginner");
		
		chapter1.setChapter_name("fundamental");
		chapter2.setChapter_name("OOP concept");
		chapter3.setChapter_name("IO and File");
		
		List<Chapter> list1=new ArrayList<Chapter>();
		list1.add(chapter1);
		list1.add(chapter2);
		list1.add(chapter3);
		
		book.setCost(300);
		book.setC_list(list1);
		
		Transaction tr=session.beginTransaction();
		tr.begin();
		
		session.save(book);
		/*session.save(chapter1);
		session.save(chapter2);
		session.save(chapter3);*/
				
		tr.commit();
			
	}
}
