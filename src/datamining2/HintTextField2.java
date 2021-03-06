package datamining2;

import java.awt.event.*;

import javax.swing.JTextField;
/**
 * @author Johan Hermansson based on http://stackoverflow.com/questions/1738966/java-jtextfield-with-input-hint
 * Unused code to create hint-textfields.
 */
@SuppressWarnings("serial")
public class HintTextField2 extends JTextField implements FocusListener {

	  private final String hint;
	  private boolean showingHint;

	  public HintTextField2(final String hint) {
	    super(hint);
	    this.hint = hint;
	    this.showingHint = true;
	    super.addFocusListener(this);
	  }

	  public void focusGained(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showingHint = false;
	    }
	  }
	  public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText(hint);
	      showingHint = true;
	    }
	  }

	  @Override
	  public String getText() {
	    return showingHint ? "" : super.getText();
	  }

	  
	  
	}