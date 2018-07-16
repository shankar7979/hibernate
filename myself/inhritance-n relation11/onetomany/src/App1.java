import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class App1 
{
public static void main(String[] args) 
	{
		try {
Parent p1 = new Parent(40, "santosh");
Child c1=new Child();
		c1.setCage(2);
		c1.setCname("munnnu");
Child c2=new Child();
		c2.setCage(4);
		c2.setCname("chunnu");
		
p1.addChild(c1);
p1.addChild(c2);
			
Session session=new Configuration().configure().buildSessionFactory().openSession();
	session.beginTransaction().begin();
			session.save(p1);
Iterator itr = p1.getChildren().iterator();
			while (itr.hasNext()) 
			{
				Child ch = (Child) itr.next();
				session.save(ch);
			}
session.beginTransaction().commit();
System.out.println("Inserted");
		
			}
		catch (Exception e) {
			e.printStackTrace();}
		}	
}
