package RedBlackTree;

public class ColorNode<T> {
    boolean color;
    T element;
    ColorNode<T> parent;
    ColorNode<T> rightChild;
    ColorNode<T> leftChild;

    ColorNode(){
        color=false;
    }

    ColorNode(T element,ColorNode<T> parent){
        color=true;
        this.element=element;
        this.parent=parent;
        rightChild=new ColorNode<T>();
        leftChild=new ColorNode<T>();
    }

    ColorNode(T element,ColorNode<T> leftChild,ColorNode<T> rightChild,ColorNode<T> parent){
        this.element=element;
        this.leftChild=leftChild;
        this.rightChild=rightChild;
        this.parent=parent;
    }

    public void changeColor(){
        color=!color;
    }
    public boolean getColor(){
        return color;
    }
}
