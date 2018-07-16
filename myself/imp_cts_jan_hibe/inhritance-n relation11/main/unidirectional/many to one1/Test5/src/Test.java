

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();
		
		Person person1=new Person();
		Person person2=new Person();
		Person person3=new Person();
		
		
		Address addr1=new Address();
		
		addr1.setCity("delhi");
		
		person1.setName("ram");
		person2.setName("shyam");
		person3.setName("kiran");
		
		person1.setAddress(addr1);
		person2.setAddress(addr1);
		person3.setAddress(addr1);
		
		session.getTransaction().begin();
		
		session.save(addr1);
		session.save(person1);
		session.save(person2);
		session.save(person3);
			
		session.flush();

		session.getTransaction().commit();

		System.out.println("Record added");
	}
}
