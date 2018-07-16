import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class EmpApp extends JFrame{
	
	
	public EmpApp() throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection connection=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

	Statement st=connection.createStatement();
ResultSet rs=st.executeQuery("select * from student");

setLayout(new FlowLayout());
JTextField t1,t2,t3;

while(rs.next()){
	t1=new JTextField(rs.getString(1));
	t2=new JTextField(rs.getString(2));
	t3=new JTextField(rs.getString(3));
	
	add(t1);
	add(t2);
	add(t3);
}
	
	
	
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE)
;
	pack();
	}
	
	
	public static void main(String[] args) {
	try {
		new EmpApp();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	

}
