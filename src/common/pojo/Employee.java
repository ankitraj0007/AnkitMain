package common.pojo;

public class Employee implements Comparable<Employee>
{
    private String firstName;
    private String lastName;
    private int salary;
    private String department;

    // constructor
    public Employee(String firstName, String lastName,
                    int salary, String department)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    // set firstName
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    // get firstName
    public String getFirstName()
    {
        return firstName;
    }

    // set lastName
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    // get lastName
    public String getLastName()
    {
        return lastName;
    }

    // set salary
    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    // get salary
    public int getSalary()
    {
        return salary;
    }

    // set department
    public void setDepartment(String department)
    {
        this.department = department;
    }

    // get department
    public String getDepartment()
    {
        return department;
    }

    // return Employee's first and last name combined
    public String getName()
    {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    // return a String containing the Employee's information

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return this.salary - employee.getSalary();
    }
}