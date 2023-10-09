package Java8Imp;

import common.pojo.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Java8Solution {

    public static void main(String[] args) {
        findFirstNonRepeatedChar();
//        findSecondMax();
//        findEmployeeOnCondition();
//        sortOnSalary();
//        getEmployeesInEachDept();
//        sumOfOddNumbers();
//        minMax();
//        empCountDept();
//        countIntOccInArray();
//        countStringOccurrence();

    }

    public static void findFirstNonRepeatedChar(){
        String str = "asbhdgrasnbfl";

        LinkedHashMap<Character, Long> collect = str.chars()
                .mapToObj(i -> (char) i)
                .collect(
                        groupingBy(c -> c, LinkedHashMap::new, counting())
                );
        System.out.println(collect);

        //using keyset
        Optional<Character> first = collect.keySet().stream().filter(key -> collect.get(key) < 2).findFirst();
        System.out.println(first.get());

        //using entrySet
        Character key = collect.entrySet().stream().filter(e -> e.getValue() < 2).findFirst().get().getKey();
        System.out.println(key);
    }

    public static void findSecondMax(){
        int[] arr = {3,11,77,54,9,23};

        Integer integer = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(integer);
    }

    public static void findEmployeeOnCondition(){
        Employee e1 = new Employee("ankit","raj",1200,"abc");
        Employee e2 = new Employee("ankit2","raj",300,"bcd");
        Employee e3 = new Employee("ankit3","raj",1100,"xyz");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        List<String> collect = employeeList.stream().filter(employee -> {
            return employee.getSalary() > 1000 && employee.getDepartment() == "abc";
        }).map(e -> e.getFirstName()).collect(toList());

        System.out.println(collect);
    }

    public static void sortOnSalary(){
        Employee e1 = new Employee("ankit","raj",1200,"abc");
        Employee e2 = new Employee("ankit2","raj",300,"abc");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);

        //use compareTo method of Employee to sort on salary
        List<Employee> collect1 = employeeList.stream().sorted(Employee::compareTo).collect(toList());

        System.out.println(collect1);
    }

    public static void getEmployeesInEachDept(){
        List<Employee> employeeList =  new ArrayList<>();
        Employee e1 = new Employee("ankit", "raj", 51000, "IT");
        Employee e2 = new Employee("appy", "bhale", 35187, "Sales");
        Employee e3 = new Employee("ram", "ji", 47100, "Marketing");
        Employee e4 = new Employee("dany", "pink", 62001, "IT");
        Employee e5 = new Employee("sudhir", "yadav", 32001, "Sales");
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

//        List<Employee> employeeList = Arrays.asList();

        Map<String, List<Employee>> deptEmps = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment, HashMap::new, Collectors.mapping(employee -> employee, Collectors.toList())
                        )
                );
        System.out.println(deptEmps);
    }

    public static void sumOfOddNumbers(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        Integer sum = list.stream()
                .filter(integer -> {
                    return integer % 2 != 0;
                })
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

//    find min and max
    public static void minMax(){
        List<Integer> list = Arrays.asList(1,12,30,77,16,51,51);
//        int max = list.stream().max((o1, o2) -> o1-o2).get();
        int max = list.stream().max(Integer::compare).get();
//        int min = list.stream().max(Comparator.reverseOrder()).get();
//        int min = list.stream().min((o1, o2) -> o1-o2).get();
        int min = list.stream().min(Integer::compare).get();
        System.out.println("min:"+min+ " , max:"+max);
    }

//    Count number of Employees in each department
    public static void empCountDept(){
        Employee[] employees = {
                new Employee("J", "Red", 51000, "IT"),
                new Employee("A", "Green", 71600, "IT"),
                new Employee("M", "Black", 35187, "Sales"),
                new Employee("K", "Yellow", 47100, "Marketing"),
                new Employee("L", "Pink", 62001, "IT"),
                new Employee("D", "Blue", 32001, "Sales"),
                new Employee("W", "Brown", 42361, "Marketing")};
        List<Employee> employeeList = Arrays.asList(employees);

        TreeMap<String, Long> count = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment, TreeMap::new, Collectors.counting()
                        )
                );
        System.out.println(count);
    }

    //count occurrence of integer in int array
    public static void countIntOccInArray(){
        Integer [] arr1 = {1, 6, 2, 8, 5, 4, 7, 7, 5, 7};
        List<Integer> list = Arrays.asList(arr1);
        TreeMap<Integer, Long> collect = list.stream()
                .collect(Collectors.groupingBy(i -> i, TreeMap::new, Collectors.counting()));
        System.out.println(collect);
    }

    //Count the no of occurrence of each string using streams() ?
    //List<String> fruitsList = Arrays.asList("Apple", "Banana", "Apple", "Orange");
    //{Orange=1, Banana=1, Apple=2}
    public static void countStringOccurrence(){
        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Apple", "Orange");

        TreeMap<String, Long> collect = fruitsList.stream().collect(groupingBy(
                str -> str, TreeMap::new, counting()
        ));
        System.out.println(collect);
    }
}
