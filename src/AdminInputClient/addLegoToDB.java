package AdminInputClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class addLegoToDB implements ActionListener{

	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static final  String dataBase="jdbc:mysql://localhost/lego";
	static int ageNumber;
	
	public void actionPerformed (ActionEvent e) {
		addLegoToDB1();
		}
		public static void addLegoToDB1(){
			try{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e){	
			}
			addLegoStatement();
	}
	
	/**
	 * @author Emil
	 * 
	 * Retrieves the text inserted in the textfield's and create a statement
	 * to add a new product to the database
	 */	
	public static void addLegoStatement() {
			String productId = AddDelete.productIdTextField.getText();
			String name = AddDelete.nameTextField.getText();
			String age = AddDelete.ageTextField.getText();
			Object category = AddDelete.categoryComboBox.getSelectedItem();
			String categoryString = category.toString(); 
			String description = AddDelete.descriptionTextField.getText();
			String pieces = AddDelete.piecesTextField.getText();
			String image = AddDelete.imageTextField.getText();
			
			if (productId.length() == 0 || name.length() == 0 ||
				age.length() == 0 || description.length() == 0 ||  pieces.length() == 0 ||
				image.length() == 0) { 
				
			JOptionPane.showMessageDialog(null, "You have to fill in all values");	
			}
			else {
				createLegoStatement(productId, name, age, description, image, pieces, categoryString);
				AddDelete.addLegoPane.dispose();
			}
	}

	/**
	 * @author Emil
	 * 
	 * Statement creator to insert a new product to the database
	 */	
	public static void createLegoStatement(String productId, String name, String age, String description, String image, String pieces, String category) {

			try {
			connection = DriverManager.getConnection

			("jdbc:mysql://localhost/lego", "root", "");

			statement = connection.createStatement();

			statement.execute("INSERT INTO products values ("+productId+", '"+name+"', '"+age+"', '"+description+"', '"+image+"', "+pieces+", '"+category+"');");
			}
			catch (Exception a){
				a.printStackTrace();
			}
	}
	/**
	 * @author Dennis
	 * 
	 * Makes sure that the textfield's that should only have numbers doesn't
	 * have letters
	 */	
	public static class Key  implements KeyListener {
		public void keyPressed(KeyEvent e) {					
		}
		public void keyReleased(KeyEvent e) {
			char key=e.getKeyChar();
		if(!Character.isDigit(key)){
			AddDelete.productIdTextField.setText("");	
		}
		}
		public void keyTyped(KeyEvent e) {					
		}
	}
	public static class Key2 implements KeyListener {
		public void keyPressed(KeyEvent e) {					
		}
		public void keyReleased(KeyEvent e) {
			char key=e.getKeyChar();
		if(!Character.isDigit(key)){
			AddDelete.ageTextField.setText("");	
		}
		}
		public void keyTyped(KeyEvent e) {					
		}
	}
	public static class Key4 implements KeyListener {
		public void keyPressed(KeyEvent e) {					
		}
		public void keyReleased(KeyEvent e) {
			char key=e.getKeyChar();
		if(!Character.isDigit(key)){	
			AddDelete.piecesTextField.setText("");
		}
		}
		public void keyTyped(KeyEvent e) {				
		}
	}
}