package org.com.model;

import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerMain {

public static void main(String[] args) {
	SessionFactory factory=HibernateUtil.retrieveSessionfactory();
	Session session=factory.openSession();
	Transaction transaction=session.beginTransaction();
	
	CustomerKey customerKey=new CustomerKey();
	customerKey.setId("1001");
	customerKey.setCountry("nepal");
	
	Customer customer=new Customer();
	customer.setCustomerKey(customerKey);
	
	customer.setName("ram kumar");
	customer.setLocation("viratnagar");
	
	transaction.begin();
	
	session.save(customer);
	transaction.commit();
	
	
}	
}
