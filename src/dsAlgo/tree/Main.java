package dsAlgo.tree;


public class Main {

    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        MyBST myBST = new MyBST();
        myBST.createBST(keys);
        myBST.traverse();

        System.out.println("-----------------");

        MyBST myBST1 = new MyBST();
        myBST1.insert(15);
        myBST1.insert(10);
        myBST1.insert(20);
        myBST1.insert(8);
        myBST1.insert(12);
        myBST1.insert(16);
        myBST1.insert(25);
        myBST1.traverse();

    }
}
