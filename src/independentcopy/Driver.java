
package independentcopy;

/**
 * This example is another approach to using DIP and the Factory Pattern. It's
 * a minor improvement over branch 'factory1'. In this example (branch factory2)
 * we use an AbstractFactory class that has static methods for retrieving 
 * Reader and Writer factory objects based on some type of flag that is
 * passed in. This has the advantage of making it possible to add or remove 
 * factory objects without breaking any other code.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class Driver {

	public static void main(String[] args) {
            
		Reader reader = AbstractFactory
                        .getReaderInstance(AbstractFactory.Readers.KEYBOARD);
                
		Writer writer = AbstractFactory
                        .getWriterInstance(AbstractFactory.Writers.GUI);
		
		// Copy from reader to writer
		// Notice that Copier is NOT dependent on implementation of reader/writer
		// (it is not rigid, fragile or immobile)
		Copier copier = new Copier( reader, writer );
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
