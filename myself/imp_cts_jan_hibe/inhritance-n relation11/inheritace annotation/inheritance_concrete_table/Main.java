package inheritance_concrete_table;

import org.com.DatabaseUtil;
import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {
		Session session = DatabaseUtil.retrieveSf().openSession();
		session.beginTransaction();
		CreditCardPayment credit = new CreditCardPayment(50000.00);
		session.save(credit);
		CashPayment cash = new CashPayment(10000.00);
		session.save(cash);
		session.flush();
		
		session.getTransaction().commit();

	}
}
