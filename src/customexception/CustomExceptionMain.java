package customexception;

import common.pojo.EmployeeListDept;

import java.util.List;

public class CustomExceptionMain {
    public static void main(String[] args) {
        try {
            getEmployee();
        } catch (MyCustomCheckedException e) {
            // log/throw/handle
            System.out.println(e);
        }


        getEmployee(3);

    }

    public static EmployeeListDept getEmployee() throws MyCustomCheckedException {
        EmployeeListDept e1 = new EmployeeListDept(1, "Ankit", List.of("java", "spring"));
        if (e1.getId() == 2) {
            return e1;
        } else
            throw new MyCustomCheckedException("some custome checked exception");
    }

    public static EmployeeListDept getEmployee(int id) {
        EmployeeListDept e1 = new EmployeeListDept(id, "Ankit", List.of("java", "spring"));
        if (e1.getId() == 2) {
            return e1;
        } else
            throw new MyCustomUncheckedException("some custome unchecked exception");
    }
}
