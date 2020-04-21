package BinaryTree;

public class MyBinaryTree<T> implements BinaryTree<T> {
    DoubleNode root;

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
        MyBinaryTree<T> t=new MyBinaryTree<T>();
        t.root=root.right;
        return t;
    }

    @Override
    public BinaryTree<T> getLeft() {
        MyBinaryTree<T> t=new MyBinaryTree<T>();
        t.root=root.left;
        return t;
    }
}
