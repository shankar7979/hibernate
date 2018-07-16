package pack;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class testCustomer {
	
	public static void main(String[] args) {
		
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		
		
		Transaction tr=null;
		try{
			tr=ses.beginTransaction();
		Customer c1=new Customer();
		c1.setId(1009);
		c1.setCode(9003);
		c1.setName("rahul");
		
		ses.save(c1);
		
		
		tr.commit();
		ses.close();
		System.out.println("record added");
		
		}
		catch (HibernateException e) {
	      tr.rollback();
	      System.out.println(e);
		}
		
	}

}
