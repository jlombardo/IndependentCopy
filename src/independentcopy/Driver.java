
package independentcopy;

/**
 * This example is a modification of the original version that uses a
 * concrete Factory object to create the Reader and Writer objects needed
 * by the Driver class. Notice that the DIP pattern is still the predominant
 * design pattern being used, but we have moved the dependency on the
 * concrete implementations of Reader and Writer to the individual factory
 * classes. This application of the Factory Pattern has the advantage of 
 * providing portable factory classes that can build any type of Reader or
 * Writer object needed. The rest of the program is oblivious to which Reader
 * or Writer is actually being delivered. Only the factory classes will ever
 * need editing. And even this remaining dependency can be removed, which we'll
 * show you in the factory3 branch.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class Driver {

	public static void main(String[] args) {
            // This is how newbies do it.
//                ReaderFactory readerFactory = ReaderFactory.getInstance();
//                Reader reader = readerFactory.getReader(ReaderFactory.Readers.KEYBOARD);
            
            // This is an advanced technique that does the same thing.
		Reader reader = ReaderFactory
                        .getInstance()
                        .getReader(ReaderFactory.Readers.KEYBOARD);
                
		Writer writer = WriterFactory
                        .getInstance()
                        .getWriter(WriterFactory.Writers.GUI);
		
		// Copy from reader to writer
		// Notice that Copier is NOT dependent on implementation of reader/writer
		// (it is not rigid, fragile or immobile)
		Copier copier = new Copier( reader, writer );
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
