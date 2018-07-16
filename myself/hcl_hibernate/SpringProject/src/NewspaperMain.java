import org.com.bean.NewsPaper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class NewspaperMain {

	public static void main(String[] args) {
ConfigurableApplicationContext 
		
//BeanFactory 
beanFactory = new FileSystemXmlApplicationContext
("src/resource/beans.xml");

NewsPaper newsPaper=    
beanFactory.getBean("npaper", NewsPaper.class);

System.out.println("News paper Information");

System.out.println("id is "+newsPaper.getId());
System.out.println("name is "+newsPaper.getName());
System.out.println("cost is "+newsPaper.getCost());

beanFactory.close();
	}
}
