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
        if(map.size() < capacity){
            pointer.addFirst(val);
            map.put(val,val);
        }else {
            //remove lru
            int toBeRemoved = pointer.getLast();
            map.remove(toBeRemoved);
            pointer.removeLast();

            map.put(val,val);
            pointer.addFirst(val);
        }
    }

    public void display(){
        map.forEach((k,v) -> System.out.print(v + ","));
    }

    public static void main(String[] args) {
        MyLRU myLRU = new MyLRU(3);
        myLRU.put(34);
        myLRU.put(55);
        myLRU.put(43);
        myLRU.get(34);
        myLRU.put(98);
        myLRU.display();
    }
}
