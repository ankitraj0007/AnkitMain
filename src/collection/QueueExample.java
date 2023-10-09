package collection;

import common.pojo.Person;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {

    public static void main(String[] args) {
//        linkedListQueue();
//        dequeQueue();
        priorityQueue();
        blockingQueue();
    }

    public static void linkedListQueue(){
        Queue<Integer> queue = new LinkedList<>(); //fifo
        queue.offer(5);
        queue.offer(90);

        System.out.println(queue);
        System.out.println(queue.poll());
        queue.offer(70);
        System.out.println(queue.peek());
        queue.offer(80);
        System.out.println(queue);

    }

    public static void dequeQueue(){
        Deque<Integer> deque = new ArrayDeque<>(); // double ended queue
        deque.offer(5);
        deque.offer(90);

        System.out.println(deque);
        System.out.println(deque.poll());
        deque.offer(70);
        System.out.println(deque.peek());
        deque.offer(80);
        System.out.println(deque);

        //as stack
        System.out.println(deque.pollLast());
        System.out.println(deque.peekLast());
        deque.offerLast(60); // same as offer
        System.out.println(deque);
    }

    public static void priorityQueue(){
        Queue<Integer> queue = new PriorityQueue<>(); //sorted in natural order
        queue.offer(78);
        queue.offer(86);
        queue.offer(23);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        //custom ordering with comparator
        Person person1 = new Person("ankit",31);
        Person person2 = new Person("aparna",32);
        Person person3 = new Person("raj",25);

        Comparator<Person> personComparator = Comparator.comparing(person -> person.getAge());
        Queue<Person> personQueue = new PriorityQueue<>(personComparator);

        personQueue.offer(person1);
        personQueue.offer(person2);
        personQueue.offer(person3);

        Iterator<Person> personIterator = personQueue.iterator();
        while (personIterator.hasNext()){
            System.out.println(personQueue.poll());
        }
    }

    public static void blockingQueue(){
        Queue<Integer> queue = new ArrayBlockingQueue<>(10); // wait
    }
}
