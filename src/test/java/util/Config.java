package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class Config
{
    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static Properties properties;
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    public static void initialize()
    {
        // Load default properties
        properties=loadProperties();

        // Check if user passed any properties using command line, then override that property
        for (String key:properties.stringPropertyNames())
        {
            if(System.getProperties().containsKey(key) && !System.getProperty(key).equalsIgnoreCase(properties.getProperty(key)))
            {
                log.info("Agrument {} passed from command line: {}",key,System.getProperty(key));
                log.info("Default Agrument {} defined in code: {}",key,properties.getProperty(key));
                properties.setProperty(key,System.getProperty(key));
            }
        }

    }
    private static Properties loadProperties()
    {
        Properties properties=new Properties();
        try {
            InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES);
            properties.load(stream);
        }catch (Exception e)
        {
            log.error(e.getMessage());
        }
        return properties;
    }

    public static String get(String key)
    {
        log.info("Property from config: {}",properties.getProperty(key));
        return properties.getProperty(key);
    }
}
