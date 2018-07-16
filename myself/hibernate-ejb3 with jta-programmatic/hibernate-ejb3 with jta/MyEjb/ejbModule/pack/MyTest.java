package pack;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


@Stateless
public class MyTest implements MyTestRemote {

	List<Book> list=new ArrayList<Book>();

	Session session = new Configuration().configure().buildSessionFactory()
	.openSession();

	
	@Override
	public List<Book> getData() {
	Query qr=    session.createQuery("from Book");
	  list=     qr.list();	
		
		return list;
	}
    

}
