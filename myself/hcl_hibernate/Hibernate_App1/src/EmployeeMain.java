import java.util.List;
import java.util.Scanner;

import org.com.model.Employee;
import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeMain {
	SessionFactory sf;
	Session session;
	Transaction tr;
	Employee emp;

	Scanner scanner;

	public EmployeeMain() {
		sf = HibernateUtil.getSF();
		scanner = new Scanner(System.in);
	}

	boolean status = false;

	Query query;
	List<Employee> elist;

	public boolean updateEmployee(int id) {
		boolean r_status = false;
		emp = null;
		emp = searchEmployee(id);
		if (emp != null) {
			session = sf.openSession();
			System.out.println("enter name to be updated");
			scanner.nextLine();
			emp.setEname(scanner.nextLine());

			System.out.println("enter salary to be updated");
			emp.setSalary(scanner.nextFloat());

			tr = session.beginTransaction();
			tr.begin();

			session.update(emp);
			tr.commit();
			session.close();
			r_status = true;
		}

		return r_status;
	}

	public boolean removeEmployee(int id) {
		boolean r_status = false;
		emp = null;
		emp = searchEmployee(id);
		if (emp != null) {
			session = sf.openSession();

			tr = session.beginTransaction();
			tr.begin();

			session.delete(emp);
			tr.commit();
			session.close();
			r_status = true;
		}

		return r_status;
	}

	public Employee searchEmployee(int id) {
		session = sf.openSession();

		/*
		 * Employee emp1 = (Employee) session.get(Employee.class, id); return
		 * emp1;
		 */

		/*
		 * query = session.createQuery("from Employee e where e.id=" + id);
		 * 
		 * elist = query.list(); if (elist.size() == 1)
		 * 
		 * return elist.get(0); else return null;
		 */

		query = session.createQuery("from Employee e where e.id=" + id);

		Employee e1 = (Employee) query.uniqueResult();
		return e1;
	}

	public List<Employee> showAll() {
		session = sf.openSession();

		// query = session.createQuery("from Employee ");
		query = session.createQuery("from Employee e  order by e.salary ");

		elist = query.list();
		session.close();
		return elist;
	}

	public void showAll1() {
		session = sf.openSession();

		query = session.createQuery("select e.ename from   Employee e");
		List<String> elist = null;
		elist = query.list();

		session.close();

		for (String s : elist) {
			System.out.println(s);
		}

	}

	public boolean addEmployee() {
		session = sf.openSession();

		emp = new Employee();
		
		/*System.out.println("Add Id");
		emp.setId(scanner.nextInt());*/

		status = false;
		/*if (searchEmployee(emp.getId()) == null) */
		{
			System.out.println("add name");
			scanner.nextLine();
			emp.setEname(scanner.nextLine());
			System.out.println("Enter salary");

			emp.setSalary(scanner.nextFloat());

			tr = session.beginTransaction();
			tr.begin();

			session.save(emp);
			tr.commit();
			session.close();

			status = true;
		}

		return status;
	}

	public boolean addEmployee1() {
		session = sf.openSession();

		emp = new Employee();
		
			System.out.println("add name");
			scanner.nextLine();
			emp.setEname(scanner.nextLine());
			System.out.println("Enter salary");

			emp.setSalary(scanner.nextFloat());

			tr = session.beginTransaction();
			tr.begin();

			session.save(emp);
			tr.commit();
			session.close();

			status = true;
		return status;
	}

	
	
	public static void main(String[] args) {
		EmployeeMain employeeMain = new EmployeeMain();
		String ch = "y";

		while (ch.equals("y")) {
			System.out.println("1.Add Record ");
			System.out.println("2.Find Record ");
			System.out.println("3.Remove  Record ");
			System.out.println("4.Update Record ");
			System.out.println("5.Show  Record ");
			System.out.println("6.Show special ");

			int x = employeeMain.scanner.nextInt();
			boolean flag = false;

			switch (x) {
			case 1:
				flag = employeeMain.addEmployee();
				if (flag)
					System.out.println("Record added");
				else
					System.out.println("Record already present with given id");
				break;

			case 2:
				System.out.println("Enter id to search");
				int id1 = employeeMain.scanner.nextInt();
				Employee emp1 = employeeMain.searchEmployee(id1);
				if (emp1 == null)
					System.out.println("Record not found ");
				else {
					System.out.println("Record found");
					System.out.println(emp1.getId() + "\t" + emp1.getEname()
							+ "\t" + emp1.getSalary());
				}

				break;
			case 3:
				System.out.println("Enter id to remove");
				id1 = employeeMain.scanner.nextInt();

				if (employeeMain.removeEmployee(id1))
					System.out.println("Record  found and deleted ");
				else {
					System.out.println("Record not  found");
				}
				break;

			case 4:
				System.out.println("Enter id to be upadted");
				id1 = employeeMain.scanner.nextInt();

				if (employeeMain.updateEmployee(id1))
					System.out.println("Record  found and updated ");
				else {
					System.out.println("Record not  found");
				}
				break;
			case 5:
				if (employeeMain.showAll().size() == 0)
					System.out.println("No Record  found  ");
				else {

					System.out.println("Record found");
					List<Employee> l1 = employeeMain.showAll();
					for (Employee emp2 : l1)
						System.out.println(emp2.getId() + "\t"
								+ emp2.getEname() + "\t" + emp2.getSalary());

				}
				break;

			case 6:
				employeeMain.showAll1();

			default:
				System.out.println("Wrong option");
				break;
			}
			System.out.println("Continue y\\n");
			ch = employeeMain.scanner.next();
		}

	}
}
