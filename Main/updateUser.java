package Main;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Johan Hermansson
 * @author Emil Sundklev 
 * @author Dennis Nielsen
 *
 */
public class updateUser {
	
	static JFrame createUserFrame;
	static JPanel infoPanel, usernamePanel, passwordPanel, firstnamePanel, lastnamePanel, adressPanel, phonePanel,
	agePanel, cardPanel, cardHolderPanel, createPanel;
	static JTextField usernameField, firstnameField, lastnameField, adressField, phoneField,
	ageField, cardNrField, cvvField, cardHolderField;
	static JButton createButton;
	static JLabel infoLabel, usernameLabel, passwordLabel, firstnameLabel, lastnameLabel, adressLabel, phoneLabel,
	ageLabel, cardNrLabel, cvvLabel, cardHolderLabel;
	static JPasswordField passwordField;
	static Connection connection;
	static ResultSet rs = null;
	static String userIdString;
	
	static Statement statement;
	static String password;
	
	/**
	 * Retrieves the existing data of the logged in user and fills the textfield's with the data
	 */
	public static void updateAcc(final String uId){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection

			("jdbc:mysql://localhost/lego", "root", "");

			statement = connection.createStatement();
			}
			catch (Exception a){
				a.printStackTrace();
			}
		createUserFrame = new JFrame("Update Account");
		createUserFrame.setLayout(new GridLayout(12, 1, 10, 10));
		infoPanel = new JPanel();
		infoLabel = new JLabel("Change the fields you want to update and press UPDATE ACCOUNT");
		infoPanel.add(infoLabel);
		createUserFrame.add(infoPanel);
		
		usernamePanel = new JPanel(new BorderLayout());
		usernameLabel = new JLabel(" Username");
		usernamePanel.add(usernameLabel, BorderLayout.WEST);
		usernameField = new JTextField(25);
		usernamePanel.add(usernameField, BorderLayout.EAST);
		createUserFrame.add(usernamePanel);
		try {
			rs = statement.executeQuery("SELECT username FROM users WHERE userid = '"+uId+"';");
			rs.next();
			usernameField.setText(rs.getString(1));
			usernameField.setEditable(false);
		}
		catch (Exception a) {		
		}
		
		passwordPanel = new JPanel(new BorderLayout());
		passwordLabel = new JLabel(" Password");
		passwordPanel.add(passwordLabel, BorderLayout.WEST);
		passwordField = new JPasswordField(25);
		passwordPanel.add(passwordField, BorderLayout.EAST);
		createUserFrame.add(passwordPanel);
		try {
			rs = statement.executeQuery("SELECT password FROM users WHERE userid = '"+uId+"';");
			rs.next();
			passwordField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		firstnamePanel = new JPanel(new BorderLayout());
		firstnameLabel = new JLabel(" Firstname");
		firstnamePanel.add(firstnameLabel, BorderLayout.WEST);
		firstnameField = new JTextField(25);
		firstnameField.setColumns(25);
		firstnamePanel.add(firstnameField,  BorderLayout.EAST);
		createUserFrame.add(firstnamePanel);
		try {
			rs = statement.executeQuery("SELECT firstname FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			firstnameField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		lastnamePanel = new JPanel(new BorderLayout());
		lastnameLabel = new JLabel(" Lastname");
		lastnamePanel.add(lastnameLabel, BorderLayout.WEST);
		lastnameField = new JTextField(25);
		lastnamePanel.add(lastnameField, BorderLayout.EAST);
		createUserFrame.add(lastnamePanel);
		try {
			rs = statement.executeQuery("SELECT lastname FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			lastnameField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		adressPanel = new JPanel(new BorderLayout());
		adressLabel = new JLabel(" Adress");
		adressPanel.add(adressLabel, BorderLayout.WEST);
		adressField = new JTextField(25);
		adressPanel.add(adressField, BorderLayout.EAST);
		createUserFrame.add(adressPanel);
		try {
			rs = statement.executeQuery("SELECT adress FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			adressField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		phonePanel = new JPanel(new BorderLayout());
		phoneLabel = new JLabel(" Phonenumber");
		phonePanel.add(phoneLabel, BorderLayout.WEST);
		phoneField = new JTextField(25);
		phonePanel.add(phoneField, BorderLayout.EAST);
		createUserFrame.add(phonePanel);
		try {
			rs = statement.executeQuery("SELECT phonenumber FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			phoneField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		agePanel = new JPanel(new BorderLayout());
		ageLabel = new JLabel(" Age");
		agePanel.add(ageLabel, BorderLayout.WEST);
		ageField = new JTextField(25);
		agePanel.add(ageField, BorderLayout.EAST);
		createUserFrame.add(agePanel);
		try {
			rs = statement.executeQuery("SELECT age FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			ageField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		cardPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		cardNrLabel = new JLabel("Cardnumber");
		cardPanel.add(cardNrLabel);
		cardNrField = new JTextField(18);
		cardPanel.add(cardNrField);
		try {
			rs = statement.executeQuery("SELECT cardnumber FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			cardNrField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		cvvLabel = new JLabel("CVV-code");
		cardPanel.add(cvvLabel);
		cvvField = new JTextField(8);
		cardPanel.add(cvvField);
		createUserFrame.add(cardPanel);
		try {
			rs = statement.executeQuery("SELECT cvvcode FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			cvvField.setText(rs.getString(1));
		}
		catch (Exception a) {		
		}
		
		cardHolderPanel = new JPanel(new BorderLayout());
		cardHolderLabel = new JLabel(" Name of the cardholder");
		cardHolderPanel.add(cardHolderLabel, BorderLayout.WEST);
		cardHolderField = new JTextField(25);
		cardHolderPanel.add(cardHolderField, BorderLayout.EAST);
		createUserFrame.add(cardHolderPanel);
		try {
			rs = statement.executeQuery("SELECT cardholder FROM billing WHERE userid = '"+uId+"';");
			rs.next();
			cardHolderField.setText(rs.getString(1));
		}
		catch (Exception a) {	
			a.printStackTrace();
		}

		createPanel = new JPanel();
		createButton = new JButton("UPDATE ACCOUNT");
		createButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 if(!passwordField.getPassword().equals("") && !firstnameField.getText().equals("") && 
						 !lastnameField.getText().equals("") && !adressField.getText().equals("") && !phoneField.getText().equals("") && 
						 !ageField.getText().equals("") &&!cardNrField.getText().equals("") && !cvvField.getText().equals("") && !cardHolderField.getText().equals("")){
					 
					 
					 

							 password = new String(passwordField.getPassword());
							
							userUpdate(password, firstnameField.getText(), lastnameField.getText(), adressField.getText(),
									phoneField.getText(), ageField.getText(), cardNrField.getText(), cvvField.getText(), cardHolderField.getText(), uId);
							

							createUserFrame.dispose();
							
					 
					 
				 }
				 else{
					 JOptionPane.showMessageDialog(null, "Need to fill every field");

				 } 
				 
				 
					
				
         }
     });
		createPanel.add(createButton);
		createUserFrame.add(createPanel);
		
		
		createUserFrame.setLocationRelativeTo(null);
		createUserFrame.pack();
		createUserFrame.setSize(500,500);
		createUserFrame.setDefaultCloseOperation(createUserFrame.DISPOSE_ON_CLOSE);
		createButton.requestFocusInWindow();
		createUserFrame.setVisible(true);
	}
	/**
	 * Retrieves the text inserted in the textfield's and makes a statement to update the users information in the database
	 */
	public static void userUpdate(String password1, String fname1, String lname1, String adress1, String phone1, String age1, 
			String cardNr1, String cvv1, String cholder1, String userId1){
				
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection

			("jdbc:mysql://localhost/lego", "root", "");

			statement = connection.createStatement();
			
			Statement statement=connection.createStatement();
			
			statement.execute("UPDATE users SET password = '"+password1+"' WHERE UserID = "+userId1+";");
			
			statement.execute("UPDATE billing SET Firstname = '"+fname1+"', Lastname = '"+lname1+"', Adress = '"+adress1+"', Phonenumber = '"+phone1+"', Age = "+age1+", Cardnumber = '"+cardNr1+"', "
					+ "Cvvcode = "+cvv1+", Cardholder = '"+cholder1+"' WHERE Userid = "+userId1+";");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
			
		}
		
	}
	
	public static void userUpdate(){
				
		try {
			
			Statement statement=connection.createStatement();
			
			
			statement.executeUpdate("UPDATE billing SET Firstname = '"+firstnameField.getText()+"'"); 
			
		}
		catch (Exception e){
			e.printStackTrace();
			
			
		}
		
	}


}
