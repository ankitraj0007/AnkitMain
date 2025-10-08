package common.pojo;

import java.util.Arrays;
import java.util.List;

public class MockEmployeeList {
    public static List<Employee> getEmployees(){
        Employee[] employees = {
                new Employee("J", "Red", 51000, "IT"),
                new Employee("A", "Green", 71600, "IT"),
                new Employee("M", "Black", 35187, "Sales"),
                new Employee("K", "Yellow", 47100, "Marketing"),
                new Employee("L", "Pink", 62001, "IT"),
                new Employee("D", "Blue", 32001, "Sales"),
                new Employee("W", "Brown", 42361, "Marketing")};
        List<Employee> employeeList = Arrays.asList(employees);
        return employeeList;
    }
}
