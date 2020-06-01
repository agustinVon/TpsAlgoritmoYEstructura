package RedBlackTree;

import Avl.DoubleNode;

public class Rotation {


    public static <T> ColorNode<T> rotateLeft(ColorNode<T> root) {
        ColorNode<T> doubleNodeAuxiliar = root.leftChild;
        root.leftChild=doubleNodeAuxiliar.rightChild;
        doubleNodeAuxiliar.rightChild=root;
        return doubleNodeAuxiliar;
    }

    public static <T> ColorNode<T> rotateRight(ColorNode<T> root) {
        ColorNode<T> doubleNodeAuxiliar = root.rightChild;
        root.rightChild=doubleNodeAuxiliar.leftChild;
        doubleNodeAuxiliar.leftChild=root;
        return doubleNodeAuxiliar;
    }

    public static <T> ColorNode<T> doubleRotationLeft(ColorNode<T> root){
        ColorNode<T> auxiliarNode= root.leftChild.rightChild;
        ColorNode<T> auxiliarLeftChild= root.leftChild;
        ColorNode<T> auxiliarRoot= root;

        auxiliarLeftChild.rightChild=auxiliarNode.leftChild;
        auxiliarRoot.leftChild=auxiliarNode.rightChild;

        auxiliarNode.leftChild=auxiliarLeftChild;
        auxiliarNode.rightChild=auxiliarRoot;

        return auxiliarNode;
    }

    public static <T> ColorNode<T> doubleRotationRight(ColorNode<T> root){
        ColorNode<T> auxiliarNode= root.rightChild.leftChild;
        ColorNode<T> auxiliarRightChild= root.rightChild;
        ColorNode<T> auxiliarRoot= root;

        auxiliarRightChild.leftChild=auxiliarNode.rightChild;
        auxiliarRoot.rightChild=auxiliarNode.leftChild;

        auxiliarNode.rightChild=auxiliarRightChild;
        auxiliarNode.leftChild=auxiliarRoot;

        return auxiliarNode;
    }
}
