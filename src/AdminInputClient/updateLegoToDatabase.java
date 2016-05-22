package AdminInputClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;


public class updateLegoToDatabase implements ActionListener{

	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static final  String dataBase="jdbc:mysql://localhost/lego";
	static int ageNumber;
	
	public void actionPerformed (ActionEvent e) {
		updateLegoToDB1();
		}
		public static void updateLegoToDB1(){
			try{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e){	
			}
			updateLegoStatement();
			AddDelete. updateLegoPane.dispose();
	}
	/**
	 * @author Emil
	 * 
	 * Retrieves the text inserted in the textfield's and create a statement
	 * to update a already existing product in the database
	 */	
	public static void updateLegoStatement() {
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
			}
	}
	
	/**
	 * @author Emil
	 * 
	 * Statement creator to update a already existing product to the database
	 */
	public static void createLegoStatement(String productId, String name, String age, String description, String image, String pieces, String category) {

			try {
			connection = DriverManager.getConnection

			("jdbc:mysql://localhost/lego", "root", "");

			statement = connection.createStatement();

			statement.execute("UPDATE products SET Name = '"+name+"', Age = '"+age+"', Description = '"+description+"', Image = '"+image+"', Pieces = "+pieces+", Category = '"+category+"' WHERE ProductId = "+productId+"");
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