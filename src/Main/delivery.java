package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * @author Johan Hermansson
 * Add to table deliver in database after purchase.
 *
 */
public class delivery {
	static Connection connection;
	
	/**
	 * @author Johan Hermansson
	 * Send every object from the list to the add-method
	 */
	public static void addDelivery(String uId){
		for(int i = 0; i < CartButton.ItemList.size(); i++){
			String item = CartButton.ItemList.get(i);
			String[] deliveryParts = item.split(" ");
			String cId = deliveryParts[0];
			String pId = deliveryParts[1];
			addingDelivery(cId, pId, uId);
			
		}
	}
	/**
	 * @author Johan Hermansson
	 * Add every object to the database
	 */
	public static void addingDelivery(String cId, String pId, String uId){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		}
		catch (Exception e)	{
			System.out.println("Couldn't load driver");
		}
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
			System.out.println("Connected to DB");
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Couldn't connect to DB");
		}
		
		
		try {
			Statement statement=connection.createStatement();
			ResultSet rs = null;
			ResultSet rs1=null;
			
			rs = statement.executeQuery("SELECT count(*) FROM Delivery;");
			rs.next();
			String amount = rs.getString(1);
			
			
			rs1=statement.executeQuery("Select count(*) from timesbought where cID="+cId+" and pID="+pId+";");
			rs1.next();
			String count=rs1.getString(1);
			if(amount == "0"){
				statement.execute("INSERT INTO Delivery values (1, "+cId+", "+pId+", "+uId+", 'false');");
			}
			else{
				int amountInt = Integer.parseInt(amount);
				
				statement.execute("INSERT INTO Delivery values ("+(amountInt+1)+", "+cId+", "+pId+", "+uId+", 'false');");
				
			}
			
			/**@author Dennis Nielsen */
			
			//Inserts data about the product in the timesbought table, with info about company ID, product ID and times bought
			
			if(count.equals("0")){
				
				statement.execute("Insert into timesbought values ("+cId+", "+pId+", 1)");
			}
			else{statement.executeUpdate("update timesbought set timesbought=timesbought+1 where cId="+cId+" and pId="+pId+";");}
		}
		catch(Exception e){
			e.printStackTrace();
		}
//		
	}
	public static void TimesBought(String cId, String pId){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
			System.out.println("Connected to DB");
			
			Statement statement=connection.createStatement();
			ResultSet rs1=null;
			rs1=statement.executeQuery("Select count(*) from timesbought where cID="+cId+" and pID="+pId+";");
			rs1.next();
			
		}
		catch(Exception e){
			
		}
	}
	
}


