package dsAlgo.tree;

public class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        else if(data <= node.data){
            node.left = node.insert(node.left, data);
        }else {
            node.right = node.insert(node.right, data);
        }
        return node;
    }

    public void traverse(Node node){
        if(node == null){
            return;
        }
        traverse(node.left);
        System.out.println(node.data);
        traverse(node.right);
    }

    public int getData() {
        return data;
    }

}
