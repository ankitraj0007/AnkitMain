package Java8Imp.compare;

import common.pojo.Cat;

import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {
        Cat c1 = new Cat("rea","white");
        Cat c2 = new Cat("sea","black");
        Cat c3 = new Cat("pea","black");

        List<Cat> cats = new ArrayList<>();
        cats.add(c1);
        cats.add(c2);
        cats.add(c3);
        System.out.println(cats);

        Comparator<Cat> catComparator = Comparator //cat doesn't implement comparable. so can create a comparator to apply sort
                                            .comparing(Cat::getColor)
                                            .thenComparing(Cat::getName);

        cats.sort(catComparator);
        System.out.println(cats);

        //treeset will give exception as there is no compareTo method
//        Set<Cat> catTreeSet = new TreeSet<>();
//        catTreeSet.add(c1);
//        catTreeSet.add(c2);
//        catTreeSet.add(c3);
        //here is how we can do it using tree
        Set<Cat> catTreeSet = new TreeSet<>(catComparator);
        catTreeSet.add(c1);
        catTreeSet.add(c2);
        catTreeSet.add(c3);
        //or
        Set<Cat> catTreeSet1 = new TreeSet<>(Comparator.comparing(Cat::getColor));
        catTreeSet1.add(c1);
        catTreeSet1.add(c2);
        catTreeSet1.add(c3);

        //binary search
        List<String> list = Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek");
        Collections.sort(list);
        Collections.binarySearch(list,"Aparna"); //binarySearch on sorted list, use natural string compare/sort

        Collections.binarySearch(cats, c2, catComparator); //pass comparator as well
    }
}
