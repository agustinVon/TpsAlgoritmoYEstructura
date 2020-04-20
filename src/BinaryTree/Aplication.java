package BinaryTree;

import java.util.HashSet;

public class Aplication<T> {

    public Aplication(){

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
        return elementsAtAuxMethod(binaryTree,level,0);
    }

    public int elementsAtAuxMethod(BinaryTree<T> binaryTree, int level,int currentLevel){
        if(binaryTree.isEmpty()){
            return 0;
        }
        else if(level==currentLevel) return 1;
        else return elementsAtAuxMethod(binaryTree.getLeft(),level,currentLevel++)
                    +elementsAtAuxMethod(binaryTree.getRight(),level,currentLevel++);
    }

    public int height(BinaryTree<T> tree){
        if(tree.isEmpty()) return -1;
        else{
            int leftTreeHeight = height(tree.getLeft());
            int rightTreeHeight = height(tree.getRight());
            if(rightTreeHeight==0 && leftTreeHeight==0) return 1;
            else if(rightTreeHeight>leftTreeHeight) return height(tree.getRight())+1;
            else return height(tree.getLeft())+1;
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

    public boolean isomorfic(BinaryTree<T> binaryTree1,BinaryTree<T> binaryTree2){
        if(binaryTree1.isEmpty()&&binaryTree2.isEmpty()) return true;
        else if(isomorfic(binaryTree1.getLeft(),binaryTree2.getLeft())&&
                isomorfic(binaryTree1.getRight(),binaryTree2.getRight())) return true;
        else return false;
    }

    public boolean similar(BinaryTree<T> binaryTree1,BinaryTree<T> binaryTree2){
        HashSet<T> elementsOfTree1=getAllElementsOfTree(binaryTree1,new HashSet<>());
        HashSet<T> elementsOfTree2=getAllElementsOfTree(binaryTree2,new HashSet<>());
        if(elementsOfTree1.containsAll(elementsOfTree2)) return true;
        else return false;
    }

    private HashSet<T> getAllElementsOfTree(BinaryTree<T> binaryTree,HashSet<T> elements){
        if(binaryTree.isEmpty()) return elements;
        else{
            elements.add(binaryTree.getRoot());
            getAllElementsOfTree(binaryTree.getRight(),elements);
            getAllElementsOfTree(binaryTree.getLeft(),elements);
            return elements;
        }
    }

    boolean isComplete(BinaryTree<T> tree){
        if(tree.isEmpty()) return false;
        else if(tree.getRight().isEmpty()&&tree.getLeft().isEmpty()) return true;
        else return isComplete(tree.getRight()) && isComplete(tree.getLeft());
    }

    /*
    boolean isFull(BinaryTree<T> tree){
        return isFullAuziliarMethod(tree,0,height(tree));
    }

    boolean isFullAuziliarMethod(BinaryTree<T> tree,int n,int height){
        if(tree.isEmpty()) return false;
        else if(!tree.getRight().isEmpty() && !tree.getLeft().isEmpty()){
            if(n==height) return true;
            else return isFullAuziliarMethod(tree.getLeft(),n+1,height)&&isFullAuziliarMethod(tree.getRight(),n+1,height);
        }
        else return false;
    }

     */ //no funca esto
}
