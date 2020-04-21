package BinaryTree;

import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals(1,aplication.height(integerBinaryTree),0);
    }

    @Test
    public void whenCalculatingIfTreeIsStableShouldSucced(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(8,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertTrue(aplication.isStable(integerBinaryTree));
    }

    @Test
    public void whenCalculatingIfTreeIsStableShouldFail(){
        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(8,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(12));

        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertFalse(aplication.isStable(integerBinaryTree));
    }

    @Test
    public void whenCalculatingIfTreeIsInsideOfAnotherTreeShouldSucced(){
       //HACELO MAU
    }

    @Test
    public void whenCalculatingIfTreeIsInsideOfAnotherTreeShouldFail(){
        //HACELO MAU x2
    }

    @Test
    public void whenCalculatingTreeBorder(){
        OtherBinaryTree<Integer> integerBinaryTreeR=new OtherBinaryTree<Integer>(8,
                new OtherBinaryTree<Integer>(2),
                new OtherBinaryTree<Integer>(3));
        OtherBinaryTree<Integer> integerBinaryTreeL=new OtherBinaryTree<Integer>(8,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5));

        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(8,
                integerBinaryTreeL,
                integerBinaryTreeR);
        Aplication<Integer> aplication=new Aplication<Integer>();
        aplication.showBorder(integerBinaryTree);

    }

    @Test
    public void whenCalculatingTreeBorderArray(){
        OtherBinaryTree<Integer> integerBinaryTreeR=new OtherBinaryTree<Integer>(8,
                new OtherBinaryTree<Integer>(2),
                new OtherBinaryTree<Integer>(3));
        OtherBinaryTree<Integer> integerBinaryTreeL=new OtherBinaryTree<Integer>(8,
                new OtherBinaryTree<Integer>(4),
                new OtherBinaryTree<Integer>(5));

        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(8,
                integerBinaryTreeL,
                integerBinaryTreeR);
        Aplication<Integer> aplication=new Aplication<Integer>();

        Assert.assertEquals(4,aplication.getBorderTree(integerBinaryTree).size());

    }


}