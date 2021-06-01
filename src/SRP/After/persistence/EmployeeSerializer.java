package SRP.After.persistence;

import SRP.After.domain.Employee;

public class EmployeeSerializer {

    public String serialize(Employee employee){
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
        return serializedEmployee.toString();
    }
}
