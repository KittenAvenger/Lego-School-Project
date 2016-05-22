package Survey;


import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import datamining2.billingInfo;

import java.util.Scanner;


/**@author Anastasia Koni, Dennis Nielsen */



public class SurveyInterface extends JFrame {
	private JTextField textField;
	//static  JRadioButton radioButtonService1;
	ButtonGroup servicegroup= new ButtonGroup();
	ButtonGroup purchasegroup= new ButtonGroup();
	ButtonGroup kidgroup= new ButtonGroup();
	ButtonGroup themegroup= new ButtonGroup();
	ButtonGroup varietygroup= new ButtonGroup();
	Action action1=new Action();
	Action2 action2=new Action2();
	Action3 action3=new Action3();
	Action4 action4=new Action4();
	Action5 action5=new Action5();
	Action6 action6=new Action6();
	Action7 action7=new Action7();
	Action8 action8=new Action8();
	Action9 action9=new Action9();
	Action10 action10=new Action10();
	Action11 action11=new Action11();
	Action12 action12=new Action12();
	Action13 action13=new Action13();
	Action14 action14=new Action14();
	Action15 action15=new Action15();
	Action16 action16=new Action16();
	
	
	static String rating;
	static String age;
	static String purchase;
	static String kid;
	static String theme;
	static String variety;
	static String age1;
	static JRadioButton radiobuttonkidNo, radioButtonKidyes;
	static SurveyInterface face;
	static boolean NoKid;
	
	static char c;
	
	//Creates the interface window and gets the userID of the logged in user
	
	public  SurveyInterface(String userID) {
		 
		
		getContentPane().setLayout(null);
		
		JLabel Satisfaction = new JLabel("Where you satisfied by the overall service?");
		Satisfaction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Satisfaction.setBounds(108, 11, 282, 23);
		getContentPane().add(Satisfaction);
		
		
		
		
		JLabel lblDidYouBuy = new JLabel("Did you buy this product for yourself?");
		lblDidYouBuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDidYouBuy.setBounds(108, 54, 262, 23);
		getContentPane().add(lblDidYouBuy);
		
		JLabel lblIfNotDid = new JLabel("If not, did you buy it for a kid?");
		lblIfNotDid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIfNotDid.setBounds(108, 103, 262, 23);
		getContentPane().add(lblIfNotDid);
		
		JLabel lblAgeOfThe = new JLabel("Age of the kid?");
		lblAgeOfThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeOfThe.setBounds(108, 163, 250, 23);
		getContentPane().add(lblAgeOfThe);
		
		textField = new JTextField();
		textField.setBounds(121, 197, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(action8);
		
		JLabel lblDidYouBuy_1 = new JLabel("Did you buy this product for its theme?");
		lblDidYouBuy_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDidYouBuy_1.setBounds(108, 228, 250, 23);
		getContentPane().add(lblDidYouBuy_1);
		
		JLabel lblWouldYouLike = new JLabel("Would you like a bigger variety of products from this theme?");
		lblWouldYouLike.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWouldYouLike.setBounds(108, 288, 379, 23);
		getContentPane().add(lblWouldYouLike);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(83, 359, 89, 23);
		getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(action6);
		
		JButton btnSkip = new JButton("SKIP");
		btnSkip.setBounds(301, 359, 89, 23);
		getContentPane().add(btnSkip);
		btnSkip.addActionListener(action7);
		
		JRadioButton radioButtonService1 = new JRadioButton("1");
		radioButtonService1.setBounds(108, 36, 41, 23);
		getContentPane().add(radioButtonService1);
		servicegroup.add(radioButtonService1);
		radioButtonService1.addActionListener(action1);
		
		JRadioButton radioButtonService2 = new JRadioButton("2");
		radioButtonService2.setBounds(166, 36, 41, 23);
		getContentPane().add(radioButtonService2);
		servicegroup.add(radioButtonService2);
		radioButtonService2.addActionListener(action2);
		
		JRadioButton radioButtonService3 = new JRadioButton("3");
		radioButtonService3.setBounds(221, 36, 41, 23);
		getContentPane().add(radioButtonService3);
		servicegroup.add(radioButtonService3);
		radioButtonService3.addActionListener(action3);
		
		JRadioButton radioButtonService4 = new JRadioButton("4");
		radioButtonService4.setBounds(264, 36, 41, 23);
		getContentPane().add(radioButtonService4);
		servicegroup.add(radioButtonService4);
		radioButtonService4.addActionListener(action4);
		
		JRadioButton radioButtonService5 = new JRadioButton("5");
		radioButtonService5.setBounds(307, 36, 41, 23);
		getContentPane().add(radioButtonService5);
		servicegroup.add(radioButtonService5);
		radioButtonService5.addActionListener(action5);
		
		JRadioButton radioButtonPurchaseyes = new JRadioButton("YES");
		radioButtonPurchaseyes.setBounds(118, 73, 74, 23);
		getContentPane().add(radioButtonPurchaseyes);
		purchasegroup.add(radioButtonPurchaseyes);
		radioButtonPurchaseyes.addActionListener(action9);
		
		JRadioButton radioButtonPurchaseNo = new JRadioButton("NO");
		radioButtonPurchaseNo.setBounds(255, 73, 59, 23);
		getContentPane().add(radioButtonPurchaseNo);
		purchasegroup.add(radioButtonPurchaseNo);
		radioButtonPurchaseNo.addActionListener(action10);
		
		 radioButtonKidyes = new JRadioButton("YES");
		radioButtonKidyes.setBounds(121, 133, 74, 23);
		getContentPane().add(radioButtonKidyes);
		kidgroup.add(radioButtonKidyes);
		radioButtonKidyes.addActionListener(action11);
		
		radiobuttonkidNo = new JRadioButton("NO");
		radiobuttonkidNo.setBounds(255, 133, 67, 23);
		getContentPane().add(radiobuttonkidNo);
		kidgroup.add(radiobuttonkidNo);
		radiobuttonkidNo.addActionListener(action12);
		
		JRadioButton radioButtonThemeYes = new JRadioButton("YES");
		radioButtonThemeYes.setBounds(130, 258, 67, 23);
		getContentPane().add(radioButtonThemeYes);
		themegroup.add(radioButtonThemeYes);
		radioButtonThemeYes.addActionListener(action13);
		
		JRadioButton radiobuttonThemeNo = new JRadioButton("NO");
		radiobuttonThemeNo.setBounds(283, 258, 61, 23);
		getContentPane().add(radiobuttonThemeNo);
		themegroup.add(radiobuttonThemeNo);
		radiobuttonThemeNo.addActionListener(action14);
		
		JRadioButton radioButtonvarietyYes = new JRadioButton("YES");
		radioButtonvarietyYes.setBounds(130, 318, 109, 23);
		getContentPane().add(radioButtonvarietyYes);
		varietygroup.add(radioButtonvarietyYes);
		radioButtonvarietyYes.addActionListener(action15);
		
		JRadioButton radioButtonVarietyNo = new JRadioButton("NO");
		radioButtonVarietyNo.setBounds(277, 318, 67, 23);
		getContentPane().add(radioButtonVarietyNo);
		varietygroup.add(radioButtonVarietyNo);
		radioButtonVarietyNo.addActionListener(action16);
		
	}
	
	//Individual action listeners 1-5  for every JRadioButton which saves what rating was pressed
	class Action implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			
			rating="1";
			
		}
	}
   class Action2 implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
			rating="2";
		}
		
	}
    class Action3 implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
			rating="3";
		}
		
	}
   class Action4 implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
			rating="4";
		}
		
	}
   class Action5 implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
			rating="5";
		}
		
	}
   
   //Checks if a kid has been selected and if he has a valid age between 0-18, otherwise inputs null in the database for age
   class Action6 implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
			 if(radiobuttonkidNo.isSelected() == true){
				 age = "NULL";
				 SurveyTable.Service(rating, age, purchase, kid, theme, variety);
				 face.dispose();
				 JOptionPane.showMessageDialog(null, "Thank you for answering our survey!");
			 }
			 else if (NoKid==false){
			 
			 age1=textField.getText();
			/* c = age1.charAt(0);*/
			 if (/*!Character.isLetter(age1)*/age1.matches("^[a-zA-Z]+$")){
				   JOptionPane.showMessageDialog(null,"Only numbers");

			   }
				else{
				   
			
			 int foo = Integer.parseInt(age1);
			 
			 if(foo<0 || foo>18){
				 JOptionPane.showMessageDialog(null,"The age is incorrect");
				 
			 }
			 else{
				 age= Integer.toString(foo);
				 SurveyTable.Service(rating, age, purchase, kid, theme, variety);
				 face.dispose();
				 JOptionPane.showMessageDialog(null, "Thank you for answering our survey!");
					
			 }
				}
				
				}
			 else if(NoKid==true){
				 age = "NULL";
				 kid="0";
				 SurveyTable.Service(rating, age, purchase, kid, theme, variety);
				 face.dispose();
				 JOptionPane.showMessageDialog(null, "Thank you for answering our survey!");
			 }
			
			/*SurveyTable.Service(rating, age, purchase, kid, theme, variety);*/
		
			
		}
		
	}
   
   //Exits the survey window
   class Action7 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   face.dispose();
	   }
   }
   
   //Gets age from the age textfield
   class Action8 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   
		   age=textField.getText();
		  
	   }
   }
   
   //Action 9 and Action 10 checks whether you have purchased the product for yourself and saves the variable
   
   class Action9 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   purchase="TRUE";
		   
		   NoKid=true;
		   
		   radiobuttonkidNo.setEnabled(false);
		   radioButtonKidyes.setEnabled(false);
		   textField.setEditable(false);
		   
	   }
   }
   class Action10 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   purchase="FALSE";
		   radiobuttonkidNo.setEnabled(true);
		   radioButtonKidyes.setEnabled(true);
		   textField.setEditable(true);
		   NoKid=false;
	   }
   }
   
   //Action 11 and action 12 checks whether you have selected that you bought the product for the kid and saves the variable
   class Action11 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		  kid="TRUE";
		  textField.setEditable(true);
	   }
   }
   class Action12 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   kid="FALSE";
		   textField.setEditable(false);
	   }
   }
   
   //Action 13 and action 14 checks whether you have selected that you bought a product for its theme and saves the variable
   class Action13 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		  theme="TRUE";
	   }
   }
   class Action14 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   theme="FALSE";
	   }
   }
   
   //Action 15 and action 16 checks whether you have selected tha you bought a product for its variety and saves the variable
   class Action15 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		   variety="TRUE";
	   }
   }
   class Action16 implements ActionListener{
	   public void actionPerformed(ActionEvent arg0){
		 variety="FALSE";
	   }
   }
   
   //Creates the survey interface window


	public static void Survey (String userID){
		face=new SurveyInterface(userID);
		face.setVisible(true);
		face.pack();
		face.setSize(500, 500);
	}
}
