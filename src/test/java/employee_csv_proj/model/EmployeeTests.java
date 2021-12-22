package employee_csv_proj.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EmployeeTests {

    Employee goodEmployee = new Employee(new String[]{"177013", "Mr.", "Joe", "M", "Bloggs", "M", "JoeBloggs@example.com", "5/13/1985", "10/28/2015", "1000000"});
    Employee badEmployee = new Employee(new String[]{"100000","M~s[.].","Ja%n*e","Z","D\"o'e","F","J]ane(Doe@exa)mp[le.com","5/13/1985","10/28/2015","100"});

    @Test
    @DisplayName("Employee ID is 177013 test")
    void employeeIdIs177013Test() {
        Assertions.assertEquals(177013, goodEmployee.getEmpId());
    }

    @Test
    @DisplayName("Name prefix is Mr. test")
    void namePrefixIsMrTest() {
        Assertions.assertEquals("Mr.", goodEmployee.getNamePrefix());
    }

    @Test
    @DisplayName("First name is Joe test")
    void firstNameIsJoeTest() {
        Assertions.assertEquals("Joe", goodEmployee.getFirstName());
    }

    @Test
    @DisplayName("Middle initial is M test")
    void middleInitialIsMTest() {
        Assertions.assertEquals('M', goodEmployee.getMiddleInitial());
    }

    @Test
    @DisplayName("Last name is Bloggs test")
    void lastNameIsBloggsTest() {
        Assertions.assertEquals("Bloggs", goodEmployee.getLastName());
    }

    @Test
    @DisplayName("Gender is M test")
    void genderIsMTest() {
        Assertions.assertEquals('M', goodEmployee.getGender());
    }

    @Test
    @DisplayName("Email is JoeBloggs@example.com test")
    void emailIsJoeBloggsExampleComTest() {
        Assertions.assertEquals("JoeBloggs@example.com", goodEmployee.getEmail());
    }

    @Test
    @DisplayName("Date of Birth is 1985/13/5 test")
    void dateOfBirthIs1985135Test() {
        Assertions.assertEquals(LocalDate.of(1985,5,13), goodEmployee.getDateOfBirth());
    }

    @Test
    @DisplayName("Date of Joining is 2015/10/28 test")
    void dateOfJoiningIs20151028Test() {
        Assertions.assertEquals(LocalDate.of(2015,10,28), goodEmployee.getDateOfJoining());
    }

    @Test
    @DisplayName("Salary is 1000000 test")
    void salaryIs1000000Test() {
        Assertions.assertEquals(1000000, goodEmployee.getSalary());
    }

    @Test
    @DisplayName("Employee ID is invalid test")
    void employeeIdIsInvalidTest() {
        badEmployee.setEmpId(1);
        Assertions.assertEquals(-1, badEmployee.getEmpId());
    }

    @Test
    @DisplayName("Name prefix cleaning test")
    void namePrefixCleaningTest() {
        Assertions.assertEquals("Ms.", badEmployee.getNamePrefix());
    }

    @Test
    @DisplayName("First name cleaning test")
    void firstNameCleaningTest() {
        Assertions.assertEquals("Jane", badEmployee.getFirstName());
    }

    @Test
    @DisplayName("Last name cleaning test")
    void lastNameCleaningTest() {
        Assertions.assertEquals("Doe", badEmployee.getLastName());
    }

    @Test
    @DisplayName("Email cleaning test")
    void emailCleaningTest() {
        Assertions.assertEquals("JaneDoe@example.com", badEmployee.getEmail());
    }

    @Test
    @DisplayName("Salary is invalid test")
    void salaryIsInvalidTest() {
        badEmployee.setSalary(-100);
        Assertions.assertEquals(-1, badEmployee.getSalary());
    }

}
