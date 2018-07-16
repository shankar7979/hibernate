import org.com.bean.Book;
import org.com.bean.Story;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookMain {

	public static void main(String[] args) {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext
			("classpath:resource/application.xml");
	
Book book= 	ctx.getBean("book", Book.class);
	
System.out.println(book);




	}
}
