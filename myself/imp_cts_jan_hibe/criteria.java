import java.util.List;
import java.util.Scanner;

import org.com.dao.BookDaoImpl;
import org.com.model.Book;
import org.com.model.DatabaseUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class BookMain2 {
	public static void main(String[] args) {

		SessionFactory factory = DatabaseUtil.retrieveSf();
		Session session = factory.openSession();

		Query query = session.createQuery("from Book");
		List<Book> blist = query.list();

		blist.stream().forEach(
				p -> System.out.println(p.getIsbn() + "\t" + p.getAuthor() + "\t" + p.getName() + "\t" + p.getPrice()));

		Criteria criteria = session.createCriteria(Book.class);

		System.out.println("using criteria \n\n");
		criteria.setMaxResults(3);
		List<Book> blist1 = criteria.list();
		blist1.stream().forEach(
				p -> System.out.println(p.getIsbn() + "\t" + p.getAuthor() + "\t" + p.getName() + "\t" + p.getPrice()));

		criteria.setMaxResults(1);

		Book p = (Book) criteria.uniqueResult();

		System.out.println(p.getIsbn() + "\t" + p.getAuthor() + "\t" + p.getName() + "\t" + p.getPrice());

		System.out.println("using like");
		Criteria criteria1 = session.createCriteria(Book.class);
		// criteria1.add(Restrictions.like("name", "p%"));
		criteria1.addOrder(Order.asc("price"));
		System.out.println("Order by price");

		blist1 = criteria1.list();
		blist1.stream().forEach(p1 -> System.out
				.println(p1.getIsbn() + "\t" + p1.getAuthor() + "\t" + p1.getName() + "\t" + p1.getPrice()));

		System.out.println("using in method.................");
	blist=	session.createCriteria(Book.class).add
		(Restrictions.in("name", new String[]{"python","perl beginner"})).
		list();
		
		blist.stream().forEach(a->System.out.println(a.getIsbn()+"\t"+a.getName()));
	}
}
