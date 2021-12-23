package employee_csv_proj.model;

import employee_csv_proj.controller.ConnectionManager;
import employee_csv_proj.controller.sql_queries.DbInitialiseStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import static employee_csv_proj.logging.LoggerManager.dbInitialiserDaoLogger;

public class DbInitialiseDAO {

    public static void dbInitialise(){
        try {
            Connection connection = ConnectionManager.dbInitialiseConnection();
            PreparedStatement dbPreparedStatement = connection.prepareStatement(DbInitialiseStatement.DB_INITIALISE);
            dbPreparedStatement.execute();
            dbInitialiserDaoLogger.log(Level.INFO, "Successfully added database");
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            dbInitialiserDaoLogger.log(Level.SEVERE, "Problem accessing database creating database", e);
            e.printStackTrace();
        }
    }

    public static void createEmployeesTable(){
        try {
            Connection connection = ConnectionManager.dbConnection();
            PreparedStatement dbPreparedStatement = connection.prepareStatement(DbInitialiseStatement.CREATE_EMPLOYEES_TABLE);
            dbPreparedStatement.execute();
            dbInitialiserDaoLogger.log(Level.INFO, "Successfully added table to database");
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            dbInitialiserDaoLogger.log(Level.SEVERE, "Problem accessing database creating table", e);
            e.printStackTrace();
        }
    }

    public static void dropEmployeesTable(){
        try {
            Connection connection = ConnectionManager.dbConnection();
            PreparedStatement dbPreparedStatement = connection.prepareStatement(DbInitialiseStatement.DROP_EMPLOYEES_TABLE);
            dbPreparedStatement.execute();
            dbInitialiserDaoLogger.log(Level.INFO, "Successfully dropped table from database");
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            dbInitialiserDaoLogger.log(Level.SEVERE, "Problem accessing database dropping table", e);
            e.printStackTrace();
        }
    }

}
