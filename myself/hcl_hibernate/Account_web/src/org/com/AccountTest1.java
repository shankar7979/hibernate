package org.com;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class AccountTest1
 */
@WebServlet("/AccountTest1")
public class AccountTest1 extends HttpServlet {
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

		SQLQuery qr1 = session.createSQLQuery("select * from account");

		List alist = qr1.list();

		for (Object obj : alist) {
			Object object[] = (Object[]) obj;
			out.print("<br>" + object[0] + "\t" + object[1]);
		}
		
		qr1 = session.createSQLQuery("select * from account").addEntity(Account.class);
		List<Account> alist1 = qr1.list();
		
		for (Account act1 : alist1) {
			out.print(act1.getId()+"\t"+act1.getName());
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
