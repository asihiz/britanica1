package util.properties;

/**
 * @implements PropertyHandlerService
 * Properties Handler Impl.
 * Implements property service.
 * Manages all property files parsing
 * Strongly immutable object
 * Single tone object
 *
 *
 * @author asih
 */

import util.general_util.GeneralUtils;

import java.io.*;
import java.util.Properties;

/**
 * @author Asaf
 *
 */

public class PropertiesHandlerImpl
{

    private static final PropertiesHandlerImpl INSTANCE = new PropertiesHandlerImpl();

    private static Properties props = new Properties();

    private PropertiesHandlerImpl(){
        if(INSTANCE != null){
            return;
        }
    }

    public static PropertiesHandlerImpl getInstance() {
        return INSTANCE;
    }

    public synchronized final Properties parseFromFile(String propFilePath)  {
        File file = new File(propFilePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            props.load(fileInput);
        } catch (IOException ioe){
            GeneralUtils.reportError("Error reading property file", ioe);
             throw new RuntimeException(ioe);
        }
        printProperties(props);
        return props;
    }

    public void printProperties(Properties prop) {
        prop.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    }

    public static Properties getPropData()
    {
        return props;
    }

    public static void setProps(Properties _props) {
        props = _props;
    }



}
