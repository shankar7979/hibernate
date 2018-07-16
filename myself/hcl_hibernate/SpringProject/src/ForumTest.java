import org.com.bean.Forum;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ForumTest {

	public static void main(String[] args) {

		BeanFactory beanFactory = new FileSystemXmlApplicationContext("src/resource/beans.xml");

		/*
		 * new ClassPathXmlApplicationContext ("classpath:resource/beans.xml");
		 */

		Forum forum = (Forum) beanFactory.getBean("forum");
		Forum forum1 = beanFactory.getBean("forum", Forum.class);

		forum1.forumInfo();

	}
}
