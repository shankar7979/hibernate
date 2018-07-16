import onetomany.Child;
import onetomany.Parent;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class OnetomanyApp1 {
	public static void main(String[] args) {
		try {
			Parent p1 = new Parent(40, "santosh");
			Child c1 = new Child();
			c1.setCage(2);
			c1.setCname("munnu");
			Child c2 = new Child();
			c2.setCage(4);
			c2.setCname("chunnu");

			p1.addChild(c1);
			p1.addChild(c2);

			Session session = new Configuration().configure()
					.buildSessionFactory().openSession();
			session.beginTransaction().begin();
			session.save(p1);
			
			session.save(c1);
			session.save(c2);
			
			session.beginTransaction().commit();
			System.out.println("Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
