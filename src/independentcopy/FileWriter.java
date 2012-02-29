
package independentcopy;

import java.io.*;

/**
 * A simple low-level, derived class that demonstrates the capability to 
 * write a line of input to a file. Notice this class is derived from the 
 * interface <code>Reader</code>, which is an abstraction of these details.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Driver for run instructions and info about design rules
 * @see     DependentCopy project for a poor design
 */
public class FileWriter implements Writer {

	/**
	 * Write a line of input to a file "c:\temp\datacopy.txt"
	 * 
	 * @see Writer#writeln()
	 */
	public void writeln(String line) {
		boolean append = false;
		File data = new File(File.separatorChar + "Temp" + 
			  File.separatorChar + "datacopy.txt");
		PrintWriter out = null;
			  
		// This is where we setup our streams (append = false means overwrite)
		// new java.io.FileWriter() creates the file if doesn't exit
		try {
			// make sure we differentiate between java.io.FileWriter
			// class and this custom FileWriter class
			out = new PrintWriter(
						new BufferedWriter(
						new java.io.FileWriter(data, append) ) );
			out.println(line);
			out.close();
			
		} catch (IOException ioe) {
			if(out != null) out.close();
			System.out.println( ioe.getMessage() );
			System.exit(1);  // 1 = signals program end with error
		}

	}

}
