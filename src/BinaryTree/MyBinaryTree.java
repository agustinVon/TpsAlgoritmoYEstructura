package BinaryTree;

public class MyBinaryTree<T> implements BinaryTree<T> {
    DoubleNode<T> root;

    public MyBinaryTree(){

    }

    public MyBinaryTree(T root){
        this.root = new DoubleNode(root);
    }

    public MyBinaryTree(T root, MyBinaryTree left, MyBinaryTree right){
        this.root = new DoubleNode(root);
        this.root.left = left.root;
        this.root.right = right.root;
    }

    public boolean isEmpty() {
        if(root == null){
            return true;
        }
        else {
            return false;
        }
    }

    public T getRoot() {
        if(root != null){
            return root.getElement();
        }
        else{
            return null;
        }
    }

    public BinaryTree<T> getRight() {
        MyBinaryTree<T> t=new MyBinaryTree<T>();
        t.root=root.right;
        return t;
    }

    public BinaryTree<T> getLeft() {
        MyBinaryTree<T> t=new MyBinaryTree<T>();
        t.root=root.left;
        return t;
    }
}
