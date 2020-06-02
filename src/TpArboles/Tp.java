package TpArboles;

import Avl.BinarySearchTree;
import BinaryTree.BinaryTree;
import RedBlackTree.RBTree;
import TpArboles.Avl.AVL;

import java.util.ArrayList;
import java.util.Random;

public class Tp {
    //TODO Tp

    AVL avlTree;
    BinarySearchTree<Integer> bsTree;
    RBTree rbTree;
    ArrayList<Integer> avlRandomNumbers, rbtRandomNumbers, bstRandomNumbers;

    public void randomAVLTree(){
        long startTime = System.currentTimeMillis();
        avlTree = new AVL(1 + new Random().nextInt(100001));
        ArrayList<Integer> avlRandomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(avlRandomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            avlRandomNumbers.add(randomAdd);
        }
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(avlRandomNumbers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to build AVL Tree: " + timeTaken);
        System.out.println("Its height is:" + avlTree.getHeight());
    }

    public void randomRBTree(){
        long startTime = System.currentTimeMillis();
        rbTree = new RBTree(1 + new Random().nextInt(100001));
        ArrayList<Integer> rbtRandomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(rbtRandomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            rbtRandomNumbers.add(randomAdd);
        }
        for (int i = 0; i < 1000; i++) {
            rbTree.insert(rbtRandomNumbers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to build Red and Black Tree: " + timeTaken);
        System.out.println("Its height is:" + rbTree.height());
    }

    public void randomBSTree(){
        long startTime = System.currentTimeMillis();
        bsTree = new BinarySearchTree(1 + new Random().nextInt(100001));
        ArrayList<Integer> bstRandomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(bstRandomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            bstRandomNumbers.add(randomAdd);
        }
        for (int i = 0; i < 1000; i++) {
            bsTree.insert(bstRandomNumbers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to build Binary Search Tree: " + timeTaken);
        System.out.println("Its height is:" + bsTree.getHeight());
    }

    public void table(){
        ArrayList<Integer> indexesToSearch = new ArrayList<Integer>();
        for (int i = 0; i < 10 ; i++) {
            indexesToSearch.add(i*10);
        }

        //AVL
        String attempts =
        for (int i = 0; i < 10 ; i++) {
            indexesToSearch
        }

    }
}
