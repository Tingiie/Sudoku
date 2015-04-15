package sudoku;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;

public class OneDigitField extends JTextField {

	/**
	 * Creates a text field to display only one digit.
	 */
	public OneDigitField() {
		super("");
		((AbstractDocument) this.getDocument()).setDocumentFilter(new OneDigitFilter());
	}

	private class OneDigitFilter extends DocumentFilter {	   	   
		OneDigitFilter() {	    
			super();	    
		} 	   

		public void insertString(FilterBypass fb, int offset, String  str, AttributeSet attr) throws BadLocationException {	    
			if ((fb.getDocument().getLength() + str.length()) > 1) {
				return;
			}
			if (! str.isEmpty() && ! Character.isDigit(str.charAt(0))) {
				return;
			}
			super.insertString(fb, offset, str, attr);	         
		}
		
		public void replace(FilterBypass fb, int offset, int length, String  str, AttributeSet attr) throws BadLocationException {	    
			if ((fb.getDocument().getLength() + str.length() - length) > 1) {
				return;
			}
			if (! str.isEmpty() && ! Character.isDigit(str.charAt(0))) {
				return;
			}
			super.replace(fb, offset, length, str, attr);	         
		}
	}
}
