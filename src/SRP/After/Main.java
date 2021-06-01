package SRP.After;

import SRP.After.logging.ConsoleLogger;
import SRP.After.persistence.EmployeeReposiory;
import SRP.After.persistence.EmployeeSerializer;
import SRP.After.domain.Employee;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        EmployeeSerializer employeeSerializer = new EmployeeSerializer();
        EmployeeReposiory employeeReposiory = new EmployeeReposiory(employeeSerializer);
        ConsoleLogger consoleLogger = new ConsoleLogger();

        Employee employee = new Employee("firstname", "lastname", 1000, "position");
        try {
            employeeReposiory.save(employee);

            consoleLogger.writeInfo("Saved Employee : "+employee.toString());
        } catch (IOException exception) {
            consoleLogger.writeError("Error : Could Not Save Employee "+exception);
        }
    }
}
