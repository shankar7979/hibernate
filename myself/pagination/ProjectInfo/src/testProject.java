import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import pack.Project;

public class testProject {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("project.cfg.xml");
		Session session = cfg.buildSessionFactory().openSession();
		// session.getTransaction().begin();
		// Project prj=new Project();
		// prj.setPname("java project");
		// session.save(prj);
		// session.getTransaction().commit();

		// System.out.println("data added");
		// Query query=
		// session.createQuery
		// ("from Project where pname=?");
		// query.setString(0, "java project");

		// Query query=
		// session.createQuery
		// ("from Project where pname=:pname")
		// .setParameter("pname", "java project");

		Project prj1 = new Project();
		prj1.setPid(18);
		prj1.setPname("java project");
		int c = 1;
		Query query = null;
		List<Project> list = null;
		for (int x = 1; x <= 4; x++) {
			query = session
					.createQuery("from Project where pid>=:pid and pname=:pname ");
			query.setProperties(prj1);
			query.setMaxResults(20);
			query.setFirstResult(c);
			query.setComment("using pagination");
			c = c + 20;
			query.setFetchSize(20);

			list = query.list();
			System.out.println("==================================");
			for (Project project : list) {
				System.out
						.println(project.getPid() + "\t" + project.getPname());
			}
			System.out.println("==================next page ===============");
		}
	}

}
