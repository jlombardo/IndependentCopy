
package independentcopy;

/**
 * A simple interface (abstraction) to be used by all derived classes that need to 
 * perform write operations. Although using an interface as a super class for
 * low-level detail classes is the preferred technique for implementing the
 * Dependency Inversion Principle, you could make this an abstract class and
 * achieve the same results. Just make sure you keep the writeln() method
 * abstract as well.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Copier.java, ScreenWriter.java and FileWriter.java for dependencies
 * @see     Driver for run instructions and info about design rules
 */
public interface Writer {
	
	// you do not need the "abstract" keyword because it is implicit
	// just implement this interface and create your own derived class implementation
	public abstract void writeln( String line );
}
