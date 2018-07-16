import java.util.Date;

import org.com.model.Product;
import org.com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductTest {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.retrieveSessionfactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		try {
			Product product = new Product();
			//product.setId(67769);
			
			product.setArea("madurai");
			product.setPh_number(6767769);
			
			
			product.setName("book");
			product.setCost(556);
			product.setMfd(new Date(2017 - 1900, 3, 30));
			
			transaction.begin();
			session.save(product);
			
			
			transaction.commit();
		} catch (HibernateException e) {
			// System.err.println(e.getMessage());
			System.err.println(e);
			transaction.rollback();
		}
	}
}
