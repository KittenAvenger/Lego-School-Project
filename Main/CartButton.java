package Main;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



/**@author Dennis Nielsen, Johan Hermansson */

public class CartButton extends JButton implements ActionListener{
	
	
	final private String productId, companyID;
	final private String name, title, price, company;
	static ArrayList<Object> CartList=new ArrayList<Object>();
	static ArrayList<String> ItemList=new ArrayList<String>();
	static int sum;
	static int count=4;
	
	
	//Creates a JButton named Add To cart that adds product to the cart and passes on information from the SearchDisplay object
	
	public CartButton (String productId, String name, String price, String company, String title, String companyID) {
		super(title);
		this.title = title;
		this.setText(title);
		super.addActionListener(this);
		this.productId = productId;
		this.name = name;
		this.price=price;
		this.company=company;
		this.companyID=companyID;
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		//Subtract amount by one and gets the SearchDisplay object data about the product you added to Cart List
		
		CheckAmount.SubtractAmount(companyID, productId);
		
		//If the amount of products is not zero then you can add them to the cart
		
		if(CheckAmount.outofstock==false){
		
		Cart cart=new Cart(productId, name, price, company);
		CartList.add(cart);
		String item = (companyID + " " + productId);    //Add company ID to Item List
		
		ItemList.add(item);
		Ribz.CartPanel.removeAll();
		JPanel addPanel = new JPanel();
		addPanel.setLayout(new GridLayout (count, 1));
		JScrollPane scroll = new JScrollPane();
		for(int i = 0; i < CartList.size();i++){
		scroll.add((Component) CartList.get(i));
		addPanel.add((Component) CartList.get(i));
		}
		scroll.setPreferredSize(new Dimension(200,385));
        scroll.setViewportView(addPanel);
        Ribz.CartPanel.add(scroll);
        
        
        //Adds price of the product to the total sum as well as adding it to the object arraylist Cart List as well as the Cart Panel
        
        sum+=Integer.parseInt(price);
        count++;
        
        Ribz.CartPanel.revalidate();
        Ribz.CartPanel.repaint();
        
        
        Ribz.BuyPanel.repaint();
        
    	String sumPrice=Integer.toString(CartButton.sum);
    	Ribz.lblTotalSum.setText("Total sum: "+ sumPrice + " kr");
    	String CartItem=CartList.get(0).toString();
		
		}
	}
	
}
