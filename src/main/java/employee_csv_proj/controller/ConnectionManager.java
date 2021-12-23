package employee_csv_proj.controller;

import employee_csv_proj.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import static employee_csv_proj.logging.LoggerManager.connectionManagerLogger;

public class ConnectionManager {

    public static Connection dbInitialiseConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl(), Config.dbUsername(), Config.dbPassword());
            connectionManagerLogger.log(Level.INFO, "Successfully initialised the connection to the database.");
        } catch (SQLException e) {
            connectionManagerLogger.log(Level.SEVERE, "Database could not be accessed to initialise the connection.", e);
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection dbConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl() + "/" + Config.dbName(), Config.dbUsername(), Config.dbPassword());
            connectionManagerLogger.log(Level.INFO, "Successfully connected to the database.");
        } catch (SQLException e) {
            connectionManagerLogger.log(Level.SEVERE, "Database could not be accessed to open the connection.", e);
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
            connectionManagerLogger.log(Level.INFO, "Connection to database closed.");
        } catch (SQLException e) {
            connectionManagerLogger.log(Level.SEVERE, "Database could not be accessed to close the connection.", e);
            e.printStackTrace();
        }
    }

}
