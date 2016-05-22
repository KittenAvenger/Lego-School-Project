package AdminInputClient;

import java.awt.event.*;


public class openLego implements ActionListener{
	
	public void actionPerformed (ActionEvent e) {	
		if(e.getSource()==AddDelete.addLegoMenuItem){
			openLego1(AddDelete.s);
		}
	}
	
	/**
	 * @author Johan
	 * 
	 * Disposes the JFrame that is currently shown 
	 * and then shows the new selected JFrame
	 */
	public static void openLego1(String s){
		if(s.equals("Lego")){
			AddDelete.addLegoPane.dispose();
		}
		if(s.equals("Update")){

			AddDelete.updateLegoPane.dispose();
		}
		AddDelete.addLego();
	}
	
	/**
	 * @author Johan
	 * @author Emil
	 * 
	 * Disposes the JFrame that is currently shown 
	 * and then shows the new selected JFrame
	 */
	public static void openUpdate1(String s){
		if(s.equals("Lego")){
			AddDelete.addLegoPane.dispose();
		}
		if(s.equals("Update")){

			AddDelete.updateLegoPane.dispose();
		}
		AddDelete.upLego();
	}
}
