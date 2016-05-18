package Main;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import Survey.SurveyInterface;

/**
 * @author Johan Hermansson
 * Make UI to show all the products when the customer confirmed the order.
 *
 */
public class orderConfirmed {
	static JFrame oConfirmed;
	static JPanel infoPanel, products ,pricePanel;
	static JLabel infoLabel, priceLabel;
	static JScrollPane scrollPanel;
	static int count1=4;
	
	/**
	 * @author Johan Hermansson
	 * Make UI to show all the products when the customer confirmed the order.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("static-access")
	public static void orderConfirm(ArrayList<Object> cartList, int price){
		
		oConfirmed = new JFrame("Complete Order");
		oConfirmed.getContentPane().setLayout(new GridLayout(3, 1, 10, 10));
		
		infoPanel = new JPanel();
		
		infoLabel = new JLabel("The products will be shipped to you within 3-5 working days");
		infoPanel.add(infoLabel);
		oConfirmed.getContentPane().add(infoPanel);
		
		
		products = new JPanel();
		scrollPanel = new JScrollPane();
		products.setLayout(new GridLayout (cartList.size(), 1));
		scrollPanel.setPreferredSize(new Dimension(200, 200));
		
		//Gets all the products from the cart and displays them in a scrollpane
		
		for(int i = 0; i < cartList.size(); i++){
			scrollPanel.add((Component) cartList.get(i));
			products.add((Component) cartList.get(i));
		}
		
		count1++;
		scrollPanel.setViewportView(products);
		oConfirmed.getContentPane().add(scrollPanel);
		
		pricePanel = new JPanel();
		String Stringprice = Integer.toString(price);
		priceLabel = new JLabel("The price of the order was " + Stringprice+ "kr");
		oConfirmed.getContentPane().add(pricePanel);
		GroupLayout gl_pricePanel = new GroupLayout(pricePanel);
		gl_pricePanel.setHorizontalGroup(
			gl_pricePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pricePanel.createSequentialGroup()
					.addGap(75)
					.addComponent(priceLabel))
		);
		gl_pricePanel.setVerticalGroup(
			gl_pricePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pricePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(priceLabel))
		);
		pricePanel.setLayout(gl_pricePanel);
		
		oConfirmed.setLocationRelativeTo(null);
		oConfirmed.pack();
		oConfirmed.addWindowListener(new WindowAdapter()
        {
            @Override
            
            //Empties the cart and brings up the survey window
            public void windowClosing(WindowEvent e){
            SurveyInterface.Survey(billingInfo.userID);
            Cart.EmptyCart();
            }
        });
		oConfirmed.setDefaultCloseOperation(oConfirmed.DISPOSE_ON_CLOSE);
		oConfirmed.setVisible(true);
		
	}

}
