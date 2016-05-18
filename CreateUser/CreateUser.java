package CreateUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;
import javax.swing.*;
/**
 * @author Johan
 * Actionlistener to make a new frame
 *
 */
public class CreateUser implements ActionListener {
	
	static JFrame createFrame;
	
            public void actionPerformed(ActionEvent e) {
            	
            	createFrame = new JFrame("Create New Account");
                createFrame.setContentPane(new CreatePane());
                createFrame.pack();
                createFrame.setLocationRelativeTo(null);
                createFrame.setVisible(true);
            	
            }
            
            }