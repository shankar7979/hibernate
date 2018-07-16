import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Servlet implementation class Client
 */
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Configuration cfg=new AnnotationConfiguration().configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		PrintWriter out=response.getWriter();
		
		Emp e=new Emp();
		
		Transaction tr=session.beginTransaction();
		
//		e.setId(1005);
//		e.setName("sita");
//		session.save(e);
//		tr.commit();
		
		
		Query qr=session.createQuery("from Emp");
		
		
		List<Emp> list=qr.list();
		
		
		Iterator<Emp> it=list.iterator();
		
		while(it.hasNext()){
			Object o=it.next();
			Emp em=(Emp)o;
		out.println("id is "+em.getId()+".....name is "+em.getName());
			
		}
		
		
		
		
		
		
		
		
		
	}

}
