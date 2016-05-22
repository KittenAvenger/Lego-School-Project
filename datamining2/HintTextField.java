package datamining2;

import java.awt.event.*;

import javax.swing.JTextField;
/**
 * @author Johan Hermansson based on http://stackoverflow.com/questions/1738966/java-jtextfield-with-input-hint
 * Make different hint-textfields
 */
@SuppressWarnings("serial")
public class HintTextField extends JTextField implements FocusListener {

	  private final String hint;
	  private final String input;
	  private boolean showingHint;


	 /**
	 * @author Johan
	 * create a hint-textfield with given hint and make set the text to the given input and if u take
	 * that away it shows the hint.
	 */
	public HintTextField(final String hint, final String input) {
		    super(hint);
		    this.input = input;
		    this.hint = hint;
//		    if (!input.equals(null) || !input.equals("")){
		    this.showingHint = false;
		    this.setText(this.input);
//		    }
//		    else{
//		    	this.setText(this.hint);
//		    	this.showingHint = true;
////		    	this.setText(this.hint);
//		    	
//		    }
		    super.addFocusListener(this);
		  }
	  @Override
	  public void focusGained(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showingHint = false;
	    }
	  }
	  @Override
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
