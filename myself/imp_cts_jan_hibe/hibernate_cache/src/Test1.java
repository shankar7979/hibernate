import org.com.model.Employee;
import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test1 {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.retrieveSF();
		Session session = factory.openSession();

		System.out.println("First time retrieval");
		Employee emp1 = (Employee) session.get(Employee.class, 1001);

		System.out.println(emp1.getId() + "\t" + emp1.getName());

		session.evict(emp1);
		System.out.println("Second  time retrieval");
		
		emp1 = (Employee) session.get(Employee.class, 1001);
		System.out.println(emp1.getId() + "\t" + emp1.getName());

	}
}
