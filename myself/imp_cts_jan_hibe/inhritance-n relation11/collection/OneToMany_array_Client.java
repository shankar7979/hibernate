import java.util.HashSet;
import java.util.List;
import java.util.Set;

import one_to_many_array.Book;
import one_to_many_array.Story;
import one_to_many_set.Complain;
import one_to_many_set.Consumer;
import one_to_one_primary_key.Customer;
import one_to_one_primary_key.Home;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany_array_Client {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction().begin();
		Book book = new Book();
		book.setName("child story");

		Story story[]=new Story[3];
		story[0]=new Story();
		story[1]=new Story();
		story[2]=new Story();
				
		story[0].setName("fox story");
		story[1].setName("crow story");
		story[2].setName("lion story");
		
		book.setStory(story);
				
		session.save(book);
		session.save(story[0]);
		session.save(story[1]);
		session.save(story[2]);
		
		session.getTransaction().commit();

/*		
	Book book1=	(Book) session.get(Book.class, 1);
	
	System.out.println("Book Record");
	System.out.println(book1.getId()+"\t"+book1.getName());
	
	Story story2[]=book1.getStory();
	
	System.out.println("story   record");
	for (Story story3 : story2) {
	System.out.println(story3.getId()+"\t"+story3.getName());	
	}
	*/
	
	Query qr=session.createQuery("from Book");
	List<Book> blist=qr.list();
	for (Book book2 : blist) {
		System.out.println("\n\nBook Record ");
		System.out.println(book2.getId()+" \t"+book2.getName());;
		Story story2[]=book2.getStory();
		
		System.out.println("\n\tstory   record");
		for (Story story3 : story2) {
		System.out.println("\t\t"+story3.getId()+"\t"+story3.getName());	
		}	
	}
	
		
	
	
	}
}
