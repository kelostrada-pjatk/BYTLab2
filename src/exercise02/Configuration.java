package exercise02;

import java.util.*;
import java.util.function.*;

/**
 * Changes:
 * 
 * - 
 * 
 * @author kelu
 */
public class Configuration {

    public int interval;

    public int duration;

    public int departure;
    
    private int loadProperty(String propertyName, Properties props) throws ConfigurationException {
        String valueString = props.getProperty(propertyName);
        if (valueString == null) {
            throw new ConfigurationException("monitor " + propertyName);
        }
        int value = Integer.parseInt(valueString);
        if (value <= 0) {
            throw new ConfigurationException("monitor " + propertyName + " > 0");
        }
        return value;
    }
    
    private int loadProperty(String propertyName, Properties props, Predicate<Integer> tester, String testInfo) throws ConfigurationException {
        int prop = loadProperty(propertyName, props);
        if (!tester.test(prop)) {
            throw new ConfigurationException("monitor " + propertyName + " did not pass the test: " + testInfo);
        }
        return prop;
    }

    public void load(Properties props) throws ConfigurationException {
        interval = loadProperty("interval", props);
        duration = loadProperty("duration", props, d -> d % interval == 0, "% interval");
        departure = loadProperty("departure", props, d -> d % interval == 0, "% interval");
    }
}
