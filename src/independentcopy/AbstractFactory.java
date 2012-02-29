package independentcopy;

/**
 * This AbstractFactory decouples the actual factories from the client
 * class, which in this case is the Driver class. This gives us the 
 * flexibility to change our factory classes as well as the reader and 
 * writer classes without breaking the client code.
 * 
 * @author jlombardo
 */
public abstract class AbstractFactory {
    // Enums Moved to here for easy, centralized access
    
    public static enum Readers {
        KEYBOARD, FILE
    }
    
    public static enum Writers {
        GUI, FILE
    }
   
    public static Reader getReaderInstance(Readers readerType) {
        Reader r = ReaderFactory.getInstance().getReader(readerType);
        return r;
    }

    public static Writer getWriterInstance(Writers writerType) {
        Writer w = WriterFactory.getInstance().getWriter(writerType);
        return w;
    }

}
