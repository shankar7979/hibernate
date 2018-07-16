import org.com.model.Employee;
import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test3 {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.retrieveSF();
		Session session = factory.openSession();

		System.out.println("First time retrieval");
		Employee emp1 = (Employee) session.get(Employee.class, 1001);

		System.out.println(emp1.getId() + "\t" + emp1.getName());

		session.close();
		Session session1 = factory.openSession();

		System.out.println("Second  time retrieval");
		
		emp1 = (Employee) session1.get(Employee.class, 1001);
		System.out.println(emp1.getId() + "\t" + emp1.getName());
		
		
	/*	emp1.setName("shyam kumar");
		session1.beginTransaction();
		session1.update(emp1);
		session1.getTransaction().commit();*/

	}
}
