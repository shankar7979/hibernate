package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MySession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		SessionFactory sessionfac = null;
		Session session1 = null;
		Transaction tr = null;

		try {
			sessionfac = new Configuration().configure().buildSessionFactory();
			// NewHibernateUtil.getSessionFactory();
			session1 = sessionfac.openSession();
			tr = session1.beginTransaction();

			String name, s;
			int id = 0;
			Emp emp;

			s = request.getParameter("combo1");

			if (s.equals("add")) {
				id = Integer.parseInt(request.getParameter("id"));
				name = request.getParameter("name");

				emp = new Emp();
				emp.setId(id);
				emp.setName(name);
				tr.begin();
				session1.save(emp);
				tr.commit();
				out.print("<br>record added");
			}

			if (s.equals("find")) {
				id = Integer.parseInt(request.getParameter("id"));

				emp = (Emp) session1.load(Emp.class, id);
				if (emp != null)
					out.println("employee with id " + id
							+ " is available\n name is " + emp.getName());
				else
					out.print(id + " is not available for any employee");
			}

			if (s.equals("update")) {
				id = Integer.parseInt(request.getParameter("id"));

				emp = (Emp) session1.load(Emp.class, id);
				if (emp != null) {
					name = request.getParameter("name");

					emp.setId(id);
					emp.setName(name);
					tr.begin();
					session1.save(emp);
					tr.commit();
					out.println("Id " + id + " is updated with name " + name);
				} else {
					out.print(id + " is not available for any employee");
				}
			}

			if (s.equals("delete")) {
				id = Integer.parseInt(request.getParameter("id"));

				emp = (Emp) session1.load(Emp.class, id);
				if (emp != null) {
					tr.begin();
					session1.delete(emp);
					tr.commit();
					out.println("record with id " + id + " is deleted ");
				} else {
					out.print(id + " is not available for any employee");
				}
			}

			if (s.equals("findall")) {
				System.out.println("findAll called .......");
				List<Emp> list = session1.createQuery("from Emp").list();

				for (Emp e : list) {
					out.print("<br>" + e.getId() + "   " + e.getName());
				}
			}
			session1.close();
		}

		catch (HibernateException e) {
			// tr.rollback();
			out.print(e.getMessage());
			e.printStackTrace();
		}
	}
}
