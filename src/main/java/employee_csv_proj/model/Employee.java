package employee_csv_proj.model;

import employee_csv_proj.exceptions.InvalidEmployeeIdException;
import employee_csv_proj.exceptions.NegativeSalaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

    private int         empId;
    private String      namePrefix;
    private String      firstName;
    private char        middleInitial;
    private String      lastName;
    private char        gender;
    private String      email;
    private LocalDate   dateOfBirth;
    private LocalDate   dateOfJoining;
    private int         salary;

    public Employee(String[] employeeData){
        this.setEmpId(Integer.parseInt(employeeData[0]));
        this.setNamePrefix(employeeData[1]);
        this.setFirstName(employeeData[2]);
        this.setMiddleInitial(employeeData[3].charAt(0));
        this.setLastName(employeeData[4]);
        this.setGender(employeeData[5].charAt(0));
        this.setEmail(employeeData[6]);
        this.setDateOfBirth(employeeData[7]);
        this.setDateOfJoining(employeeData[8]);
        this.setSalary(Integer.parseInt(employeeData[9]));
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        final int idLength = String.valueOf(empId).length();

        try {
            if (idLength == 6) {
                this.empId = empId;
            } else {
                throw new InvalidEmployeeIdException("Employee ID is not 6 digits");
            }
        }
        catch (InvalidEmployeeIdException e){
                e.printStackTrace();
        }
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix.replaceAll("[^A-Za-z]", "") + ".";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.replaceAll("[^A-Za-z]", "");
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.replaceAll("[^A-Za-z]", "");
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.replaceAll("[^A-Za-z0-9@.!#$%&'*+-/=?^_`{|}~]", "");
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = LocalDate.parse(dateOfJoining, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        try {
            if (salary < 0) {
                this.salary = salary;
            } else throw new NegativeSalaryException("Salary cannot be less than 0");
        }
        catch (NegativeSalaryException e){
            e.printStackTrace();
        }
    }
}
