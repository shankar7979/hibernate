package pkg;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test {
public static void main(String[] args) {

	Session session=new Configuration().configure().buildSessionFactory().openSession();
	Address add1=new Address("sec3", "noida", "up", "200956");
	Address add2=new Address("sec4", "noida", "up", "200958");
	
	Student s1=new Student("ram",add1);
	Student s2=new Student("shyam",add2);
session.getTransaction().begin();
session.save(s1);
session.save(s2);
session.getTransaction().commit();
	
System.out.println("student adda added");	


}
}
