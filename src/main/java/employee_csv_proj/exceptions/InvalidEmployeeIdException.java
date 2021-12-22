package employee_csv_proj.exceptions;

public class InvalidEmployeeIdException extends Exception{
    public InvalidEmployeeIdException(String errorMessage) {
        super(errorMessage);
    }
}
