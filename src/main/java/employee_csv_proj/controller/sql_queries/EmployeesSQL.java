package employee_csv_proj.controller.sql_queries;

/**
 *
 */
public interface EmployeesSQL {
    String ADD_EMPLOYEE = "INSERT INTO employees (" +
            "TableID," +
            "EmployeeID," +
            "NamePrefix," +
            "FirstName," +
            "MiddleInitial," +
            "LastName," +
            "Gender," +
            "Email," +
            "DateOfBirth," +
            "DateOfJoining," +
            "Salary) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String GET_ALL_EMPLOYEES = "SELECT * FROM employees";
    // example
    String GET_AVG_SALARY = "SELECT AVG(Salary) FROM employees";
}
