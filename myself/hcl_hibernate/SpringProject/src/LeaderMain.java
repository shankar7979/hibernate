import org.com.bean.Book;
import org.com.bean.Leader;
import org.com.bean.Speech;
import org.com.bean.Story;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LeaderMain {

	public static void main(String[] args) {
	
	ConfigurableApplicationContext	
	//ApplicationContext 
	ctx=new ClassPathXmlApplicationContext
			("classpath:resource/application.xml");
	
Leader leader=	ctx.getBean("leader", Leader.class);
	
System.out.println("Leader Information  ");
System.out.println("\tId is "+leader.getId());
System.out.println("\tName is "+leader.getName());
System.out.println("\tSSNB is "+leader.getSsnb());


Speech speech=leader.getSpeech();

System.out.println("\n Speech information ");
System.out.println("\tId is "+speech.getSpeech_id());
System.out.println("\tName is "+speech.getSpeech_name());
System.out.println("\tLocation is "+speech.getSpeech_location());

ctx.close();

	}
}
