package Main;

import javax.swing.GroupLayout;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class Cart extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5046903248707458373L;

	/**@author Dennis Nielsen
	 
	 
	 Design for the Cart constructor in the Cart List
	 */
	
	public Cart(String pID, String name, String price, String company) {
		setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblPid = new JLabel("PID: "+pID);
		
		JLabel lblName = new JLabel("Name: "+name);
		
		JLabel lblPrice = new JLabel("Price: "+price+" kr");
		
		
		
		JLabel lblCompanyname = new JLabel("Company: "+company);
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblPrice)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblPid, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblCompanyname)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPid)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrice)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						
						.addComponent(lblCompanyname)))
		);
		setLayout(groupLayout);
	}
	
	public static void EmptyCart(){
		Ribz.CartPanel.removeAll();
		Ribz.CartPanel.revalidate();
		Ribz.CartPanel.repaint();
		CartButton.sum=0;
		String sumPrice=Integer.toString(CartButton.sum);
		Ribz.lblTotalSum.setText("Total sum: "+ sumPrice + " kr");
    	CartButton.CartList.clear();
    	CartButton.ItemList.clear();
	}
}
