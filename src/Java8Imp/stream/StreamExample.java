package Java8Imp.stream;

import common.pojo.Cat;
import common.pojo.EmployeeListDept;
import common.pojo.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class StreamExample {

    public static void main(String[] args) {
//		example();
//		collect();
//      filter();
//		streamCat("src/common/cat.txt");
//		minMax();
//		findAndMatch();
//        flatMap();
        primitive();
//        sorting();
    }

    public static void example() {
        //Stream
        int[] intArr = {2, 5, 4, 8, 9, 1};
        List<Integer> intList = Arrays.asList(2, 5, 4, 8, 9, 1);
        Arrays.stream(intArr).filter(i -> i < 5).forEach(j -> System.out.print(j + ", "));//filter
        System.out.println("stream filter");

        intList.stream().map(i -> i * i).forEach(j -> System.out.print(j + ", "));//map
        System.out.println("stream map");

        Stream<Integer> s = intList.stream(); // to get stream object and then can configure and perform operation
        List<Integer> intMap = s.map(i -> i * 2).collect(Collectors.toList());
        System.out.print(intMap);
        System.out.println("stream map and collect");

        List<Integer> intList1 = List.of(5, 8, 1, 3, 6);
        System.out.print("intList1 Java8main::print method reference ");
        intList1.stream().forEach(StreamExample::print);//functional programming -> method reference
        System.out.println();
        intList1.stream().forEach(System.out::print);
        System.out.println();
        intList1.stream().filter(n -> n % 2 == 0).forEach(System.out::print);


        List<Double> list = Arrays.asList(2.1, 4.3, 1.0, 7.1, 5.2);
        list.stream()
                .peek(System.out::println)
                .filter(d -> d > 5)
                .peek(System.out::println)
                .count();

        Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek")
                .stream()
                .peek(System.out::println)
                .filter(str2 -> {
                    System.out.println("filter1: " + str2);
                    return str2.startsWith("A");
                })
                .filter(str3 -> {
                    System.out.println("filter2: " + str3);
                    return str3.length() > 5;
                })
                .limit(1) //this will limit till one find. so will not reach Abhishek
                .forEach(System.out::println);

        //create stream from collection
        List<String> list1 = Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek");
        Stream<String> stringStream = list1.stream();
        stringStream.count();

        Map<String, Integer> map = new HashMap<>();
        map.put("Ankit", 31);
        map.entrySet()//get a set i.e collection to use stream on it
                .stream()
                .count();

        //of
        Stream<Integer> integerStream1 = Stream.of(1, 5, 3, 2);

        //generate
        Stream<Double> doubleStream = Stream.generate(() -> {
            return Math.random();
        });

        //iterate
        Stream<Integer> integerStream = Stream.iterate(2, n -> n + 2);
        integerStream.limit(3).forEach(System.out::println);

        //reduce
        Stream.of(2, 3, 4)
                .reduce(1, (integer1, integer2) -> integer1 * integer2);//24

    }

    public static void collect() {
        //collect
        Stream.of("An", "kit", " ", "Raj") //Ankit Raj //parallel execution
                .collect(() -> new StringBuilder(), //supplier
                        (sb, str) -> sb.append(str), //accumulator
                        (sb1, sb2) -> sb1.append(sb2)); //combiner

        //collectors
        Stream.of("Ankit", "Aparna", "Raj", "Abhishek")
                .collect(Collectors.joining(", "));

        Stream.of("Ankit", "Aparna", "Raj", "Abhishek")
                .collect(Collectors.averagingInt(s1 -> s1.length()));

        //collectors.toMap
        Map<String, Integer> map1 =
                Stream.of("Ankit", "Aparna")
                        .collect(Collectors.toMap(
                                s -> s,
                                s -> s.length()
                        )); //{Ankit=5,Aparna=6}
        System.out.println(map1);

        //Collectors.groupingBy
        Map<Integer, List<String>> listMap =
                Stream.of("Ankit", "Aparna", "Raj", "Abhishek", "Rudra", "Ankit")
                        .collect(
                                Collectors.groupingBy(String::length) // s-> s.length()
                        );
        System.out.println("groupingBy listMap: " + listMap);

        Map<Integer, Set<String>> setMap =
                Stream.of("Ankit", "Aparna", "Raj", "Abhishek", "Rudra", "Ankit")
                        .collect(
                                Collectors.groupingBy(
                                        String::length,
                                        Collectors.toSet() // to get the set
                                )
                        );
        System.out.println("groupingBy setMap: " + setMap);

        TreeMap<Integer, List<String>> treeMap =
                Stream.of("Ankit", "Aparna", "Raj", "Abhishek", "Rudra", "Ankit")
                        .collect(
                                Collectors.groupingBy(
                                        String::length,
                                        TreeMap::new,  //map type supplier
                                        Collectors.toList()
                                )
                        );
        System.out.println("groupingBy treeMap: " + treeMap);

        //Collectors.partitioningBy
        Map<Boolean, List<String>> booleanListMap =
                Stream.of("Ankit", "Aparna", "Raj", "Abhishek", "Rudra", "Ankit")
                        .collect(Collectors.partitioningBy(s -> s.startsWith("A")));
        System.out.println("partitioningBy: " + booleanListMap);
    }

    public static void filter() {
        List<String> stringList = Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek", "Rudra", "Ankit");
        stringList.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("---------------");

        //distinct
        stringList.stream()
                .distinct()
                .forEach(System.out::println);
    }

    public static void streamCat(String fileName) {
        List<Cat> cats = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            lines.forEach(line -> {
                String[] catString = line.split("/");
                cats.add(new Cat(catString[0], catString[1]));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cats.forEach(System.out::println);
    }

    public static void minMax() {
        //int
        Stream<Integer> integers = Stream.of(7, 3, 9, 22, 11);
        int max = integers
                .max((o1, o2) -> o1 - o2)
                .orElseThrow(NoSuchElementException::new);
        System.out.println(max);

        //object
        Person person1 = new Person("Ankit", 31);
        Person person2 = new Person("Aparna", 30);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        Optional<Person> personMaxAge = personList.stream().max(Comparator.comparing(Person::getAge));
        if (personMaxAge.isPresent()) System.out.println("max age: " + personMaxAge.get());

        //string
        String[] strings = {"Ankit", "Aparna", "Raj", "Abhishek"};
        Optional<String> min = Arrays.stream(strings).min((o1, o2) -> o1.length() - o2.length());
        System.out.println("min str: " + min);
    }

    public static void findAndMatch() {
        List<String> strings = Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek");
        System.out.println("findFirst: " + strings.stream().findFirst());
        System.out.println("findAny: " + strings.stream().findAny());

        System.out.println("anyMatch: " + strings.stream().anyMatch(s -> s.startsWith("R")));
        System.out.println("allMatch :" + strings.stream().allMatch(s -> s.contains("Ank")));
        System.out.println("noneMatch :" + strings.stream().noneMatch(s -> s.contains("Ankit")));
    }

    public static void flatMap(){
        //flatMap
        List<String> list2 = Arrays.asList("Ankit", "Aparna");
        List<String> list3 = Arrays.asList("Rudra", "Meera");

        Stream<String> stringStream1 = Stream.of(list2, list3).flatMap(list4 -> list4.stream()); // converted into single stream of String
        stringStream1.forEach(System.out::println);

        //flatMap -> flatten a map. below example to find all unique departments
        EmployeeListDept e1 = new EmployeeListDept(1, "Ankit", Arrays.asList("testing", "development", "management"));
        EmployeeListDept e2 = new EmployeeListDept(2, "Aparna", Arrays.asList("development", "ScrumMaster", "PO"));
        List<EmployeeListDept> employeeListDepts = new ArrayList<>();
        employeeListDepts.add(e1);
        employeeListDepts.add(e2);
        Set<List<String>> deptSetMap = employeeListDepts.stream().map(e -> e.getDepartments()).collect(Collectors.toSet());
        System.out.println();
        System.out.println("deptSetMap: " + deptSetMap); //map
        Set<String> deptSetFlatMap = employeeListDepts.stream().flatMap(e -> e.getDepartments().stream()).collect(Collectors.toSet());
        System.out.println("deptSetFlatMap: " + deptSetFlatMap); //flatMap
    }

    public static void primitive(){
        //primitive stream
        IntStream intStream = IntStream.of(2,4,9,1);
//        intStream.min(); //can take min, max, sum and avg etc
//        intStream.sum();

        DoubleStream doubleStream1 = Stream.of("ankit","aparna")
                .mapToDouble(value -> value.length());

        LongStream longStream = LongStream.of(8l,5l);
        longStream.mapToDouble(value -> (double)value);

        Stream<String> stringStream2 = intStream
                .mapToObj(value -> "Number:"+value);
    }

    public static void sorting(){
        //sorting
        List<String> stringList = Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek", "Rudra", "Ankit");
        stringList.stream()
                .sorted() //default sort for string alphanumeric
                .forEach(System.out::println);

        Person ankit = new Person("ankit",31);
        Person aparna = new Person("aparna", 30);

        Stream.of(ankit,aparna)
//                .sorted(Comparator.comparing(Person::getAge)) //using method ref
                .sorted(Comparator.comparing(person -> person.getAge())) // using lamda
                .forEach(System.out::println);
    }

    public static void print(int number) {
        System.out.print(number + ", ");
    }
}
