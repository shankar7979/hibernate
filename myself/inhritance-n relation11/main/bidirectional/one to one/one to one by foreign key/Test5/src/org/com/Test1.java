package org.com;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test1 {

	public static void main(String[] args) {
		
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		
		Product product=new Product();
		ProductDetail pdetail=new ProductDetail();
		
		product.setName("pen");
		product.setDom(new Date());
		
		pdetail.setPrd_name("parker pen");
		
		product.setPrdDetail(pdetail);		
		
		pdetail.setProduct(product);
		
		
		session.getTransaction().begin();
	    //session.save(pdetail);
		
		session.save(product);
		session.flush();

		session.getTransaction().commit();
		
		System.out.println("Record added");
	}
}
