package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Application<T extends Comparable<T>> {

    private ArrayList<T> arrayAuxiliarFronter = new ArrayList<>();

    public Application(){

    }

    public int getSize(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()){
            return 0;
        }
        return 1 + getSize(binaryTree.getRight()) + getSize(binaryTree.getLeft());
    }

    public int getCompleteNodes(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty() || (binaryTree.getLeft().isEmpty() && binaryTree.getRight().isEmpty())){
            return 0;
        }
        if(binaryTree.getRight().isEmpty()){
            return getCompleteNodes(binaryTree.getLeft());
        }
        if(binaryTree.getLeft().isEmpty()){
            return getCompleteNodes(binaryTree.getRight());
        }
        return 1 + getCompleteNodes(binaryTree.getRight()) + getCompleteNodes(binaryTree.getLeft());
    }

    public int find(BinaryTree<T> binaryTree, T element){
        if(binaryTree.isEmpty()){
            return 0;
        }
        if(binaryTree.getRoot().equals(element)){
            return 1 + find(binaryTree.getRight(), element) + find(binaryTree.getLeft(), element);
        }
        return find(binaryTree.getRight(), element) + find(binaryTree.getLeft(), element);
    }

    public int elementsAt(BinaryTree<T> binaryTree, int level){
        return elementsAt(binaryTree,level,0);
    }

    private int elementsAt(BinaryTree<T> binaryTree, int level, int currentLevel){
        if(binaryTree.isEmpty()) return 0;
        else if (level==currentLevel) return 1;
        else {
            currentLevel++;
            return elementsAt(binaryTree.getLeft(),level,currentLevel) + elementsAt(binaryTree.getRight(),level,currentLevel);
        }
    }

    public int height(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()) return -1;
        else{
            int leftTreeHeight = height(binaryTree.getLeft());
            int rightTreeHeight = height(binaryTree.getRight());
            if(rightTreeHeight==0 && leftTreeHeight==0) return 1;
            else if(rightTreeHeight>leftTreeHeight) return height(binaryTree.getRight())+1;
            else return height(binaryTree.getLeft())+1;
        }
    }

    public int sumOfElements(BinaryTree<Integer> binaryTree){
        if(binaryTree.isEmpty()) return 0;
        else return 1+sumOfElements(binaryTree.getRight())+sumOfElements(binaryTree.getLeft());
    }

    public int sumOfElementsMultOf3(BinaryTree<Integer> binaryTree){
        if(binaryTree.isEmpty()) return 0;
        else if(binaryTree.getRoot()%3==0) return 1+sumOfElementsMultOf3(binaryTree.getRight())+sumOfElementsMultOf3(binaryTree.getLeft());
        else return sumOfElementsMultOf3(binaryTree.getRight())+sumOfElementsMultOf3(binaryTree.getLeft());

    }

    public boolean equals(BinaryTree<T> binaryTree1,BinaryTree<T> binaryTree2){
        if(binaryTree1.isEmpty()&&binaryTree2.isEmpty()) return true;
        else if(binaryTree1.getRoot()==binaryTree2.getRoot()&&
                equals(binaryTree1.getLeft(),binaryTree2.getLeft())&&
                equals(binaryTree1.getRight(),binaryTree2.getRight())) return true;
        else return false;
    }

    public boolean isomorphic(BinaryTree<T> binaryTree1,BinaryTree<T> binaryTree2){
        if(binaryTree1.isEmpty()&&binaryTree2.isEmpty()) return true;
        else if(isomorphic(binaryTree1.getLeft(),binaryTree2.getLeft())&&
                isomorphic(binaryTree1.getRight(),binaryTree2.getRight())) return true;
        else return false;
    }

    public boolean similar(BinaryTree<T> binaryTree1,BinaryTree<T> binaryTree2){
        HashSet<T> elementsOfTree1= getAllElements(binaryTree1,new HashSet<>());
        HashSet<T> elementsOfTree2= getAllElements(binaryTree2,new HashSet<>());
        if(elementsOfTree1.containsAll(elementsOfTree2)) return true;
        else return false;
    }

    private HashSet<T> getAllElements(BinaryTree<T> binaryTree, HashSet<T> elements){
        if(binaryTree.isEmpty()) return elements;
        else{
            elements.add(binaryTree.getRoot());
            getAllElements(binaryTree.getRight(),elements);
            getAllElements(binaryTree.getLeft(),elements);
            return elements;
        }
    }

    public boolean isComplete(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()) return false;
        else if(binaryTree.getRight().isEmpty()&&binaryTree.getLeft().isEmpty()) return true;
        else return isComplete(binaryTree.getRight()) && isComplete(binaryTree.getLeft());
    }

    public boolean isFull(BinaryTree<T> binaryTree){
        return isFull(binaryTree,1,height(binaryTree));
    }

    private boolean isFull(BinaryTree<T> binaryTree, int n, int height){
        if(binaryTree.isEmpty()) return false;
        else if(!binaryTree.getRight().isEmpty() && !binaryTree.getLeft().isEmpty()){
            if(n==height) return true;
            else{
                int p=n+1;
                return isFull(binaryTree.getLeft(),p,height)&& isFull(binaryTree.getRight(),p,height);
            }
        }
        else return false;
    }

    public boolean isStable(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()) return true;
        else if(binaryTree.getLeft().isEmpty()&&binaryTree.getRight().isEmpty()) return true;
        else{
            if(binaryTree.getRoot().compareTo(binaryTree.getLeft().getRoot())<0 || binaryTree.getRoot().compareTo(binaryTree.getRight().getRoot())<0){
                return false;
            }
            else return isStable(binaryTree.getLeft())&&isStable(binaryTree.getRight());
        }
    }

    public boolean isInside(BinaryTree<T> binaryTree1, BinaryTree<T> binaryTree2){
        if(binaryTree1.isEmpty() && binaryTree2.isEmpty()){
            return true;
        } else if(binaryTree1.getRoot().compareTo(binaryTree2.getRoot()) == 0 && equals(binaryTree1, binaryTree2)){
            return true;
        } else if(!binaryTree1.getLeft().isEmpty() && !binaryTree1.getRight().isEmpty()) {
            return (isInside(binaryTree1.getLeft(), binaryTree2) || isInside(binaryTree1.getRight(),binaryTree2));
        } else if(!binaryTree1.getRight().isEmpty()){
            return isInside(binaryTree1.getRight(),binaryTree2);
        } else if(!binaryTree1.getLeft().isEmpty()){
            return isInside(binaryTree1.getLeft(),binaryTree2);
        }
        return false;
    }

    public void showBorder(BinaryTree<T> binaryTree){
        getBorderTree(binaryTree);

        for (T t:arrayAuxiliarFronter) {
            System.out.println(t);
        }

    }

    public ArrayList<T> getBorderTree(BinaryTree<T> binaryTree){
        if(binaryTree.isEmpty()){
            System.out.println("");
        }
        else if(binaryTree.getLeft().isEmpty() && binaryTree.getRight().isEmpty()){
            arrayAuxiliarFronter.add(binaryTree.getRoot());
        } else {
            getBorderTree(binaryTree.getLeft());
            getBorderTree(binaryTree.getRight());
        }

        return arrayAuxiliarFronter;
    }

    public void printPreorder(BinaryTree<T> binaryTree) {
        printPreorder(binaryTree.root);
    }

    public void printPreorder(DoubleNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public void printInorder(BinaryTree<T> binaryTree) {
        printInorder(binaryTree.root);
    }

    public void printInorder(DoubleNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.println(node.element);
        printInorder(node.right);
    }

    public void printPostorder(BinaryTree<T> binaryTree) {
        printPostorder(binaryTree.root);
    }

    public void printPostorder(DoubleNode node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.element);
    }

    public void printByLevel(BinaryTree<T> binaryTree) {
        for (int i = 0; i < height(binaryTree); i++) {
            printByLevel(binaryTree.root, i);
            System.out.println();
        }
    }

    public void printByLevel(DoubleNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.element);
        else if (level > 1) {
            printByLevel(root.left, level - 1);
            printByLevel(root.right, level - 1);
        }
    }

    boolean checkAVL(BinaryTree<T> tree){
        if(tree.isEmpty()){
            return true;
        }else if(!tree.getLeft().isEmpty() && !tree.getRight().isEmpty()){
            int maximus = max(height(tree.getLeft()),height(tree.getRight()));
            int min = min(height(tree.getLeft()),height(tree.getRight()));

            if((maximus-min) <= 1){
                return checkAVL(tree.getLeft()) && checkAVL(tree.getRight());
            }else {
                return false;
            }
        }else if(!tree.getRight().isEmpty()){
            return checkAVL(tree.getRight());
        }else if(!tree.getLeft().isEmpty()){
            return checkAVL(tree.getLeft());
        }else{
            return false;
        }
    }

    void addToTreeBinarySearch(BinaryTree<T> tree,DoubleNode<T> node){
        if(tree.isEmpty()){
            tree.getRoot() = ;
        }
    }


}
