package org.com.model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeTest {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure();
		
		SessionFactory factory=configuration.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		Employee employee=new Employee();
	//	employee.setId(1003);
		employee.setName("suman kumar");
		
		employee.setSalary(20000);
		employee.setDob(new Date(1977-1900, 4, 23));
		employee.setEntry_time(new Time(new Date().getTime()));
		
		transaction.begin();
		
		session.save(employee);
		transaction.commit();
		System.out.println("Record added");
		
	Query query=	session.createQuery("from Employee");
	List<Employee> elist=	query.list();
			
	elist.stream().forEach(p->System.out.println
			(p.getId()+"\t"+p.getName()+"\t"+p.getSalary()+"\t"+p.getDob()+"\t"+p.getEntry_time()));
	
	
	for (Employee employee2 : elist) {
		
	}
	
		
	}
	
}
