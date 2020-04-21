package BinaryTree;

public class OtherBinaryTree<T> implements BinaryTree<T>{

    OtherBinaryTree rightNode;
    OtherBinaryTree leftNode;
    T root;

    public  OtherBinaryTree(){
        this(null,null,null);
    }

    public OtherBinaryTree(T root){
        this(root,new OtherBinaryTree<T>(),new OtherBinaryTree<T>());
    }

    public OtherBinaryTree(T root,OtherBinaryTree<T> leftNode,OtherBinaryTree<T>rightNode){
        this.root=root;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
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
        return root;
    }

    public BinaryTree<T> getRight() {
        return rightNode;
    }

    public BinaryTree<T> getLeft() {
        return leftNode;
    }
}
