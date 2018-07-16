package org.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.com.bean.Employee;

public class EmployeeDao {
	
	private DataSource ds;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	Statement st;
	Connection con;
	ResultSet rs;

	public  void EmployeeDao() throws SQLException {
		con = ds.getConnection();
	}

	List<Employee> elist;
	Employee emp;

	public List<Employee> getEmp() throws SQLException {
		st = con.createStatement();
		rs = st.executeQuery("select * from student1");

		elist = new ArrayList<Employee>();

		while (rs.next()) {
			emp = null;
			emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSubject(rs.getString(3));

          elist.add(emp);
		}
       return elist;
	}
}
