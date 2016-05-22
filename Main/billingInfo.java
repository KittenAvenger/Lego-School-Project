package Main;



/**@Author Johan Hermansson */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//JFrame that displays the customer's billing information



 
public class billingInfo {
	
	static JFrame loginFrame, billingFrame, loginBuyFrame;
	static JPanel loginButtonsPanel, loginPanel, infoPanel, firstnamePanel, lastnamePanel, adressPanel, phonePanel, agePanel, cardPanel, cardHolderPanel, confirmPanel,
	usernamePanel, passwordPanel, loginBuyPanel;
	static JTextField firstnameField, lastnameField, adressField, phoneField, ageField, cardNrField, cvvField, cardHolderField, usernameField;
	static JPasswordField passwordField;
	static JLabel infoLabel, usernameLabel, passwordLabel;
	static JButton confirm, loginBuy;
	static Connection connection;
	static String username;
	static String password;
	static boolean LogSuccess=false;
	private static JLabel lblPleaseLogIn;
	static String usertype;
	public static String companyID, userID;
	
	static JFrame createUserFrame;
	static JPanel  createPanel;
	
	static JButton confirmButton;
	static JLabel  firstnameLabel, lastnameLabel, adressLabel, phoneLabel,
	ageLabel, cardNrLabel, cvvLabel, cardHolderLabel;
	
	
	

	//Creates a window if you haven't logged in and trying to buy products
	
	
	public static void Buy () {
		loginFrame = new JFrame("Login to buy");
		loginFrame.getContentPane().setLayout(new GridLayout(3, 1, 10, 10));
		
		loginPanel = new JPanel();
		loginFrame.getContentPane().add(loginPanel);
		
		loginButtonsPanel = new JPanel();
		loginFrame.getContentPane().add(loginButtonsPanel);
		
		lblPleaseLogIn = new JLabel("Please log in or create an account to buy products");
		loginButtonsPanel.add(lblPleaseLogIn);
		
		loginFrame.setLocationRelativeTo(null);
		loginFrame.pack();
		loginFrame.setDefaultCloseOperation(loginFrame.DISPOSE_ON_CLOSE);
		loginFrame.setVisible(true);
	}
	
	//Unused method
	
	public static void login(){
		loginBuyFrame = new JFrame("LOGIN");
		loginBuyFrame.getContentPane().setLayout(new GridLayout(3, 1, 10, 10));
		
		usernamePanel = new JPanel();
		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(20);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		loginBuyFrame.getContentPane().add(usernamePanel);
		
		passwordPanel = new JPanel();
		passwordLabel = new JLabel("Username: ");
		passwordField = new JPasswordField(20);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		loginBuyFrame.getContentPane().add(passwordPanel);
		
		loginBuyPanel = new JPanel();
		loginBuy = new JButton("LOGIN");
		loginBuy.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 checkLogin();
          }
      });
		loginBuyPanel.add(loginBuy);
		loginBuyFrame.getContentPane().add(loginBuyPanel);
		loginBuyFrame.setLocationRelativeTo(null);
		loginBuyFrame.pack();
		loginBuyFrame.setDefaultCloseOperation(loginFrame.DISPOSE_ON_CLOSE);
		loginBuyFrame.setVisible(true);
		
	}
	
	//Main method that checks if your login exist in the database and what user type has logged in
	
	public static void checkloginMF(){
		username = Ribz.LoginField.getText();
	 password = new String(Ribz.PasswordField.getPassword());
		
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
			System.out.println("Couldn't connect to DB");
		}
		
		try {
			System.out.println("a");
			Statement statement=connection.createStatement();
			
			ResultSet rs = null;
			rs=statement.executeQuery("Select * from users where Username='"+username+"' and Password='"+password+"'");
			
			
				
				 
				
			
			
			
			if(rs.next()){
			LogSuccess=true;
			
			rs=statement.executeQuery("Select * from users where Username='"+username+"' and Password='"+password+"' ");
			
			 rs.next();
			 String userName=rs.getString(1);
			  usertype=rs.getString(4);
			  
			  if(usertype.equals("Company")){
				  
				  rs=statement.executeQuery("Select companyID from company where CompanyName='"+userName+"'");
					rs.next();
					companyID=rs.getString(1);
					
					 Ribz.BuyProducts.setVisible(false);
					 Ribz.ClearList.setVisible(false);
			  }
			  if(usertype.equals("User")){
				  rs=statement.executeQuery("Select userID from users where userName='"+userName+"'");
					rs.next();
					userID=rs.getString(1);
			  }
			  
			 
			

			}
			else{JOptionPane.showMessageDialog(null, "Username or password is not working\nTry Again");}
		}
		catch (Exception a){
			a.printStackTrace();
			
		}
	}
	
	//Gets the billing information for the logged in customer
	
	public static void checkLogin(){
	    username = Ribz.LoginField.getText();
		String password = new String(Ribz.PasswordField.getPassword());
//		String username = "Johan";
//		String password = "hej";
		
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
			System.out.println("Couldn't connect to DB");
		}
		try {
			Statement statement=connection.createStatement();
			ResultSet rs = null;
			
			rs = statement.executeQuery("SELECT Firstname FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");
			
			
			
			rs.next();
			String fname = rs.getString(1);
			
			rs = statement.executeQuery("SELECT Lastname FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			rs.next();
			String lname = rs.getString(1);
			rs = statement.executeQuery("SELECT Adress FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			
			rs.next();
			String adress = rs.getString(1);
			rs = statement.executeQuery("SELECT Phonenumber FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			
			rs.next();
			String phone = rs.getString(1);
			rs = statement.executeQuery("SELECT Age FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			rs.next();
			String age = rs.getString(1);
			rs = statement.executeQuery("SELECT Cardnumber FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			rs.next();
			String cardnr = rs.getString(1);
			rs = statement.executeQuery("SELECT CVVcode FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			rs.next();
			String cvv = rs.getString(1);
			rs = statement.executeQuery("SELECT Cardholder FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			rs.next();
			String cholder = rs.getString(1);
			
			
			buy(fname, lname, adress, phone, age, cardnr, cvv, cholder);
			
			
			
			
			
		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "Username or password is not working\nTry Again");
			a.printStackTrace();
		}
	}
	
	//Unused method
	
	public static void buy(){
		billingFrame = new JFrame("Billing Information");
		billingFrame.getContentPane().setLayout(new GridLayout(10, 1, 10, 10));
		infoPanel = new JPanel();
		infoLabel = new JLabel("Fill in all the fields and press confirm to complete your order");
		infoPanel.add(infoLabel);
		billingFrame.getContentPane().add(infoPanel);
		
		firstnamePanel = new JPanel();
		firstnameField = new HintTextField("Firstname");
		firstnameField.setColumns(25);
		firstnamePanel.add(firstnameField);
		billingFrame.getContentPane().add(firstnamePanel);
		
		lastnamePanel = new JPanel();
		lastnameField = new HintTextField("Lastame");
		lastnameField.setColumns(25);
		lastnamePanel.add(lastnameField);
		billingFrame.getContentPane().add(lastnamePanel);
		
		adressPanel = new JPanel();
		adressField = new HintTextField("Adress");
		adressField.setColumns(25);
		adressPanel.add(adressField);
		billingFrame.getContentPane().add(adressPanel);
		
		phonePanel = new JPanel();
		phoneField = new HintTextField("Phonenumber");
		phoneField.setColumns(25);
		phonePanel.add(phoneField);
		billingFrame.getContentPane().add(phonePanel);
		
		agePanel = new JPanel();
		ageField = new HintTextField("Age");
		ageField.setColumns(25);
		agePanel.add(ageField);
		billingFrame.getContentPane().add(agePanel);
		
		cardPanel = new JPanel();
		cardNrField = new HintTextField("Cardnumber");
		cardNrField.setColumns(17);
		cardPanel.add(cardNrField);
		cvvField = new HintTextField("CVV-code");
		cvvField.setColumns(8);
		cardPanel.add(cvvField);
		billingFrame.getContentPane().add(cardPanel);
		
		cardHolderPanel = new JPanel();
		cardHolderField = new HintTextField("Name of the cardholder");
		cardHolderField.setColumns(25);
		cardHolderPanel.add(cardHolderField);
		billingFrame.getContentPane().add(cardHolderPanel);
		
		confirmPanel = new JPanel();
		confirm = new JButton("CONFIRM ORDER");
		confirmPanel.add(confirm);
		billingFrame.getContentPane().add(confirmPanel);
		
		
		billingFrame.setLocationRelativeTo(null);
		billingFrame.pack();
		billingFrame.setSize(500,500);
		billingFrame.setDefaultCloseOperation(billingFrame.DISPOSE_ON_CLOSE);
		confirm.requestFocusInWindow();
		billingFrame.setVisible(true);
		
		
		
	}
	
	//Autofills all the fields in the billing information window
	
	public static void buy(String fname, String lname, String adress, String phone, String age, String cardnr, String cvv, String cholder){
		
		
		
		createUserFrame = new JFrame("Billing information");
		createUserFrame.setLayout(new GridLayout(10, 1, 10, 10));
		infoPanel = new JPanel();
		infoLabel = new JLabel("The products will be shipped to this adress");
		infoPanel.add(infoLabel);
		createUserFrame.add(infoPanel);
		
	/*	usernamePanel = new JPanel(new BorderLayout());
		usernameLabel = new JLabel(" Username");
		usernamePanel.add(usernameLabel, BorderLayout.WEST);
		usernameField = new JTextField(25);
		usernamePanel.add(usernameField, BorderLayout.EAST);
		createUserFrame.add(usernamePanel);
		
		passwordPanel = new JPanel(new BorderLayout());
		passwordLabel = new JLabel(" Password");
		passwordPanel.add(passwordLabel, BorderLayout.WEST);
		passwordField = new JPasswordField(25);
		passwordPanel.add(passwordField, BorderLayout.EAST);
		createUserFrame.add(passwordPanel);*/
		
		firstnamePanel = new JPanel(new BorderLayout());
		firstnameLabel = new JLabel(" Firstname");
		firstnamePanel.add(firstnameLabel, BorderLayout.WEST);
		firstnameField = new JTextField(25);
		firstnameField.setText(fname);
		firstnameField.setEditable(false);
		firstnameField.setColumns(25);
		firstnamePanel.add(firstnameField,  BorderLayout.EAST);
		createUserFrame.add(firstnamePanel);
		
		lastnamePanel = new JPanel(new BorderLayout());
		lastnameLabel = new JLabel(" Lastname");
		lastnamePanel.add(lastnameLabel, BorderLayout.WEST);
		lastnameField = new JTextField(25);
		lastnameField.setText(lname);
		lastnameField.setEditable(false);
		lastnamePanel.add(lastnameField, BorderLayout.EAST);
		createUserFrame.add(lastnamePanel);
		
		adressPanel = new JPanel(new BorderLayout());
		adressLabel = new JLabel(" Adress");
		adressPanel.add(adressLabel, BorderLayout.WEST);
		adressField = new JTextField(25);
		adressField.setText(adress);
		adressField.setEditable(false);
		adressPanel.add(adressField, BorderLayout.EAST);
		createUserFrame.add(adressPanel);
		
		phonePanel = new JPanel(new BorderLayout());
		phoneLabel = new JLabel(" Phonenumber");
		phonePanel.add(phoneLabel, BorderLayout.WEST);
		phoneField = new JTextField(25);
		phoneField.setText(phone);
		phoneField.setEditable(false);
		phonePanel.add(phoneField, BorderLayout.EAST);
		createUserFrame.add(phonePanel);
		
		agePanel = new JPanel(new BorderLayout());
		ageLabel = new JLabel(" Age");
		agePanel.add(ageLabel, BorderLayout.WEST);
		ageField = new JTextField(25);
		ageField.setText(age);
		ageField.setEditable(false);
		agePanel.add(ageField, BorderLayout.EAST);
		createUserFrame.add(agePanel);
		
		cardPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		cardNrLabel = new JLabel("Cardnumber");
		cardPanel.add(cardNrLabel);
		cardNrField = new JTextField(18);
		cardNrField.setText(cardnr);
		cardNrField.setEditable(false);
		cardPanel.add(cardNrField);
		cvvLabel = new JLabel("CVV-code");
		cardPanel.add(cvvLabel);
		cvvField = new JTextField(8);
		cvvField.setText(cvv);
		cvvField.setEditable(false);
		cardPanel.add(cvvField);
		createUserFrame.add(cardPanel);
		
		cardHolderPanel = new JPanel(new BorderLayout());
		cardHolderLabel = new JLabel(" Name of the cardholder");
		cardHolderPanel.add(cardHolderLabel, BorderLayout.WEST);
		cardHolderField = new JTextField(25);
		cardHolderField.setText(cholder);
		cardHolderField.setEditable(false);
		cardHolderPanel.add(cardHolderField, BorderLayout.EAST);
		createUserFrame.add(cardHolderPanel);

		createPanel = new JPanel();
		confirmButton = new JButton("CONFIRM ORDER");
		
		confirmButton.addActionListener(new ActionListener() {

			//Adds products to the delivery table, opens the confirmed order window and exits the billing information window
			public void actionPerformed(ActionEvent e){
				delivery.addDelivery(billingInfo.userID);
				orderConfirmed.orderConfirm(CartButton.CartList, CartButton.sum);
				createUserFrame.dispose();
			         }

			     });
		
		
		
		
		createPanel.add(confirmButton);
		createUserFrame.add(createPanel);
		
		
		createUserFrame.setLocationRelativeTo(null);
		createUserFrame.pack();
		createUserFrame.setSize(500,500);
		createUserFrame.setDefaultCloseOperation(createUserFrame.DISPOSE_ON_CLOSE);
		confirmButton.requestFocusInWindow();
		createUserFrame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
