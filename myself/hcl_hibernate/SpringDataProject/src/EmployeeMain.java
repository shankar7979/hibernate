import java.sql.SQLException;
import java.util.List;

import org.com.bean.Employee;
import org.com.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) throws SQLException {
		
	ApplicationContext ctx=new ClassPathXmlApplicationContext
			("classpath:resource/application.xml");
	
EmployeeDao empdao=	ctx.getBean("dao", EmployeeDao.class);

List<Employee> elist=  empdao.getEmp();	

for (Employee employee : elist) {
	System.out.println
	(employee.getId()+"\t"+employee.getName()+"\t"+employee.getSubject());
}



		
	}
}
