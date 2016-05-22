package CreateUser;
import java.sql.*;
import javax.swing.*;
/**
 * @author Johan
 * @author Dennis
 * Unused package, first we used it to create account but now we use a new and better.
 *
 */
public class CreateAccount {
	
	static String newUser, newPass, firstname, lastname, age;
/**
 * @author Johan
 * @author Dennis
 * create new account in database.
 */
public static void CreateAccount(){
	newUser = CreatePane.newUserField.getText();
	newPass = new String (CreatePane.newPassField.getPassword());
	firstname = CreatePane.firstnameField.getText();
	lastname = CreatePane.lastnameField.getText();
	age = CreatePane.ageField.getText();
	CreateUser.createFrame.setVisible(false);
	 
	 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		  System.out.println("Driver loaded");
		 
		  Connection connection=DriverManager.getConnection
		  ("jdbc:mysql://localhost/billing", "root", "");
		  System.out.println("Database connected");
		 		 
		 		 
		  Statement statement1=connection.createStatement();
		  Statement statement2=connection.createStatement();
		  Statement statement3=connection.createStatement();
		  Statement statement4=connection.createStatement();
		  statement1.executeUpdate("INSERT INTO USERS (USERNAME, PASSWORD) VALUES ('"+newUser+"', '"+newPass+"')");
		  statement2.executeUpdate("INSERT INTO BILLING (FIRSTNAME, LASTNAME, AGE) VALUES ('"+firstname+"', '"+lastname+"', "+age+")");
		 
		 
	
}catch (Exception ae){
	JOptionPane.showMessageDialog(null,"Can't connect to database");
	ae.printStackTrace();
}
}
}
