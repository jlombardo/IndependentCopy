package independentcopy;

/**
 * A simple Factory Pattern implementation.
 * 
 * @author jlombardo
 */
public class WriterFactory {
    public static enum Writers {
        GUI, FILE
    }
    
    private static WriterFactory instance;
    
    /*
     * This is an implementation of the Singleton Design Pattern.
     * The Singleton pattern is used to make sure that one and only
     * one instance of a class can ever be created. By making the
     * constructor private, we can control instance creation and provide
     * a static method (see getInstance() below) to provide what is needed.
     */
    private WriterFactory() {
    }
    
    /**
     * Needed to get a Singleton instance. Why? Because the constructor
     * needs to be private.
     */
    public static WriterFactory getInstance() {
        if(instance == null) {
            instance = new WriterFactory();
        }
        return instance;
    }
    
    /**
     * This is the actual Factory method.
     * @param writerType - a type safe enum representing the type of
     * Writer to create.
     * @return a Writer built to spec
     */
    public Writer getWriter(Writers writerType) {
        Writer w = null;
        
        switch(writerType) {
            case GUI:
                w = new GuiWriter();
                break;
            case FILE:
                w = new FileWriter();
                break;
        }
        
        return w;
    }
}
