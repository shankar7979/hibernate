import org.com.bean.Account;
import org.com.bean.Account.AccountPk;
import org.com.bean.Book;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class AccountMain {

	public static void main(String[] args) {
		
//	Configuration cfg=new AnnotationConfiguration().configure();
		Configuration cfg=new AnnotationConfiguration().configure
				("hibernate1.cfg.xml");
		
Session session=cfg.buildSessionFactory().openSession();
	session.getTransaction().begin();

	Account act=new Account();
	act.setDescription("My account");
	AccountPk pk=new AccountPk();
	pk.setMyid(2001);
	pk.setName("ram kumar");
	
	act.setId(pk);
	
	session.save(act);
	session.getTransaction().commit();
	System.out.println("Account record added");
	
	}
}
