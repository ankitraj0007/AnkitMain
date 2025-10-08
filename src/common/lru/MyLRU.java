package common.lru;

import java.util.*;

public class MyLRU {

    int capacity;
    LinkedList<Integer> pointer;
    Map<Integer, Integer> map;

    MyLRU(int capacity){
        map = new HashMap<>();
        pointer = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int val){
        if(map.containsKey(val)){
            pointer.removeFirstOccurrence(val);
            pointer.addFirst(val);
            return map.get(val);
        }
        throw new NoSuchElementException();
    }

    public void put(int val){
        int key = val;
        if(map.containsKey(key)){
            // Update the value and move the key to the front of the pointer
            map.put(key, val);
            pointer.removeFirstOccurrence(key);
            pointer.addFirst(key);
        } else {
            if(map.size() < capacity){
                pointer.addFirst(key);
                map.put(key, val);
            }else {
                // Remove the least recently used key
                int toBeRemoved = pointer.getLast();
                map.remove(toBeRemoved);
                pointer.removeLast();

                // Add the new key-value pair
                map.put(key, val);
                pointer.addFirst(key);
            }
        }
    }

    public void display(){
        pointer.forEach(value -> System.out.print(value + ","));
    }

    public static void main(String[] args) {
        MyLRU myLRU = new MyLRU(3);
        myLRU.put(34);
        myLRU.put(55);
        myLRU.put(34);
        myLRU.put(43);
        myLRU.get(34);
        myLRU.put(98);
        myLRU.display();
    }
}
