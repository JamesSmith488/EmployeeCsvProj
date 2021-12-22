package employee_csv_proj.exceptions;

public class NegativeSalaryException extends Exception{
    public NegativeSalaryException(String errorMessage) {
        super(errorMessage);
    }
}

