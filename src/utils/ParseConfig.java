
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author nikita
 */
public class ParseConfig {
    private static String FIGURE;
    private static double[] COORDS;
    private static String PATH;
    
    public ParseConfig () throws IOException {
        Properties props = new Properties();
        File fl = new File("config.txt");
        props.load(new FileInputStream(new File("config.txt")));
        
        FIGURE = props.getProperty("FIGURE", "CUBE");
        PATH = props.getProperty("PATH", "images/img.jpg");
        
        String[] parts = props.getProperty("COORDS").split(";");
        COORDS = new double[parts.length];
        for (int i = 0; i < parts.length; ++i)
	{
            COORDS[i] = Double.valueOf(parts[i]);
	}
    }
    public String getFigure() {
        return FIGURE;
    }
    public String getPath() {
        return PATH;
    }    
    public double[] getCOORDS() {
        return COORDS;
    }
}
