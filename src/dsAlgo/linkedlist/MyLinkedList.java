package dsAlgo.linkedlist;

public class MyLinkedList {
    private MyNode head;
    private int size; //if needed add this field

    public void addInFront(int element){
        MyNode node = new MyNode(element);
        node.setNext(head);
        head=node;
        size++;
    }

    public void addInLast(int element){
        if(head == null){
            head = new MyNode(element);
        } else {
            MyNode currentNode = head;
            while (currentNode.getNext()!=null){
                currentNode=currentNode.getNext();
            }
            currentNode.setNext(new MyNode(element));
        }
    }

    public int removeFromFront(){
        if(!isEmpty()){
            MyNode removedNode = head;
            head=head.getNext();
            size--;
            return removedNode.getElement();
        }else return -1; //check this logic for appropriate value
    }

    //challenge --> assumption only using this method to insert
    public int insertSorted(int element){

        if(isEmpty() || head.getElement()>element){
            addInFront(element);
        }else{
            MyNode currNode = head.getNext();
            MyNode prevNode = head;

            while(currNode!= null && currNode.getElement()<element){
                prevNode = currNode;
                currNode = currNode.getNext();
            }

            MyNode newNode = new MyNode(element);
            newNode.setNext(currNode);
            prevNode.setNext(newNode);
            size++;
        }

        return element; //return can be diff
    }

    public void print(){
        MyNode currentNode = head;
        while (currentNode!=null){
            System.out.println(currentNode.getElement());
            currentNode=currentNode.getNext();
        }
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        } else return false;
    }

    public MyNode getHead() {
        return head;
    }

    public void setHead(MyNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


//    public static void main(String[] args){
//        MyLinkedList linkedList = new MyLinkedList();
//
//        System.out.println(linkedList.isEmpty());
//        linkedList.addInFront(34);
//        linkedList.addInFront(45);
//        linkedList.print();
//
//        System.out.println(linkedList.isEmpty());
//
//        System.out.println(linkedList.getSize());
//        System.out.println("removed " + linkedList.removeFromFront());
//        linkedList.print();
//    }
