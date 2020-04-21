package BinaryTree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AplicationTest {

    @Test
    public void whenCalculatingAmountOfElementsInTreeShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
        new MyBinaryTree(4),
        new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));

        Aplication<Integer> app=new Aplication<Integer>();

        System.out.println(app.sumOfElements(integerBinaryTree));
    }

    @Test
    public void whenCalculatingAmountOfElementsMultOf3InTreeShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));

        Aplication<Integer> app=new Aplication<Integer>();

        System.out.println(app.sumOfElementsMultOf3(integerBinaryTree));
    }

    @Test
    public void whenComparingTwoSimilarTreesShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));
        MyBinaryTree<Integer> integerBinaryTree2=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)),
                new MyBinaryTree(4));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertTrue(aplication.similar(integerBinaryTree,integerBinaryTree2));
    }

    @Test
    public void whenCheckingATreeIsFullShouldFail(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertFalse(aplication.isFull(integerBinaryTree));
    }

    @Test
    public void whenCheckingATreeIsFullShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertTrue(aplication.isFull(integerBinaryTree));
    }

    @Test
    public void whenCalculatingHeightShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertEquals(1,aplication.height(integerBinaryTree),0);
    }

    @Test
    public void whenCalculatingIfTreeIsStableShouldSucced(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(3));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertTrue(aplication.isStable(integerBinaryTree));
    }

    @Test
    public void whenCalculatingIfTreeIsStableShouldFail(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(33));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertFalse(aplication.isStable(integerBinaryTree));
    }


}