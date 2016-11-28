
package independentcopy;

/**
 * This example is the final example of using the DIP pattern in combination
 * with the Factory Pattern. In this example (branch factory4) the 
 * factory that creates the reader and writer is encapsulated in the Copier
 * class.
 * <P>
 * The advantage of this version over all previous ones is that all class
 * dependencies are hidden from this class, whilst still providing the 
 * flexibility of using different readers and writers. This also adheres to
 * the Principle of Least Knowledge. Why do we need to know about the
 * reader and writer, or the factory here? We don't.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class Driver {

	public static void main(String[] args) {
		// Notice that Copier gets its reader and writer on its own
		Copier copier = new Copier();
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
