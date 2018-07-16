import org.hibernate.*;

import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		CreditCardPayment credit = new CreditCardPayment(50000.00);
		session.save(credit);
		CashPayment cash = new CashPayment(10000.00);
		session.save(cash);
		session.flush();
		transaction.commit();

	}

}
