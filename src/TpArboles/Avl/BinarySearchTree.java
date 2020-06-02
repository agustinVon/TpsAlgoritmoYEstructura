package TpArboles.Avl;

import java.io.IOException;

public class BinarySearchTree<T> implements ISearchTree<T> {

    DoubleNode<T> root;

    public BinarySearchTree(T element, BinarySearchTree<T> left, BinarySearchTree<T> right){
        root = new DoubleNode<T>(element,left.root,right.root);
    }

    public BinarySearchTree(T element){
        root = new DoubleNode<T>(element);
    }
    public BinarySearchTree(DoubleNode<T> node){
        this.root = node;
    }


    /// METHOD

    public DoubleNode<T> insert(T element) {
        Comparable<T> elementComparable = (Comparable<T>) element;
        if(elementComparable.compareTo(this.getRoot()) == 0){
            throw new RuntimeException("Is the same of the root");
        }else if(elementComparable.compareTo(this.getRoot()) > 0){
            if(getNodeRoot().getRight() == null){
                DoubleNode<T> NodeToADD = new DoubleNode<T>(element);
                this.getNodeRoot().setRight(NodeToADD);
            }
            else{
                this.getRight().insert(element);
            }
        }else if(elementComparable.compareTo(this.getRoot()) < 0){
            if(getNodeRoot().getLeft() == null){
                DoubleNode<T> NodeToADD = new DoubleNode<T>(element);
                this.getNodeRoot().setLeft(NodeToADD);
            }
            else{
                this.getLeft().insert(element);
            }
        }
        return root;
    }

    public DoubleNode<T> deletes(T element, DoubleNode<T> tree){
        Comparable<T> elementComparable = (Comparable<T>) element;
        if(elementComparable.compareTo(this.getRoot()) == 0){
            System.out.println("se elimino" + this.getRoot());
            this.root = null;
            return this.root;
        }else if(elementComparable.compareTo(this.getRoot()) < 0){
            tree.setLeft(getLeft().deletes(element,getLeft().getNodeRoot()));
        }else if(elementComparable.compareTo(this.getRoot()) > 0){
            tree.setRight(getRight().deletes(element,getRight().getNodeRoot()));
        }

        return tree;
    }



    public DoubleNode<T> delete(T element, DoubleNode<T> tree){
        Comparable<T> elementComparable = (Comparable<T>) element;
        if(elementComparable.compareTo(this.getRoot()) == 0){
            if(!this.getRight().isEmpty() && !this.getLeft().isEmpty()){
                DoubleNode<T> nodeAuxiliar = getRight().getMin(getRight());
                System.out.println("Hola soy " + nodeAuxiliar.root);
                delete(nodeAuxiliar.getRoot(),tree);
                getNodeRoot().setRoot(nodeAuxiliar.getRoot());
            }else if(!this.getRight().isEmpty() && this.getLeft().isEmpty()){
                DoubleNode<T> nodeAuxiliar = getRight().getNodeRoot();
                delete(nodeAuxiliar.getRoot(),tree);
                getNodeRoot().setRoot(nodeAuxiliar.getRoot());
            }else if(this.getRight().isEmpty() && !this.getLeft().isEmpty()){
                DoubleNode<T> nodeAuxiliar  = getLeft().getNodeRoot();
                delete(nodeAuxiliar.getRoot(),tree);
                getNodeRoot().setRoot(nodeAuxiliar.getRoot());
            }else if(this.getRight().isEmpty() && this.getLeft().isEmpty()){
                System.out.println("Se elimino "+ root.getRoot());
                this.root = null;
                return this.root;

            }
        }else if(elementComparable.compareTo(this.getRoot()) < 0){
            tree.setLeft(getLeft().delete(element,getLeft().getNodeRoot()));
        }else if(elementComparable.compareTo(this.getRoot()) > 0){
            tree.setRight(getRight().delete(element,getRight().getNodeRoot()));
        }else{
            throw new RuntimeException("no existe");
        }

        return tree;

    }

    public DoubleNode<T> getNodeRoot(){
        return root;
    }


    @Override
    public int getHeight() {
        if(isEmpty()){
            return 0;
        }else{
            return Math.max(getRight().getHeight()+1,getLeft().getHeight()+1);
        }
    }

    @Override
    public T getRoot() {
        if(!isEmpty()){
            return root.getRoot();
        }
        else{
            throw new RuntimeException("Tree is empty");
        }
    }

    @Override
    public BinarySearchTree<T> getLeft() {
        if(!isEmpty()){
            return new BinarySearchTree<T>(root.getLeft());
        }
        throw new RuntimeException("Empty node left");
    }

    @Override
    public BinarySearchTree<T> getRight() {
        if(!isEmpty()){
            return new BinarySearchTree<T>(root.getRight());
        }
        throw new RuntimeException("Empty node right");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public void printPostOrden(ISearchTree<T> a) //IDR
    {
        if(!a.isEmpty())
        {
            printPostOrden(a.getLeft());
            printPostOrden(a.getRight());
            System.out.println(a.getRoot());

        }
    }

    public boolean exist(T element){
        try {
            return existAuxiliar(element, (Comparable<T>) element);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public DoubleNode<T> getMax(ISearchTree<T> tree) {
        Comparable<T> node = (Comparable<T>) this.getNodeRoot().root;
        ISearchTree<T> rightNode = this.getRight();
        if(!rightNode.isEmpty()) {
            if (node.compareTo(rightNode.getRoot()) > 0) {
                return this.getNodeRoot();
            } else if (node.compareTo(rightNode.getRoot()) < 0) {
                return getRight().getMax(getRight());
            }
        }
        return getNodeRoot();
    }

    public DoubleNode<T> getMin(ISearchTree<T> tree) {
        Comparable<T> node = (Comparable<T>) this.getNodeRoot().root;
        ISearchTree<T> leftNode = this.getLeft();
        if(!leftNode.isEmpty()) {
            if (node.compareTo(leftNode.getRoot()) < 0) {
                return this.getNodeRoot();
            } else if (node.compareTo(leftNode.getRoot()) > 0) {
                return getLeft().getMin(getLeft());
            }
        }
        return getNodeRoot();
    }

    public boolean existAuxiliar(T element, Comparable<T> tComparable) throws IOException {
        if(tComparable.compareTo(this.getRoot()) == 0){
            return true;
        }else if(tComparable.compareTo(this.getRoot())>0){
            if(getNodeRoot().getRight() != null){
                return getRight().exist(element);
            }
        }else if(tComparable.compareTo(this.getRoot())<0){
            if(getNodeRoot().getLeft() != null){
                return getLeft().exist(element);
            }
        }
        return false;
    }

    public void setRoot(DoubleNode<T> node){
        this.root = node;
    }
}
