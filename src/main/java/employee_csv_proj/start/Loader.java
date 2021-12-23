package employee_csv_proj.start;

import employee_csv_proj.controller.EmployeeCsvParser;
import static employee_csv_proj.controller.EmployeeCsvParser.createEmployeeData;
import static employee_csv_proj.controller.EmployeeCsvParser.getEmployeesArrayList;
import static employee_csv_proj.logging.LoggerManager.initialiseLoggers;
import static employee_csv_proj.model.DbInitialiseDAO.createEmployeesTable;
import static employee_csv_proj.model.DbInitialiseDAO.dbInitialise;
import static employee_csv_proj.model.EmployeesDAO.addListOfEmployees;

public class Loader {

    public static void start() {
        //Initialises the loggers to be used throughout the program
        initialiseLoggers();
        // Uses prepared statements to connect to localhost and create SQL database called csv_project and a table called "employees"
        dbInitialise();
        createEmployeesTable();
        // Read csv - in doing so, setters within Employee class clean and format data correctly.
        createEmployeeData();
        // Remove duplicates and log to a file. Arraylist is now cleaned
        EmployeeCsvParser.EmployeeCsvChecker.duplicateRemover(getEmployeesArrayList());
        // Adds ArrayList of employee objects to employees table in SQL database
        addListOfEmployees(getEmployeesArrayList());
    }

}
