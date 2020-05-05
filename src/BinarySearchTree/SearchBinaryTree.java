package BinarySearchTree;

import BinaryTree.BinaryTree;


public class SearchBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    DoubleNode<T> rootNode;

    SearchBinaryTree(T root){
        rootNode=new DoubleNode<T>(root);
    }

    SearchBinaryTree(T root, SearchBinaryTree<T> left, SearchBinaryTree<T> right){
        rootNode = new DoubleNode<T>(root);
        rootNode.left = left.rootNode;
        rootNode.right = right.rootNode;
    }

    SearchBinaryTree(){
    }

    @Override
    public boolean isEmpty() {
        return rootNode==null;
    }

    @Override
    public T getRoot() {
        return rootNode.element;
    }

    @Override
    public SearchBinaryTree<T> getRight() {
        SearchBinaryTree<T> t=new SearchBinaryTree<>();
        t.rootNode=rootNode.right;
        return t;
    }

    @Override
    public SearchBinaryTree<T> getLeft() {
        SearchBinaryTree<T> t=new SearchBinaryTree<>();
        t.rootNode=rootNode.left;
        return t;
    }

    public void insert(T element){
        if(isEmpty()){
            rootNode=new DoubleNode<>(element);
        }
        else {
            insert(rootNode, element);
        }
    }

    public DoubleNode<T> insert(DoubleNode<T> node, T element) {
        if (node == null) {
            node = new DoubleNode(element);
            return node;
        }
        if (element.compareTo(node.element)>0)
            node.right = insert(node.right, element);
        else if (element.compareTo(node.element)<0)
            node.left = insert(node.left, element);
        return node;
    }

    public void delete(T element) {
        deleteRootElement(rootNode, element);
    }

    private DoubleNode<T> deleteRootElement(DoubleNode<T> node, T element) {
        if(node == null){
            return node;
        }
        if(element.compareTo(node.element) < 0){
            node.left = deleteRootElement(node.left, element);
        }
        else if(element.compareTo(node.element) > 0){
            node.right = deleteRootElement(node.right, element);
        }
        else{
            if(node.right == null && node.right == null) {
                return null;
            }
            else if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            } else {
                T minValue = minValue(node.right);
                node.element = minValue;
                node.right = deleteRootElement(node.right, minValue);
            }
        }
        return node;
    }

    private T minValue(DoubleNode<T> node) {

        if(node.left != null) {
            return minValue(node.left);
        }
        return node.element;
    }

    public boolean exists(T element){
        if(isEmpty()){
            throw new RuntimeException();
        }
        else{
            if(element.equals(rootNode.element)){
                return true;
            }
            else if(element.compareTo(rootNode.element)>0){
                return exists(element,getRight());
            }
            else return exists(element,getLeft());
        }
    }

    private boolean exists(T element, SearchBinaryTree<T> searchBinaryTree) {
        if(searchBinaryTree.isEmpty()){
            return false;
        }
        else{
            if(searchBinaryTree.getRoot().equals(element)){
                return true;
            }
            else if(element.compareTo(searchBinaryTree.getRoot())>0){
                return exists(element,searchBinaryTree.getRight());
            }
            else return exists(element,searchBinaryTree.getLeft());
        }
    }
}
