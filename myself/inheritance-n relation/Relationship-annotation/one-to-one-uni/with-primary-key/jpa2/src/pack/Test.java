package pack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("jpa2");
		EntityManager em=fac.createEntityManager();
		
		EntityTransaction tr=em.getTransaction();
		
		Phone p=new Phone();
		p.setId(107);
		p.setName("nokia");		
		
		Customer c=new Customer();
		c.setName("mohan");
		c.setId(1);
		c.setPhone(p);
		
		
		tr.begin();
		em.persist(c);
		em.persist(p);
		tr.commit();
		System.out.println("added");
		
	
		em.close();
		
	
	}

}
