package employee_csv_proj.logging;

import java.io.IOException;
import java.util.logging.*;

public class LoggerManager {

    public static Logger systemLogger = Logger.getLogger("systemLogger");
    public static Logger configLogger = Logger.getLogger("configLogger");
    public static Logger dbInitialiserDaoLogger = Logger.getLogger("dbInitialiserDaoLogger");
    public static Logger employeesDaoLogger = Logger.getLogger("employeesDaoLogger");
    public static Logger connectionManagerLogger = Logger.getLogger("connectionManagerLogger");
    public static Logger employeeCsvParserLogger = Logger.getLogger("employeeCsvParserLogger");
    public static Logger duplicatesLogger = Logger.getLogger("duplicatesLogger");

    public static void initialiseLoggers() {
        initialiseSystemLogger();
        initialiseConfigLogger();
        initialiseDbInitialiserDaoLogger();
        initialiseEmployeesDaoLogger();
        initialiseConnectionManagerLogger();
        initialiseEmployeeCsvParserLogger();
        initialiseDuplicatesLogger();
    }

    private static void initialiseSystemLogger() {
        initialiseLogger(systemLogger, Level.ALL);
    }

    private static void initialiseConfigLogger() {
        initialiseLogger(configLogger, Level.ALL);
    }

    private static void initialiseDbInitialiserDaoLogger() {
        initialiseLogger(dbInitialiserDaoLogger, Level.ALL);
    }

    private static void initialiseEmployeesDaoLogger() {
        initialiseLogger(employeesDaoLogger, Level.ALL);
    }

    private static void initialiseConnectionManagerLogger() {
        initialiseLogger(connectionManagerLogger, Level.ALL);
    }

    private static void initialiseEmployeeCsvParserLogger() {
        initialiseLogger(employeeCsvParserLogger, Level.ALL);
    }

    private static void initialiseDuplicatesLogger() {
        initialiseLogger(duplicatesLogger, Level.ALL);
    }

    private static void initialiseLogger(Logger loggerName, Level logLevel) {
        try {
            Handler fileHandler = new FileHandler("src/main/logs/" + loggerName.getName() + ".log", true);
            fileHandler.setLevel(logLevel);
            loggerName.addHandler(fileHandler);
            loggerName.setUseParentHandlers(false);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
