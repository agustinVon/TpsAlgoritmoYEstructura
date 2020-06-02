package TpArboles.Avl;

public class DoubleNode<T>{
    public T root;
    private DoubleNode<T> right = null;
    private DoubleNode<T> left = null;

    public DoubleNode (T element){
        this.root = element;
        this.right = null;
        this.left = null;
    }
    public DoubleNode(T element, DoubleNode<T> leftnode, DoubleNode<T> rightNode){
        this.root = element;
        this.right = rightNode;
        this.left = leftnode;
    }

    public DoubleNode(){

    }


    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public void setRight(DoubleNode<T> right) {
        this.right = right;
    }

    public void setLeft(DoubleNode<T> left) {
        this.left = left;
    }

    public DoubleNode<T> getRight() {
        if(!isEmpty()){
            return right;
        }
        return null;
    }

    public DoubleNode<T> getLeft() {
        if(!isEmpty()){
            return left;
        }
        return null;
    }


    public boolean isEmpty() {
        return root == null;
    }
}
