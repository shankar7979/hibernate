import java.util.ArrayList;
import java.util.List;

import org.com.model.one_to_many.Employee;
import org.com.model.one_to_many.Address;
import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Empmain3 {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.retrieveSF();
		Session session = factory.openSession();

		Employee employee = new Employee();
		employee.setId(1001);
		employee.setName("ram kumar");
		employee.setSalary(20000);

		Address address = new Address();
		address.setId(2001);
		address.setCity("chennai");
		address.setStreet("omr");

		Address address1 = new Address();
		address1.setId(2002);
		address1.setCity("madurai");
		address1.setStreet("1st main");

		List<Address> list1 = new ArrayList<Address>();
		list1.add(address);
		list1.add(address1);
	//	list1.add(address);

		employee.setElist(list1);
		Transaction tr=session.beginTransaction();

		session.save(employee);
		session.save(address);
		session.save(address1);
	//	 session.save(address);

		tr.commit();
	}
}
