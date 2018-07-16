package resource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class EmployeeData {

	public static void main(String[] args) throws SQLException {
	//DataSource ds=new OracleDataSource();	
		
	OracleDataSource ds=new OracleDataSource();

      ds.setPassword("java1629");
      ds.setUser("java1629");
      ds.setURL("jdbc:oracle:thin:@10.113.17.58:1521:appsdb01");
      
      
      Connection con=ds.getConnection();
      Statement st=con.createStatement();
    ResultSet rs=  st.executeQuery("select * from student1");
      
      
    while(rs.next()){
    
    	System.out.println
    (rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));	
    	
    }



		
	}
}
