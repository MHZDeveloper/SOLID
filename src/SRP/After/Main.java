package SRP.After;

import SRP.After.logging.ConsoleLogger;
import SRP.After.persistence.EmployeeRepository;
import SRP.After.persistence.EmployeeSerializer;
import SRP.After.domain.Employee;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        EmployeeSerializer employeeSerializer = new EmployeeSerializer();
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeSerializer);
        ConsoleLogger consoleLogger = new ConsoleLogger();

        Employee employee = new Employee("firstname", "lastname", 1000, "position");
        try {
            employeeRepository.save(employee);

            consoleLogger.writeInfo("Saved Employee : "+employee.toString());
        } catch (IOException exception) {
            consoleLogger.writeError("Error : Could Not Save Employee "+exception);
        }
    }
}
