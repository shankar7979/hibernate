import org.com.bean.Product;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
	
		BeanFactory beanFactory = 
				new 
				FileSystemXmlApplicationContext
				("src/resource/context.xml");

		Product product=beanFactory.getBean
				("prd1", Product.class);

		System.out.println("Product id "+product.getId());
		System.out.println("Product name "+product.getName());
		System.out.println("Product cost "+product.getCost());
		
	}
}
