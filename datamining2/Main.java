package datamining2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * @author Johan
 * Unused code for datamining what the user bought.
 *
 */
public class Main {
	static Connection connection;
	static int companyId, productId;
	
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		}
		catch (Exception e)	{
			System.out.println("Couldn't load driver");
		}
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/datamining", "root", "");
			System.out.println("Connected to DB");
		}
		catch (Exception e){
			System.out.println("Couldn't connect to DB");
		}
		companyId = 3;
		productId = 123454545;
		try {
			Statement statement=connection.createStatement();
			ResultSet rs = null;
			
			rs = statement.executeQuery("SELECT * FROM time WHERE pId = '" +productId+ "' and cId = '" +companyId+ "';");
			
			if(!rs.next()) {
				statement.execute("INSERT INTO time values ("+companyId+", "+productId+", 1);");
				
			}
			else{
				
				statement.executeUpdate("UPDATE time SET bought = bought+1 WHERE pId = '" +productId+ "' and cId = '" +companyId+ "';");
				

			}
		}
		catch(Exception a) {
			
		}
		

	}
	
}
