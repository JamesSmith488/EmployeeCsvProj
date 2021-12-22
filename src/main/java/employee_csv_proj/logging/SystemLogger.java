package employee_csv_proj.logging;

import java.util.logging.*;

public class SystemLogger {
    public static Logger logger = Logger.getLogger("logger");

    //format logger

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logSevere(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void logConfig(String message) {
        logger.log(Level.CONFIG, message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }
}
