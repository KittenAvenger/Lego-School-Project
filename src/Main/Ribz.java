package Main;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;







import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;







import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;




import CreateUser.CreateUser;
import AdminInputClient.AddDelete;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import datamining2.createUser;

/** @author Dennis Nielsen
*/

//	Test comment
public class Ribz {

	private JFrame frame;
	public static JTextField SearchField;
	public static JTextField LoginField;
	private JLabel LegoLogo_1;
	public static JPanel ProductDisplayPanel;
	public static JButton Search;
	static String[]pricerange={"All", "0-299", "299-599","599-999", "999-1399","1399-1699","1699-1999","1999-2999","2999-3999","3999-4999"};
	static String[]piecerange={"All", "0-200", "200-400", "400-600", "600-1000","1000-1600","1600-2200","2200-3200"};
	static JComboBox PriceList;
	static JComboBox PiecesList;
	static String input="";
	static String priceMin="";
	static String priceMax="";
	static String piecesMin="";
	static String piecesMax="";
	static String[]mjau;
	static String[]bacon;
	static String sql;
	static boolean flag = false;
	static boolean flag2 = false;
	static boolean flag3 = false;
	static boolean flag4 = false;
	Action action=new Action();
	JButton BatmanButton = new JButton("Batman");
	JButton LordOfTheRingsButton = new JButton("Lord of The Rings");
	JButton MarvelButton = new JButton("Marvel");
	JButton StarWarsButton = new JButton("Star Wars");
	static SearchDisplay searchDisplay;
	static JPanel CartPanel;
	static JLabel lblTotalSum;
	static JPanel BuyPanel;
	static JButton ClearList, UpdateProfile;
	static JButton BuyProducts;
	public static JPanel LoginPanel;
	public static JPasswordField PasswordField;
	static JButton LoginButton, LogoutButton;
	static JLabel lblLogin, lblLoggedin;
	static JLabel lblPassword;
	static JButton AddDeleteProducts;
	static JButton CreateAccount;
	static boolean admin=false;
	static boolean company=false;
	static boolean user=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ribz window = new Ribz();
					window.frame.setVisible(true);
					window.frame.setExtendedState(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Ribz() throws Exception {
		initialize();
		SearchField.addActionListener(action);
		Search.addActionListener(action);
		PriceList.addActionListener(action);
		PiecesList.addActionListener(action);
		BatmanButton.addActionListener(action);
		MarvelButton.addActionListener(action);
		LordOfTheRingsButton.addActionListener(action);
		StarWarsButton.addActionListener(action);
		ClearList.addActionListener(action);
		BuyProducts.addActionListener(action);
		LoginButton.addActionListener(action);
		LogoutButton.addActionListener(action);
		AddDeleteProducts.addActionListener(action);
		CreateAccount.addActionListener(action);
		UpdateProfile.addActionListener(action);

		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	/**This is the entire code for the GUI created using Windowbuilder pro 
	 @author Dennis Nielsen, Anastasia Koni */
	private void initialize () throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 865, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel CategoryPanel = new JPanel();
		
	    ProductDisplayPanel = new JPanel();
	    
		ProductDisplayPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel MyCartPanel = new JPanel();
		
		JPanel SearchPanel = new JPanel();
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_2 = new JSeparator();
		
	    CartPanel = new JPanel();
		CartPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
	
		
		
		BuyPanel = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(SearchPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 850, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(CategoryPanel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ProductDisplayPanel, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(CartPanel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
								.addComponent(BuyPanel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))))
					.addGap(367)
					.addComponent(MyCartPanel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(SearchPanel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(MyCartPanel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addComponent(CategoryPanel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProductDisplayPanel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(CartPanel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
					.addGap(6)
					.addComponent(BuyPanel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
		);
		
		
		
		 lblTotalSum = new JLabel("Total sum: 0 kr");
		
		
		
		 BuyProducts = new JButton("Buy Products");
		
		 ClearList = new JButton("Clear List");
		GroupLayout gl_BuyPanel = new GroupLayout(BuyPanel);
		gl_BuyPanel.setHorizontalGroup(
			gl_BuyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BuyPanel.createSequentialGroup()
					.addGroup(gl_BuyPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_BuyPanel.createSequentialGroup()
							.addComponent(BuyProducts)
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(ClearList))
						.addComponent(lblTotalSum))
					.addContainerGap())
		);
		gl_BuyPanel.setVerticalGroup(
			gl_BuyPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BuyPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_BuyPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BuyProducts)
						.addComponent(ClearList))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTotalSum)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		BuyPanel.setLayout(gl_BuyPanel);
		
		SearchField = new JTextField();
		SearchField.setColumns(10);
		
		Search = new JButton("Search");
		
		PriceList = new JComboBox(pricerange);
		
		PiecesList = new JComboBox(piecerange);
		
		JLabel Price = new JLabel("Price");
		
		JLabel Pieces = new JLabel("    Pieces");
		
		BufferedImage logo=ImageIO.read( new URL("file:///"+"C:\\Dropbox\\Pictures\\LegoIcon2.png"));
		LegoLogo_1 = new JLabel(new ImageIcon (logo));
		
		 AddDeleteProducts = new JButton("Add/Delete Products");
		 UpdateProfile=new JButton ("Update Profile");
		 UpdateProfile.setVisible(false);
		 AddDeleteProducts.setVisible(false);
		/*AddDeleteProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AddDelete.AddDelete1();	
				
			}
		});*/
		
		LoginPanel = new JPanel();
		
		
		
		 lblLogin = new JLabel("Login");
		 lblLoggedin = new JLabel("Logged in as: "+billingInfo.username );
		
		LoginField = new JTextField();
		LoginField.setColumns(10);
		
		 lblPassword = new JLabel("Password");
		
		 LoginButton = new JButton("Login");
		 
		 LogoutButton=new JButton ("Log out");
		
		PasswordField = new JPasswordField();
		
		 CreateAccount = new JButton("Create Account");
		 
		GroupLayout gl_LoginPanel = new GroupLayout(LoginPanel);
		gl_LoginPanel.setHorizontalGroup(
			gl_LoginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LoginPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_LoginPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(PasswordField, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_LoginPanel.createSequentialGroup()
							.addComponent(LoginButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CreateAccount))
						.addComponent(lblPassword, Alignment.LEADING)
						.addComponent(LoginField, Alignment.LEADING)
						.addComponent(LogoutButton, Alignment.LEADING)
						.addComponent(lblLoggedin, Alignment.LEADING)
						.addComponent(lblLogin, Alignment.LEADING))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_LoginPanel.setVerticalGroup(
			gl_LoginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LoginPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addComponent(lblLoggedin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(LogoutButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addGap(1)
					.addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_LoginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(CreateAccount))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);lblLoggedin.setVisible(false);
		   LogoutButton.setVisible(false);
		LoginPanel.setLayout(gl_LoginPanel);
			
		
		
		GroupLayout gl_SearchPanel = new GroupLayout(SearchPanel);
		gl_SearchPanel.setHorizontalGroup(
			gl_SearchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SearchPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(LegoLogo_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_SearchPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SearchPanel.createSequentialGroup()
							.addGroup(gl_SearchPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_SearchPanel.createSequentialGroup()
									.addComponent(Price, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(Pieces, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addComponent(SearchField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Search, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(AddDeleteProducts)
						.addComponent(UpdateProfile)
						
						.addGroup(gl_SearchPanel.createSequentialGroup()
							.addComponent(PriceList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(PiecesList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(260)
					.addComponent(LoginPanel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(2))
		);
		gl_SearchPanel.setVerticalGroup(
			gl_SearchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SearchPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SearchPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SearchPanel.createSequentialGroup()
							.addComponent(LoginPanel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_SearchPanel.createSequentialGroup()
							.addGroup(gl_SearchPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(LegoLogo_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addGroup(gl_SearchPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(AddDeleteProducts)
									.addComponent(UpdateProfile)
									.addGap(18, 18, Short.MAX_VALUE)
									.addGroup(gl_SearchPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(SearchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(Search))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SearchPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Price)
								.addComponent(Pieces))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_SearchPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(PriceList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PiecesList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(118))))
		); AddDeleteProducts.setVisible(false);
		SearchPanel.setLayout(gl_SearchPanel);
		
		JLabel MyCart = new JLabel(" My Cart:");
		GroupLayout gl_MyCartPanel = new GroupLayout(MyCartPanel);
		gl_MyCartPanel.setHorizontalGroup(
			gl_MyCartPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MyCartPanel.createSequentialGroup()
					.addComponent(MyCart, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_MyCartPanel.setVerticalGroup(
			gl_MyCartPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MyCartPanel.createSequentialGroup()
					.addComponent(MyCart, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		MyCartPanel.setLayout(gl_MyCartPanel);
		GroupLayout gl_CategoryPanel = new GroupLayout(CategoryPanel);
		gl_CategoryPanel.setHorizontalGroup(
			gl_CategoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CategoryPanel.createSequentialGroup()
					.addGroup(gl_CategoryPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(LordOfTheRingsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(BatmanButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(MarvelButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(StarWarsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4))
		);
		gl_CategoryPanel.setVerticalGroup(
			gl_CategoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CategoryPanel.createSequentialGroup()
					.addComponent(BatmanButton)
					.addGap(5)
					.addComponent(LordOfTheRingsButton)
					.addGap(4)
					.addComponent(MarvelButton)
					.addGap(5)
					.addComponent(StarWarsButton)
					.addGap(93))
		);
		CategoryPanel.setLayout(gl_CategoryPanel);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	/** @author Dennis Nielsen */
	
	
class Action implements ActionListener {

		
		public void actionPerformed(ActionEvent b) {
			
			
			
			
			String input=SearchField.getText();
			
			
			
				
			//Goes to the create user account window
			
			if(b.getSource()==CreateAccount){
				createUser.createAccount(false);
			}
			
			//Goes to the admin window for altering products for admin privileges
			
			if(b.getSource()==AddDeleteProducts && admin==true){
				AddDelete.AddDelete2();	
				
			}
			
			//Goes to the company window for altering products for company privileges
			if(b.getSource()==AddDeleteProducts && company==true){
				companyEditClient.CompanyClient(billingInfo.companyID);
			}
			
			//Goes to the update profile window for regular users
			if(b.getSource()==UpdateProfile && user==true){
				updateUser.updateAcc(billingInfo.userID);
			}
			
			
			//Logs out and resest the interface to its default state
			
			if(b.getSource()==LogoutButton){
				billingInfo.LogSuccess=false;
				lblLogin.setVisible(true);
				lblLoggedin.setVisible(false);
				LogoutButton.setVisible(false);
				LoginField.setVisible(true);
				PasswordField.setVisible(true);
				lblPassword.setVisible(true);
				LoginButton.setVisible(true);
				LoginField.setText("");
				PasswordField.setText("");
				AddDeleteProducts.setVisible(false);
				billingInfo.usertype="";
				admin=false;
				company=false;
				CreateAccount.setVisible(true);
				 Ribz.BuyProducts.setVisible(true);
				 Ribz.ClearList.setVisible(true);
				 lblTotalSum.setVisible(true);
				 UpdateProfile.setVisible(false);
				 CheckAmount.Amount();
				 Cart.EmptyCart();

				
				
			}
			
			//Checks if a login is possible
			
			if(b.getSource()==LoginButton){
				billingInfo.LogSuccess=false;
				billingInfo.checkloginMF();
				
				if(billingInfo.LogSuccess==true){
				lblLogin.setVisible(false);
				lblLoggedin.setVisible(true);
				LogoutButton.setVisible(true);
				LoginField.setVisible(false);
				PasswordField.setVisible(false);
				lblPassword.setVisible(false);
				LoginButton.setVisible(false);
				CreateAccount.setVisible(false);
				lblLoggedin.setText("Logged in as: "+billingInfo.username);
			   }
				
				//Checks if the user is logged in and is an admin and changes the interface so that an admin can add products, update or delete them in the products table
				if(billingInfo.LogSuccess==true && billingInfo.usertype.equals("Admin")){
					admin=true;
					lblLogin.setVisible(false);
					lblLoggedin.setVisible(true);
					LogoutButton.setVisible(true);
					LoginField.setVisible(false);
					PasswordField.setVisible(false);
					lblPassword.setVisible(false);
					LoginButton.setVisible(false);
					lblLoggedin.setText("Logged in as: "+billingInfo.username);
					 Ribz.BuyProducts.setVisible(false);
					 Ribz.ClearList.setVisible(false);
					 lblTotalSum.setVisible(false);
					 Cart.EmptyCart();
					AddDeleteProducts.setVisible(true);
				   }
				//Checks if the user has logged in and is the usertype company, where it makes certain components non visible and gives the ability to alter products in the company price table
				if(billingInfo.LogSuccess==true && billingInfo.usertype.equals("Company")){
					company=true;
					lblLogin.setVisible(false);
					lblLoggedin.setVisible(true);
					LogoutButton.setVisible(true);
					LoginField.setVisible(false);
					PasswordField.setVisible(false);
					lblPassword.setVisible(false);
					LoginButton.setVisible(false);
					lblTotalSum.setVisible(false);
					Cart.EmptyCart();
					lblLoggedin.setText("Logged in as: "+billingInfo.username);
					AddDeleteProducts.setVisible(true);
				   }
				
				//Checks if the user has logged in and is the usertype user and empties the cart
				if(billingInfo.LogSuccess==true && billingInfo.usertype.equals("User")){
					user=true;
					lblLogin.setVisible(false);
					lblLoggedin.setVisible(true);
					LogoutButton.setVisible(true);
					LoginField.setVisible(false);
					PasswordField.setVisible(false);
					lblPassword.setVisible(false);
					LoginButton.setVisible(false);
					
					Cart.EmptyCart();
					lblLoggedin.setText("Logged in as: "+billingInfo.username);
					UpdateProfile.setVisible(true);
				   }
			}
			
			
			//Checks if you are logged in, if you are and have bought products it will direct you to billing information, otherwise it will tell you log in or add a product to the cart
			
			if(b.getSource()==BuyProducts){
				
				if(billingInfo.LogSuccess==false){
				billingInfo.Buy();
				}
				
				else{
				if(CartButton.CartList.size()==0){
					JOptionPane.showMessageDialog(null, " You have no products in your cart");
				}
				else{billingInfo.checkLogin();
				}
			}
			
			}	
			
			//Clears the Cart Panel as well as sets the total sum to zero and clears the object arraylist Cart List
			
			if(b.getSource()==ClearList){
				if (JOptionPane.showConfirmDialog(null, "Do you really want to delete your cart?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				    
					CartPanel.removeAll();
					CartPanel.revalidate();
					CartPanel.repaint();
					CartButton.sum=0;
					String sumPrice=Integer.toString(CartButton.sum);
			    	lblTotalSum.setText("Total sum: "+ sumPrice + " kr");
			    	CartButton.CartList.clear();
				} else {
				    
				}
				
				
			}
			
			//Gets the info from the SearchDisplay object in order to add info about the product in the Cart List
			
			if(b.getSource()==SearchDisplay.AddToCart){
				String cart=searchDisplay.getName();
				
			}
			
			
			//Searches for a keyword  you have typed and if you haven't, it will give you a Message dialog
			
			if (b.getSource()==SearchField||b.getSource()==Search){
				flag=false;
				flag2=false;
				flag3=false;
				flag4=false;
				
				SearchEngine.CountWords(input);
				if(input.length()<1){
				JOptionPane.showMessageDialog(null, "Please type the category you are looking for");
				}
			}
			
			String searchContent;
			
			//Gets the selected price range from the price dropdown list
			
			if(b.getSource()==PriceList){
				String price=(String)PriceList.getSelectedItem();
			    mjau=price.split("-");
				
			    
				if(!price.equals("All")){
				priceMin=mjau[0];
				priceMax=mjau[1];
				}
				else {
				 priceMin=mjau[0];	
				}
			}
			
			//Gets the selectecd pieces range from the piece dropdown list
			
			if(b.getSource()==PiecesList){
				String pieces=(String)PiecesList.getSelectedItem();
				bacon=pieces.split("-");
				
				
				
				if(!pieces.equals("All")){
				piecesMin=bacon[0];
				piecesMax=bacon[1];
			   }
			   else {
				 piecesMin=bacon[0];  
			   }
				
			}
	 		try {
			JDBC data = new JDBC();
			
			//Checks if there is text in the searchfield
			
			searchContent = SearchField.getText();
	 			
	 			
	 			try {
	 				
	 				
	 				//Displays products from Batman category
	 				
	 				
	 				if(b.getSource()==BatmanButton){
	 					SearchField.setText("");
	 					sql="";
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category =  'Batman'   ";
	 					
	 					flag=true;
	 					flag2=false;
	 					flag3=false;
	 					flag4=false;
	 					
	 				}
	 				
	 				//Displays products from Marvel category
	 				
	 				if(b.getSource()==MarvelButton){
	 					SearchField.setText("");
	 					sql="";
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND  category = 'Marvel' ";
	 					
	 					flag=false;
	 					flag2=true;
	 					flag3=false;
	 					flag4=false;
	 					
	 				}
	 				
	 				//Displays products from Lord of the Rings
	 				
	 				if(b.getSource()==LordOfTheRingsButton){
	 					SearchField.setText("");
	 					sql="";
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Lord Of The Rings'  ";
	 					
	 					flag=true;
	 					flag2=false;
	 					flag3=true;
	 					flag4=false;
	 					
	 				}
	 				
	 				//Displays products from Star Wars
	 				
	 				if(b.getSource()==StarWarsButton){
	 					SearchField.setText("");
	 					sql="";
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Star Wars'  ";
	 					
	 					flag=false;
	 					flag2=false;
	 					flag3=false;
	 					flag4=true;
	 				}
	 				
	 				//Looks if the searchfield has an actual text input and searches for a specific keyword
	 				
	 				else if(!SearchField.getText().equals("")){
	 					
	 				 sql = "SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND name like '"+searchContent+"%'  ";
	 				}
	 				
	 				if (priceMin.equals("All")&&flag==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category =  'Batman'  ";
	 				}
	 				if (priceMin.equals("All")&&flag2==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND  category = 'Marvel'  ";
	 				}
	 				if (priceMin.equals("All")&&flag3==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Lord Of The Rings'  ";
	 				}
	 				if (priceMin.equals("All")&&flag4==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Star Wars' ";
	 				}
	 				
	 				if (piecesMin.equals("All")&&flag==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category =  'Batman'   ";
	 				}
	 				if (piecesMin.equals("All")&&flag2==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND  category = 'Marvel'  ";
	 				}
	 				if (piecesMin.equals("All")&&flag3==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Lord Of The Rings'  ";
	 				}
	 				if (piecesMin.equals("All")&&flag4==true){
	 					sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Star Wars'  ";
	 				}
	 				
	 				boolean searchonprice = priceMin != null && !priceMin.isEmpty() && !priceMin.equals("All");

	 				boolean searchonpiece = piecesMin != null && !piecesMin.isEmpty() && !piecesMin.equals("All");
	 				
	 				//Searches for price as well as pieces together from the result you got using category or search function
	 				
	 				if(searchonprice && searchonpiece)
	 				{	
	 					
	 					sql = sql + " and Price BETWEEN " + priceMin + " AND " + priceMax;	
	 					sql = sql + " and pieces BETWEEN " + piecesMin + " AND " + piecesMax;
	 				}
	 				else
	 				{
	 					
	 					//Only searching on price
	 				if(searchonprice) {
	 					if(flag==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category =  'Batman'   ";}
	 					if(flag2==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND  category = 'Marvel'  ";}
	 					if(flag3==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Lord Of The Rings'  ";}
	 					if(flag4==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Star Wars'  ";}
	 					sql = sql + " and Price BETWEEN " + priceMin + " AND " + priceMax;}
	 				
	 				
			 			
		 			//Only searching on pieces
	 				
		 			if(searchonpiece) {
		 				if(flag==true) {sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category =  'Batman'   ";}
	 					if(flag2==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND  category = 'Marvel'  ";}
	 					if(flag3==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Lord Of The Rings'  ";}
	 					if(flag4==true){sql="SELECT * FROM products, companyprice, company WHERE products.ProductID = companyPrice.ProductID AND companyPrice.CompanyID = company.CompanyID AND category = 'Star Wars'  ";}
		 				
		 				
		 				sql = sql + " and pieces BETWEEN " + piecesMin + " AND " + piecesMax;}
		 			}
	 				
		 			
		 	
		 			
	 				
	 				
		 			
		 			
		 			
	 				
	 				
	 				
	 				ResultSet rs = data.SQL.executeQuery(sql);
		 			
		 			String list = "";
		 			
		 			//Returns a dialog window if your search came up empty
		 			
		 			if(rs.next()==false){
		 				JOptionPane.showMessageDialog(null, "Sorry your search yielded nothing");
		 				
		 			}
		 			
		 			
		 			int count=1;
		 			
		 			//Counts the amount of results as rows and saves it as an int variable count in order to dynamically alter the gridlayout depending on the amount of products that came up in the search
		 			
		 			while (rs.next()){
		 				count++;
		 			}
		 			
		 			
		 			
		 			//Clears the panel and adds a scrollpane
		 			
		 			ResultSet result = data.SQL.executeQuery(sql);
		 			ProductDisplayPanel.removeAll();
		 			JPanel addPanel = new JPanel();
		 			addPanel.setLayout(new GridLayout (count, 1));
		 			JScrollPane scroll = new JScrollPane();
		 			
		 			//Creates a SearchDisplay object to display information about each product and adds these to the JScrollPane
		 			
		            while (result.next()) {
						searchDisplay  = new SearchDisplay (result);            
						scroll.add(searchDisplay);
		            	addPanel.add(searchDisplay);
		            	
					}	
		            scroll.setPreferredSize(new Dimension(425,390));
		            scroll.setViewportView(addPanel);
		            ProductDisplayPanel.add(scroll);
		            
		            
		            ProductDisplayPanel.revalidate();
		            ProductDisplayPanel.repaint();
		            
					
		            //SearchDisplay.AddToCart.addActionListener(action);
		            //frame.add(SearchDisplay.AddToCart);
		            

		 		} catch (Exception ae){
		 			ae.printStackTrace(); 
		 		}
	 		 
	 		} catch (Exception e1) {
				
				e1.printStackTrace();
			} 		
		}		
	}
}	
	

