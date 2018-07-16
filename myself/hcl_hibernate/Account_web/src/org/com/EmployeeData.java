package org.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/EmployeeData")
public class EmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	DataSource ds;
	InitialContext ctx;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
		ctx=new InitialContext();
ds=(DataSource)	ctx.lookup("java:comp/env/jdbc/myoracle");		
con=ds.getConnection();			

/*Class.forName("oracle.jdbc.driver.OracleDriver");
			  con = DriverManager.getConnection(
"jdbc:oracle:thin:@10.113.17.58:1521:appsdb01", "java1629", "java1629");*/

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}     
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out=response.getWriter();
	try {
		st=con.createStatement();
		out.print
	("<table align='center' border='1' bgcolor='aqua' width=50%>");
		
		rs=st.executeQuery("select * from employee");
		ResultSetMetaData metaData=rs.getMetaData();
		out.print("<tr>");
		for (int i = 1; i <=metaData.getColumnCount(); i++) {
			out.print("<th>"+metaData.getColumnName(i)+"</th>");
		}
		out.print("</tr>");
		while(rs.next())
		{
	out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
		}
		out.print("<table>");	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		try {
			con.close();
			st.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
			}	
	
	
	}


}
