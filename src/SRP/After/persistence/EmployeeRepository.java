package SRP.After.persistence;

import SRP.After.domain.Employee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeRepository {

    private final EmployeeSerializer employeeSerializer;

    public EmployeeRepository(EmployeeSerializer employeeSerializer) {
        this.employeeSerializer = employeeSerializer;
    }

    public void save(Employee employee) throws IOException {
            //serialize employee
            String serializedEmployee = employeeSerializer.serialize(employee);

            //save in a file
            Path path = Paths.get(employee.getFullName().replaceAll(" ", "_") + ".txt");
            Files.write(path, serializedEmployee.getBytes(StandardCharsets.UTF_8));
    }
}
