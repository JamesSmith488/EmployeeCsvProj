package employee_csv_proj.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EmployeeTests {

    @Test
    @DisplayName("Employee ID is 1 test")
    void employeeIdIs1Test() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals(177013, employee.getEmpId());
    }

    @Test
    @DisplayName("Name prefix is Mr. test")
    void namePrefixIsMrTest() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals("Mr.", employee.getNamePrefix());
    }

    @Test
    @DisplayName("First name is Joe test")
    void firstNameIsJoeTest() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals("Joe", employee.getFirstName());
    }

    @Test
    @DisplayName("Middle initial is M test")
    void middleInitialIsMTest() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals('M', employee.getMiddleInitial());
    }

    @Test
    @DisplayName("Last name is Bloggs test")
    void lastNameIsBloggsTest() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals("Bloggs", employee.getLastName());
    }

    @Test
    @DisplayName("Gender is M test")
    void genderIsMTest() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals('M', employee.getGender());
    }

    @Test
    @DisplayName("Email is JoeBloggs@example.com test")
    void emailIsJoeBloggsExampleComTest() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals("JoeBloggs@example.com", employee.getEmail());
    }

    @Test
    @DisplayName("Date of Birth is 1985/13/5 test")
    void dateOfBirthIs1985135Test() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals(LocalDate.of(1985,5,13), employee.getDateOfBirth());
    }

    @Test
    @DisplayName("Date of Joining is 2015/10/28 test")
    void dateOfJoiningIs20151028Test() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals(LocalDate.of(2015,10,28), employee.getDateOfJoining());
    }

    @Test
    @DisplayName("Salary is 1000000 test")
    void salaryIs1000000Test() {
        Employee employee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
        Assertions.assertEquals(1000000, employee.getSalary());
    }

}
