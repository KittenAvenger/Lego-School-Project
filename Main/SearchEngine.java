package Main;
import java.sql.*;

import javax.swing.JOptionPane;

/** @author Dennis Nielsen, Johan Hermansson */

public class SearchEngine {
	
	
	//Checks the word in the searchfield and counts if it has been added to the database, if it hasn't it adds a new row, otherwise it adds one to amount

	public static void CountWords(String word){
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 System.out.println("Database connected");
			 
			 
			 int count=1;		 
			 
			 
			 
			 
			 
			 Statement statement=connection.createStatement();
			 ResultSet rs=statement.executeQuery("Select count(*) from searchengine where word= '"+word+"'");
			 rs.next();
			 String check=rs.getString(1);
			 if(check.equals("0")){
				 statement.execute("INSERT INTO searchengine VALUES ('"+word+"', "+count+")");
			 }
			 else{statement.executeUpdate("update searchengine set count=count+1 where word='"+word+"'");}
			
			 
			 
			
		 }
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		  }
	
}
