package Main;


import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


/**
 * @author Johan Hermansson
 * Inputclient for companys
 * 
 */
public class companyEditClient {
	static JFrame cec, updateFrame, addFrame;
	static JPanel buttons, pIdPanel, cIdPanel, pricePanel, amountPanel, updatePanel, addPanel;
	static JLabel pIdLabel, cIdLabel, priceLabel, amountLabel;
	static JTextField pIdField, cIdField, priceField, amountField;
	static JButton add, update, delete, updateButton, addButton;
	static Connection connection;
	static String pId, price, amount, cprice, camount, companyId, count, text;
	static ResultSet rs = null;
	
	/**
	 * The UI for the inputclient
	 */
	public static void CompanyClient(String cId){
		companyId = cId;
		cec = new JFrame("ADD / UPDATE / DELETE PRODUCTS");
		buttons = new JPanel();
		add = new JButton("ADD PRODUCT");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				add();
			}
	  });
		update = new JButton("UPDATE PRODUCT");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				update();
			}
	  });
		delete = new JButton("DELETE PRODUCT");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				delete();
			}
	  });
		buttons.add(add);
		buttons.add(update);
		buttons.add(delete);
		cec.add(buttons);
		
		cec.setLocationRelativeTo(null);
    	cec.pack();
    	cec.setDefaultCloseOperation(cec.DISPOSE_ON_CLOSE);
    	cec.setVisible(true);	
	}
	
	
	/**
	 * Make the UI when you want to add a product and insert it to the database. 
	 */
	public static void add(){
		
		
		
		
		addFrame = new JFrame("ADD PRODUCT");
		addFrame.setLayout(new GridLayout(6, 1, 10, 10));
		
		pIdPanel = new JPanel();
		pIdLabel = new JLabel("ProductId");
		pIdField = new JTextField(10);
		pIdField.addKeyListener(new KeyAdapter(){
        	public void keyTyped(KeyEvent e){
                text = pIdField.getText();
                text = text.replaceAll("\\D+","");
                pIdField.setText(text);
        	}
        });
		pIdPanel.add(pIdLabel);
		pIdPanel.add(pIdField);
		addFrame.add(pIdPanel);
		cIdPanel = new JPanel();
		cIdLabel = new JLabel("CompanyId");
		cIdField = new JTextField(10);
		cIdField.setText(companyId);
		cIdField.setEditable(false);
		cIdPanel.add(cIdLabel);
		cIdPanel.add(cIdField);
		addFrame.add(cIdPanel);
		pricePanel = new JPanel();
		priceLabel = new JLabel("Price (kr)");
		priceField = new JTextField(10);
		priceField.addKeyListener(new KeyAdapter(){
        	public void keyTyped(KeyEvent e){
                text = priceField.getText();
                text = text.replaceAll("\\D+","");
                priceField.setText(text);
        	}
        });
		pricePanel.add(priceLabel);
		pricePanel.add(priceField);
		addFrame.add(pricePanel);
		amountPanel = new JPanel();
		amountLabel = new JLabel("Amount");
		amountField = new JTextField(10);
		amountField.addKeyListener(new KeyAdapter(){
        	public void keyTyped(KeyEvent e){
                text = amountField.getText();
                text = text.replaceAll("\\D+","");
                amountField.setText(text);
        	}
        });
		amountPanel.add(amountLabel);
		amountPanel.add(amountField);
		addFrame.add(amountPanel);
		addPanel = new JPanel();
		addButton = new JButton("ADD PRODUCT");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				pId = pIdField.getText();
				pId = pId.replaceAll("\\D+","");
				price = priceField.getText();
				price = price.replaceAll("\\D+","");
				amount = amountField.getText();
				amount = amount.replaceAll("\\D+","");
				try{
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
					Statement statement=connection.createStatement();
					rs = statement.executeQuery("SELECT count(*) FROM products WHERE productId = "+pId+";");
					rs.next();
					count = rs.getString(1);
					if(count.equals("1")){
					rs = statement.executeQuery("SELECT count(*) FROM companyprice WHERE productId = "+pId+" AND companyId = "+companyId+";");
					rs.next();
					count = rs.getString(1);
					
					if(count.equals("0")){
					statement.execute("INSERT INTO companyprice values ("+pId+", "+companyId+", "+price+", "+amount+");");
					JOptionPane.showMessageDialog(null, "ProductID ("+pId+") added");
					}
					else{
						JOptionPane.showMessageDialog(null, "The product already exist \nTry to update it!");
					}
					}
					else{
						JOptionPane.showMessageDialog(null, "The product doesn't exist \nContact the admin!");
					}
				}
					catch(Exception r){
					}
				addFrame.dispose();
			}
	  });
		addPanel.add(addButton);
		addFrame.add(addPanel);
		addFrame.setLocationRelativeTo(null);
		addFrame.pack();
		addFrame.setDefaultCloseOperation(addFrame.DISPOSE_ON_CLOSE);
		addFrame.setVisible(true);
		
	}
	
	/**
	 * Make the UI when you want to update a product and update it in the database. 
	 */
	public static void update(){
		pId=JOptionPane.showInputDialog("Enter the ProductId you want to UPDATE");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
			Statement statement=connection.createStatement();
			ResultSet rs = null;
			rs = statement.executeQuery("SELECT count(*) FROM companyprice WHERE CompanyId = "+companyId+" AND ProductId = "+pId+";");
			rs.next();
			count = rs.getString(1);
			if(count.equals("1")){
			rs = statement.executeQuery("SELECT * FROM companyprice WHERE CompanyId = "+companyId+" AND ProductId = "+pId+";");
			rs.next();
			cprice = rs.getString(3);
			camount = rs.getString(4);
			}
		}
			catch(Exception e){
			}
		if(count.equals("1")){
		updateFrame = new JFrame("UPDATE PRODUCT");
		updateFrame.setLayout(new GridLayout(6, 1, 10, 10));
		
		pIdPanel = new JPanel();
		pIdLabel = new JLabel("ProductId");
		pIdField = new JTextField(10);
		pIdField.setText(pId);
		pIdField.setEditable(false);
		pIdPanel.add(pIdLabel);
		pIdPanel.add(pIdField);
		updateFrame.add(pIdPanel);
		cIdPanel = new JPanel();
		cIdLabel = new JLabel("CompanyId");
		cIdField = new JTextField(10);
		cIdField.setText(companyId);
		cIdField.setEditable(false);
		cIdPanel.add(cIdLabel);
		cIdPanel.add(cIdField);
		updateFrame.add(cIdPanel);
		pricePanel = new JPanel();
		priceLabel = new JLabel("Price (kr)");
		priceField = new JTextField(10);
		priceField.addKeyListener(new KeyAdapter(){
        	public void keyTyped(KeyEvent e){
                text = priceField.getText();
                text = text.replaceAll("\\D+","");
                priceField.setText(text);
        	}
        });
		priceField.setText(cprice);
		pricePanel.add(priceLabel);
		pricePanel.add(priceField);
		updateFrame.add(pricePanel);
		amountPanel = new JPanel();
		amountLabel = new JLabel("Amount");
		amountField = new JTextField(10);
		amountField.addKeyListener(new KeyAdapter(){
        	public void keyTyped(KeyEvent e){
                text = amountField.getText();
                text = text.replaceAll("\\D+","");
                amountField.setText(text);
        	}
        });
		amountField.setText(camount);
		amountPanel.add(amountLabel);
		amountPanel.add(amountField);
		updateFrame.add(amountPanel);
		updatePanel = new JPanel();
		updateButton = new JButton("UPDATE PRODUCT");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				price = priceField.getText();
				price = price.replaceAll("\\D+","");
				amount = amountField.getText();
				amount = amount.replaceAll("\\D+","");
				try{
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
					Statement statement=connection.createStatement();
					statement.execute("UPDATE companyprice SET Price = "+price+" , Amount = "+amount+" WHERE CompanyId = "+companyId+" AND ProductId = "+pId+"");
					JOptionPane.showMessageDialog(null, "ProductID ("+pId+") updated");
					}
					catch(Exception q){
					}
				updateFrame.dispose();
			}
	  });
		updatePanel.add(updateButton);
		updateFrame.add(updatePanel);
		updateFrame.setLocationRelativeTo(null);
		updateFrame.pack();
		updateFrame.setDefaultCloseOperation(updateFrame.DISPOSE_ON_CLOSE);
		updateFrame.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "The product doesn't exist \nCheck if you used the correct PRODUCTID("+pId+")!");
		}
		
		
	}
	
	/**
	 * Make the UI when you want to delete a product and delete it from the database. 
	 */
	public static void delete(){
		pId=JOptionPane.showInputDialog("Enter the ProductId you want to DELETE");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/lego", "root", "");
			Statement statement=connection.createStatement();
			rs = statement.executeQuery("SELECT count(*) FROM companyprice WHERE CompanyId = "+companyId+" AND ProductId = "+pId+";");
			rs.next();
			count = rs.getString(1);
			if(count.equals("1")){

			statement.execute("DELETE FROM companyprice WHERE CompanyId = "+companyId+" AND ProductId = "+pId+";");
			JOptionPane.showMessageDialog(null, "ProductID ("+pId+") deleted");
			}
			else{
				JOptionPane.showMessageDialog(null, "The product doesn't exist \nCheck if you used the correct PRODUCTID("+pId+")!");
			}
			}
			catch(Exception e){
				
			}
	}

}
