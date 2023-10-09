package collection;

import common.pojo.Person;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        factory();
        treeSet();
        hasSet();
        linkedHasSet();
    }

    public static void factory(){
        //factory. cant add,delete
        Set<String> stringSet = Set.of("ankit","aparna");
        Set<String> copyOf = Set.copyOf(stringSet);
    }

    public static void treeSet(){
        //sorted
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("raj");
        treeSet.add("ankit");
        treeSet.add("aparna");
        System.out.println(treeSet);

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(56);
        integerTreeSet.add(89);
        integerTreeSet.add(56);//duplicate will not be added
        integerTreeSet.add(100);
        System.out.println(integerTreeSet);
        System.out.println(integerTreeSet.lower(89));
        System.out.println(integerTreeSet.pollLast());
    }

    public static void hasSet(){
        //insertion order is not maintained
        Person person1 = new Person("ankit",31);
        Person person2 = new Person("aparna",32);
        Person person3 = new Person("ankit",31);//duplicate
        Person person4 = new Person("raj",31);

        Set<Person> personSet = new HashSet<>(); //order is not maintained
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);//wouldn't add to the set. will use person hashCode and equal method to compare
        personSet.add(person4);

        System.out.println(personSet);
    }

    public static void linkedHasSet(){
        //insertion order is maintained
        Person person1 = new Person("ankit",31);
        Person person2 = new Person("aparna",32);
        Person person3 = new Person("ankit",31);//duplicate
        Person person4 = new Person("raj",31);

        Set<Person> personSet = new LinkedHashSet<>(); //order is maintained as per add
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);//wouldn't add to the set. will use person hashCode and equal method to compare
        personSet.add(person4);

        System.out.println(personSet);
    }
}
