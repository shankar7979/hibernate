import org.com.bean.Product;
import org.com.bean.Survey;
import org.com.bean.SurveyImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SurveyMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = 
				new 
				FileSystemXmlApplicationContext
				("src/resource/context.xml");

/*Survey survey=beanFactory.getBean
				("survey", Survey.class);*/
		
		SurveyImpl survey=beanFactory.getBean
				("survey", SurveyImpl.class);		

System.out.println(survey.getSurveyInfo());

	}
}
