package employee_csv_proj.logging;

import java.io.IOException;
import java.util.logging.*;

public class SystemLogger {
    public static Logger logger = Logger.getLogger("logger");

    public static void initialiseLogger(String loggerName) {
        try {
            Handler fileHandler = new FileHandler("src/main/logs/" + loggerName + ".log", true);
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            logger.log(Level.SEVERE,"File logger not working.");
            e.printStackTrace();
        }
    }
}
