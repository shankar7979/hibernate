import java.util.Iterator;
import java.util.Properties;

import org.com.bean.Developer;
import org.com.bean.Project;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Dev_Main {

	public static void main(String[] args) {
		BeanFactory beanFactory = new FileSystemXmlApplicationContext("src/resource/context.xml");
		Developer developer = beanFactory.getBean("dev", Developer.class);

		System.out.println("developer information ");
		System.out.println("id is " + developer.getId());
		System.out.println("name is " + developer.getName());
		System.out.println("salary is " + developer.getSalary());

		Project project = developer.getP_list();

		System.out.println("\n Project Information ");
		System.out.println("project id " + project.getP_id());
		System.out.println("project name " + project.getP_name());

		System.out.println("project location " + project.getP_location());

		System.out.println("\nAddress City are follwing\n");

		for (String s : developer.getAddress())
			System.out.println("\t" + s);

		System.out.println("\nDurations  are follwing\n");

		for (Integer s : developer.getDuration())
			System.out.println("\t" + s);

		System.out.println("\nVehicles are follwing\n");
		int x = 1;
		for (String key : developer.getVehicle().keySet()) {
			System.out.println("\t" + x++ + "." + " " + key + "-----" + developer.getVehicle().get(key));

		}

		System.out.println("\nBirthdays can be  follwing\n");

		Properties prop1 = developer.getBirthday();
		for (Object obj : prop1.keySet()) {
			System.out.println
		(obj + "  " + prop1.getProperty(obj.toString()));
		}

	}
}
