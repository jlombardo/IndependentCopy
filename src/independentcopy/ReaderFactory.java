package independentcopy;

/**
 * A simple Factory Pattern implementation.
 * 
 * @author jlombardo
 */
public class ReaderFactory extends AbstractFactory {
    
    private static ReaderFactory instance;
    
    /*
     * This is an implementation of the Singleton Design Pattern.
     * The Singleton pattern is used to make sure that one and only
     * one instance of a class can ever be created. By making the
     * constructor private, we can control instance creation and provide
     * a static method (see getInstance() below) to provide what is needed.
     */
    private ReaderFactory() {
    }
    
    /**
     * Needed to get a Singleton instance. Why? Because the constructor
     * needs to be private.
     */
    public static ReaderFactory getInstance() {
         if(instance == null) {
            instance = new ReaderFactory();
         }
         return instance;
    }
    
    /**
     * This is the actual Factory method.
     * @param readerType - a type safe enum representing the type of
     * Reader to create.
     * @return a Reader built to spec
     */
    public Reader getReader(AbstractFactory.Readers readerType) {
        Reader r = null;
        
        switch(readerType) {
            case KEYBOARD:
                r = new KeyboardReader();
                break;
            case FILE:
                r = new FileReader();
                break;
        }
        
        return r;
    }
}
