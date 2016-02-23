
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

    private float[] projectorCoords;
    private String PATH;
    private float[] vector1Coords;
    private float[] vector2Coords;
    public ParseConfig (File configFile) throws IOException {
        Properties props = new Properties();
        //File fl = new File("config.txt");
       
        props.load(new FileInputStream(configFile));
        

        PATH = props.getProperty("PATH", "images/img.jpg");
         
        String[] parts = props.getProperty("ProjectorCoords").split(";");
        projectorCoords = new float[parts.length];
        for (int i = 0; i < parts.length; ++i)
	{
            projectorCoords[i] = Float.valueOf(parts[i]);
	}
       
        parts = props.getProperty("Vector1Coords").split(";");
        vector1Coords = new float[parts.length];
        for (int i = 0; i < parts.length; ++i)
	{
            vector1Coords[i] = Float.valueOf(parts[i]);
	}

        parts = props.getProperty("Vector2Coords").split(";");
        vector2Coords = new float[parts.length];
        for (int i = 0; i < parts.length; ++i)
	{
            vector2Coords[i] = Float.valueOf(parts[i]);
	}
    }
    public String getPath() {
        return PATH;
    }    
    public float[] getCOORDS() {
        return projectorCoords;
    }
    public float[] getVector1Coords() {
        return vector1Coords;
    }
    public float[] getVector2Coords() {
        return vector2Coords;
    }
    
}
