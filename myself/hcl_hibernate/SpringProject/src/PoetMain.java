import org.com.bean.Poem;
import org.com.bean.Poet;
import org.com.bean.PoetConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PoetMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx=
				new AnnotationConfigApplicationContext
		(PoetConfig.class);
	
Poet poet=	ctx.getBean(Poet.class);

System.out.println("poet Information ");
System.out.println("\tid is "+poet.getId());
System.out.println("\tname is "+poet.getName());
System.out.println("\tlanguage is "+poet.getLanguage());
System.out.println("\tpoet is "+poet.getState());

System.out.println("\n\nPoem Information ");
Poem poem=poet.getPoem();

System.out.println("\tid is "+poem.getPoem_id());
System.out.println("\tid is "+poem.getPoem_name());

	}
}
