package org.com.model;

import java.util.Date;

import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductMain {

	public static void main(String[] args) {
	
	SessionFactory factory=HibernateUtil.getSF();
	Session session=factory.openSession();

	
	Transaction transaction=session.beginTransaction();
	transaction.begin();
	
	Product product=new Product();
	
	product.setId(10001);
	product.setName("hibernate made easy");
	product.setCost(500);
	
	product.setPublish_date(new Date());
	
	session.save(product);
	
	transaction.commit();
	
		
	}
}
