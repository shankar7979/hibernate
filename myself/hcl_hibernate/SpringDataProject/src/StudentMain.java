import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.com.bean.Employee;
import org.com.bean.Student;
import org.com.bean.StudentConfig;
import org.com.dao.EmployeeDao;
import org.com.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) throws SQLException {
		/*
		 * ApplicationContext ctx = new
		 * ClassPathXmlApplicationContext("classpath:resource/application.xml");
		 * 
		 * StudentDao dao = ctx.getBean("sdao", StudentDao.class);
		 */
		ApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
		StudentDao dao = ctx.getBean(StudentDao.class);

		Scanner sc = new Scanner(System.in);

		String ch = "y";
		Student s = null;

		while (ch.equals("y")) {
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Update  Student");
			System.out.println("4. show All  Student");
			System.out.println("5. Search Student");

			
			int x = sc.nextInt();
			int p = 0;
			switch (x) {
			case 1:
				s = new Student();
				System.out.println("enter id ");
				s.setId(sc.nextInt());

				System.out.println("enter name ");
				sc.nextLine();
				s.setName(sc.nextLine());

				System.out.println("enter subject ");
				s.setSubject(sc.next());
				/*
				 * p = dao.addStudent(s); if (p == 1)
				 * System.out.println("Record added");
				 */ boolean status = dao.addStudent1(s);
				System.out.println("status is " + status);
				if (!status)
					System.out.println("Record added");

				break;
			case 2:
				s = null;
				s = new Student();
				System.out.println("enter id ");
				s.setId(sc.nextInt());
				p = 0;
				p = dao.removeStudent(s);
				if (p == 1)
					System.out.println("Record deleted");
				break;

			case 3:
				s = new Student();
				System.out.println("enter id ");
				s.setId(sc.nextInt());

				System.out.println("enter name ");
				sc.nextLine();
				s.setName(sc.nextLine());

				System.out.println("enter subject ");
				s.setSubject(sc.next());
				p = dao.updateStudent(s);
				if (p == 1)
					System.out.println("Record updated");
				break;

			case 4:

				List<Student> slist = 
dao.getAllStudent_rowmapper();				
				//dao.getAllStudent();

				for (Student student : slist) {
					System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getSubject());
				}
				break;

			case 5:
				System.out.println("enter id ");
				
   Student stud=   dao.searchStudent(sc.nextInt());
		if(stud==null)
			System.out.println("Record not found");
		else{
			System.out.println("Recorrd found");
	System.out.println
	(stud.getId()+"\t"+stud.getName()+"\t"+stud.getSubject());
		
		}
				break;
				
				
			default:
				break;
			}
			System.out.println("continue y\\n");
			ch = sc.next();
		}

	}
}
