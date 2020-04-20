package BinaryTree;

import javax.print.attribute.standard.MediaSize;

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
        return root;
    }

    @Override
    public BinaryTree<T> getRight() {
        return rightNode;
    }

    @Override
    public BinaryTree<T> getLeft() {
        return leftNode;
    }
}
