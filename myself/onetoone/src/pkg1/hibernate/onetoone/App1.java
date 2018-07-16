package pkg1.hibernate.onetoone;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App1 {
	SessionFactory sf = null;
	Session session = null;

	public App1() {
		try {
			sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
		} catch (Exception e) {
		}
	}

	public void addStudent() {
		try {
			Transaction tr = session.beginTransaction();
			tr.begin();
			Address address1 = new Address("A-7", "noida", "RMG", "600097");
			Address address2 = new Address("B-26", "Noida", "ESG", "560000");

			Student student1 = new Student("ram", address1);
			Student student2 = new Student("shayam", address2);
			session.save(student1);
			session.save(student2);
			tr.commit();
			System.out.println("Inserted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void method1()
	{
		try {
			//Transaction tr = session.beginTransaction();
			//tr.begin();
			Student s1=(Student)session.get(Student.class,2l);
			Address ad=s1.getStudentAddress();
			System.out.println("Student id "+s1.getStudentId()+
					"\n name"+s1.getStudentName()+
					"\nAddress id "+ad.getAddressId() +
							"\ncity "+ad.getCity());
			//tr.commit();
		//	System.out.println("Inserted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
App1 obj=new App1();
// obj.addStudent();
obj.method1();
	}

}
