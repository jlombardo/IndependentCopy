
package independentcopy;

/**
 * Note that there are 4 versions of this sample, each contained in a
 * separate Git Branch: master, factory1, factory2 and factory3.
 * <P>
 * This example (master) is the same one used earlier in the semester to  
 * demonstrate the DIP pattern. It's a very flexible design but still has 
 * dependency issues. If you look at the Driver class you can see that we have 
 * rigidly defined the Reader and Writer implementations that are used. However,
 * major portions of this program do not suffer from such dependencies 
 * (the Copier class does not require changes to support 
 * various Readers and Writers -- changes that would break other
 * classes that depend on the Copier class); and it is PROTABLE
 * (you can use the Copier class in many programs without fear of 
 * problems caused by implementation-specific code, such as KeyboardReader).
 * <p>
 * INSTRUCTIONS:
 * When using KeyboardReader and ScreenWriter:
 * if you run this from Eclipse, make sure the Console view is 
 * open and the display is cleared. After running the program you may have to 
 * manually place your cursor in the console view. Now type a line of text, 
 * followed by a return character. Now type a second return character to end the
 * program. View results in console view.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class Driver {

	public static void main(String[] args) {
            
		// Uncomment this out (and comment following reader/writer)
		// to see how switching objects causes no problems with
		// Copier class because it's Polymorphic!!!
		Reader reader = new KeyboardReader();
		Writer writer = new GuiWriter();

		// Comment this out (and uncomment preceeding reader/writer)
		// to see how switching objects causes no problems with
		// Copier class because it's Polymorphic!!!
//		Reader reader = new FileReader();
//		Writer writer = new GuiWriter();
                // If using this writer, the file will be named 'datacopy.txt'
                // and will be located at the root of the drive where the app
                // is executing, and then under a directory named "Temp"
//		Writer writer = new FileWriter();                
		
		// Copy from reader to writer
		// Notice that Copier is NOT dependent on implementation of reader/writer
		// (it is not rigid, fragile or immobile)
		Copier copier = new Copier( reader, writer );
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
