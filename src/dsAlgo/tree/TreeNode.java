package dsAlgo.tree;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;


    public void insert(int data) {
        if (data == this.data) {
            return;
        }
        if (data < this.data) {
            if (this.left == null) {
                this.left = new TreeNode(data);
            } else {
                this.left.insert(data);
            }
        } else {
            if (this.right == null) {
                this.right = new TreeNode(data);
            } else {
                this.right.insert(data);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == this.data) {
            return this;
        }
        if (value < this.data) {
            if (this.left != null) {
                return this.left;
            }
        } else {
            if (this.right != null) {
                return this.right;
            }
        }
        return null;
    }

    public void inOrderTraversal() {
        if (this.left != null) {
            this.left.inOrderTraversal();
        }

        System.out.print(this.data + ", ");

        if (this.right != null) {
            this.right.inOrderTraversal();
        }
    }

    public void preOrderTravesal() {
        System.out.print(this.data + ", ");

        if (this.left != null) {
            this.getLeft().preOrderTravesal();
        }

        if (this.right != null) {
            this.right.preOrderTravesal();
        }
    }

    public void postOrderTravesal() {
        if (this.left != null) {
            this.left.postOrderTravesal();
        }

        if (this.right != null) {
            this.right.postOrderTravesal();
        }

        System.out.print(this.data + ", ");
    }

    public TreeNode min() {
        if (this.left == null) {
            return this;
        } else {
            return this.left.min();
        }
    }

    public TreeNode max() {
        if (this.right == null) {
            return this;
        } else {
            return this.right.max();
        }
    }

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


}
