package employee_csv_proj.controller;

import employee_csv_proj.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection dbInitialiseConnection(){
        Connection connection = null;
        try {
        connection = DriverManager.getConnection(Config.dbConnectionUrl(), Config.dbUsername(), Config.dbPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection dbConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl() + "/" + Config.dbName(), Config.dbUsername(), Config.dbPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
            //logging here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
