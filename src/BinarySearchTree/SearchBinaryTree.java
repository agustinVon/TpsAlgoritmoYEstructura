package BinarySearchTree;

import BinaryTree.BinaryTree;


public class SearchBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    DoubleNode<T> rootNode;

    SearchBinaryTree(T root){
        rootNode=new DoubleNode(root);
    }
    SearchBinaryTree(){}

    @Override
    public boolean isEmpty() {
        if(rootNode==null) return true;
        else return false;
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

    /**
     * if tree is empty it inserts element in root
     * if not, compares element with root and repeats procedure with respective element
     *
     * @param element element to insert
     */
    public void insert(T element){
        if(isEmpty()) rootNode=new DoubleNode(element);
        else if(element.compareTo(rootNode.element)>0){
            insert(element,getRight());
        }
        else insert(element,getLeft());
    }

    /**
     *
     * auxiliary method of insert to analise subtrees
     *
     * @param element element to insert
     * @param binaryTree tree where you want to insert element
     */
    private void insert(T element,SearchBinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()) binaryTree.rootNode=new DoubleNode(element);
        else if(element.compareTo(binaryTree.getRoot())>0){
            insert(element,binaryTree.getRight());
        }
        else insert(element,binaryTree.getLeft());
    }

    /**
     * searches position of element in tree
     * then deletes root element
     *
     * if empty throws exception
     *
     * @param element element you want to delete
     */
    public void delete(T element){
        if(isEmpty()){
            throw new RuntimeException();
        }
        else{
            if(element.equals(rootNode.element)){
                deleteRootElement(this);
            }
            else if(element.compareTo(rootNode.element)>0){
                delete(element,getRight());
            }
            else delete(element,getLeft());
        }
    }

    /**
     *
     * Auxiliary method of delete to analise subTrees
     *
     * @param element element you want to delete
     * @param binaryTree tree yo want to delete element from
     */
    private void delete(T element,SearchBinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()){
            throw new RuntimeException();
        }
        else{
            if(element.equals(binaryTree.getRoot())){
                deleteRootElement(this);
            }
            else if(element.compareTo(binaryTree.getRoot())>0){
                delete(element,getRight());
            }
            else delete(element,getLeft());
        }
    }

    /**
     *
     * this method checks which is the correct way to delete the element and deletes it so the tree keeps being a search tree
     * if tree has no leaves it deletes the root
     * if tree has one leave it replaces the root with the leave node
     * if tree has both leaves then root is replaced with the minimum value of the right tree
     *
     * @param binaryTree tree which its root is the element you want to delete
     */
    private void deleteRootElement(SearchBinaryTree<T> binaryTree){
        if(binaryTree.rootNode.right==null && binaryTree.rootNode.left==null){
            binaryTree.rootNode=null;
        }
        else if(binaryTree.rootNode.right != null && binaryTree.rootNode.left == null){
            rootNode=rootNode.right;
        }
        else if(binaryTree.rootNode.right == null){
            rootNode=rootNode.left;
        }
        else{
            rootNode.element=getMinAndEliminateNode(binaryTree.getRight());
        }
    }

    /**
     * Finds minimum value, deletes it and returns minimum
     *
     * @param binaryTree binary tree you want to get minimum and delete minimum from
     * @return minimum
     */
    private T getMinAndEliminateNode(SearchBinaryTree<T> binaryTree){
        if(binaryTree.getLeft().rootNode==null){
            T min=binaryTree.getRoot();
            binaryTree.rootNode=null;
            return min;
        }
        else return getMinAndEliminateNode(binaryTree.getLeft());
    }

    public boolean search(T element){
        if(isEmpty()){
            throw new RuntimeException();
        }
        else{
            if(element.equals(rootNode.element)){
                return true;
            }
            else if(element.compareTo(rootNode.element)>0){
                return search(element,getRight());
            }
            else return search(element,getLeft());
        }
    }

    private boolean search(T element, SearchBinaryTree<T> binaryTree) {
        if(binaryTree.isEmpty()){
            throw new RuntimeException();
        }
        else{
            if(element.equals(binaryTree.getRoot())){
                return true;
            }
            else if(element.compareTo(binaryTree.getRoot())>0){
                return search(element,getRight());
            }
            else return search(element,getLeft());
        }
    }
}
