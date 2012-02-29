
package independentcopy;

/**
 * A simple class that demonstrates a capability to write a line of 
 * text to the console. Notice this class is derived from the 
 * interface <code>Writer</code>, which is an abstraction of these details.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class ConsoleWriter implements Writer {
	
	/**
	 * Write a line of text to the console.
	 * 
	 * @param line - a String representing one line of text.
	 * @see Writer#writeln()
	 */
	public void writeln( String line ) {
            System.out.println("Here is the text you entered, which I've copied below.");
            System.out.println( line );
	}
}
