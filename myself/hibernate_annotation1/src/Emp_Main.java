import java.util.ArrayList;
import java.util.List;

import org.com.model.one_to_many.Employee;
import org.com.model.one_to_many.Address;
import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Emp_Main {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.retrieveSF();

		Session session = factory.openSession();

		Employee employee = new Employee();
		String city[] = { "chennai", "madurai", "kanchipuram" };
		String street[] = { "2nd main", "OMR main", "3rd main" };
		int id[] = { 2001, 2002, 2003 };

		Address address[] = new Address[3];
		employee.setId(1001);
		employee.setName("ram kumar");
		employee.setSalary(12000);

		List<Address> address_list = new ArrayList<Address>();

		for (int i = 0; i < address.length; i++) {
			address[i] = new Address();
			address[i].setId(id[i]);
			address[i].setCity(city[i]);
			address[i].setStreet(street[i]);
			address_list.add(address[i]);
		}
		employee.setElist(address_list);

		Transaction tr = session.beginTransaction();
		session.save(employee);
		for (Address address2 : address_list) {
			session.save(address2);
		}
		tr.commit();
	}
}