package Java8Imp.optional;

import common.pojo.EmployeeListDept;

import java.util.*;
import java.util.stream.DoubleStream;

public class OptionalExample {

    public static void main(String[] args) {
        List<EmployeeListDept> employeeListDepts = new ArrayList<>();
        EmployeeListDept e3 = new EmployeeListDept(3, null, Arrays.asList("development", "ScrumMaster", "PO"));
        employeeListDepts.add(e3);
        Optional<EmployeeListDept> employeeOptional = employeeListDepts.stream().filter(e -> e.getId() == 3).findFirst();
        if (!employeeOptional.isEmpty()) { //use isEmpty, can also use isPresent also can use ifPresent
            if (Optional.ofNullable(employeeOptional.get().getName()).isPresent()) { //use isPresent with Optional.ofNullable
                System.out.println(employeeOptional);
            } else {
                System.out.println("Name is null");
            }
        } else {
            System.out.println("Employee not present");
        }
        employeeOptional.ifPresentOrElse(e -> System.out.println(e), () -> System.out.println("Employee not present"));

        //
        DoubleStream doubleStream = DoubleStream.of(7.0,3.1,5.2);
        OptionalDouble average = doubleStream.average(); //avg returns a optional
        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        }

        average.orElse(Double.NaN);
        average.ifPresent(System.out::println);
        average.orElseGet(() -> Math.random());
    }
}
