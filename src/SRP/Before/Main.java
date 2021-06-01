package SRP.Before;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("firstname","lastname",1000,"position");
        Employee.save(employee);
    }
}
