package Avl;

public class Rotation {


    public static <T> DoubleNode<T> rotateLeft(DoubleNode<T> root) {
        DoubleNode<T> doubleNodeAuxiliar = root.getLeft();
        root.setLeft(doubleNodeAuxiliar.getRight());
        doubleNodeAuxiliar.setRight(root);
        return doubleNodeAuxiliar;
    }

    public static <T> DoubleNode<T> rotateRight(DoubleNode<T> root) {
        DoubleNode<T> doubleNodeAuxiliar = root.getRight();
        root.setRight(doubleNodeAuxiliar.getLeft());
        doubleNodeAuxiliar.setLeft(root);
        return doubleNodeAuxiliar;
    }
}
