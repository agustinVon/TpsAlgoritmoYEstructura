package Avl;

public interface ISearchTree <T>{
    public T getRoot();
    ISearchTree<T> getLeft();
    ISearchTree<T> getRight();
    boolean isEmpty();
    int getHeight();
    DoubleNode<T> insert(T element);
    public DoubleNode<T> delete(T element, DoubleNode<T> tree);
    public boolean exist(T element);


}
