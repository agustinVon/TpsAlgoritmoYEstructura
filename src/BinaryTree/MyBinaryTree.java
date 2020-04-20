package BinaryTree;

public class MyBinaryTree<T> implements BinaryTree<T> {
    DoubleNode root;

    public MyBinaryTree(){

    }

    public MyBinaryTree(T root){
        this.root = new DoubleNode(root);
    }

    public MyBinaryTree(DoubleNode root){
        this.root = root;
    }

    public MyBinaryTree(T root, MyBinaryTree left, MyBinaryTree right){
        this.root = new DoubleNode(root);
        this.root.left = left.root;
        this.root.right = right.root;
    }

    @Override
    public boolean isEmpty() {
        if(root == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public T getRoot() {
        if(root != null){
            return (T) root.element;
        }
        else{
            return null;
        }
    }

    @Override
    public BinaryTree<T> getRight() {
        return new MyBinaryTree(root.right);
    }

    @Override
    public BinaryTree<T> getLeft() {
        return new MyBinaryTree(root.right);
    }
}
