package dsAlgo.linkedlist;

import dsAlgo.linkedlist.DoublyLinkedList;
import dsAlgo.linkedlist.MyLinkedList;

public class Main {

        public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();

        System.out.println(linkedList.isEmpty());
//        linkedList.addInFront(34);
//        linkedList.addInFront(45);
//        linkedList.print();
//
//        System.out.println(linkedList.isEmpty());
//
//        System.out.println(linkedList.getSize());
//        System.out.println("removed " + linkedList.removeFromFront());
            linkedList.insertSorted(8);
            linkedList.insertSorted(4);
            linkedList.insertSorted(10);
            linkedList.insertSorted(2);
            linkedList.insertSorted(11);
        linkedList.print();
    }
}
