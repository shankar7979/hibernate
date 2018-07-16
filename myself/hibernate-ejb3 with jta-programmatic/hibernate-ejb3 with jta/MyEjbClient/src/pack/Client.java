package pack;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		InitialContext ctx=new InitialContext();
		
		MyTestRemote  test=	(MyTestRemote)ctx.lookup("MyTest/remote");
		
		List<Book> list=test.getData();
		
		
		for (Book book : list) {
			response.getWriter().print("<br>"+book.getId()+"   "+book.getName());
		}
		
		
	} catch (NamingException e) {
		e.printStackTrace();
	}
	
	}

}
