package AdminInputClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Johan
 * 
 * Pops-up an JOptionPane when the JMenubarItem is clicked
 * to either delete or update a product
 */
public class openDelete implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		if(e.getSource()==AddDelete.deleteLegoMenuItem){
			AddDelete.deleteLego();
		}
		if(e.getSource()==AddDelete.updateLegoMenuItem){
			openLego.openUpdate1(AddDelete.s);
		}
	}
}
