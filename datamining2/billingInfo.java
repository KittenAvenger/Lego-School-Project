package datamining2;

import java.awt.GridLayout;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

/**
 * @author Johan Hermansson
 * make login and create users
 *
 */
public class billingInfo {
	
	static JFrame loginFrame, billingFrame, loginBuyFrame;
	static JPanel loginButtonsPanel, loginPanel, infoPanel, firstnamePanel, lastnamePanel, adressPanel, phonePanel, agePanel, cardPanel, cardHolderPanel, confirmPanel,
	usernamePanel, passwordPanel, loginBuyPanel, createAccBuyPanel;
	static JTextField firstnameField, lastnameField, adressField, phoneField, ageField, cardNrField, cvvField, cardHolderField, usernameField;
	static JPasswordField passwordField;
	static JLabel loginLabel, infoLabel, usernameLabel, passwordLabel;
	static JButton login, buy, confirm, loginBuy, createAccBuy;
	static Connection connection;
	
	/**
	 * @author Johan
	 * unused main-method. make a frame to check if the user want to log in and buy or create a new account.
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		loginFrame = new JFrame("NEW OR ALREADY CUSTOMER");
		loginFrame.setLayout(new GridLayout(3, 1, 10, 10));
		
		loginPanel = new JPanel();
		loginLabel = new JLabel("Are you already customer use LOGIN AND BUY else use BUY or CREATE ACCOUNT");
		loginPanel.add(loginLabel);
		loginFrame.add(loginPanel);
		
		loginButtonsPanel = new JPanel();
		login = new JButton("LOGIN AND BUY");
		login.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 loginFrame.dispose();
				 login();
            }
        });
		buy = new JButton("     BUY     ");
		buy.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 loginFrame.dispose();
				 buy();
           }
       });
		loginButtonsPanel.add(login);
		loginButtonsPanel.add(buy);
		loginFrame.add(loginButtonsPanel);
		
		createAccBuyPanel = new JPanel();
		createAccBuy = new JButton("CREATE ACCOUNT");
		createAccBuy.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e){
			 loginFrame.dispose();
			createUser.createAccount(true);
      }
  });
		createAccBuyPanel.add(createAccBuy);
		loginFrame.add(createAccBuyPanel);
		
		
		loginFrame.setLocationRelativeTo(null);
		loginFrame.pack();
		loginFrame.setDefaultCloseOperation(loginFrame.DISPOSE_ON_CLOSE);
		loginFrame.setVisible(true);
	}
	/**
	 * @author Johan
	 * make login UI:
	 */
	
	@SuppressWarnings("static-access")
	public static void login(){
		loginBuyFrame = new JFrame("LOGIN");
		loginBuyFrame.setLayout(new GridLayout(3, 1, 10, 10));
		
		usernamePanel = new JPanel();
		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(20);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		loginBuyFrame.add(usernamePanel);
		
		passwordPanel = new JPanel();
		passwordLabel = new JLabel("Password: ");
		passwordField = new JPasswordField(20);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		loginBuyFrame.add(passwordPanel);
		
		loginBuyPanel = new JPanel();
		loginBuy = new JButton("LOGIN");
		loginBuy.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 
          }
      });
		loginBuyPanel.add(loginBuy);
		loginBuyFrame.add(loginBuyPanel);
		loginBuyFrame.setLocationRelativeTo(null);
		loginBuyFrame.pack();
		loginBuyFrame.setDefaultCloseOperation(loginFrame.DISPOSE_ON_CLOSE);
		loginBuyFrame.setVisible(true);
		
	}
	
	/**
	 * @author Johan
	 * check if the user exist in the database with correct password.
	 */
	public static void checkLogin(String username, String password){
		
		
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
//			System.out.println("a");
			rs = statement.executeQuery("SELECT Firstname FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");
//			System.out.println("b");
			
			
			rs.next();
			String fname = rs.getString(1);
//			System.out.println("b");
			rs = statement.executeQuery("SELECT Lastname FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

			rs.next();
			String lname = rs.getString(1);
			rs = statement.executeQuery("SELECT Adress FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

//			System.out.println("b");
			rs.next();
			String adress = rs.getString(1);
			rs = statement.executeQuery("SELECT Phonenumber FROM billing, users WHERE (billing.UserId = users.UserId) and (users.Username = '"+username+"') and (users.Password = '"+password+"') ;");

//			System.out.println("b");
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
			
//			System.out.println(fname);
			buy(fname, lname, adress, phone, age, cardnr, cvv, cholder);
			
		}
		catch(Exception a) {
			JOptionPane.showMessageDialog(null, "Username or password is not correct\nTry Again");
		}
	}
	
	/**
	 * @author Johan
	 * Unused. Make the UI if the user want to buy without login. 
	 */
	@SuppressWarnings("static-access")
	public static void buy(){
		billingFrame = new JFrame("Billing Information");
		billingFrame.setLayout(new GridLayout(10, 1, 10, 10));
		infoPanel = new JPanel();
		infoLabel = new JLabel("Fill in all the fields and press confirm to complete your order");
		infoPanel.add(infoLabel);
		billingFrame.add(infoPanel);
		
		firstnamePanel = new JPanel();
		firstnameField = new HintTextField2("Firstname");
		firstnameField.setColumns(25);
		firstnamePanel.add(firstnameField);
		billingFrame.add(firstnamePanel);
		
		lastnamePanel = new JPanel();
		lastnameField = new HintTextField2("Lastame");
		lastnameField.setColumns(25);
		lastnamePanel.add(lastnameField);
		billingFrame.add(lastnamePanel);
		
		adressPanel = new JPanel();
		adressField = new HintTextField2("Adress");
		adressField.setColumns(25);
		adressPanel.add(adressField);
		billingFrame.add(adressPanel);
		
		phonePanel = new JPanel();
		phoneField = new HintTextField2("Phonenumber");
		phoneField.setColumns(25);
		phonePanel.add(phoneField);
		billingFrame.add(phonePanel);
		
		agePanel = new JPanel();
		ageField = new HintTextField2("Age");
		ageField.setColumns(25);
		agePanel.add(ageField);
		billingFrame.add(agePanel);
		
		cardPanel = new JPanel();
		cardNrField = new HintTextField2("Cardnumber");
		cardNrField.setColumns(17);
		cardPanel.add(cardNrField);
		cvvField = new HintTextField2("CVV-code");
		cvvField.setColumns(8);
		cardPanel.add(cvvField);
		billingFrame.add(cardPanel);
		
		cardHolderPanel = new JPanel();
		cardHolderField = new HintTextField2("Name of the cardholder");
		cardHolderField.setColumns(25);
		cardHolderPanel.add(cardHolderField);
		billingFrame.add(cardHolderPanel);
		
		confirmPanel = new JPanel();
		confirm = new JButton("CONFIRM ORDER");
		confirmPanel.add(confirm);
		billingFrame.add(confirmPanel);
		
		
		billingFrame.setLocationRelativeTo(null);
		billingFrame.pack();
		billingFrame.setSize(500,500);
		billingFrame.setDefaultCloseOperation(billingFrame.DISPOSE_ON_CLOSE);
		confirm.requestFocusInWindow();
		billingFrame.setVisible(true);
		
		
		
	}
	/**
	 * @author Johan
	 * 
	 * Make UI and set correct text in every field that the logged in user need to buy. 
	 * 
	 */
	@SuppressWarnings("static-access")
	public static void buy(String fname, String lname, String adress, String phone, String age, String cardnr, String cvv, String cholder){
		billingFrame = new JFrame("Billing Information");
		billingFrame.setLayout(new GridLayout(10, 1, 10, 10));
		infoPanel = new JPanel();
		infoLabel = new JLabel("Check that all the fields is correct and press confirm to complete your order");
		infoPanel.add(infoLabel);
		billingFrame.add(infoPanel);
		
		firstnamePanel = new JPanel();
		firstnameField = new HintTextField("Firstname", fname);
//		firstnameField.setText(fname);
		firstnameField.setColumns(25);
		firstnamePanel.add(firstnameField);
		billingFrame.add(firstnamePanel);
		
		lastnamePanel = new JPanel();
		lastnameField = new HintTextField("Lastame", lname);
//		lastnameField.setText(lname);
		lastnameField.setColumns(25);
		lastnamePanel.add(lastnameField);
		billingFrame.add(lastnamePanel);
		
		adressPanel = new JPanel();
		adressField = new HintTextField("Adress", adress);
		adressField.setText(adress);
		adressField.setColumns(25);
		adressPanel.add(adressField);
		billingFrame.add(adressPanel);
		
		phonePanel = new JPanel();
		phoneField = new HintTextField("Phonenumber", phone);
//		phoneField.setText(phone);
		phoneField.setColumns(25);
		phonePanel.add(phoneField);
		billingFrame.add(phonePanel);
		
		agePanel = new JPanel();
		ageField = new HintTextField("Age", age);
//		ageField.setText(age);
		ageField.setColumns(25);
		agePanel.add(ageField);
		billingFrame.add(agePanel);
		
		cardPanel = new JPanel();
		cardNrField = new HintTextField("Cardnumber", cardnr);
//		cardNrField.setText(cardnr);
		cardNrField.setColumns(17);
		cardPanel.add(cardNrField);
		cvvField = new HintTextField("CVV-code", cvv);
//		cvvField.setText(cvv);
		cvvField.setColumns(8);
		cardPanel.add(cvvField);
		billingFrame.add(cardPanel);
		
		cardHolderPanel = new JPanel();
		cardHolderField = new HintTextField("Name of the cardholder", cholder);
//		cardHolderField.setText(cholder);
		cardHolderField.setColumns(25);
		cardHolderPanel.add(cardHolderField);
		billingFrame.add(cardHolderPanel);
		
		confirmPanel = new JPanel();
		confirm = new JButton("CONFIRM ORDER");
		confirmPanel.add(confirm);
		billingFrame.add(confirmPanel);
		
		
		billingFrame.setLocationRelativeTo(null);
		billingFrame.pack();
		billingFrame.setSize(500,500);
		billingFrame.setDefaultCloseOperation(billingFrame.DISPOSE_ON_CLOSE);
		confirm.requestFocusInWindow();
		billingFrame.setVisible(true);
		
		
		
	}

}
