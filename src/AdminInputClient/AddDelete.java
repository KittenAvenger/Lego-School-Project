package AdminInputClient;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import AdminInputClient.AddDelete;
import AdminInputClient.addLegoToDB.Key;
import AdminInputClient.addLegoToDB.Key2;
import AdminInputClient.addLegoToDB.Key4;

public class AddDelete {
	
	static JFrame addLegoPane, addGamePane, updateLegoPane;
	static JPanel productIdPanel, namePanel, categoryPanel, agePanel, pricePanel, descriptionPanel, imagePanel, piecesPanel, addButtonPanel, consolePanel, publisherPanel, releaseDatePanel;
	static JButton add;
	static JLabel productIdLabel, nameLabel, categoryLabel, ageLabel, priceLabel, descriptionLabel, imageLabel, piecesLabel, consoleLabel, publisherLabel, releaseDateLabel;
	static JTextField productIdTextField, nameTextField, ageTextField, priceTextField, descriptionTextField, imageTextField, piecesTextField, publisherTextField, releaseDateTextField;
	@SuppressWarnings("rawtypes")
	static JComboBox categoryComboBox, consoleComboBox;
	static JMenuBar menuBar;
	static JMenu menuAddDelete;
	static JMenuItem addLegoMenuItem, addGameMenuItem, updateLegoMenuItem, deleteLegoMenuItem, deleteGameMenuItem;
	static String productId, s;
	static Statement statement;
	static boolean idExistsInDB = false;
	static ResultSet rs = null;
	static openDelete openDelete=new openDelete();
	static openLego openLego=new openLego();

	public static void AddDelete2() {
		addLego();	
	}
			
			/**
			 * @author Johan
			 * 
			 * Creates the frame for adding new products
			 */
			@SuppressWarnings({ "static-access", "rawtypes" })
			public static void addLego(){
				//FRAME and MENUBAR
				addLegoPane = new JFrame("Add Lego");
				addLegoPane.setLayout(new GridLayout(10, 1, 10, 10));
				menuBar = new JMenuBar();
				menuAddDelete = new JMenu("Add / Update / Delete");
				addLegoMenuItem = new JMenuItem("Add Product");
				menuAddDelete.add(addLegoMenuItem);
				updateLegoMenuItem = new JMenuItem("Update Product");
				menuAddDelete.add(updateLegoMenuItem);
				deleteLegoMenuItem = new JMenuItem("Delete Product");
				menuAddDelete.add(deleteLegoMenuItem);					
				menuBar.add(menuAddDelete);
				addLegoPane.setJMenuBar(menuBar);
				
				//CATEGORY panel
				categoryPanel = new JPanel();
				categoryLabel = new JLabel("Category");
				categoryPanel.add(categoryLabel);
				String[] category = {"Batman", "Starwars", "Marvel", "Lord of the Rings" };
				categoryComboBox = new JComboBox(category);
				categoryPanel.add(categoryComboBox);
				addLegoPane.add(categoryPanel);
				
				
				//PRODUCTID panel
				productIdPanel = new JPanel();
				productIdLabel = new JLabel("ProductId");
				productIdPanel.add(productIdLabel);
				productIdTextField = new JTextField(50);
				productIdPanel.add(productIdTextField);
				addLegoPane.add(productIdPanel);
				
				//NAME panel
				namePanel = new JPanel();
				nameLabel = new JLabel("Name");
				namePanel.add(nameLabel);
				nameTextField = new JTextField(50);
				namePanel.add(nameTextField);
				addLegoPane.add(namePanel);
				
				//AGE panel
				agePanel = new JPanel();
				ageLabel = new JLabel("Age");
				agePanel.add(ageLabel);
				ageTextField = new JTextField(50);
				agePanel.add(ageTextField);
				addLegoPane.add(agePanel);
				
				//DESCRIPTION panel
				descriptionPanel = new JPanel();
				descriptionLabel = new JLabel("Description");
				descriptionPanel.add(descriptionLabel);
				descriptionTextField = new JTextField(50);
				descriptionPanel.add(descriptionTextField);
				addLegoPane.add(descriptionPanel);
				
				//IMAGE panel
				imagePanel = new JPanel();
				imageLabel = new JLabel("Image");
				imagePanel.add(imageLabel);
				imageTextField = new JTextField(50);
				imagePanel.add(imageTextField);
				addLegoPane.add(imagePanel);
				
				//PIECES panel
				piecesPanel = new JPanel();
				piecesLabel = new JLabel("Pieces");
				piecesPanel.add(piecesLabel);
				piecesTextField = new JTextField(50);
				piecesPanel.add(piecesTextField);
				addLegoPane.add(piecesPanel);
				
				//ADDBUTTON panel
				addButtonPanel = new JPanel();
				add = new JButton("ADD LEGO");
				addButtonPanel.add(add);
				addLegoPane.add(addButtonPanel);
				
				//ACTIONLISTENERS
				s = "Lego";
				addLegoMenuItem.addActionListener(openLego);
		    	deleteLegoMenuItem.addActionListener(openDelete);
		    	updateLegoMenuItem.addActionListener(openDelete);
		    	add.addActionListener((ActionListener) new addLegoToDB());
				
		    	//LAST OF THE FRAME
				addLegoPane.setLocation(300, 150);
		    	addLegoPane.pack();
		    	addLegoPane.setDefaultCloseOperation(addLegoPane.DISPOSE_ON_CLOSE);
		    	addLegoPane.setVisible(true);
		    	Key key=new Key();
		    	Key2 key2=new Key2();
		    	Key4 key4=new Key4();
				productIdTextField.addKeyListener(key);
				ageTextField.addKeyListener(key2);
				piecesTextField.addKeyListener(key4);
	}
			
			/**
			 * @author Johan - GUI and interface
			 * @author Emil - Statements
			 * 
			 * Creates the frame for updating a already existing product and fills the textfield's
			 * with the existing information
			 */
			@SuppressWarnings({ "static-access", "unchecked" })
			public static void upLego(){
				
				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection

					("jdbc:mysql://localhost/lego", "root", "");

					statement = connection.createStatement();
					}
					catch (Exception a){
						a.printStackTrace();
					}
				JTextField id = new JTextField();
				Object[] message = { "Lego Product Id:", id };
				int option = JOptionPane.showConfirmDialog(null, message, "Update Lego", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					productId = id.getText();
					try {
						rs = statement.executeQuery("SELECT * FROM products WHERE productId = '" +productId+ "';");
						if(!rs.next()) {
							JOptionPane.showMessageDialog(null, "ProductId didn't exist\nTry Again");
							upLego();
						}
						else{
						}
					}
					catch(Exception a) {		
					}
				}
				
				//FRAME and MENUBAR
				updateLegoPane = new JFrame("Update Lego");
				updateLegoPane.setLayout(new GridLayout(10, 1, 10, 10));
				menuBar = new JMenuBar();
				menuAddDelete = new JMenu("Add / Update / Delete");
				addLegoMenuItem = new JMenuItem("Add Product");
				menuAddDelete.add(addLegoMenuItem);
				updateLegoMenuItem = new JMenuItem("Update Product");
				menuAddDelete.add(updateLegoMenuItem);
				deleteLegoMenuItem = new JMenuItem("Delete Product");
				menuAddDelete.add(deleteLegoMenuItem);				
				menuBar.add(menuAddDelete);
				updateLegoPane.setJMenuBar(menuBar);
				
				//CATEGORY panel
				categoryPanel = new JPanel();
				categoryLabel = new JLabel("Category");
				categoryPanel.add(categoryLabel);
				String[] category = {"Batman", "Starwars", "Marvel", "Lord of the Rings" };
				categoryComboBox = new JComboBox(category);
				categoryPanel.add(categoryComboBox);
				updateLegoPane.add(categoryPanel);
				
				//PRODUCTID panel
				productIdPanel = new JPanel();
				productIdLabel = new JLabel("ProductId");
				productIdPanel.add(productIdLabel);
				productIdTextField = new JTextField(50);
				productIdPanel.add(productIdTextField);
				updateLegoPane.add(productIdPanel);
				try {
					rs = statement.executeQuery("SELECT productId FROM products WHERE productId = '"+productId+"';");
					rs.next();
					productIdTextField.setText(rs.getString(1));
					productIdTextField.setEditable(false);
				}
				catch (Exception a) {		
				}
				
				//NAME panel
				namePanel = new JPanel();
				nameLabel = new JLabel("Name");
				namePanel.add(nameLabel);
				nameTextField = new JTextField(50);
				namePanel.add(nameTextField);
				updateLegoPane.add(namePanel);
				try {
					rs = statement.executeQuery("SELECT Name FROM products WHERE productId = '"+productId+"';");
					rs.next();
					nameTextField.setText(rs.getString(1));
				}
				catch (Exception a) {		
				}
				
				//AGE panel
				agePanel = new JPanel();
				ageLabel = new JLabel("Age");
				agePanel.add(ageLabel);
				ageTextField = new JTextField(50);
				agePanel.add(ageTextField);
				updateLegoPane.add(agePanel);
				try {
					rs = statement.executeQuery("SELECT Age FROM products WHERE productId = '"+productId+"';");
					rs.next();
					ageTextField.setText(rs.getString(1));
				}
				catch (Exception a) {		
				}
				
				//DESCRIPTION panel
				descriptionPanel = new JPanel();
				descriptionLabel = new JLabel("Description");
				descriptionPanel.add(descriptionLabel);
				descriptionTextField = new JTextField(50);
				descriptionPanel.add(descriptionTextField);
				updateLegoPane.add(descriptionPanel);
				try {
					rs = statement.executeQuery("SELECT Description FROM products WHERE productId = '"+productId+"';");
					rs.next();
					descriptionTextField.setText(rs.getString(1));
				}
				catch (Exception a) {		
				}
				
				//IMAGE panel
				imagePanel = new JPanel();
				imageLabel = new JLabel("Image");
				imagePanel.add(imageLabel);
				imageTextField = new JTextField(50);
				imagePanel.add(imageTextField);
				updateLegoPane.add(imagePanel);
				try {
					rs = statement.executeQuery("SELECT Image FROM products WHERE productId = '"+productId+"';");
					rs.next();
					imageTextField.setText(rs.getString(1));
				}
				catch (Exception a) {		
				}
				
				//PIECES panel
				piecesPanel = new JPanel();
				piecesLabel = new JLabel("Pieces");
				piecesPanel.add(piecesLabel);
				piecesTextField = new JTextField(50);
				piecesPanel.add(piecesTextField);
				updateLegoPane.add(piecesPanel);
				try {
					rs = statement.executeQuery("SELECT Pieces FROM products WHERE productId = '"+productId+"';");
					rs.next();
					piecesTextField.setText(rs.getString(1));
				}
				catch (Exception a) {		
				}
				
				//ADDBUTTON panel
				addButtonPanel = new JPanel();
				add = new JButton("UPDATE LEGO");
				addButtonPanel.add(add);
				updateLegoPane.add(addButtonPanel);
				
				//ACTIONLISTENERS
				s = "Update";
				addLegoMenuItem.addActionListener(openLego);
		    	deleteLegoMenuItem.addActionListener(openDelete);
		    	updateLegoMenuItem.addActionListener(openDelete);
		    	add.addActionListener((ActionListener) new updateLegoToDatabase());
				
		    	//LAST OF THE FRAME
		    	updateLegoPane.setLocation(300, 150);
		    	updateLegoPane.pack();
		    	updateLegoPane.setDefaultCloseOperation(updateLegoPane.DISPOSE_ON_CLOSE);
		    	updateLegoPane.setVisible(true);
		    	Key key=new Key();
		    	Key2 key2=new Key2();
		    	Key4 key4=new Key4();
				productIdTextField.addKeyListener(key);
				ageTextField.addKeyListener(key2);
				piecesTextField.addKeyListener(key4);
	}
			
			/**
			 * @author Emil
			 * 
			 * Makes a statement to delete a product from the database
			 */
			public static void deleteLego(){
				idExistsInDB = false;
				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection

					("jdbc:mysql://localhost/lego", "root", "");

					statement = connection.createStatement();
					}
					catch (Exception a){
						a.printStackTrace();
					}
				JTextField id = new JTextField();
				Object[] message = { "Lego Product Id:", id };
				int option = JOptionPane.showConfirmDialog(null, message, "Delete Lego", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					productId = id.getText();
					try {
						rs = statement.executeQuery("SELECT * FROM products WHERE productId = '" +productId+ "';");
						if(!rs.next()) {
							JOptionPane.showMessageDialog(null, "ProductId didn't exist\nTry Again");
							deleteLego();
						}
						else{
							idExistsInDB = true;
						}
					}
					catch(Exception a) {		
					}
					if(idExistsInDB == true){
					try {
						statement.execute("DELETE FROM products WHERE productId = '"+productId+"';");
						JOptionPane.showMessageDialog(null, "The product with the ID "+productId+" has been deleted");
					}
					catch (Exception a) {		
					}
				}
				}
			}
			
}
