package employee_csv_proj.controller.sql_queries;

import employee_csv_proj.config.Config;

/**
 *
 */
public interface DbInitialiseStatement {
    String DB_INITIALISE = "CREATE DATABASE IF NOT EXISTS " + Config.dbName();
    String CREATE_EMPLOYEES_TABLE = "CREATE TABLE IF NOT EXISTS employees (" +
            "TableID INTEGER," +
            "EmployeeID INTEGER," +
            "NamePrefix VARCHAR(10)," +
            "FirstName VARCHAR(20)," +
            "MiddleInitial CHAR(1)," +
            "LastName VARCHAR(20)," +
            "Gender CHAR(1)," +
            "Email VARCHAR(50)," +
            "DateOfBirth DATE," +
            "DateOfJoining DATE," +
            "Salary INTEGER)";
}
