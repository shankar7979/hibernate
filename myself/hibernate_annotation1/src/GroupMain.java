import org.com.model.one_to_many.Group;
import org.com.model.one_to_many.Story;
import org.com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.util.io.StreamCopier;

public class GroupMain {
public static void main(String[] args) {
	SessionFactory factory = HibernateUtil.retrieveSF();

	Session session = factory.openSession();
	Transaction tr = session.beginTransaction();		
	Group group=new Group();	
	group.setGr_name("child group");	
	Story story[]=new Story[3];	
	story[0]=new Story();
	story[0].setName("lion story");	
	story[1]=new Story();
	story[1].setName("king story");	
	story[2]=new Story();
	story[2].setName("prince story");
	group.setStory(story);	
	tr.begin();
	
	session.save(group);
	session.save(story[0]);
	session.save(story[1]);
	session.save(story[2]);
	
	tr.commit();
	
}
}
