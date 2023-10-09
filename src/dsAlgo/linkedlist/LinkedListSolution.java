package dsAlgo.linkedlist;

import common.MyMain;

import java.util.Arrays;
import java.util.List;

public class LinkedListSolution {

    public static void main(String[] args) {
        //Reverse a given the list using LinkedList and check whether its a palindrome or not ?
        //Given elements = 10 , 20 , 15 , 35 , 15 , 20 , 10

        List<Integer> integers = Arrays.asList(10 , 20 , 15 , 35 , 15 , 20 , 10);

        MyLinkedList myLinkedList = new MyLinkedList();

        for(int i = integers.size() -1 ; i>=0; i--){
            myLinkedList.add(integers.get(i));
        }

        for (int i = 0 ; i < integers.size(); i++){
            Node node = myLinkedList.pop();

            if(node.data != integers.get(i)){
                System.out.println(false);
                return;
            }

        }
        System.out.println(true);
    }

//    static boolean checkPalindrome(){
//
//    }

    static class MyLinkedList{
        Node lastNode;
        Node root;
        Node currNode;

        public void add(int i){

            if(root == null){
                root = new Node(i);
                lastNode = root;
                lastNode.nextNode = null;
            }else {
                currNode = new Node(i);
                lastNode.nextNode = currNode;
                lastNode = currNode;
                currNode.nextNode = null;
            }

        }

        public Node pop(){
            Node nodeToBeReturned = root;
            root = root.nextNode;
            return nodeToBeReturned;
        }
    }


    static class Node{
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
