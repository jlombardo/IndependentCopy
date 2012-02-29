
package independentcopy;

import javax.swing.JOptionPane;

/**
 * A simple class that demonstrates a capability to write a line of 
 * text to a GUI Window. Notice this class is derived from the 
 * interface <code>Writer</code>, which is an abstraction of these details.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class GuiWriter implements Writer {
	
	/**
	 * Write a line of text to a GUI Window.
	 * 
	 * @param line - a String representing one line of text.
	 * @see Writer#writeln()
	 */
	public void writeln( String line ) {
            JOptionPane.showMessageDialog(null, line);
	}
}
