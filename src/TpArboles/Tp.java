package TpArboles;

import Avl.BinarySearchTree;
import RedBlackTree.RBTree;
import TpArboles.Avl.AVL;

import java.util.ArrayList;
import java.util.Random;

public class Tp {
    //TODO Tp

    public void randomAVLTree(){
        long startTime = System.currentTimeMillis();
        AVL avlTree = new AVL(1 + new Random().nextInt(100001));
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
        System.out.println(timeTaken);
    }

    public void randomRBTree(){
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
        System.out.println(timeTaken);
    }

    public void randomBSTree(){
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
        System.out.println(timeTaken);
    }
}
