package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.User;
import pack.UserDAO;
import pack.UserDAOImpl;

public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String choice = request.getParameter("op");
		UserDAO udi = new UserDAOImpl();
		User usr; 
		
		boolean status = false;
		if (choice.equals("add")) {
			String name = request.getParameter("name");
			int uid = Integer.parseInt(request.getParameter("uid"));
			int salary = Integer.parseInt(request.getParameter("salary"));
			udi.addUser(uid, name, salary);
			out.print("user data added");
		}
		else if (choice.equals("remove")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			status = udi.removeUser(uid);
			if (status)
				out.print("user removed with id " + uid);
			else
				out.print("user  id is not available");
		}
		else if (choice.equals("showall")) {
	List<User> list=	udi.showAll();
	for (User user : list) {
		out.println("<br>User Name "+user.getName());
		out.println("User Salary "+user.getSalary());
		out.println("User Uid "+user.getUid());
	}
	
		}	
		
		else if (choice.equals("find")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			 usr= udi.findUser(uid);
			if (usr!=null){
				out.println("user found");
			out.println("<br>User Name "+usr.getName());
			out.println("<br>User Salary "+usr.getSalary());
			out.println("<br>User Uid "+usr.getUid());
			}			else
				out.print("user  id is not available");
		}
	}

}
