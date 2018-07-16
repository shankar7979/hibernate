import java.util.List;
import java.util.Scanner;

import org.com.dao.ItemDao;
import org.com.model.Item;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemClient {

	public static void main(String[] args) {

		BeanFactory fact = new ClassPathXmlApplicationContext("beans.xml");
		ItemDao dao = fact.getBean("item",ItemDao.class);
		Item item=new Item();
		item.setId(676776);
		item.setName("book");
		item.setCost(556);
				
		System.out.println(dao.addBook(item));
	}
}
