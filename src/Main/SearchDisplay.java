package Main;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;


public class SearchDisplay extends JPanel {
	
	/* got external help with this class */
	
	private static final long serialVersionUID = 1L;
	
	static String name;
	static CartButton AddToCart;
	static String productID;
	static String price;

	public SearchDisplay(ResultSet result) throws Exception{
		
		setPreferredSize(new Dimension(500, 156));
		setVisible(true);
		
		
		String link = result.getString("image");
		

		BufferedImage picture = ImageIO.read( new URL( "file:///"+link));
		JLabel lblImage = new JLabel(new ImageIcon (picture));
		
	    name = result.getString("Name");
		JLabel lblName = new JLabel(name);
		
		String category = result.getString("Pieces");
		JLabel lblFlavour = new JLabel("Pieces: "+category);
		
		String productID = result.getString("ProductID");
		JLabel lblPrice = new JLabel("Product ID: " + productID);
		
		String price = result.getString("Price");
		JLabel lblType = new JLabel("Price: "+ price +" kr");
		
		String age= result.getString("Age");
		JLabel lblBrand = new JLabel("Age: "+age);
		
		String company=result.getString("CompanyName");
		JLabel lblCompany = new JLabel("Company:"+company);
		
		String companyID=result.getString("CompanyID");
		
		
		
		
		 AddToCart = new CartButton(productID, name, price, company, "Add to cart",companyID);
		
		
		//Visual design for the Search Display object
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(lblFlavour, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblCompany)
											.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap(74, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addComponent(AddToCart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(123))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFlavour, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCompany)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(AddToCart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	
		
	}
}


