import org.com.bean.Birthday;
import org.com.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
	
	ApplicationContext
	  ctx=new ClassPathXmlApplicationContext
	  ("classpath:resource/projectContext.xml");
	
Person person=(Person)	ctx.getBean("person");
	
System.out.println("Person Information");
System.out.println("\t Id is "+person.getId());
System.out.println("\t Name is "+person.getName());
System.out.println("\n Birthday  is ");
	
Birthday birthday=person.getBirthday();

System.out.println
("\t "+birthday.getDay()+"-"+birthday.getMonth()+"-"+birthday.getYear());



	
	}
}
