package org.com.model;

import java.util.List;

import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.retrieveSF();

		Session session = factory.openSession();

		Query query = session.createSQLQuery("select * from employee1").addEntity(Employee.class);
		List<Employee> elist = query.list();

		for (Employee employee : elist) {
			System.out.println(employee.getId() + "\t" + employee.getName());
		}

		System.out.println("using procedure ");

		Query query1 = session.createSQLQuery("call emp_show_all()").addEntity(Employee.class);
		List<Employee> elist1 = query1.list();

		elist1.stream().forEach(p -> System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getSalary()));

		System.out.println("using procedure using parameter  ");

		Query query2 = session.createSQLQuery("call emp_search(:id)").addEntity(Employee.class).setParameter("id",
				1001);
		List<Employee> elist2 = query2.list();

		elist2.stream().forEach(p -> System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getSalary()));

	}
}
/*
 * mysql> delimiter //
mysql> create procedure emp_show_all()
    -> begin
    -> select * from employee1;
    -> end;
mysql> call emp_show_all();
mysql> create procedure emp_search(id1 int)
    -> begin
    -> select * from employee1 where id=id1;
    -> end;
mysql> call emp_search(1001) //



 * 
 * 
 */
