package dsAlgo.linkedlist;

public class MyNode {
    private int element;
    private MyNode next;

    public MyNode(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
