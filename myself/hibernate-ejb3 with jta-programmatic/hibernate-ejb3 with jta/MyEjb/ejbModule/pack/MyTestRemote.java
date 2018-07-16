package pack;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface MyTestRemote {
	
	List<Book> getData();

}
