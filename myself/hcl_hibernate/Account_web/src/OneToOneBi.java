import org.com.model.Customer;
import org.com.model.Phone;
import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class OneToOneBi {

	public static void main(String[] args) {
		
		SessionFactory sf;
		Session session1;
		Transaction tr;
		Query qr;

		sf = HibernateUtil.getSF();
		session1 = sf.openSession();
		
		tr=session1.beginTransaction();
		
		Customer customer=new Customer();

		Phone phone=new Phone();
				
		customer.setName("masoom");
		customer.setSsn(757557);
		customer.setLocation("manesar");
		
		phone.setModel("Redmi 4");
		phone.setCost(14000);
		
		//customer.setPhone(phone);
		
		phone.setCustomer(customer);
		
		tr.begin();
		//session1.save(customer);
		session1.save(phone);
		
		tr.commit();
		
	}
}
