package employee_csv_proj.controller;

import employee_csv_proj.config.Config;
import employee_csv_proj.model.Employee;
import employee_csv_proj.model.EmployeesDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import static employee_csv_proj.logging.SystemLogger.logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;


public class EmployeeCsvParser {

    private static final ArrayList<Employee> employeesArrayList = new ArrayList<>();

    public static void createEmployeeData(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Config.employeeCSVFileLocation()));
            bufferedReader.readLine();
            for (String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine()){
                String[] employeeData = employeeRecord.split(",");
                Employee employee = new Employee(employeeData);

                employeesArrayList.add(employee);
                //if (EmployeeCsvChecker.check(employeeData, employee)){employeesArrayList.add(employee);}
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Problem parsing employee data from CSV file", e);
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> getEmployeesArrayList() {
        return employeesArrayList;
    }

    public static class EmployeeCsvChecker {
      
        public static void duplicateRemover(ArrayList<Employee> arrayList){
            LinkedHashSet<Integer> idHashSet = new LinkedHashSet<>();
            for (Employee employee : arrayList) idHashSet.add(employee.getEmpId());

            ArrayList<Integer> idArrayList = new ArrayList<>(idHashSet);

            for (int i = 0; i < arrayList.size(); i++){
                if (arrayList.get(i).getEmpId() != idArrayList.get(i)) {
                    // log duplicate employee
                    System.out.println("Duplicate found: " + arrayList.get(i).toString());
                    arrayList.remove(i);
                    i--;
                }
            }
        }
      
    }
  
}
