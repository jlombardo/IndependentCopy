
package independentcopy;

/**
 * A simple interface (abstraction) to be used by all derived classes that need to 
 * perform read operations. Although using an interface as a super class for
 * low-level detail classes is the preferred technique for implementing the
 * Dependency Inversion Principle, you could make this an abstract class and
 * achieve the same results. Just make sure you keep the readln() method
 * abstract as well.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.02
 * @see     Copier.java, KeyboardReader.java and FileReader.java for dependencies
 * @see     Driver for run instructions and info about design rules
 */
public interface Reader {

	// you do not need the "abstract" keyword because it is implicit
	// just implement this interface and create your own derived class implementation
	public abstract String readln();
}
