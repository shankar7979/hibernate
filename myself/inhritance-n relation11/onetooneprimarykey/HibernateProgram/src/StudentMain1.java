import java.util.List;
import java.util.Scanner;

import org.com.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;

public class StudentMain1 {
	Configuration cfg;
	SessionFactory sf;
	Session session;
	Transaction tr;
	Student stud;
	Scanner sc = new Scanner(System.in);
	int roll;

	StudentMain1() {
		// cfg = new Configuration();
		// cfg.configure();
		// sf = cfg.buildSessionFactory();
		sf = HibernateUtil.retrieveSessionFactory();
		session = sf.openSession();
	}

	void addStudent() {
		stud = new Student();
		System.out.println("enter name ");
		stud.setName(sc.next());
		System.out.println("enter marks ");
		stud.setMarks(sc.nextInt());
		session.save(stud);
		tr = session.beginTransaction();
		tr.commit();
		System.out.println("Record added");
	}

	void showAllStudent() {
		Query qr = session.createQuery("from Student");
		List<Student> slits = qr.list();

		System.out.println("Roll\tname\tmarks");

		for (Student student : slits) {
			System.out.println(student.getRoll() + "\t" + student.getName()
					+ "\t" + student.getMarks());
		}
	}

	void update() {
		System.out.println("Enter roll");
		roll = sc.nextInt();

		stud = (Student) session.get(Student.class, roll);

		if (stud != null) {
			System.out.println("Record found with roll " + roll);
			System.out.println("It can be updated");

			System.out.println("Enter name");
			stud.setName(sc.next());

			System.out.println("Enter marks");
			stud.setMarks(sc.nextInt());
			session.update(stud);
			tr = session.beginTransaction();
			tr.commit();
			System.out.println("Record updated");
		} else {
			System.out.println("Roll no not present\nIt cannot be updated");
		}
	}

	void search() {
		System.out.println("Enter roll");
		roll = sc.nextInt();
		stud = (Student) session.get(Student.class, roll);

		if (stud != null) {
			System.out.println("Record found with roll " + roll);
			System.out.println("Student Detail for roll " + roll);
			System.out.println("name is " + stud.getName());
			System.out.println("name is " + stud.getMarks());

		} else {
			System.out.println("Record not found with roll " + roll);
		}
	}


	void delete() {
		System.out.println("Enter roll");
		roll = sc.nextInt();
		stud = (Student) session.get(Student.class, roll);
		if(stud!=null)
		{
			System.out.println("Record found with roll "+roll);
			System.out.println("It can be deleted ");
			System.out.println("Delete Record y\\n");
			String ch=sc.next();
			if(ch.equals("y"))
				session.delete(stud);
			tr=session.beginTransaction();
			tr.commit();
		}
		else
			System.out.println("Record not found with roll "+roll);
		
 	}
	
	public static void main(String[] args) {
		String ch = "y";
		StudentMain1 main = new StudentMain1();

		while (ch.equalsIgnoreCase("y")) {

			System.out.println("1. Insert Record");
			System.out.println("2. ShowAll Record");
			System.out.println("3. Update  Record");
			System.out.println("4. Search  Record");
			System.out.println("5. Remove  Record");
			int x = main.sc.nextInt();

			switch (x) {
			case 1:
				main.addStudent();
				break;
			case 2:
				main.showAllStudent();
				break;

			case 3:
				main.update();
				break;
			case 4:
				main.search();
				break;
			
			case 5:
				main.delete();
				break;
				
			default:
				System.out.println("Wrong choice ");
				break;
			}

			System.out.println("Continue y\\n");
			ch = main.sc.next();
		}

	}
}
