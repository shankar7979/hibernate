import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class client {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();
		
		Transaction transaction = null;
		try {
			Scanner sc = new Scanner(System.in);

			String choice = "y";

			while (choice.equals("y")) {
				Stud s = new Stud();
				transaction = session.beginTransaction();

				int roll;
				String name;
				int ch;

				System.out.println("1. Add\t2. Delete\t3. Update\t4. Show\t5. ShowAll ");
				ch = sc.nextInt();

				if (ch == 1) {
					System.out.println("Enter roll");
					roll = sc.nextInt();

					System.out.println("Enter name");
					name = sc.next();

					s.setRoll(roll);
					s.setName(name);
					session.save(s);
					System.out.println("record inserted");
				}

				else if (ch == 2) {
					System.out.println("Enter roll");
					roll = sc.nextInt();

					s.setRoll(roll);
					session.delete(s);
					System.out.println("record deleted");
				}

				else if (ch == 3) {
					System.out.println("Enter roll");
					roll = sc.nextInt();

					System.out.println("Enter name");
					name = sc.next();

					s.setRoll(roll);
					s.setName(name);
					session.update(s);
					System.out.println("record updated");
				}

				else if (ch == 4) {
					System.out.println("Enter roll");
					roll = sc.nextInt();
					// List l=session.find("from stud where roll=2");
					List l = session.createQuery("from Stud s where s.roll="+roll+"")
							.list();

					for (Object object : l) {
						System.out.println(((Stud) object).getRoll());
						System.out.println(((Stud) object).getName());
					}
				}

				else if (ch == 5) {
				
					List l = session.createQuery("from Stud")
							.list();

					for (Object object : l) {
						System.out.println(((Stud) object).getRoll());
						System.out.println(((Stud) object).getName());
					}
				}

				
				transaction.commit();
				System.out
						.println("Enter choice for another operation \n y\\n ");
				choice = sc.next();
			}

		} catch (HibernateException e) {
			 transaction.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
