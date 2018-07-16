import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import pack.Project;


public class testProject1 {
public static void main(String[] args) {
	Configuration cfg = new Configuration().configure("project.cfg.xml");
	Session session = cfg.buildSessionFactory().openSession();
Query namedquery=session.getNamedQuery("getAllProject");

List<Project> list=namedquery.list();

for (Project project : list) {
	System.out.print("\n"+project.getPid());
	System.out.print("\t"+project.getPname());
	
}


}
}
