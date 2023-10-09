package collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("ankit");
        stack.add("raj");

        System.out.println(stack.peek());
        System.out.println(stack.pop()); //raj removed lifo
        System.out.println(stack.push("aparna"));
        System.out.println(stack);

        //using Deque. recommended for stack
        Deque<Integer> integerDeque = new ArrayDeque<>();
        integerDeque.add(1);
        integerDeque.add(5);
        integerDeque.add(3);
        System.out.println(integerDeque.peek());
        System.out.println(integerDeque.pop());
        integerDeque.push(8);
        System.out.println(integerDeque);
    }
}
