
package independentcopy;

/**
 * This example is the final example of using the DIP pattern in combination
 * with the Factory Pattern. In this example (branch factory3) the 
 * specifications for building Reader and Writer objects are stored in an
 * external file (config.properties). Please make sure this file exists in
 * a folder named 'temp' which should be located at the root of the drive
 * where this application is running.
 * <P>
 * The advantage of this version over all previous ones is that the class
 * dependencies for Reader and Writer objects have been totally externalized
 * so that changes to not require editing any source code. However, we are
 * now dependent on those external files. That's still better though because
 * now changes can be made without recompiling any code.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class Driver {

	public static void main(String[] args) {
            
		Reader reader = ExternalSpecFactory.getReaderInstance();
                
		Writer writer = ExternalSpecFactory.getWriterInstance();
		
		// Copy from reader to writer
		// Notice that Copier is NOT dependent on implementation of reader/writer
		// (it is not rigid, fragile or immobile)
		Copier copier = new Copier( reader, writer );
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
