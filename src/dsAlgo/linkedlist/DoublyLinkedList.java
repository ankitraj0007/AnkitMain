package dsAlgo.linkedlist;

public class DoublyLinkedList {
    MyDoubleNode head;
    MyDoubleNode tail;
    int size;

    public void addInFront(int element){

        MyDoubleNode node = new MyDoubleNode(element);
        if ( head == null ) {
            tail = node;
        }
        node.setNext(head);
        node.setPrevious(null);
        head = node;
        size++;

    }

    public void addInLast(int element){
        MyDoubleNode node=new MyDoubleNode(element);
        if ( head == null ) {
            head = node;
        }
        tail.setNext(node);
        node.setPrevious(tail);
        tail=node;
        size++;
    }

    public int removeFromFront(){
        MyDoubleNode removedNode =head;
        head=head.getNext();
        head.setPrevious(null);
//        removedNode.setPrevious(null);
//        removedNode.setNext(null);
        size--;
        return removedNode.getElement();
    }

    public int removeFromLast(){
        MyDoubleNode removedNode = tail;
        tail=tail.getPrevious();
        tail.setNext(null);
        size--;
        return  removedNode.getElement();
    }
    //challenge
    public int addBefore(int newElement, int existingElement){
        //can write logic for head null check and if existingElement is there
        MyDoubleNode currElement = head;
        while(currElement.getElement()!=existingElement){
            currElement=currElement.next;
        }
        MyDoubleNode newNode = new MyDoubleNode(newElement);
        newNode.previous=currElement.previous;
        newNode.next=currElement;
        currElement.previous.next=newNode;
        currElement.previous=newNode;
        //can write logic set new node to head in case existingElement is head
        size++;
        return newElement; // can return boolean
    }

    public void print(){
        MyDoubleNode current=head;
        while(current!=null){
            System.out.println(current.getElement());
            current=current.getNext();
        }
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        } return false;
    }


    public MyDoubleNode getHead() {
        return head;
    }

    public void setHead(MyDoubleNode head) {
        this.head = head;
    }

    public MyDoubleNode getTail() {
        return tail;
    }

    public void setTail(MyDoubleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class MyDoubleNode {
    int element;
    MyDoubleNode next;
    MyDoubleNode previous;

    public MyDoubleNode(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public MyDoubleNode getNext() {
        return next;
    }

    public void setNext(MyDoubleNode next) {
        this.next = next;
    }

    public MyDoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(MyDoubleNode previous) {
        this.previous = previous;
    }
}

//    public static void main(String[] args){
//        DoublyLinkedList linkedList = new DoublyLinkedList();
//
//        System.out.println(linkedList.isEmpty());
//        linkedList.addInFront(34);
//        linkedList.addInFront(45);
//        linkedList.addInLast(50);
//        linkedList.addInLast(60);
//        linkedList.print();
//
//        System.out.println(linkedList.isEmpty());
//
//        System.out.println(linkedList.getSize());
//        System.out.println("removed " + linkedList.removeFromFront());
//        System.out.println("removed " + linkedList.removeFromLast());
//        linkedList.print();
//        System.out.println("");
//
//        linkedList.addBefore(70,50);
//        linkedList.print();
//    }