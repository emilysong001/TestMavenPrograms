package Log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp {
    private static final Logger logger = Logger.getLogger(MyApp.class);

    public static void main(String[] args) {
        // Configure log4j using a properties file
        PropertyConfigurator.configure("log4j.properties");

        // Log some messages
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }
}
