package BinaryTree;

public class DoubleNode<T> {
    T element;
    DoubleNode<T> right,left;

    public DoubleNode(T element){
        this.element = element;
        right = null;
        left = null;
    }

    public T getElement(){
        return element;
    }
}