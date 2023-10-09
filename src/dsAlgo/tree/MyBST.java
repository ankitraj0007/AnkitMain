package dsAlgo.tree;

public class MyBST {

    //root
    Node root;

    //insert
    public void insert(int data){
        if(root == null){
            root = new Node(data);
        }else {
            root.insert(root, data);
        }
    }

    //inorder traversal
    public void traverse(){
        root.traverse(root);
    }

    public void createBST(int[] arr){
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }
    }
}
