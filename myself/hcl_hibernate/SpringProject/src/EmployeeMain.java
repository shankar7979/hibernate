import org.com.bean.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class EmployeeMain {

	public static void main(String[] args) {

		Resource res=new ClassPathResource
				("resource/beans.xml");

		BeanFactory factory =new  
				XmlBeanFactory(res);
			
		
		
				/*new ClassPathXmlApplicationContext
				("beans.xml");*/
		

		Employee emp = (Employee) factory.getBean("emp1");

		System.out.println("id is " + emp.getId());
		System.out.println("name is " + emp.getName());
	}
}
