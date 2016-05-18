package CreateUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
/**
 * @author Johan
 * Create panels, labels and textfields for create account.
 *
 */
public class CreatePane extends JPanel {
	
	static JTextField newUserField, firstnameField, lastnameField, ageField, extraField;
    static JPasswordField newPassField;
    static JLabel newUserLabel, newPassLabel, firstnameLabel, lastnameLabel, ageLabel;
    static JButton createAccButton;
	
    /**
     * @author Johan
     * Create panels, labels and textfields for create account.
     *
     */
	public CreatePane() {
		
		setLayout(new GridLayout(8, 1, 10, 10));
        JPanel newUserPanel = new JPanel();
        newUserLabel = new JLabel("Username:");
        newUserPanel.add(newUserLabel);
        newUserField = new JTextField(15);
        newUserPanel.add(newUserField);
        
        add(newUserPanel);
        
        
        JPanel newPassPanel = new JPanel();
        newPassLabel = new JLabel("Password:");
        newPassPanel.add(newPassLabel);
        
        newPassField = new JPasswordField(15);
        newPassPanel.add(newPassField);
        
        add(newPassPanel);
        
        JPanel firstnamePanel = new JPanel();
        
        firstnameLabel = new JLabel("First Name:");
        firstnamePanel.add(firstnameLabel);
        
        firstnameField = new JTextField(20);
        firstnamePanel.add(firstnameField);
        
        add(firstnamePanel);
        
        JPanel lastnamePanel = new JPanel();
        
        lastnameLabel = new JLabel("Last Name:");
        lastnamePanel.add(lastnameLabel);
        
        lastnameField = new JTextField(20);
        lastnamePanel.add(lastnameField);
        
        add(lastnamePanel);
        
        JPanel agePanel = new JPanel();
        
        ageLabel = new JLabel("Age:");
        agePanel.add(ageLabel);
        
        ageField = new JTextField(20);
        agePanel.add(ageField);
        
        createAccButton = new JButton("Create");
        agePanel.add(createAccButton);
        
        add(agePanel);
        
        createAccButton.addActionListener(new getNewUser());
        
        JPanel extraPanel = new JPanel();
        
        extraField = new JTextField(25);
        extraPanel.add(extraField);
        extraField.setEditable(false);
        
        
        
		
		
	}
}