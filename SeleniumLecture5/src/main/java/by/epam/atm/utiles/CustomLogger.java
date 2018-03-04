package by.epam.atm.utiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {


    private static Logger logger = LogManager.getLogger(CustomLogger.class);

    public static void info (String message){
        logger.info(message);
    }

    public static void  error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public static void  errorMessage(String message) {
        logger.error(message);
    }

    public static void debug (String message){
        logger.debug(message);
    }

    public static void attach(String filePath, String message) {
        logger.info("RP_MESSAGE#FILE#{}#{}", filePath, message);
    }
}

