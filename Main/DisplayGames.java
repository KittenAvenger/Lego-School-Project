package Main;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import java.net.URL;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

/**@author Dennis Nielsen*/

public class DisplayGames extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	//A similar SearchDisplay object for videogames that was never utilized in the final version

	public DisplayGames(ResultSet result) throws Exception{
		
		setPreferredSize(new Dimension(500, 156));
		setVisible(true);
		
		
		String link = result.getString("image");
		System.out.println(link);

		BufferedImage picture = ImageIO.read( new URL( "file:///"+link));
		JLabel lblImage = new JLabel(new ImageIcon (picture));
		
		String name = result.getString("Name");
		JLabel lblName = new JLabel(name);
		
		String category = result.getString("ReleaseDate");
		JLabel lblFlavour = new JLabel("Release Date: "+category);
		
		String productID = result.getString("ProductID");
		JLabel lblPrice = new JLabel("Product ID: " + productID);
		
		String price = result.getString("Price");
		JLabel lblType = new JLabel("Price: "+ price +" kr");
		
		String age= result.getString("Age");
		JLabel lblBrand = new JLabel("Age: "+age);
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblFlavour, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblName, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFlavour, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	
		
	}
	
}