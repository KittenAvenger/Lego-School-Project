package Main;
import java.awt.Component;
import java.sql.*;

import javax.swing.JOptionPane;


/**@author Johan Hermansson */
public class CheckAmount {
	
	static boolean outofstock=false;
	
	//Checks amount of products left in a company's warehouse
	
	public static void SubtractAmount (String companyid, String pID){
		 
		 
		 
		   try{
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Driver loaded");
			 
			 Connection connection=DriverManager.getConnection
			 ("jdbc:mysql://localhost/lego", "root", "");
			 System.out.println("Database connected");
			 
			 outofstock=false;
			 		 
			 Statement statement=connection.createStatement();
			 
			 ResultSet rs=statement.executeQuery("select amount from companyprice where companyid="+companyid+" and productId="+pID+";");
			 rs.next();
			 String check=rs.getString(1);
			 if(check.equals("0")){
				 JOptionPane.showMessageDialog(null, "Product is out of stock" );
				 outofstock=true;
			 }
			 else{
			 statement.executeUpdate
			 ("update companyprice  set amount=amount-1 where companyid="+companyid+" and productId="+pID+";");
			 
			 }
			
			}
			
		    catch (SQLException | ClassNotFoundException a){
			a.printStackTrace();
		    }
		  }
	
	//Adds the same amount that was subtracted if you decided not to go through buying the products or exiting the application before pressing confirm order
	
	public static void AddAmount (String companyid, String pID){
		 
		try{
				 Class.forName("com.mysql.jdbc.Driver");
				 System.out.println("Driver loaded");
				 
				 Connection connection=DriverManager.getConnection
				 ("jdbc:mysql://localhost/lego", "root", "");
				 System.out.println("Database connected");
				 
				 outofstock=false;
				 		 
				 Statement statement=connection.createStatement();
				 
				
				 statement.executeUpdate
				 ("update companyprice  set amount=amount+1 where companyid="+companyid+" and productId="+pID+";");
				
				
				}
				
			    catch (SQLException | ClassNotFoundException a){
				a.printStackTrace();
			    }
	}
	
	//Gets data about every product in the Cart List
	public static void Amount(){
		for(int i = 0; i < CartButton.ItemList.size();i++){
			String item=CartButton.ItemList.get(i);
			String[] items=item.split(" ");
			String cID=items[0];
			String pID=items[1];
			AddAmount(cID, pID);
			}
	}
}
