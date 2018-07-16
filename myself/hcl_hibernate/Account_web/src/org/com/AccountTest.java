package org.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.model.Account;
import org.com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

@WebServlet("/AccountTest")
public class AccountTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SessionFactory sf;
	Session session;
	Transaction tr;
	Query qr;

	@Override
	public void init(ServletConfig config) throws ServletException {

		sf = HibernateUtil.getSF();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		session = sf.openSession();

		// qr = session.createQuery("from Account");
		qr = session.getNamedQuery("findall");

		List<Account> act_list = qr.list();

		out.print("<table border='1' bgcolor='pink' width=50% align='center'>");

		for (Account account : act_list) {

			out.print("<tr><td>" + account.getId() + "</td><td>"
					+ account.getName() + "</td><td>" + account.getBalance()
					+ "</td><td>");
			out.print(account.getCity() + "</td></tr>");
		}

		out.print("</table>");

		qr = session
				.createQuery("select a.city, avg(a.balance) from Account a group by a.city");

		List list1 = qr.list();

		out.print("<br><br><br><br><table border='1' bgcolor='pink' width=50% align='center'>");

		for (int x = 0; x < list1.size(); x++) {
			Object obj[] = (Object[]) list1.get(x);

			out.print("<tr><td>" + obj[0] + "</td><td> " + obj[1]
					+ "</td></tr>");
		}

		out.print("</table>");
		out.print("<br><br><br><br><table border='1' bgcolor='pink' width=50% align='center'>");

		for (Object object : list1) {
			Object obj[] = (Object[]) object;
			out.print("<tr><td>" + obj[0] + "</td><td> " + obj[1]
					+ "</td></tr>");

		}

		out.print("</table>");

		out.print("search for id 1001");
		
		qr = session.getNamedQuery("search1");
		// from Account a where a.id=:id -- named based parameter
		//qr.setInteger("id", 1001);

		//from Account a where a.id=:? -- position based
		qr.setInteger(0, 113);
		
		List<Account> elist1 = qr.list();

		if (elist1.size()==1) {
			out.print("Record found");
			Account act = elist1.get(0);

			out.print(act.getId() + "\t" + act.getName() + "\t"
					+ act.getBalance());
		} else
			out.print("Record not found");

	}

}
