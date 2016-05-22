package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class JDBC {
	
	Statement SQL;
	Connection connection;
	
	
	//Creates a connection to the database lego


public  JDBC () throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
		SQL = connection.createStatement();
		if (connection.isClosed()){
			System.out.println("Connection is closed");
		}
	}
}