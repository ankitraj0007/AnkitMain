package dsAlgo.tree;

public class Tree {
    private TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public TreeNode get(int value) {
        if (value == root.getData()) {
            return root;
        } else {
            root.get(value);
        }
        return null;
    }

    public void inOrderTraversal() {
        root.inOrderTraversal();
    }

    public void preOrderTraversal() {
        root.preOrderTravesal();
    }

    public void postOrderTraversal() {
        root.postOrderTravesal();
    }

    public TreeNode min() {
        return root.min();
    }

    public TreeNode max() {
        return root.max();
    }

    public void delete(int value) {
        delete(root, value);
    }

    private TreeNode delete(TreeNode node, int value) {

        if (node == null) {
            return node;
        }

        if (value < node.getData()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getData()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            //if both children are there. replace the data with right child min. this will keep the binary tree intact
            node.setData(node.getRight().min().getData());
            //delete the right child min now
            node.setRight(delete(node.getRight(), node.getData()));
        }
        return node;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    //main
//	Tree tree = new Tree();
//	tree.insert(25);
//	tree.insert(20);
//	tree.insert(15);
//	tree.insert(27);
//	tree.insert(30);
//	tree.insert(29);
//	tree.insert(26);
//	tree.insert(22);
//	tree.insert(32);
//	tree.insert(17);
//
//	tree.inOrderTraversal();
//	System.out.println("-----------------------");
//	tree.preOrderTraversal();
//	System.out.println("-----------------------");
//	tree.postOrderTraversal();
//	System.out.println("-----------------------");

//	System.out.println(tree.get(23).getData());
//	System.out.println(tree.min().getData());
//	System.out.println(tree.max().getData());


//	tree.delete(77);
//	tree.inOrderTraversal();
//	System.out.println("-----------------------");


}
