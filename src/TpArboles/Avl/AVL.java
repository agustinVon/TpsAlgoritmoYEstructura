package TpArboles.Avl;

import java.io.IOException;

public class AVL<T> implements ISearchTree<T> {

    DoubleNode<T> root;

    public AVL(T element){
        root = new DoubleNode<T>(element);
    }

    public AVL(T element, DoubleNode<T> rnode, DoubleNode<T> lnode){
        root = new DoubleNode<T>(element,rnode,lnode);
    }

    public AVL(DoubleNode<T> node){
        root = node;
    }

    @Override
    public T getRoot() {
        return root.getRoot();
    }

    @Override
    public AVL<T> getLeft() {
        if(!isEmpty()){
            return new AVL<T>(root.getLeft());
        }
        throw new RuntimeException("Left node is empty");
    }

    @Override
    public AVL<T> getRight() {
        if(!isEmpty()){
            return new AVL<T>(root.getRight());
        }
        throw new RuntimeException("Right node is empty");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getHeight() {
        if(isEmpty()){
            return 0;
        }else{
            return Math.max(getRight().getHeight()+1,getLeft().getHeight()+1);
        }
    }

    public DoubleNode<T> insert(T element) {
        Comparable<T> elementComparable = (Comparable<T>) element;
        if(root.isEmpty()){
            root = new DoubleNode<T>(element);
        }else if(elementComparable.compareTo(this.getRoot()) < 0){
            root.setLeft(getLeft().insert(element));
            if((getLeft().getHeight() - getRight().getHeight()) == 2){
                if(elementComparable.compareTo(getLeft().getRoot()) < 0){
                    root = Rotation.rotateLeft(root);
                }else{
                    root.setLeft(Rotation.rotateRight(root.getLeft()));
                    root = Rotation.rotateLeft(root);
                }
            }
        }else if(elementComparable.compareTo(this.getRoot()) > 0){
            root.setRight(getRight().insert(element));
            if((getRight().getHeight() - getLeft().getHeight()) == 2){
                if(elementComparable.compareTo(getRight().getRoot()) < 0){
                    root = Rotation.rotateRight(root);
                }else{
                    root.setRight(Rotation.rotateLeft(root.getRight()));
                    root = Rotation.rotateRight(root);
                }
            }
        }else if(elementComparable.compareTo(element) == 0){
            throw new RuntimeException("This element already exist");
        }
        return root;

    }

    @Override
    public DoubleNode<T> delete(T element, DoubleNode<T> tree) {
        Comparable<T> elementComparable = (Comparable<T>) element;
        if(elementComparable.compareTo(this.getRoot()) == 0){
            if(!this.getRight().isEmpty() && !this.getLeft().isEmpty()){
                DoubleNode<T> nodeAuxiliar = getRight().getMin(getRight());
                delete(nodeAuxiliar.getRoot(),tree);
                root.setRoot(nodeAuxiliar.getRoot());
            }else if(!this.getRight().isEmpty() && this.getLeft().isEmpty()){
                DoubleNode<T> nodeAuxiliar = getRight().root;
                delete(nodeAuxiliar.getRoot(),tree);
                root.setRoot(nodeAuxiliar.getRoot());
            }else if(this.getRight().isEmpty() && !this.getLeft().isEmpty()){
                DoubleNode<T> nodeAuxiliar  = getLeft().root;
                delete(nodeAuxiliar.getRoot(),tree);
                root.setRoot(nodeAuxiliar.getRoot());
            }else if(this.getRight().isEmpty() && this.getLeft().isEmpty()){
                this.root = null;
                return this.root;
            }

        }else if(elementComparable.compareTo(this.getRoot()) < 0){
            tree.setLeft(getLeft().delete(element,getLeft().root));
            if((getLeft().getHeight() - getRight().getHeight()) == 2){
                if(elementComparable.compareTo(getLeft().getRoot()) < 0){
                    root = Rotation.rotateLeft(root);
                }else{
                    root.setLeft(Rotation.rotateRight(root.getLeft()));
                    root = Rotation.rotateLeft(root);
                }
            }
        }else if(elementComparable.compareTo(this.getRoot()) > 0){
            tree.setRight(getRight().delete(element,getRight().root));
            if((getRight().getHeight() - getLeft().getHeight()) == 2){
                if(elementComparable.compareTo(getRight().getRoot()) < 0){
                    root = Rotation.rotateRight(root);
                }else{
                    root.setRight(Rotation.rotateLeft(root.getRight()));
                    root = Rotation.rotateRight(root);
                }
            }
        }else{
            throw new RuntimeException("no existe");
        }

        return tree;

    }

    public boolean exist(T element){
        try {
            return existAuxiliar(element, (Comparable<T>) element);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existAuxiliar(T element, Comparable<T> tComparable) throws IOException {
        if(tComparable.compareTo(this.getRoot()) == 0){
            return true;
        }else if(tComparable.compareTo(this.getRoot())>0){
            if(root.getRight() != null){
                return getRight().exist(element);
            }
        }else if(tComparable.compareTo(this.getRoot())<0){
            if(root.getLeft() != null){
                return getLeft().exist(element);
            }
        }
        return false;
    }

    public DoubleNode<T> getMax(ISearchTree<T> tree) {
        Comparable<T> node = (Comparable<T>) this.root.getRoot();
        ISearchTree<T> rightNode = this.getRight();
        if(!rightNode.isEmpty()) {
            if (node.compareTo(rightNode.getRoot()) > 0) {
                return this.root;
            } else if (node.compareTo(rightNode.getRoot()) < 0) {
                return getRight().getMax(getRight());
            }
        }
        return root;
    }

    public DoubleNode<T> getMin(ISearchTree<T> tree) {
        Comparable<T> node = (Comparable<T>) this.root.getRoot();
        ISearchTree<T> leftNode = this.getLeft();
        if(!leftNode.isEmpty()) {
            if (node.compareTo(leftNode.getRoot()) < 0) {
                return this.root;
            } else if (node.compareTo(leftNode.getRoot()) > 0) {
                return getLeft().getMin(getLeft());
            }
        }
        return root;
    }

}
