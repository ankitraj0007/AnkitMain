package designpattern.behavioural.iterator;

import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String[] names = {"ankit","appy","raj"};
        NameIterator nameIterator = new NameIterator(names);
        while (nameIterator.hasNext()){
            System.out.println(nameIterator.next());
        }

        //java
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
