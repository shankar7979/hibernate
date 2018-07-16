import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class Client1 {
	public static void main(String[] args) {
		try{
		//Session session = new Configuration().configure().buildSessionFactory()
		//.openSession();
			
			Configuration config=new Configuration().configure();
			
			
			SessionFactory factory=config.buildSessionFactory();
			Session session=factory.openSession();
			
			
		///Transaction tr=null;
		Stud s1=new Stud();
		s1.setRoll(99);
		s1.setName("shankar");
		//tr=session.beginTransaction();
		
		session.save(s1);
		//session.update(s1);
		
			Stud s=(Stud)session.get(Stud.class, 99);
			
			if(s!=null){
			System.out.println("record is present");
			
			session.delete(s);
			//System.out.println("roll is "+s.getRoll());
			//System.out.println("name is "+s.getName());
			
			}
			else {
				System.out.println("record is not  present");	
				
				
			}
			
			
			//Query query=session.createQuery("from Stud");
			Query query=session.createQuery("from Stud where roll=?");
			query.setInteger(0, 1);
			
			Stud ss=(Stud)query.uniqueResult();

			
			System.out.println(ss.getRoll());
			System.out.print("   "+ss.getName());

			/*List<Stud>  list=query.list();
			
			for(Stud s3:list)
			{
				System.out.println(s3.getRoll());
				System.out.print("   "+s3.getName());
				
			}*/
			
			
			
		session.flush();
		session.close();
		//tr.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
