package employee_csv_proj.model;

import employee_csv_proj.controller.ConnectionManager;
import employee_csv_proj.controller.sql_queries.DbInitialiseStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInitialiseDAO {

    public static void dbInitialise(){
        try {
            Connection connection = ConnectionManager.dbInitialiseConnection();
            PreparedStatement dbPreparedStatement = connection.prepareStatement(DbInitialiseStatement.DB_INITIALISE);
            dbPreparedStatement.execute();
            //Logger here
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEmployeesTable(){
        try {
            Connection connection = ConnectionManager.dbConnection();
            PreparedStatement dbPreparedStatement = connection.prepareStatement(DbInitialiseStatement.CREATE_EMPLOYEES_TABLE);
            dbPreparedStatement.execute();
            //Logger here
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropEmployeesTable(){
        try {
            Connection connection = ConnectionManager.dbConnection();
            PreparedStatement dbPreparedStatement = connection.prepareStatement(DbInitialiseStatement.DROP_EMPLOYEES_TABLE);
            dbPreparedStatement.execute();
            //Logger here
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
