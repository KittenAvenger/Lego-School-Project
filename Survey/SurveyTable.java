package Survey;


import java.sql.*;

import javax.swing.JOptionPane;


/**@author Anastasia Koni, Dennis Nielsen */
public class SurveyTable {

	//Inputs data from the survey in the survey table

	public static void Service (String input, String input2, String input3, String input4, String input5, String input6 ){
		 
		 
		 
		   try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 //System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 //System.out.println("Database connected");
			 		 
			 		 
			 Statement statement=connection.createStatement();
			 statement.execute ("INSERT INTO SURVEY (RATING, KIDAGE, PURCHASEDBYSELF,FORAKID,FORTHEME, WANTVARIETY) VALUES ("+input+", "+input2+","+input3+", "+input4+","+input5+","+input6+")");
			 
			
			 
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		}
	
	
	//Everything here is dead code that was tried but didn't make it in the final version
	
	/*

	public static void createDataBase() {
		try{
		Class.forName("com.mysql.jdbc.Driver");

		 Connection connection=DriverManager.getConnection
		 ("jdbc:mysql://localhost/lego", "root", "");
		 
		
		}
		catch (Exception e){
			
		}
	}
	public static Statement getS() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException cnfe) {
			System.err.println("Couldn't find driver class: " + cnfe.getMessage());
			return null;
		}
		System.out.println("Sucessfully loaded driver");
		
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost/Survey", "root", "");
		} catch(SQLException se) {
			System.out.println("ERROR GETTING CONNECTION " + se.getMessage());
			return null;
		}
		System.out.println("Sucessfully Connected to DB");
		
		Statement s = null;
		
		try {
			s = c.createStatement();
		} catch(SQLException se) {
			System.out.println("ERROR CREATING STATEMENT " + se.getMessage());
			return null;
		}
		System.out.println("Statement created");		
		
		return s;
	}
	public Object[][] importTableSurveyFromDB() {

		int numberOfColumns = 8;
		
		Object[][] emptyTable = {{"","","","","","","",""}};
		
		Statement s = getS();
		
		ResultSet rs = null;
		try {
			rs = s.executeQuery("SELECT COUNT(*) FROM `SURVEY`");
		} catch(SQLException se) {
			System.out.println("ERROR IN SQL QUERY COUNT " + se.getMessage());
			return emptyTable;
		}
		System.out.println("SQL Query get table size successful");
		
		int resultSetSize = 1;
		try {
			resultSetSize = Integer.parseInt(rs.getString(1));
		} catch (NumberFormatException e) {
			System.out.println("UNABLE TO CONVERT STRING TO INT FOR ARRAY SIZE");
			e.printStackTrace();
			return emptyTable;
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION");
			e.printStackTrace();
			return emptyTable;
		}

		try {
			rs = s.executeQuery("SELECT * FROM SURVEY");
		} catch(SQLException se) {
			System.out.println("ERROR IN SQL QUERY " + se.getMessage());
			return emptyTable;
		}
		System.out.println("SQL Query successful");
			
		Object[][] returnObject = new Object[resultSetSize][numberOfColumns];
		
		int index = 0;
		try {
			while(rs.next()) {

				System.out.println("ROW = " + index +" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				returnObject[index][0] = rs.getString(1);
				returnObject[index][1] = rs.getString(2);
				returnObject[index][2] = rs.getString(3);

				index++;
			}
		} catch(SQLException se) {
			System.out.println("ERROR RETREIVING VALUES: " + se.getMessage());
			return emptyTable;
		}
		
		return returnObject;
	}
	
	public static void Purchase (String input ){
		 
		 
		 
		   try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 //System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 //System.out.println("Database connected");
			 		 
			 		 
			 Statement statement=connection.createStatement();
			 statement.execute ("INSERT INTO SURVEY (PURCHASEDBYSELF) VALUES ("+input+")");
			 
			
			 
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		}
	public static void Kid  (String input ){
		 
		 
		 
		   try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 //System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 //System.out.println("Database connected");
			 		 
			 		 
			 Statement statement=connection.createStatement();
			 statement.execute ("INSERT INTO SURVEY (FORAKID) VALUES ("+input+")");
			 
			
			 
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		}
	public static void Age (String input ){
		 
		 
		 
		   try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 //System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 //System.out.println("Database connected");
			 		 
			 		 
			 Statement statement=connection.createStatement();
			 statement.execute ("INSERT INTO SURVEY (KIDAGE) VALUES ("+input+")");
			 System.out.println(input);
			
			 
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		}
	public static void Theme (String input ){
		 
		 
		 
		   try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 //System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 //System.out.println("Database connected");
			 		 
			 		 
			 Statement statement=connection.createStatement();
			 statement.execute ("INSERT INTO SURVEY (FORTHEME) VALUES ("+input+")");
			 
			
			 
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		}
	public static void Variety (String input ){
		 
		 
		 
		   try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 //System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 //System.out.println("Database connected");
			 		 
			 		 
			 Statement statement=connection.createStatement();
			 statement.execute ("INSERT INTO SURVEY (WANTVARIETY) VALUES ("+input+")");
			 
			
			 
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		}*/ 
}
