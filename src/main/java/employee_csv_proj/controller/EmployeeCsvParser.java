package employee_csv_proj.controller;

import employee_csv_proj.config.Config;
import employee_csv_proj.model.Employee;
import employee_csv_proj.model.EmployeesDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

import static employee_csv_proj.logging.SystemLogger.logger;

public class EmployeeCsvParser {

    public static void createEmployeeData(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Config.employeeCSVFileLocation()));
            bufferedReader.readLine();
            for (String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine()){
                String[] employeeData = employeeRecord.split(",");
                Employee employee = new Employee(employeeData);
                //testing employee
                //EmployeeDAO.addEmployee(employee);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem parsing employee data from CSV file", e);
            e.printStackTrace();
        }
    }

}
