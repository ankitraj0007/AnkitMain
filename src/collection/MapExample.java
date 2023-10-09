package collection;

import java.util.*;

//map is not an official Collection but used to store bunch of objects with key
public class MapExample {

    public static void main(String[] args) {
        hashMap();
        linkedMap();
        hashTable();
        treeMap();
    }

    public static void treeMap(){
        //ordered by key
        Map<String,Integer> map = new TreeMap<>();
        map.put("ankit",31);
        map.put("aparna",30);
        map.put("raj",null);

        map.forEach((k,v)-> System.out.println(k+" "+v));

        map.putIfAbsent("ankit",10);
        map.putIfAbsent("raj",5);

        map.entrySet().forEach(entry -> System.out.println(entry.getKey()+" -> "+entry.getValue()));

        System.out.println(map.keySet());

        map.replaceAll((string, integer) -> string.length());
        System.out.println(map);
    }

    public static void hashTable(){
        //synchronized
        Map<String,Integer> map = new Hashtable<>();
    }

    public static void hashMap(){
        Map<String, Integer> map = new HashMap<>();
    }

    public static void linkedMap(){
        //maintains order of insertion
        Map<String, Integer> map = new LinkedHashMap<>();
    }
}
