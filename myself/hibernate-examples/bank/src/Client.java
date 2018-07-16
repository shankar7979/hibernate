import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class Client {
public static void main(String[] args) {
	
	
	
	
	
	
	
	
	
	
Session ses=new Configuration().configure().buildSessionFactory().openSession();
bank b=new bank();
b.setName("ssssss");

ses.save(b);ses.flush();
ses.close();

}
}
