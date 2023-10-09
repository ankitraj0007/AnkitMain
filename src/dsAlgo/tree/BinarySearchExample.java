package dsAlgo.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ankit", "Aparna", "Raj", "Abhishek");

        Collections.sort(list);

        Collections.binarySearch(list,"Aparna"); //on sorted list
    }
}
