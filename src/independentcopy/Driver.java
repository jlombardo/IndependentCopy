
package independentcopy;

/**
 * This example demonstrates a good design -- one that has NO
 * dependency issues. It is not RIGID (Copier can be used with 
 * an unlimited number of Reader and Writer objects); it is not 
 * FRAGILE (the Copier class does not require changes to support 
 * various Readers and Writers -- changes that would break other
 * classes that depend on the Copier class); and it is PROTABLE
 * (you can use the Copier class in many programs without fear of 
 * problems caused by implementation-specific code, such as KeyboardReader).
 * <p>
 * Notice that the high-level Copier class (also called the client, 
 * because it uses the services of other objects) is not dependent on 
 * any low-level classes. Instead, it is only dependent upon abstractions 
 * (interfaces, although we could just as easily use abstract classes), 
 * following the Dependency Inversion Principle and the Liskov Substitution 
 * Principle.
 * <p>
 * Design Success #1 -- adheres to Dependency Inversion Principle, which
 * states that 1) High-level modules should not depend upon low level
 * modules. Both should depend upon abstractions; and, 2) Abstractions
 * should not depend upon details. Details should depend upon abstractions.
 * <p>
 * Design Success #2 -- adheres to Liskov Substitution Principle, which 
 * tells us that derived classes (e.g., KeyboardReader, FileReader) must 
 * be usable through their base class interfaces (Reader and Writer), without 
 * the client (in this case, Copier) being able to tell the difference.
 * <p>
 * INSTRUCTIONS:
 * When using KeyboardReader and ScreenWriter:
 * if you run this from Eclipse, make sure the Console view is 
 * open and the display is cleared. After running the program you may have to 
 * manually place your cursor in the console view. Now type a line of text, 
 * followed by a return character. Now type a second return character to end the
 * program. View results in console view.
 * <p>
 * When using FileReader and FileWriter, make sure you have a plain text file 
 * (use Notepad to create one) named "data.txt" and containing one line of text. 
 * Store this file in c:\temp. Now run the program. Go back to c:\temp and notice 
 * that the program has created "datacopy.txt" which contains a copy of the line 
 * of text in "data.txt".
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class Driver {

	public static void main(String[] args) {
            
		Reader reader = AbstractFactory.getReaderInstance();
                
		Writer writer = AbstractFactory.getWriterInstance();
		
		// Copy from reader to writer
		// Notice that Copier is NOT dependent on implementation of reader/writer
		// (it is not rigid, fragile or immobile)
		Copier copier = new Copier( reader, writer );
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
