package employee_csv_proj.model;

import employee_csv_proj.controller.ConnectionManager;
import employee_csv_proj.controller.sql_queries.EmployeesSQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesDAO {

    public static void addListOfEmployees(ArrayList<Employee> employeeArrayList) {
        for (Employee i : employeeArrayList)
            if (i.getEmpId() != -1 || i.getSalary() != -1) {
                addEmployee(i);
            }
    }

    public static void addEmployee(Employee employee) {
        try {
            Connection connection = ConnectionManager.dbConnection();
            PreparedStatement employeePreparedStatement = connection.prepareStatement(EmployeesSQL.ADD_EMPLOYEE);

            employeePreparedStatement.setInt(1, employee.getEmpId());
            employeePreparedStatement.setString(2, employee.getNamePrefix());
            employeePreparedStatement.setString(3, employee.getFirstName());
            employeePreparedStatement.setString(4, String.valueOf(employee.getMiddleInitial()));
            employeePreparedStatement.setString(5, employee.getLastName());
            employeePreparedStatement.setString(6, String.valueOf(employee.getGender()));
            employeePreparedStatement.setString(7, employee.getEmail());
            employeePreparedStatement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
            employeePreparedStatement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
            employeePreparedStatement.setInt(10, employee.getSalary());
            employeePreparedStatement.execute();

            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            System.err.println("Problem accessing database");
            //logging here pls
            e.printStackTrace();
        }
    }

    public static void removeEmployee(Employee employee) {

        try {
            Connection connection = ConnectionManager.dbConnection();
            PreparedStatement removeEmployeeStatement = connection.prepareStatement(EmployeesSQL.REMOVE_EMPLOYEE);
            removeEmployeeStatement.setInt(1, employee.getEmpId());
            removeEmployeeStatement.execute();
            ConnectionManager.closeConnection(connection);

        } catch (SQLException e) {
            System.err.println("Problem accessing database");
            //logging here
            e.printStackTrace();
        }
    }
}
