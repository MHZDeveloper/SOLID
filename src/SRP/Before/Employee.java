package SRP.Before;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Employee {

    private String firstName;
    private String lastName;
    private String position;
    private int wage;

    public Employee(String firstName, String lastName, int wage, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wage = wage;
        this.position = position;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getWage() {
        return wage;
    }

    public String getPosition() {
        return position;
    }

    public static void save(Employee employee) {

        try {
            //serialize employee
            StringBuilder serializedEmployee = new StringBuilder();
            serializedEmployee.append("### RECORD ###");
            serializedEmployee.append(System.lineSeparator());
            serializedEmployee.append("NAME : ");
            serializedEmployee.append(employee.getFullName());
            serializedEmployee.append(System.lineSeparator());
            serializedEmployee.append("POSITION : ");
            serializedEmployee.append(employee.getPosition());
            serializedEmployee.append(System.lineSeparator());
            serializedEmployee.append("WAGE : ");
            serializedEmployee.append(employee.getWage());
            serializedEmployee.append(System.lineSeparator());

            //save in a file
            Path path = Paths.get(employee.getFullName().replaceAll(" ", "_") + ".txt");
            Files.write(path, serializedEmployee.toString().getBytes(StandardCharsets.UTF_8));

            //log
            System.out.println("Saved Employee");
        } catch (IOException e){
            System.out.println("Error : Could Not Save Employee");
        }
    }
}
