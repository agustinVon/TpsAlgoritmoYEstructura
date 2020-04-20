package BinaryTree;

public interface BinaryTree<T> {
    public DoubleNode root = null;
    public boolean isEmpty();
    public T getRoot();
    public BinaryTree<T> getRight();
    public BinaryTree<T> getLeft();
}
