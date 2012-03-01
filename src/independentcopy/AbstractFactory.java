package independentcopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This AbstractFactory decouples the actual factories from the client class,
 * which in this case is the Driver class. This gives us the flexibility to
 * change our factory classes as well as the reader and writer classes without
 * breaking the client code.
 *
 * @author jlombardo
 */
public abstract class AbstractFactory {

    public static Reader getReaderInstance() {
        Reader r = null;

        // First read config setting in properties file
        File file = new File("c:/temp/config.properties");
        Properties props = new Properties();
        FileInputStream inFile;
        try {
            inFile = new FileInputStream(file);
            props.load(inFile);
            inFile.close();
        
            // Next use Java reflection to create instance
            String className = props.getProperty("reader");
            Class clazz = Class.forName(className);
            r = (Reader)clazz.newInstance();
            
        } catch (Exception ex) {
            System.out.println("ERROR: you must place a copy of the\n "
                    + "config.properties file in the 'c:/temp' directory of "
                    + "your computer's main hard drive.");
        }
        
        return r;
    }

    public static Writer getWriterInstance() {
        Writer w = null;

        // First read config setting in properties file
        Properties props = new Properties();
        FileInputStream inFile;
        try {
            inFile = new FileInputStream("c:/temp/config.properties");
            props.load(inFile);
            inFile.close();
        
            // Next use Java reflection to create instance
            String className = props.getProperty("writer");
            Class clazz = Class.forName(className);
            w = (Writer)clazz.newInstance();
            
        } catch (Exception ex) {
            Logger.getLogger(AbstractFactory.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return w;
    }
}
