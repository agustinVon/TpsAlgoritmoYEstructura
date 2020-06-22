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

    public void randomAVLTree(){
        long startTime = System.currentTimeMillis();
        avlTree = new AVL(1 + new Random().nextInt(100001));
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(randomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            randomNumbers.add(randomAdd);
        }
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(randomNumbers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to build AVL Tree: " + timeTaken);
        System.out.println("Its height is:" + avlTree.getHeight());
    }

    public void randomRBTree(){
        long startTime = System.currentTimeMillis();
        rbTree = new RBTree(1 + new Random().nextInt(100001));
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(randomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            randomNumbers.add(randomAdd);
        }
        for (int i = 0; i < 1000; i++) {
            rbTree.insert(randomNumbers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to build Red and Black Tree: " + timeTaken);
        System.out.println("Its height is:" + rbTree.height());
    }

    public void randomBSTree(){
        long startTime = System.currentTimeMillis();
        bsTree = new BinarySearchTree(1 + new Random().nextInt(100001));
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(randomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            randomNumbers.add(randomAdd);
        }
        for (int i = 0; i < 1000; i++) {
            bsTree.insert(randomNumbers.get(i));
        }
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to build Binary Search Tree: " + timeTaken);
        System.out.println("Its height is:" + bsTree.getHeight());
    }

    public void randomAVLTreeMean(){
        long totalTime=0;
        int totalLength=0;
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            AVL avlTree = new AVL(1 + new Random().nextInt(100001));
            ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
            for (int j = 0; j < 1000 ; j++) {
                int randomAdd = 1 + new Random().nextInt(100001);
                while(randomNumbers.contains(randomAdd)){
                    randomAdd = 1 + new Random().nextInt(100001);
                }
                randomNumbers.add(randomAdd);
            }
            for (int j = 0; j < 1000; j++) {
                avlTree.insert(randomNumbers.get(j));
            }
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            totalTime=totalTime+timeTaken;
            totalLength=totalLength+avlTree.getHeight();
        }
        System.out.println("Mean of time and mean of height in AVL: ");
        System.out.println(totalTime/10);
        System.out.println(totalLength/10);
    }

    public void randomRBTreeMean(){
        double totalTime=0;
        int totalLength=0;
        for (int j = 0; j < 10; j++) {
            long startTime = System.currentTimeMillis();
            RBTree rbTree = new RBTree(1 + new Random().nextInt(100001));
            ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
            for (int i = 0; i < 1000 ; i++) {
                int randomAdd = 1 + new Random().nextInt(100001);
                while(randomNumbers.contains(randomAdd)){
                    randomAdd = 1 + new Random().nextInt(100001);
                }
                randomNumbers.add(randomAdd);
            }
            for (int i = 0; i < 1000; i++) {
                rbTree.insert(randomNumbers.get(i));
            }
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            totalTime=totalTime+timeTaken;
            totalLength=totalLength+rbTree.height();
        }
        System.out.println("Mean of time and mean of height in RBTree: ");
        System.out.println(totalTime/10);
        System.out.println(totalLength/10);
    }

    public void randomBSTreeMean(){
        double totalTime=0;
        int totalLength=0;
        for (int j = 0; j < 10; j++) {
            long startTime = System.currentTimeMillis();
            BinarySearchTree bsTree = new BinarySearchTree(1 + new Random().nextInt(100001));
            ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
            for (int i = 0; i < 1000 ; i++) {
                int randomAdd = 1 + new Random().nextInt(100001);
                while(randomNumbers.contains(randomAdd)){
                    randomAdd = 1 + new Random().nextInt(100001);
                }
                randomNumbers.add(randomAdd);
            }
            for (int i = 0; i < 1000; i++) {
                bsTree.insert(randomNumbers.get(i));
            }
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            totalTime=totalTime+timeTaken;
            totalLength=totalLength+bsTree.getHeight();
        }
        System.out.println("Mean of time and mean of height in RBTree: ");
        System.out.println(totalTime/10);
        System.out.println(totalLength/10);

    }

    public void tabla(){
        avlTree = new AVL(1 + new Random().nextInt(100001));
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 1000 ; i++) {
            int randomAdd = 1 + new Random().nextInt(100001);
            while(randomNumbers.contains(randomAdd)){
                randomAdd = 1 + new Random().nextInt(100001);
            }
            randomNumbers.add(randomAdd);
        }
        for (int number:randomNumbers) {
            avlTree.insert(number);
        }
        for (int number:randomNumbers) {
            System.out.println(avlTree.existCounter(number));
        }
    }

}
