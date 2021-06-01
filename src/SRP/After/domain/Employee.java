package SRP.After.domain;

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

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", wage=" + wage +
                '}';
    }
}
