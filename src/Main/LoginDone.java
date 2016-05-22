package Main;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**@author Dennis Nielsen*/


public class LoginDone extends JPanel {
	
	//Visual design for the Logged in button, which shows that you have logged and presents you a log out button
	
	public LoginDone() {
		
		setPreferredSize(new Dimension(100, 100));
		setVisible(true);
		JLabel LoggedInLabel = new JLabel("Logged in as: <dynamic>");
		
		JButton LogOutButton = new JButton("  Log out");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addComponent(LogOutButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(LoggedInLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(4, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(LoggedInLabel)
					.addGap(86)
					.addComponent(LogOutButton)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
}
