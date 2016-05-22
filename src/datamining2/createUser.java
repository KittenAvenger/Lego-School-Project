package datamining2;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

/**
 * @author Johan Hermansson
 *create interface for create users ;
 */
public class createUser {
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
	static int userId;
//	static boolean buyOrNot;
	

	/**
	 * @author Johan Hermansson
	 *create interface for create users ;
	 */
	@SuppressWarnings("static-access")
	public static void createAccount(final boolean buyOrNot) {
		
		createUserFrame = new JFrame("Create Account");
		createUserFrame.setLayout(new GridLayout(12, 1, 10, 10));
		infoPanel = new JPanel();
		infoLabel = new JLabel("Fill in all the fields and press CREATE to create your account");
		infoPanel.add(infoLabel);
		createUserFrame.add(infoPanel);
		
		usernamePanel = new JPanel(new BorderLayout());
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
		createUserFrame.add(passwordPanel);
		
		firstnamePanel = new JPanel(new BorderLayout());
		firstnameLabel = new JLabel(" Firstname");
		firstnamePanel.add(firstnameLabel, BorderLayout.WEST);
		firstnameField = new JTextField(25);
		firstnameField.setColumns(25);
		firstnamePanel.add(firstnameField,  BorderLayout.EAST);
		createUserFrame.add(firstnamePanel);
		
		lastnamePanel = new JPanel(new BorderLayout());
		lastnameLabel = new JLabel(" Lastname");
		lastnamePanel.add(lastnameLabel, BorderLayout.WEST);
		lastnameField = new JTextField(25);
		lastnamePanel.add(lastnameField, BorderLayout.EAST);
		createUserFrame.add(lastnamePanel);
		
		adressPanel = new JPanel(new BorderLayout());
		adressLabel = new JLabel(" Adress");
		adressPanel.add(adressLabel, BorderLayout.WEST);
		adressField = new JTextField(25);
		adressPanel.add(adressField, BorderLayout.EAST);
		createUserFrame.add(adressPanel);
		
		phonePanel = new JPanel(new BorderLayout());
		phoneLabel = new JLabel(" Phonenumber");
		phonePanel.add(phoneLabel, BorderLayout.WEST);
		phoneField = new JTextField(25);
		phonePanel.add(phoneField, BorderLayout.EAST);
		createUserFrame.add(phonePanel);
		
		agePanel = new JPanel(new BorderLayout());
		ageLabel = new JLabel(" Age");
		agePanel.add(ageLabel, BorderLayout.WEST);
		ageField = new JTextField(25);
		agePanel.add(ageField, BorderLayout.EAST);
		createUserFrame.add(agePanel);
		
		cardPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		cardNrLabel = new JLabel("Cardnumber");
		cardPanel.add(cardNrLabel);
		cardNrField = new JTextField(18);
		cardPanel.add(cardNrField);
		cvvLabel = new JLabel("CVV-code");
		cardPanel.add(cvvLabel);
		cvvField = new JTextField(8);
		cardPanel.add(cvvField);
		createUserFrame.add(cardPanel);
		
		cardHolderPanel = new JPanel(new BorderLayout());
		cardHolderLabel = new JLabel(" Name of the cardholder");
		cardHolderPanel.add(cardHolderLabel, BorderLayout.WEST);
		cardHolderField = new JTextField(25);
		cardHolderPanel.add(cardHolderField, BorderLayout.EAST);
		createUserFrame.add(cardHolderPanel);

		createPanel = new JPanel();
		createButton = new JButton("CREATE ACCOUNT");
		createButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
				 if(!usernameField.getText().equals("") && !passwordField.getPassword().equals("") && !firstnameField.getText().equals("") && 
						 !lastnameField.getText().equals("") && !adressField.getText().equals("") && !phoneField.getText().equals("") && 
						 !ageField.getText().equals("") &&!cardNrField.getText().equals("") && !cvvField.getText().equals("") && !cardHolderField.getText().equals("")){
					 
					 
					 
					 try{
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Driver loaded");
							
							connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
							System.out.println("Connected to DB");
							
							Statement statement=connection.createStatement();
							rs = statement.executeQuery("SELECT count(*) FROM users;");
							rs.next();
							userIdString = rs.getString(1);
							userId = Integer.parseInt(userIdString);
							userId = userId+1;
							String password = new String(passwordField.getPassword());


							userToDB(usernameField.getText(), password, firstnameField.getText(), lastnameField.getText(), adressField.getText(),
									phoneField.getText(), ageField.getText(), cardNrField.getText(), cvvField.getText(), cardHolderField.getText(), userId);
							if(buyOrNot == true){
							billingInfo.buy(firstnameField.getText(), lastnameField.getText(), adressField.getText(),
									phoneField.getText(), ageField.getText(), cardNrField.getText(), cvvField.getText(), cardHolderField.getText());
							}
							createUserFrame.dispose();
						}
							
						catch (Exception ex)	{
							ex.printStackTrace();
						}
					 
					 
				 }
				 else{
					 JOptionPane.showMessageDialog(null, "Need to fill every field");
//					 System.out.println("Need to fill every field");
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
	 * @author Johan Hermansson
	 * put the new user in the database with all information that are needed for buying products
	 */
	public static void userToDB(String username, String password, String fname, String lname, String adress, String phone, String age, 
			String cardNr, String cvv, String cholder, int userId){
		
//		System.out.println(username+" "+password+" "+fname+" "+lname+" "+adress+" "+phone+" "+age+" "+cardNr+" "+cvv+" "+cholder+" "+userId);
		
		try {
			Statement statement=connection.createStatement();
			statement.execute("INSERT INTO users  values ('"+username+"', '"+password+"', " + userId + ", 'User');");
			statement.execute("INSERT INTO billing values ('"+fname+"', '"+lname+"', '"+adress+"', '"+phone+"', "+age+", '"+cardNr+"', "
					+ ""+cvv+", '"+cholder+"', "+userId+");");
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
	}

}
