package collection;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
        factory();
        arraylist();
        linkedList();
    }

    public static void factory(){
        String[] array = new String[]{"ankit","raj","monu"};

        //factory methods . immutable list. cant add or delete elements but can modify
        List<String> arraysAsList = Arrays.asList(array); // cant use add method
        List<String> listOf = List.of(array); // cant use add method
        List<String> copyOf = List.copyOf(arraysAsList); // cant use add/set method
//        arraysAsList.add("aparna"); runtime UnsupportedOperationException
        array[0]="aparna";
        arraysAsList.set(1,"bhale"); // backend support
        System.out.println(Arrays.toString(array));

        Collections.sort(arraysAsList);
        System.out.println(Arrays.toString(array));
    }

    public static void arraylist(){
        //arraylist
        List<String> stringList = new ArrayList<>();
        stringList.add("ankit"); // can use add method
        stringList.removeIf(s -> s.startsWith("R"));
        stringList.replaceAll(s-> s+"kumar");
    }

    public static void linkedList(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("ankit");
        linkedList.addFirst("raj");
        linkedList.addLast("aparna");
        System.out.println(linkedList);
    }
}
