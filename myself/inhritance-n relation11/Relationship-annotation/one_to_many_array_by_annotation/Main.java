package org.com.one_to_many_array_by_annotation;

import org.com.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = DatabaseUtil.retrieveSf();
		Session session = factory.openSession();

		Department department = new Department();
		department.setName("training");
		department.setId(656565);
		department.setLocation("chennai");

		Staff staff[] = new Staff[3];

		String name[] = { "prabhakar", "sudhakar", "madhukar" };
		float salary[] = { 23000, 56000, 90000 };

		int x = 0;
		for (; x < staff.length; x++) {
			staff[x] = new Staff();
			staff[x].setName(name[x]);
			staff[x].setSalary(salary[x]);
		}

		Transaction tr = session.beginTransaction();
		session.save(department);
		session.save(staff[0]);
		session.save(staff[1]);
		session.save(staff[2]);

		tr.commit();
	}
}
