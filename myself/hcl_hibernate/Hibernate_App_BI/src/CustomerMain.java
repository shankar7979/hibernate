import java.util.List;
import java.util.Scanner;

import org.com.model.CreditCard;
import org.com.model.Customer;
import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerMain {

	public static void main(String[] args) {
		SessionFactory sf;
		Session session;
		Transaction tr;

		sf = HibernateUtil.getSF();
		session = sf.openSession();
		tr = session.beginTransaction();

		tr.begin();

		Customer cust = new Customer();
		CreditCard card = new CreditCard();

		cust.setFirstName("r kumar");
		cust.setLastName("sharma");

		card.setNameOnCard("r kumar sharma");

		cust.setCreditCard(card);
		card.setCustomer(cust);

		// session.save(cust);
		session.save(card);

		tr.commit();

		for (Customer cs : (List<Customer>) session
				.createQuery("from Customer").list()) {
			System.out.println(cs.getId() + "\t" + cs.getFirstName() + "\t"
					+ cs.getCreditCard().getId() + "\t"
					+ cs.getCreditCard().getNameOnCard());
		}

		tr.begin();
		session.delete(card);

		tr.commit();

		System.out.println("after delete");

		for (Customer cs : (List<Customer>) session
				.createQuery("from Customer").list()) {
			System.out.println(cs.getId() + "\t" + cs.getFirstName() + "\t"
					+ cs.getCreditCard().getId() + "\t"
					+ cs.getCreditCard().getNameOnCard());
		}

	}
}
