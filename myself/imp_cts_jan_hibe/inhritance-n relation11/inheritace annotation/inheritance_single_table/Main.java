package inheritance_single_table;

import org.com.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = DatabaseUtil.retrieveSf();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		CreditCardPayment credit = new CreditCardPayment(50000.00);
		session.save(credit);
		CashPayment cash = new CashPayment(10000.00);
		session.save(cash);
		transaction.commit();
		session.close();

	}
}
