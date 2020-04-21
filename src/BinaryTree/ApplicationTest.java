package BinaryTree;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void testSize(){
        OtherBinaryTree binaryTree = new OtherBinaryTree<Integer>(1, new OtherBinaryTree<Integer>(5), new OtherBinaryTree<Integer>(3, new OtherBinaryTree<Integer>(3), new OtherBinaryTree<Integer>(3)));
        Application application = new Application();
        Assert.assertEquals(5, application.getSize(binaryTree));
    }

    @Test
    public void testCompleteNodes(){
        OtherBinaryTree binaryTree = new OtherBinaryTree<Integer>(1, new OtherBinaryTree<Integer>(5), new OtherBinaryTree<Integer>(3, new OtherBinaryTree<Integer>(3), new OtherBinaryTree<Integer>(3)));
        Application application = new Application();
        Assert.assertEquals(2, application.getCompleteNodes(binaryTree));
    }

    @Test
    public void testFind(){
        OtherBinaryTree binaryTree = new OtherBinaryTree<Integer>(1, new OtherBinaryTree<Integer>(5), new OtherBinaryTree<Integer>(5, new OtherBinaryTree<Integer>(3), new OtherBinaryTree<Integer>(3)));
        Application application = new Application();
        Assert.assertEquals(2,application.find(binaryTree,5));
    }

    @Test
    public void testElementsAt(){
        OtherBinaryTree binaryTree = new OtherBinaryTree<Integer>(1, new OtherBinaryTree<Integer>(5), new OtherBinaryTree<Integer>(3));
        Application application = new Application();
        Assert.assertEquals(2, application.elementsAt(binaryTree, 1));
    }

    @Test
    public void testHeight(){
        OtherBinaryTree binaryTree = new OtherBinaryTree<Integer>(1, new OtherBinaryTree<Integer>(5, new OtherBinaryTree<Integer>(69), new OtherBinaryTree<Integer>(420)), new OtherBinaryTree<Integer>(5, new OtherBinaryTree<Integer>(92, new OtherBinaryTree<Integer>(8), new OtherBinaryTree<Integer>(5)), new OtherBinaryTree<Integer>(3)));
        Application application = new Application();
        Assert.assertEquals(3,application.height(binaryTree));
    }

    @Test
    public void whenCalculatingAmountOfElementsInTreeShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
        new MyBinaryTree(4),
        new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));

        Application<Integer> app=new Application<Integer>();

        System.out.println(app.sumOfElements(integerBinaryTree));
    }

    @Test
    public void whenCalculatingAmountOfElementsMultOf3InTreeShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));

        Application<Integer> app=new Application<Integer>();

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

        Application<Integer> application =new Application<Integer>();

        Assert.assertTrue(application.similar(integerBinaryTree,integerBinaryTree2));
    }

    @Test
    public void whenCheckingATreeIsFullShouldFail(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5,new MyBinaryTree(3),new MyBinaryTree(2)));

        Application<Integer> application =new Application<Integer>();

        Assert.assertFalse(application.isFull(integerBinaryTree));
    }

    @Test
    public void whenCheckingATreeIsFullShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5));

        Application<Integer> application =new Application<Integer>();

        Assert.assertTrue(application.isFull(integerBinaryTree));
    }

    @Test
    public void whenCalculatingHeightShouldSucceed(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(5));

        Application<Integer> application =new Application<Integer>();

        Assert.assertEquals(1, application.height(integerBinaryTree),0);
    }

    @Test
    public void whenCalculatingIfTreeIsStableShouldSucced(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(3));

        Application<Integer> application =new Application<Integer>();

        Assert.assertTrue(application.isStable(integerBinaryTree));
    }

    @Test
    public void whenCalculatingIfTreeIsStableShouldFail(){
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(4,
                new MyBinaryTree(4),
                new MyBinaryTree(33));

        Application<Integer> application =new Application<Integer>();

        Assert.assertFalse(application.isStable(integerBinaryTree));
    }

    @Test
    public void whenCalculatingIfTreeIsInsideOfAnotherTreeShouldSucceed(){
        MyBinaryTree<Integer> childBinaryTree = new MyBinaryTree(5, new MyBinaryTree(4), new MyBinaryTree(3) );
        MyBinaryTree<Integer> parentBinaryTree=new MyBinaryTree<Integer>(5, childBinaryTree, new MyBinaryTree(2));

        Application<Integer> application =new Application<Integer>();

        Assert.assertTrue(application.isInside(parentBinaryTree, childBinaryTree));
    }

    @Test
    public void whenCalculatingIfTreeIsInsideOfAnotherTreeShouldFail(){
        MyBinaryTree<Integer> childBinaryTree = new MyBinaryTree(5, new MyBinaryTree(4), new MyBinaryTree(3) );
        MyBinaryTree<Integer> parentBinaryTree=new MyBinaryTree<Integer>(5, new MyBinaryTree(4), new MyBinaryTree(2));

        Application<Integer> application =new Application<Integer>();

        Assert.assertFalse(application.isInside(parentBinaryTree, childBinaryTree));
    }

    @Test
    public void whenCalculatingTreeBorder(){
        MyBinaryTree<Integer> integerBinaryTreeR=new MyBinaryTree<Integer>(8,
                new MyBinaryTree(2),
                new MyBinaryTree(3));
        MyBinaryTree<Integer> integerBinaryTreeL=new MyBinaryTree<Integer>(8,
                new MyBinaryTree(4),
                new MyBinaryTree(5));

        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(8,
                integerBinaryTreeL,
                integerBinaryTreeR);
        Application<Integer> application =new Application<Integer>();
        application.showBorder(integerBinaryTree);

    }

    @Test
    public void whenCalculatingTreeBorderArray(){
        MyBinaryTree<Integer> integerBinaryTreeR=new MyBinaryTree<Integer>(8,
                new MyBinaryTree(2),
                new MyBinaryTree(3));
        MyBinaryTree<Integer> integerBinaryTreeL=new MyBinaryTree<Integer>(8,
                new MyBinaryTree(4),
                new MyBinaryTree(5));
        MyBinaryTree<Integer> integerBinaryTree=new MyBinaryTree<Integer>(8,
                integerBinaryTreeL,
                integerBinaryTreeR);
        Application<Integer> application =new Application<Integer>();

        Assert.assertEquals(4, application.getBorderTree(integerBinaryTree).size());

    }

    @Test
    public void whenCalculatingTreeIsAVLFailed(){
/*
        OtherBinaryTree<Integer> integerBinaryTreeRRR=new OtherBinaryTree<Integer>(15,
                new OtherBinaryTree<Integer>(14),
                null);
        OtherBinaryTree<Integer> integerBinaryTreeRR=new OtherBinaryTree<Integer>(7,
                null,
                integerBinaryTreeRRR);
        OtherBinaryTree<Integer> integerBinaryTreeR=new OtherBinaryTree<Integer>(6,
                new OtherBinaryTree<Integer>(5),
                integerBinaryTreeRR);
        OtherBinaryTree<Integer> integerBinaryTreeL=new OtherBinaryTree<Integer>(2,
                new OtherBinaryTree<Integer>(1),
                new OtherBinaryTree<Integer>(3));

        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                integerBinaryTreeL,
                integerBinaryTreeR);


 */

        OtherBinaryTree<Integer> integerBinaryTreeRR=new OtherBinaryTree<Integer>(8);
        OtherBinaryTree<Integer> integerBinaryTreeR=new OtherBinaryTree<Integer>(6,
                new OtherBinaryTree<Integer>(null),
                integerBinaryTreeRR);

        OtherBinaryTree<Integer> integerBinaryTree=new OtherBinaryTree<Integer>(4,
                new OtherBinaryTree<Integer>(null),
                integerBinaryTreeR);
        Application<Integer> application =new Application<Integer>();

        Assert.assertFalse(application.checkAVL(integerBinaryTree));

    }



}