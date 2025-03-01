package ProjectAutomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyam", "12345");
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM TAP_PERSON WHERE MRN = '452135'" );
		while (rs.next()) 
		{
		String mrn= rs.getString("MRN");
		String FirstName = rs.getString("FIRST_NAME");
		String MiddleName = rs.getString("MIDDLE_NAME");
		String LastName = rs.getString("LAST_NAME");
		String Gender = rs.getString("GENDER");
		String DOB = rs.getString("DOB");
		System.out.println(mrn+FirstName+LastName);
		System.out.println ("______________");
		}
		

	}

}
