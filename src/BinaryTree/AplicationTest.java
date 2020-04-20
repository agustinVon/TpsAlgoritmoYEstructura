package BinaryTree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AplicationTest {

    @Test
    public void whenCalculatingAmountOfElementsInTreeShouldSucceed(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
        new OtherBinaryTree<Integer>(4),
        new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)));

        Aplication<Integer> app=new Aplication<Integer>();

        System.out.println(app.sumOfElements(integerBinaryTree));
    }

    @Test
    public void whenCalculatingAmountOfElementsMultOf3InTreeShouldSucceed(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)));

        Aplication<Integer> app=new Aplication<Integer>();

        System.out.println(app.sumOfElementsMultOf3(integerBinaryTree));
    }

    @Test
    public void whenComparingTwoSimilarTreesShouldSucceed(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)));
        OtherBinaryTree<Integer> integerBinaryTree2=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)),
                new OtherBinaryTree<Integer>(4));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertTrue(aplication.similar(integerBinaryTree,integerBinaryTree2));
    }

    @Test
    public void whenCheckingATreeIsFullShouldFail(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5,new OtherBinaryTree<Integer>(3),new OtherBinaryTree<Integer>(2)));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertFalse(aplication.isFull(integerBinaryTree));
    }

    @Test
    public void whenCheckingATreeIsFullShouldSucceed(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertTrue(aplication.isFull(integerBinaryTree));
    }

    @Test
    public void whenCalculatingHeightShouldSucceed(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertEquals(2,aplication.height(integerBinaryTree),0);
    }


}